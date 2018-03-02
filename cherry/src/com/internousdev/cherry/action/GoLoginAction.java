package com.internousdev.cherry.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	public Map<String, Object> session;
	// private String userId;
	String result = null;
	private boolean loginFlg;

	public String execute() {

		if (session.containsKey("loginFlg")) {
			loginFlg = (boolean) session.get("loginFlg");
			System.out.println(loginFlg);
			if (loginFlg != true) {
				result = ERROR;

				// if(!session.containsKey("userId")){

			} else {

				// if (session.containsKey("loginFlg")) {

				result = SUCCESS;
			}
		}

		return result;

	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return this.session;
	}

	/**
	 * @Override
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public boolean isLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

}