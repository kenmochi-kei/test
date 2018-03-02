package com.internousdev.solare.dto;

/**
 * UpdateReservationEditDTO アップデートリザベーションエディットディーティーオー
 *
 * @since 2015/04/14
 * @version 1.0
 */
public class UpdateReservationEditDTO {

	/**
	 * 会員予約番号
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private int customerReservationNumber;

	/**
	 * コース番号
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private int courseNumber;

	/**
	 * 予約人数
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private int numberOfPeople;

	/**
	 * 予約時間
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private String reservationTime;

	/**
	 * 来店日時
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private String reservationDate;

	/**
	 * 予約番号
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private int reservationNumber;

	/**
	 * アカウント番号
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private int accountNumber;

	/**
	 * 会員予約番号取得メソッド
	 *
	 * @return customerReservationNumber 顧客予約番号
	 */
	public int getCustomerReservationNumber() {
		return customerReservationNumber;
	}

	/**
	 * 会員予約番号登録メソッド
	 *
	 * @param customerReservationNumber
	 *            顧客予約番号
	 */
	public void setCustomerReservationNumber(int customerReservationNumber) {
		this.customerReservationNumber = customerReservationNumber;
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
	 * @param numberOfPeople2
	 *            予約人数
	 * @param numberOfPeople
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
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
	 * 来店日時取得メソッド
	 *
	 * @return reservationDate 来店日時
	 */
	public String getReservationDate() {
		return reservationDate;
	}

	/**
	 * 来店日時登録メソッド
	 *
	 * @param reservationDate
	 *            来店日時
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * 予約番号取得メソッド
	 *
	 * @return reservationNumber 予約番号
	 */
	public int getReservationNumber() {
		return reservationNumber;
	}

	/**
	 * 予約番号登録メソッド
	 *
	 * @param reservationNumber
	 *            予約番号
	 */
	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	/**
	 * アカウント番号取得メソッド
	 *
	 * @return accountNumber アカウント番号
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * アカウント番号登録メソッド
	 *
	 * @param accountNumber
	 *            アカウント番号
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
}
