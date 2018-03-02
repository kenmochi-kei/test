package com.internousdev.solare.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToReservationConfirmAction 予約確認画面へ遷移するアクション
 *
 * @since 2015/04/15
 * @version 1.0
 */
public class GoToReservationConfirmPageAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private static final long serialVersionUID = -745121293003060553L;

	/**
	 * 来店日時
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String reservationDate;

	/**
	 * コース番号
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private int courseNumber;

	/**
	 * 予約時間
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String reservationTime;

	/**
	 * 予約人数
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private int numberOfPeople;

	/**
	 * コース(String)
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String courseString;

	/**
	 * セッション情報
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * ユーザー遷移先リクエスト
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String userRequest;

	/**
	 * 実行メソッド
	 *
	 * @since 2015/04/15
	 * @return result 結果
	 */
	public String execute() {
		String result = ERROR;
		if (!sessionMap.containsKey("userId") && !sessionMap.containsKey("AccessToken")) {
			if (!(userRequest == null) && !userRequest.isEmpty()) {
				return result;
			}
		} else if (courseString.isEmpty() && numberOfPeople == 0 && reservationDate.isEmpty()
				&& reservationTime.isEmpty()) {
			return result;
		} else {
			result = SUCCESS;
		}
		return result;
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
	 * @return reservationDate 予約日時
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
	 * @return courseNumber コース番号
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
	 * @return reservationTime 予約時間
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
	 * @return numberOfPeople 予約人数
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * コース番号(String)取得メソッド
	 *
	 * @return courseString コース番号(String)
	 */
	public String getCourseString() {
		return courseString;
	}

	/**
	 * コース番号(String)登録メソッド
	 *
	 * @return courseString コース番号(String)
	 */
	public void setCourseString(String courseString) {
		this.courseString = courseString;
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
	 * ユーザー遷移先リクエスト登録メソッド
	 *
	 * @param userRequest
	 *            ユーザーリクエスト
	 */
	public void setUserRequest(String userRequest) {
		this.userRequest = userRequest;
	}
}
