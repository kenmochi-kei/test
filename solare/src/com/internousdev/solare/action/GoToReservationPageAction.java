package com.internousdev.solare.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.solare.dao.SearchInfoDAO;
import com.internousdev.solare.dto.GetSeatInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToReservationPageAction 予約可能な曜日と時間を照会するためのクラス
 *
 * @since 2015/04/15
 * @version 1.0
 */
public class GoToReservationPageAction extends ActionSupport {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private static final long serialVersionUID = 9021709457191194116L;

	/**
	 * 日付リスト
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private List<String> tomorrowList = new ArrayList<String>();

	/**
	 * 曜日リスト
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private List<String> nextWeekList = new ArrayList<String>();

	/**
	 * 空席情報リスト
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private List<String> vacancyList = new ArrayList<String>();

	/**
	 * 席情報リスト
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private List<GetSeatInfoDTO> seatInfoList = new ArrayList<GetSeatInfoDTO>();

	/**
	 * チェック用席情報リスト
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private ArrayList<GetSeatInfoDTO> checkRecordList = new ArrayList<GetSeatInfoDTO>();

	/**
	 * メッセージ
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String message;

	/**
	 * 実行メソッド
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 * @return result 結果
	 */
	public String execute() throws Exception {
		String result = ERROR;
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
		result = SUCCESS;
		return result;
	}

	/**
	 * 曜日変換メソッド
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 * @return WEEK 曜日
	 */
	public String checkWeek(int i) {
		String WEEK = null;
		switch (i) {
		case 0:
			String week1 = "Monday";
			WEEK = week1;
			break;
		case 1:
			String week2 = "Tuesday";
			WEEK = week2;
			break;
		case 2:
			String week3 = "Wednesday";
			WEEK = week3;
			break;
		case 3:
			String week4 = "Thursday";
			WEEK = week4;
			break;
		case 4:
			String week5 = "Friday";
			WEEK = week5;
			break;
		case 5:
			String week6 = "Saturday";
			WEEK = week6;
			break;
		case 6:
			String week7 = "Sunday";
			WEEK = week7;
			break;
		}
		return WEEK;
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
	 * 曜日リスト登録メソッド
	 *
	 * @return nextWeekList 曜日リスト
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
