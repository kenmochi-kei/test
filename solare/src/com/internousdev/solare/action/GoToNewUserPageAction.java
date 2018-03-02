package com.internousdev.solare.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToNewUserAction 新規登録画面へ遷移するためのクラス
 *
 * @since 2015/04/06
 * @version 1.0
 */
public class GoToNewUserPageAction extends ActionSupport {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private static final long serialVersionUID = -8000708529554031043L;

	/**
	 * 来店日時
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private String reservationDate;

	/**
	 * コース番号
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private int courseNumber;

	/**
	 * 予約時間
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private String reservationTime;

	/**
	 * 予約人数
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private int numberOfPeople;

	/**
	 * コース(String)
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private String courseString;

	/**
	 * ユーザー遷移先リクエスト
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private String userRequest;

	/**
	 * 実行メソッド
	 *
	 * @since 2015/04/06
	 * @return result 結果
	 */
	public String excute() {
		return SUCCESS;
	}

	/**
	 * 予約日取得メソッド
	 *
	 * @return reservationDate 予約日
	 */
	public String getReservationDate() {
		return reservationDate;
	}

	/**
	 * 予約日登録メソッド
	 *
	 * @param reservationDate
	 *            予約日
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * コース番号取得メソッド
	 *
	 * @return 予約コース番号
	 */
	public int getCourseNumber() {
		return courseNumber;
	}

	/**
	 * コース番号登録メソッド
	 *
	 * @param courseNumber
	 *            予約番号
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
	 * コース番号取得メソッド
	 *
	 * @return courseString 予約コース名
	 */
	public String getCourseString() {
		return courseString;
	}

	/**
	 * コース番号登録メソッド
	 *
	 * @param courseString
	 *            予約コース名
	 */
	public void setCourseString(String courseString) {
		this.courseString = courseString;
	}

	/**
	 * ユーザー遷移先リクエスト情報取得メソッド
	 *
	 * @return userRequest ユーザー遷移先リクエスト情報
	 */
	public String getUserRequest() {
		return userRequest;
	}

	/**
	 * ユーザー遷移先リクエスト情報登録メソッド
	 *
	 * @param userRequest
	 *            ユーザー遷移先リクエスト
	 */
	public void setUserRequest(String userRequest) {
		this.userRequest = userRequest;
	}

}
