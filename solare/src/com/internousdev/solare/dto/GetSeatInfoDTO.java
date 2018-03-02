package com.internousdev.solare.dto;

/**
 * GetSeatInfoDTO ゲットシートインフォディーティーオー
 *
 * @since 2015/03/06
 * @version 1.0
 */
public class GetSeatInfoDTO {

	/**
	 * 日付
	 *
	 * @since 2015/03/06
	 * @version 1.0
	 */
	private String date;

	/**
	 * 来店曜日
	 *
	 * @since 2015/03/06
	 * @version 1.0
	 */
	private int dayOfWeek;

	/**
	 * 最大予約人数
	 *
	 * @since 2015/03/06
	 * @version 1.0
	 */
	private int maxNumberOfPpl;

	/**
	 * 空席数
	 *
	 * @since 2015/03/06
	 * @version 1.0
	 */
	private int remainingSeat;

	/**
	 * 日付取得メソッド
	 *
	 * @return date 日付
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 日時登録メソッド
	 *
	 * @param dete
	 *            日時
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 曜日取得メソッド
	 *
	 * @return dayOfWeek 曜日
	 */
	public int getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * 曜日登録メソッド
	 *
	 * @param dayOfWeek
	 *            曜日
	 */
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * 最大予約人数取得メソッド
	 *
	 * @return maxNumberOfPpl 最大予約人数
	 */
	public int getMaxNumberOfPpl() {
		return maxNumberOfPpl;
	}

	/**
	 * 最大予約人数登録メソッド
	 *
	 * @param maxNumberOfPpl
	 *            最大予約人数
	 */
	public void setMaxNumberOfPpl(int maxNumberOfPpl) {
		this.maxNumberOfPpl = maxNumberOfPpl;
	}

	/**
	 * 空席数取得メソッド
	 *
	 * @return remainingSeat 空席数
	 */
	public int getRemainingSeat() {
		return remainingSeat;
	}

	/**
	 * 空席数登録メソッド
	 *
	 * @param remainingSeat
	 *            空席数
	 */
	public void setRemainingSeat(int remainingSeat) {
		this.remainingSeat = remainingSeat;
	}
}
