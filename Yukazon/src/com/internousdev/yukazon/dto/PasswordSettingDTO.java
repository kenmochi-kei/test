package com.internousdev.yukazon.dto;

/*  PasswordSettingActionやPasswordSettingDAOから呼び出される
 * privateにしてあるため呼び出せるようにしておく */
public class PasswordSettingDTO {

	private String loginId;
	private String secretQuestion;
	private String secretAnswer;
	private boolean updateLoginFlg = false;

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	public boolean getUpdateLoginFlg() {
		return updateLoginFlg;
	}
	public void setUpdateLoginFlg(boolean updateLoginFlg) {
		this.updateLoginFlg = updateLoginFlg;
	}

}
