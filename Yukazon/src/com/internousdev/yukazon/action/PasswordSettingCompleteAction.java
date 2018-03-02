package com.internousdev.yukazon.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.yukazon.dao.PasswordSettingCompleteDAO;
import com.internousdev.yukazon.dto.PasswordSettingDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PasswordSettingCompleteAction extends ActionSupport implements SessionAware{
	//ユーザーID
	private String loginId;
	//パスワード
	private String loginPassword;
	//確認パスワード
	private String checkLoginPassword;
	//ログイン情報を格納しておくMap
	public Map<String, Object> session;
	//パスワード設定DAO
	private PasswordSettingCompleteDAO dao = new PasswordSettingCompleteDAO();
	//エラーメッセージ
	private String errorMassage;

	/* パスワード変更実行メソッドexecute--------------------------------------- */
	public String execute() throws SQLException{

		String result = ERROR;

		//もしpasswordSetting.jspでの入力が空欄ではなかったら(jspで"required"設定しているけど完全ではない為)
		if(!(loginPassword.equals("")) && !(checkLoginPassword.equals(""))) {
			//もしpasswordSetting.jspで入力した"loginPassword"と"checkLoginPassword"が等しければ
			if(loginPassword.equals(checkLoginPassword)){
				//PasswordSettingCompleteDAOの"PasswordUpdateInfo"
				boolean checkUpdate =dao.PasswordUpdateInfo (
						loginPassword,
						((PasswordSettingDTO) session.get("updateLoginUser")).getLoginId());
					if(checkUpdate){
						result = SUCCESS;
						//passwordSettingComplete.jspで使用するためput
						session.put("loginPassword", loginPassword);
					}
			}else{
				setErrorMassage("パスワードと確認パスワードが違います。");
			}
		}
		return result;
	}

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getCheckLoginPassword() {
		return checkLoginPassword;
	}
	public void setCheckLoginPassword(String checkPassword) {
		this.checkLoginPassword = checkPassword;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getErrorMassage() {
		return errorMassage;
	}
	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}
}

