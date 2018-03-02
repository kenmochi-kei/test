package com.internousdev.cherry.action;


import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport{

	private String userId;
	private boolean saveLogin;
	private String saveId;


	public String execute(){
		String ret=SUCCESS;
		return ret;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isSaveLogin() {
		return saveLogin;
	}
	public void setSaveLogin(boolean saveLogin) {
		this.saveLogin = saveLogin;
	}

	public String getSaveId() {
		return saveId;
	}
	public void setSaveId(String saveId) {
		this.saveId = saveId;
	}
}