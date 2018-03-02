package com.internousdev.solare.dto;

/**
 * GoToUpdateCustomerConfirmDTO ゴートゥーアップデートカスタマーコンファームディーティーオー
 *
 * @since 2015/4/20
 * @version 1.0
 *
 */
public class GoToUpdateCustomerConfirmDTO {

	/**
	 * 苗字
	 *
	 * @since 2015/4/20
	 * @version 1.0
	 */
	private String lastName;

	/**
	 * 名前
	 *
	 * @since 2015/4/20
	 * @version 1.0
	 */
	private String firstName;

	/**
	 * 電話番号
	 *
	 * @since 2015/4/20
	 * @version 1.0
	 */
	private String userTel;

	/**
	 * メールアドレス
	 *
	 * @since 2015/4/20
	 * @version 1.0
	 */
	private String userEmail;

	/**
	 * 性別
	 *
	 * @since 2015/4/20
	 * @version 1.0
	 */
	private int gender;

	/**
	 * ユーザーID
	 *
	 * @since 2015/4/20
	 * @version 1.0
	 */
	private String userId;

	/**
	 * ユーザーパスワード
	 *
	 * @since 2015/4/20
	 * @version 1.0
	 */
	private String userPassword;

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
	 * 電話番号取得メソッド
	 *
	 * @return userTel 電話番号
	 */
	public String getUserTel() {
		return userTel;
	}

	/**
	 * 電話番号登録メソッド
	 *
	 * @param userTel
	 *            電話番号
	 */
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	/**
	 * メールアドレス取得メソッド
	 *
	 * @return userEmail メールアドレス
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * メールアドレス登録メソッド
	 *
	 * @param userEmail
	 *            メールアドレス
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * 性別取得メソッド
	 *
	 * @return gender 性別
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * 性別登録メソッド
	 *
	 * @param gender
	 *            性別
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

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
	 * ユーザーパスワード取得メソッド
	 *
	 * @return userPassword ユーザーパスワード
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * ユーザーパスワード登録メソッド
	 *
	 * @param userPassword
	 *            ユーザーパスワード
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
