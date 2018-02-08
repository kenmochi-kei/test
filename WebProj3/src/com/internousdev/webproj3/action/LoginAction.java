package com.internousdev.webproj3.action;

import com.internousdev.webproj3.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;

	public String execute() {
		String ret=ERROR;
		System.out.println(username);
		System.out.println(password);
		LoginDAO dao = new LoginDAO();
		dto = dao.select(username, password);

	}
}
