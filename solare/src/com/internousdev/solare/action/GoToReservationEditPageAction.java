package com.internousdev.solare.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.EditReservationInfoDAO;
import com.internousdev.solare.dao.SearchInfoDAO;
import com.internousdev.solare.dto.GetSeatInfoDTO;
import com.internousdev.solare.dto.ReservationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToReservationEditPageAction 予約可能な曜日と時間を照会し、予約を変更するためのクラス
 *
 * @since 2015/04/16
 * @version 1.0
 */
public class GoToReservationEditPageAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private static final long serialVersionUID = -5167572410327589151L;

	/**
	 * 日付リスト
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private List<String> tomorrowList = new ArrayList<String>();

	/**
	 * 曜日リスト
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private List<String> nextWeekList = new ArrayList<String>();

	/**
	 * 空席情報リスト
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private List<String> vacancyList = new ArrayList<String>();

	/**
	 * 席情報リスト
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private List<GetSeatInfoDTO> seatInfoList = new ArrayList<GetSeatInfoDTO>();

	/**
	 * チェック用席情報リスト
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private List<GetSeatInfoDTO> checkRecordList = new ArrayList<GetSeatInfoDTO>();

	/**
	 * 予約情報リスト
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private List<ReservationInfoDTO> reservationInfoList = new ArrayList<ReservationInfoDTO>();

	/**
	 * セッション情報
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * メッセージ
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String message;

	/**
	 * 予約番号
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private int customerReservationNumber;

	/**
	 * コース番号
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private int courseNumber;
	/**
	 * 予約人数
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private int numberOfPeople;
	/**
	 * 予約日
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String reservationDate;
	/**
	 * 予約時間
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */

	private String reservationTime;
	/**
	 * コース番号(String)
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String courseNumberString;

	/**
	 * 実行メソッド
	 *
	 * @since 2015/04/16
	 * @return result 結果
	 */
	public String execute() throws Exception {
		String result = ERROR;
		if (!sessionMap.containsKey("userId") && !sessionMap.containsKey("AccessToken")) {
			result = "notSession";
			return result;
		}
		String judge = "◎";
		String judge2 = "△";
		String judge3 = "×";

		SearchInfoDAO dao = new SearchInfoDAO();

		int check = dao.checkRecordNum();

		if (check == 7) {
			dao.select();
			seatInfoList.addAll(dao.getSeatInfoList());
			for (int j = 0; j < seatInfoList.size(); j++) {
				tomorrowList.add(seatInfoList.get(j).getDate());
				nextWeekList.add(checkWeek(seatInfoList.get(j).getDayOfWeek()));
				int check2 = (seatInfoList.get(j).getMaxNumberOfPpl() - seatInfoList.get(j).getRemainingSeat());
				if (check2 >= 70) {
					vacancyList.add(judge);
				} else if (check2 > 10 && check2 > 70) {
					vacancyList.add(judge2);
				} else if (check2 < 10) {
					vacancyList.add(judge3);
				}
			}
		} else if (check == 0) {
			dao.insertZeroRecord();
			dao.select();
			seatInfoList.addAll(dao.getSeatInfoList());
			for (int j = 0; j < seatInfoList.size(); j++) {
				tomorrowList.add(seatInfoList.get(j).getDate());

				nextWeekList.add(checkWeek(seatInfoList.get(j).getDayOfWeek()));

				int check2 = (seatInfoList.get(j).getMaxNumberOfPpl() - seatInfoList.get(j).getRemainingSeat());
				if (check2 >= 70) {
					vacancyList.add(judge);
				} else if (check2 > 10 && check2 > 70) {
					vacancyList.add(judge2);
				} else if (check2 < 10) {
					vacancyList.add(judge3);
				}
			}
		} else {
			checkRecordList.addAll(dao.getCheckRecordList());
			String date = checkRecordList.get(checkRecordList.size() - 1).getDate();
			dao.insertRecord(date);
			dao.select();
			seatInfoList.addAll(dao.getSeatInfoList());
			for (int j = 0; j < seatInfoList.size(); j++) {
				tomorrowList.add(seatInfoList.get(j).getDate());
				nextWeekList.add(checkWeek(seatInfoList.get(j).getDayOfWeek()));
				int check2 = (seatInfoList.get(j).getMaxNumberOfPpl() - seatInfoList.get(j).getRemainingSeat());
				if (check2 >= 70) {
					vacancyList.add(judge);
				} else if (check2 > 10 && check2 > 70) {
					vacancyList.add(judge2);
				} else if (check2 < 10) {
					vacancyList.add(judge3);
				}
			}
		}
		EditReservationInfoDAO dao2 = new EditReservationInfoDAO();
		boolean getReservationListCheck = dao2.getReservationInfoList((int) sessionMap.get("accountNumber"));
		if (!getReservationListCheck) {
			message = "予約がございません。";
			result = ERROR;
			return result;
		}
		reservationInfoList.addAll(dao2.getReservationInfoList());
		List<Timestamp> timeStampFomrmatList = new ArrayList<Timestamp>();
		for (int i = 0; i < reservationInfoList.size(); i++) {
			timeStampFomrmatList.add(reservationInfoList.get(i).getReservationDateTimestamp());
		}

		for (int i = 0; i < timeStampFomrmatList.size(); i++) {
			String reservationDate = new SimpleDateFormat("yyyy/MM/dd").format(timeStampFomrmatList.get(i));
			String reservationTime = new SimpleDateFormat("HH:mm").format(timeStampFomrmatList.get(i));
			reservationInfoList.get(i).setReservationDateString(reservationDate);
			reservationInfoList.get(i).setReservationTimeString(reservationTime);

			switch (reservationInfoList.get(i).getCourseNumber()) {
			case 0:
				reservationInfoList.get(i).setCourseString("A");
				break;
			case 1:
				reservationInfoList.get(i).setCourseString("B");
				break;
			case 2:
				reservationInfoList.get(i).setCourseString("C");

			default:
				break;
			}
		}
		result = SUCCESS;
		return result;
	}

	/**
	 * 曜日変換メソッド
	 *
	 * @since 2015/04/16
	 * @return WEEK 曜日
	 */
	public String checkWeek(int i) {
		String week = null;
		switch (i) {
		case 0:
			String week1 = "Monday";
			week = week1;
			break;
		case 1:
			String week2 = "Tuesday";
			week = week2;
			break;
		case 2:
			String week3 = "Wednesday";
			week = week3;
			break;
		case 3:
			String week4 = "Thursday";
			week = week4;
			break;
		case 4:
			String week5 = "Friday";
			week = week5;
			break;
		case 5:
			String week6 = "Saturday";
			week = week6;
			break;
		case 6:
			String week7 = "Sunday";
			week = week7;
			break;
		}
		return week;
	}

	/**
	 * 日付リスト取得メソッド
	 *
	 * @return tomorrowList 日付リスト
	 */
	public List<String> getTomorrowList() {
		return tomorrowList;
	}

	/**
	 * 空席情報リスト取得メソッド
	 *
	 * @return vacancyList 空席情報リスト
	 */
	public List<String> getVacancyList() {
		return vacancyList;
	}

	/**
	 * メッセージ取得メソッド
	 *
	 * @return message メッセージ
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 曜日リスト取得メソッド
	 *
	 * @return nextWeekList 曜日リスト
	 */
	public List<String> getNextWeekList() {
		return nextWeekList;
	}

	/**
	 * セッション情報登録メソッド
	 *
	 * @param session
	 *            セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

	/**
	 * ユーザー予約情報取得メソッド
	 *
	 * @return reservationInfoList ユーザー予約情報取得メソッド
	 */
	public List<ReservationInfoDTO> getReservationInfoList() {
		return reservationInfoList;
	}

	/**
	 * 予約番号取得メソッド
	 *
	 * @return customerReservationNumber 予約番号取得メソッド
	 */
	public int getCustomerReservationNumber() {
		return customerReservationNumber;
	}

	/**
	 * 予約番号登録メソッド
	 *
	 * @return customerReservationNumber 予約番号登録メソッド
	 */
	public void setCustomerReservationNumber(int customerReservationNumber) {
		this.customerReservationNumber = customerReservationNumber;
	}

	/**
	 * コース番号取得メソッド
	 *
	 * @return courseNumber コース番号取得メソッド
	 */
	public int getCourseNumber() {
		return courseNumber;
	}

	/**
	 * コース番号登録メソッド
	 *
	 * @return courseNumber コース番号登録メソッド
	 */
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * 予約人数取得メソッド
	 *
	 * @return numberOfPeople 予約人数取得メソッド
	 */
	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	/**
	 * 予約人数登録メソッド
	 *
	 * @return numberOfPeople 予約人数登録メソッド
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * 予約日取得メソッド
	 *
	 * @return reservationDate 予約日取得メソッド
	 */
	public String getReservationDate() {
		return reservationDate;
	}

	/**
	 * 予約日登録メソッド
	 *
	 * @return reservationDate 予約日登録メソッド
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * 予約時間取得メソッド
	 *
	 * @return reservationTime 予約時間取得メソッド
	 */
	public String getReservationTime() {
		return reservationTime;
	}

	/**
	 * 予約時間登録メソッド
	 *
	 * @return reservationTime 予約時間登録メソッド
	 */
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	/**
	 * コース番号(String)取得メソッド
	 *
	 * @return courseNumberString コース番号(String)取得メソッドメソッド
	 */
	public String getCourseNumberString() {
		return courseNumberString;
	}

	/**
	 * コース番号(String)登録メソッド
	 *
	 * @return courseNumberString コース番号(String)登録メソッド
	 */
	public void setCourseNumberString(String courseNumberString) {
		this.courseNumberString = courseNumberString;
	}

}
