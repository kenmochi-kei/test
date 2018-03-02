package com.internousdev.yukazon.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.yukazon.dao.PasswordSettingDAO;
import com.internousdev.yukazon.dto.PasswordSettingDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 秘密の質問、答え認証処理
 * secretQuestionConfirm.jspからログインID、秘密の質問、答えを受け取りDBへ問い合わせる
 */

public class PasswordSettingAction extends ActionSupport implements SessionAware{
	//ユーザーID
	private String loginUserId;
	//秘密の質問
	private String secretQuestion;
	//答え
	private String secretAnswer;
	 //ログイン情報を格納
	public Map<String, Object> session;
	// ログイン情報取得DAO
	private PasswordSettingDAO dao = new PasswordSettingDAO();
	//ログイン情報格納DTO
	private PasswordSettingDTO dto = new PasswordSettingDTO();

	/* 実行メソッドexecute--------------------------------------- */
	public String execute() {
		//resultに初期値EROORを代入
		String result = ERROR;

		//もしSecretQuestionConfirm.jspでの入力が空欄ではなかったら(jspで"required"設定しているけど完全ではない為)
		if( !(loginUserId.equals("")) &&!(secretQuestion.equals("質問を選んでください"))&& !(secretAnswer.equals("")))
		// PasswordSettingDAOのgetLoginUserInfoメソッドの結果をldtoに代入
		dto = dao.getUpdateLoginUserInfo(loginUserId,secretQuestion,secretAnswer);
		//上のldtoを"loginUser"というkeyでsessionに置いておく
		session.put("updateLoginUser", dto);
		//PasswordSetting型にキャスト→Object型のsessionをPasswordSettingDTO型に変更
		//(Object型はそのままgetできないので)
		// ※jspでは自動的にObject型→String型に変更してくれる
		//PasswordSettingDTO型にキャストしたsessionの"LoginFlg"を呼び出す
		if(((PasswordSettingDTO) session.get("updateLoginUser")).getUpdateLoginFlg()) {
			//"result"に"SUCCESS"を代入
			result = SUCCESS;
			//passwordSettingComplete.jspで使用するためput
			session.put("loginUserId", loginUserId);
		}
		return result;
	}

	//ログイン情報とsessionはprivateにしているため呼び出せるようにしておく
		public String getLoginUserId() {
			return loginUserId;
		}
		public void setLoginUserId(String loginUserId) {
			this.loginUserId = loginUserId;
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

		@Override
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}
}
