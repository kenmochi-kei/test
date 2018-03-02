package com.internousdev.solare.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.LoginDAO;
import com.internousdev.solare.dao.SearchInfoDAO;
import com.internousdev.solare.dto.GetSeatInfoDTO;
import com.internousdev.solare.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * LoginAction
 * ログインアクション
 * @since 2015/04/06
 * @version 1.0
 */

/**
 * アカウント情報を渡し、予約状況を取得して渡すアクション。
 *
 * @since 2016/04/18
 * @version 1.0
 */
public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private static final long serialVersionUID = -3426942618662393785L;

	/**
	 * ユーザーID
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String userId;

	/**
	 * ユーザーパスワード
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String userPassword;

	/**
	 * メッセージ
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String message;

	/**
	 * セッション情報
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * 来店日時
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String reservationDate;

	/**
	 * コース番号
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private int courseNumber;

	/**
	 * 予約時間
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String reservationTime;

	/**
	 * 予約人数
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private int numberOfPeople;

	/**
	 * 日付リスト
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private List<String> tomorrowList = new ArrayList<String>();

	/**
	 * 曜日リスト
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private List<String> nextWeekList = new ArrayList<String>();

	/**
	 * 空席情報リスト
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private List<String> vacancyList = new ArrayList<String>();

	/**
	 * 席情報リスト
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private List<GetSeatInfoDTO> seatInfoList = new ArrayList<GetSeatInfoDTO>();

	/**
	 * チェック用席情報リスト
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private ArrayList<GetSeatInfoDTO> checkRecordList = new ArrayList<GetSeatInfoDTO>();

	/**
	 * コース番号
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String courseString;

	/**
	 * ユーザーリクエスト
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String userRequest;

	/**
	 * ログアウトフラグ
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String logOutFlag;

	/**
	 * 実行メソッド
	 *
	 * @return result 結果
	 */
	public String execute() throws Exception {
		String result = ERROR;
		String judge = "◎";
		String judge2 = "△";
		String judge3 = "×";

		List<LoginDTO> userInfoList = new ArrayList<LoginDTO>();
		SearchInfoDAO searchInfoDao = new SearchInfoDAO();
		try {
			LoginDAO dao = new LoginDAO();
			if (dao.isLoginCheck(userId, userPassword)) {

				userInfoList = dao.getUserInfoList();
				sessionMap.put("lastName", userInfoList.get(0).getLastName());
				sessionMap.put("userId", userInfoList.get(0).getUserId());
				sessionMap.put("userPassword",userInfoList.get(0).getLastName());
				sessionMap.put("accountNumber",userInfoList.get(0).getAccountNumber());
				if (!logOutFlag.isEmpty()) {

					if (logOutFlag.equals("logOutComplete")) {
						result = "goMyPage";
						return result;
					}
				}
				if (userRequest.equals("goMyPage")) {

					result = "goMyPage";
					return result;
				} else {

					int check = searchInfoDao.checkRecordNum();

					if (check == 7) {
						searchInfoDao.select();
						seatInfoList.addAll(searchInfoDao.getSeatInfoList());

						for (int j = 0; j < seatInfoList.size(); j++) {

							tomorrowList.add(seatInfoList.get(j).getDate());

							nextWeekList.add(checkWeek(seatInfoList.get(j).getDayOfWeek()));

							int check2 = (seatInfoList.get(j).getMaxNumberOfPpl() - seatInfoList
									.get(j).getRemainingSeat());

							if (check2 >= 70) {
								vacancyList.add(judge);
							} else if (check2 > 10 && check2 > 70) {
								vacancyList.add(judge2);
							} else if (check2 < 10) {
								vacancyList.add(judge3);
							}

						}
					} else if(check == 0){
						searchInfoDao.insertZeroRecord();
						searchInfoDao.select();
						seatInfoList.addAll(searchInfoDao.getSeatInfoList());
						for (int j = 0; j < seatInfoList.size(); j++) {
							tomorrowList.add(seatInfoList.get(j).getDate());
							nextWeekList.add(checkWeek(seatInfoList.get(j).getDayOfWeek()));
							int check2 = (seatInfoList.get(j).getMaxNumberOfPpl() - seatInfoList
									.get(j).getRemainingSeat());
							if (check2 >= 70) {
								vacancyList.add(judge);
							} else if (check2 > 10 && check2 > 70) {
								vacancyList.add(judge2);
							} else if (check2 < 10) {
								vacancyList.add(judge3);
							}
						}
					} else {
						checkRecordList.addAll(searchInfoDao.getCheckRecordList());
						String date = checkRecordList.get(checkRecordList.size() - 1).getDate();
						searchInfoDao.insertRecord(date);
						searchInfoDao.select();
						seatInfoList.addAll(searchInfoDao.getSeatInfoList());
						for (int j = 0; j < seatInfoList.size(); j++) {
							tomorrowList.add(seatInfoList.get(j).getDate());
							nextWeekList.add(checkWeek(seatInfoList.get(j).getDayOfWeek()));
							int check2 = (seatInfoList.get(j).getMaxNumberOfPpl() - seatInfoList
									.get(j).getRemainingSeat());
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
				}
			} else {
				message = "IDまたはパスワードが違います";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 空き日程情報をSessiinに格納
		sessionMap.put("tomorrowList", tomorrowList);
		sessionMap.put("nextWeekList", nextWeekList);
		sessionMap.put("vacancyList", vacancyList);

		return result;
	}

	/**
	 * 曜日変換メソッド
	 *
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
	 * セッション情報登録メソッド
	 *
	 * @return session セッション情報
	 */
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

	/**
	 * エラーメッセージ取得メソッド
	 *
	 * @return message エラーメッセージ
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * ユーザーID登録メソッド
	 *
	 * @param userId
	 *            ユーザーID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザーID登録メソッド
	 *
	 * @param userId
	 *            ユーザーID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * ユーザーパスワード登録メソッド
	 *
	 * @return userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * ユーザーパスワード取得メソッド
	 *
	 * @param userPassword
	 *            セットする userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 予約日時取得メソッド
	 *
	 * @return reservationDate 予約日時
	 */
	public String getReservationDate() {
		return reservationDate;
	}

	/**
	 * 予約日時登録メソッド
	 *
	 * @param reservationDate
	 *            予約日時
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * コース番号取得メソッド
	 *
	 * @return courseNumber コース番号
	 */
	public int getCourseNumber() {
		return courseNumber;
	}

	/**
	 * コース番号登録メソッド
	 *
	 * @param courseNumber
	 *            コース番号
	 */
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * 予約時間取得メソッド
	 *
	 * @return reservationTime 予約時間
	 */
	public String getReservationTime() {
		return reservationTime;
	}

	/**
	 * 予約時間登録メソッド
	 *
	 * @param reservationTime
	 *            予約時間
	 */
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	/**
	 * 予約人数取得メソッド
	 *
	 * @return numberOfPeople 予約人数
	 */
	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	/**
	 * 予約人数登録メソッド
	 *
	 * @param numberOfPeople
	 *            予約人数
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * コース名取得メソッド
	 *
	 * @return courseString コース名
	 */
	public String getCourseString() {
		return courseString;
	}

	/**
	 * コース名取得メソッド
	 *
	 * @param courseString
	 *            コース名
	 */
	public void setCourseString(String courseString) {
		this.courseString = courseString;
	}

	/**
	 * ユーザー遷移先リクエスト情報登録メソッド
	 *
	 * @param userRequest
	 *            ユーザー遷移先リクエスト情報
	 */
	public void setUserRequest(String userRequest) {
		this.userRequest = userRequest;
	}

	/**
	 * ログアウトフラグ登録メソッド
	 *
	 * @param logOutFlag
	 */
	public void setLogOutFlag(String logOutFlag) {
		this.logOutFlag = logOutFlag;
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
	 * 曜日リスト取得メソッド
	 *
	 * @return nextWeekList 曜日リスト
	 */
	public List<String> getNextWeekList() {
		return nextWeekList;
	}
}
