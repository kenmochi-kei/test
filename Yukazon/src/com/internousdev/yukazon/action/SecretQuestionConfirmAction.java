package com.internousdev.yukazon.action;

import com.opensymphony.xwork2.ActionSupport;

/* home.jsp,loginError.jspからパスワード再設定秘密の質問、答え画面に移行する */
public class SecretQuestionConfirmAction extends ActionSupport {
	public String execute() {
		return SUCCESS;
	}
}