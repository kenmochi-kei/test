package com.internousdev.solare.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToReservationEditConfirmPageAction コースの変更を行い、確認画面に遷移するアクション
 *
 * @since 2015/04/15
 * @version 1.0
 */
public class GoToReservationEditConfirmPageAction extends ActionSupport {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private static final long serialVersionUID = -5991233436882725182L;

	/**
	 * 予約番号
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private int customerReservationNumber;

	/**
	 * コース番号
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private int courseNumber;

	/**
	 * 予約人数
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private int numberOfPeople;

	/**
	 * 予約日
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String reservationDate;

	/**
	 * 予約時間
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String reservationTime;
	/**
	 * コース番号（String）
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String courseNumberString;

	/**
	 * 実行メソッド
	 *
	 * @since 2015/04/15
	 * @return result
	 */
	public String execute() {
		String result = ERROR;
		switch (courseNumber) {
		case 0:
			this.courseNumberString = "A";
			break;
		case 1:
			this.courseNumberString = "B";
			break;
		case 2:
			this.courseNumberString = "C";
			break;
		default:
			break;
		}

		result = SUCCESS;
		return result;
	}

	/**
	 * 予約番号取得メソッド
	 *
	 * @return customerReservationNumber 予約番号
	 */
	public int getCustomerReservationNumber() {
		return customerReservationNumber;
	}

	/**
	 * 予約番号登録メソッド
	 *
	 * @return customerReservationNumber 予約番号
	 */
	public void setCustomerReservationNumber(int customerReservationNumber) {
		this.customerReservationNumber = customerReservationNumber;
	}

	/**
	 * 予約コース番号取得メソッド
	 *
	 * @return courseNumber コース番号
	 */
	public int getCourseNumber() {
		return courseNumber;
	}

	/**
	 * 予約コース番号登録メソッド
	 *
	 * @return courseNumber コース番号
	 */
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
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
	 * @return reservationDate 予約日
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
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
	 * コース番号（String）取得メソッド
	 *
	 * @return courseNumberString コース番号（String）
	 */
	public String getCourseNumberString() {
		return courseNumberString;
	}

	/**
	 * コース番号（String）登録メソッド
	 *
	 * @return courseNumberString コース番号（String）
	 */
	public void setCourseNumberString(String courseNumberString) {
		this.courseNumberString = courseNumberString;
	}

}