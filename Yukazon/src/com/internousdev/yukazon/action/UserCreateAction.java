package com.internousdev.yukazon.action;
import com.opensymphony.xwork2.ActionSupport;

/* home.jsp,loginError.jspから新規ユーザー登録画面に移行する */
public class UserCreateAction extends ActionSupport {
	public String execute() {
		return SUCCESS;
	}
}