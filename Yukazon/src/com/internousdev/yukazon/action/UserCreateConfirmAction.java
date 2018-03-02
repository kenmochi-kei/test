package com.internousdev.yukazon.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.yukazon.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *新規ユーザー登録処理
 *userCreate.jspから入力情報を受け取り
 * @author internous
 *
 */

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
	//ユーザーID
	private String loginUserId;
	//パスワード
	private String loginPassword;
	//確認パスワード
	private String checkLoginPassword;
	//パスワードを忘れた時の質問
	private String secretQuestion;
	//質問の答え
	private String secretAnswer;
	//ログイン情報を格納しておくMap
	public Map<String,Object> session;
	//エラーメッセージ
	private String errorMassage;

	/* 実行メソッドexecute------------------------------------ */
	public String execute() {
		//resultに初期値SUCCESSを代入
		String result = SUCCESS;

		//もしuserCreate.jspでの入力が空欄ではなかったら(jspで"required"設定しているけど完全ではない為)
		if(!(loginUserId.equals("")) && !(loginPassword.equals("")) && !(secretQuestion.equals("質問を選んでください"))
				&& !(secretAnswer.equals(""))) {
			//もしuserCreate.jspで入力した"loginPassword"と"checkLoginPassword"が等しくなければ
			if(loginPassword.equals(checkLoginPassword)){
				//データーベース情報取得
				UserCreateConfirmDAO dao = new UserCreateConfirmDAO();
				//UserCreateConfirmDAOの"getUserInfo"メソッドの結果を"checkId"に代入
				boolean checkId = dao.getUserInfo(loginUserId, loginPassword);
					//userCreateConfirm.jspで使うのでsessionしておく
					if(checkId){
						session.put("loginUserId", loginUserId);
						session.put("loginPassword", loginPassword);
						session.put("secretQuestion", secretQuestion);
						session.put("secretAnswer", secretAnswer);
					}else{
					setErrorMassage("そのIDは使われています。");
					result = ERROR;
					}
			}else{
				setErrorMassage("パスワードと確認パスワードが違います。");
				result=ERROR;
			}
		}else {
			if (secretQuestion.equals("質問を選んでください")) {
				setErrorMassage("パスワードを忘れた時の質問を選んでください。");
			} else {
				setErrorMassage("未入力の項目があります。");
			}
			result = ERROR;
		}
		return result;
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
	public String getCheckLoginPassword() {
		return checkLoginPassword;
	}
	public void setCheckLoginPassword(String checkPassword) {
		this.checkLoginPassword = checkPassword;
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
	public String getErrorMassage() {
		return errorMassage;
	}
	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}
}
