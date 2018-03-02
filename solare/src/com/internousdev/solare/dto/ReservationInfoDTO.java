package com.internousdev.solare.dto;

import java.sql.Timestamp;

/**
 * ReservationInfoDTO リザベーションインフォディーティーオー
 *
 * @since 2015/04/20
 * @version 1.0
 *
 */
public class ReservationInfoDTO {

	/**
	 * 顧客予約番号
	 *
	 * @since 2015/04/20
	 * @version 1.0
	 */
	private int customerReservationNumber;

	/**
	 * コース番号
	 *
	 * @since 2015/04/20
	 * @version 1.0
	 */
	private int courseNumber;

	/**
	 * 予約人数
	 *
	 * @since 2015/04/20
	 * @version 1.0
	 */
	private int numberOfPeople;

	/**
	 * 来店日時
	 *
	 * @since 2015/04/20
	 * @version 1.0
	 */
	private Timestamp reservationDateTimestamp;

	/**
	 * 来店日文字列型
	 *
	 * @since 2015/04/20
	 * @version 1.0
	 */
	private String reservationDateString;

	/**
	 * コース滞在時間
	 *
	 * @since 2015/04/20
	 * @version 1.0
	 */
	private int reservationTime;

	/**
	 * 来店時間文字列型
	 *
	 * @since 2015/04/20
	 * @version 1.0
	 */
	private String reservationTimeString;

	/**
	 * コース名
	 *
	 * @since 2015/04/20
	 * @version 1.0
	 */
	private String courseString;

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
	 * @param numberOfPeople
	 *            予約人数
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * 予約日時取得メソッド
	 *
	 * @return reservationDateTimestamp 予約日時
	 */
	public Timestamp getReservationDateTimestamp() {
		return reservationDateTimestamp;
	}

	/**
	 * 予約日時登録メソッド
	 *
	 * @param reservationDateTimestamp
	 *            予約日時
	 */
	public void setReservationDateTimestamp(Timestamp reservationDateTimestamp) {
		this.reservationDateTimestamp = reservationDateTimestamp;
	}

	/**
	 * 予約時間取得メソッド
	 *
	 * @return reservationTime 予約時間
	 */
	public int getReservationTime() {
		return reservationTime;
	}

	/**
	 * 予約時間登録メソッド
	 *
	 * @param reservationTime
	 *            予約時間
	 */
	public void setReservationTime(int reservationTime) {
		this.reservationTime = reservationTime;
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
	 * コース名登録メソッド
	 *
	 * @param courseString
	 *            コース名
	 */
	public void setCourseString(String courseString) {
		this.courseString = courseString;
	}

	/**
	 * 顧客予約番号取得メソッド
	 *
	 * @return customerRservationNumber 顧客予約番号
	 */
	public int getCustomerReservationNumber() {
		return customerReservationNumber;
	}

	/**
	 * 顧客予約番号登録メソッド
	 *
	 * @param customerReservationNumber
	 *            顧客予約番号
	 */
	public void setCustomerReservationNumber(int customerReservationNumber) {
		this.customerReservationNumber = customerReservationNumber;
	}

	/**
	 * 来店日文字列型取得メソッド
	 *
	 * @return reservationDateString 来店日文字列型
	 */
	public String getReservationDateString() {
		return reservationDateString;
	}

	/**
	 * 来店日文字列型登録メソッド
	 *
	 * @param reservationDateString
	 *            来店日文字列型
	 */
	public void setReservationDateString(String reservationDateString) {
		this.reservationDateString = reservationDateString;
	}

	/**
	 * 来店時間文字列型取得メソッド
	 *
	 * @return reservationTimeString 来店時間文字列型
	 */
	public String getReservationTimeString() {
		return reservationTimeString;
	}

	/**
	 * 来店時間文字列型登録メソッド
	 *
	 * @param reservationTimeString
	 *            来店時間文字列型
	 */
	public void setReservationTimeString(String reservationTimeString) {
		this.reservationTimeString = reservationTimeString;
	}
}
