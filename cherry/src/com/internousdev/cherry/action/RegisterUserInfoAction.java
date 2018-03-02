package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.CartInfoDAO;
import com.internousdev.cherry.dao.UserInfoDAO;
import com.internousdev.cherry.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterUserInfoAction extends ActionSupport implements SessionAware {

	Map<String, Object> session;

	private String userId;

	private String password;

	private String familyName;

	private String firstName;

	private String familyNameKana;

	private String firstNameKana;

	/**
	 * 0:男性、1:女性
	 */
	private String sex;

	private String email;

	public String execute() throws SQLException {
		System.out.println("RegisterUserInfoAction");
		UserInfoDAO dao = new UserInfoDAO();
		UserInfoDTO dto = new UserInfoDTO();
		dto.setUserName(familyName, firstName, familyNameKana, firstNameKana);
		if (sex.equals("0")) {
			dto.setSex(false);
		} else if (sex.equalsIgnoreCase("1")) {
			dto.setSex(true);
		}
		dto.setEmail(email);
		dto.setUserId(userId);
		dto.setPassword(password);

		if (dao.registerUser(dto)) {
			session.put("userId", userId);
			session.put("loginFlg", true);
			// カーとの情報を引き継ぐ
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			cartInfoDAO.changeUserId(session.get("tempUserId").toString(), session.get("userId").toString());

			return SUCCESS;

		} else {
			return SUCCESS;
		}
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public String isSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
}