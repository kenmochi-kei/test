package com.internousdev.yukazon.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.yukazon.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	//ユーザーID
	private String loginUserId;
	//パスワード
	private String loginPassword;
	//ログイン情報を格納しておくMap
	public Map<String,Object> session;
	//データーベース情報取得
	private UserCreateCompleteDAO dao = new UserCreateCompleteDAO();

	/* 新規登録実行メソッドexecute---------------------------- */
	public String execute() throws SQLException {
		//UserCreateCompleteDAOから呼び出してString型に変える
		dao.createUser(session.get("loginUserId").toString(),
			session.get("loginPassword").toString(),
			session.get("secretQuestion").toString(),
			session.get("secretAnswer").toString());
		//resultに初期値SUCCESSを代入
		String result = SUCCESS;
		//結果を"result"に返す
		return result ;
	}

	//登録情報とsessionはprivateにしているため呼び出せるようにしておく
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public UserCreateCompleteDAO getDao() {
		return dao;
	}
}
