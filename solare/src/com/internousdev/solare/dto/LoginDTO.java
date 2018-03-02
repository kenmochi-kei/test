package com.internousdev.solare.dto;

/**
 * LoginDTO ログインディーティーオー
 *
 * @since 2015/04/06
 * @version 1.0
 */
public class LoginDTO {

	/**
	 * 苗字
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private String lastName;

	/**
	 * ユーザーID
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private String userId;

	/**
	 * ユーザーパスワード
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private String userPassword;

	/**
	 * アカウントナンバー
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private int accountNumber;

	/**
	 * 苗字登録メソッド
	 *
	 * @return lastName 苗字
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * ユーザーID登録メソッド
	 *
	 * @return userId ユーザーID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * ユーザーPass登録メソッド
	 *
	 * @return userPassword ユーザーPass
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * ユーザーPass取得メソッド
	 *
	 * @return userPassword ユーザーPass
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * アカウント番号登録メソッド
	 *
	 * @return accountNumber アカウント番号
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * アカウント番号取得メソッド
	 *
	 * @return accountNumber アカウント番号
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
}
