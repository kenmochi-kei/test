package com.internousdev.solare.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * LoginCheckAction
 *ログイン状態か判断し、ログインされていれば予約を続行するアクション
 * @since 2015/04/08 @version1.0
 */
public class LoginCheckAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/08 @version1.0
	 */
	private static final long serialVersionUID = 5451711762091842945L;

	/**
	 *
	 */

	/**
	 * セッション情報
	 *
	 * @since 2015/04/08 @version1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * 来店日時
	 *
	 * @since 2015/04/08 @version1.0
	 */
	private String reservationDate;

	/**
	 * コース番号
	 *
	 * @since 2015/04/08 @version1.0
	 */
	private int courseNumber;

	/**
	 * 予約時間
	 *
	 * @since 2015/04/08 @version1.0
	 */
	private String reservationTime;

	/**
	 * 予約人数
	 *
	 * @since 2015/04/08 @version1.0
	 */
	private int numberOfPeople;

	/**
	 * コース(String)
	 *
	 * @since 2015/04/08 @version1.0
	 */
	private String courseString;

	/**
	 * 実行メソッド
	 *
	 * @return result 結果
	 */
	public String execute() throws Exception {
		String result = SUCCESS;
		switch (courseNumber) {
		case 0:
			this.courseString = "A";
			break;
		case 1:
			this.courseString = "B";
			break;
		case 2:
			this.courseString = "C";
			break;
		default:
			result = ERROR;
			break;
		}
		if (sessionMap.containsKey("userId") || sessionMap.containsKey("AccessTokenSecret")) {
			if (sessionMap.containsKey("userId") ) {
				result = "skip";
			} else if (sessionMap.containsKey("AccessToken")) {
				result = "skip";
			}
		}
		return result;
	}

	/**
	 * セッション情報登録メソッド
	 *
	 * @param session
	 *            セッション情報
	 */
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
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
	 * コース情報取得メソッド
	 *
	 * @return courseString コース情報
	 */
	public String getCourseString() {
		return courseString;
	}
}
