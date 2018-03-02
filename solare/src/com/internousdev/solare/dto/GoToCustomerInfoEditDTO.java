package com.internousdev.solare.dto;

/**
 * GoToCustomerInfoEditDTO ゴートゥーカスタマーインフォエディットディーティーオー
 *
 * @since 2015/04/16
 * @version 1.0
 */
public class GoToCustomerInfoEditDTO {

	/**
	 * ユーザーID
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String userId;

	/**
	 * 苗字
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String lastName;

	/**
	 * 名前
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String firstName;

	/**
	 * 氏名
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String fullName;

	/**
	 * メールアドレス
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String mailAddress;

	/**
	 * 性別
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	public int genderInt;

	/**
	 * 性別
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String genderStr;

	/**
	 * ユーザーID取得メソッド
	 *
	 * @return userId ユーザーID
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
	 * 苗字取得メソッド
	 *
	 * @return lastName 苗字
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 苗字登録メソッド
	 *
	 * @param lastName
	 *            苗字
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 名前取得メソッド
	 *
	 * @return firstName 名前
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 名前登録メソッド
	 *
	 * @param firstName
	 *            名前
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 氏名取得メソッド
	 *
	 * @return fullName 氏名
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * 氏名登録メソッド
	 *
	 * @param fullName
	 *            氏名
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * メールアドレス取得メソッド
	 *
	 * @return mailAddress メールアドレス
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * メールアドレス登録メソッド
	 *
	 * @param mailAddress
	 *            メールアドレス
	 */

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * 性別取得メソッド
	 *
	 * @return genderInt 性別
	 */
	public int getGenderInt() {
		return genderInt;
	}

	/**
	 * 性別登録メソッド
	 *
	 * @param genderInt
	 *            性別
	 */
	public void setGenderInt(int genderInt) {
		this.genderInt = genderInt;
	}

	/**
	 * 性別取得メソッド
	 *
	 * @return genderStr 性別
	 */
	public String getGenderStr() {
		return genderStr;
	}

	/**
	 * 性別登録メソッド
	 *
	 * @param genderStr
	 *            性別
	 */
	public void setGenderStr(String genderStr) {
		this.genderStr = genderStr;
	}

}
