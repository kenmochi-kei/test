package com.internousdev.cherry.dto;

public class MyPageDTO {

	private String userId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	/**
	 * 0:男性、1:女性
	 */
	private boolean sex;
	private String email;
	private String register_date;
	private String update_date;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

}

/**
 * 登録情報テーブル id int PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ID user_id varchar(16)
 * UNIQUE KEY NOT NULL,-- ユーザーID password varchar(16) NOT NULL,-- パスワード
 * family_name varchar(32) NOT NULL, -- 姓 first_name varchar(32) NOT NULL,-- 名
 * family_name_kana varchar(32) NOT NULL,-- 姓かな first_name_kana varchar(32) NOT
 * NULL, -- 名かな sex tinyint NOT NULL DEFAULT 0, -- 性別 (0:男性 1:女性) email
 * varchar(32) NOT NULL,-- メールアドレス status tinyint NOT NULL DEFAULT 1,-- ステータス
 * (0:無効、1:有効) logined tinyint NOT NULL DEFAULT 0,-- ログインフラグ (0:未ログイン、1:ログイン済み)
 * regist_date datetime NOT NULL,-- 登録日 update_date datetime-- 更新日
 */