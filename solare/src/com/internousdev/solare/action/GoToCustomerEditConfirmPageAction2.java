package com.internousdev.solare.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.GoToUpdateCustomerConfirmDAO;
import com.internousdev.solare.dto.GoToUpdateCustomerConfirmDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToCustomerEditConfirmPageAction 変更した会員情報の確認用アクション
 *
 * @since 2015/04/16
 * @version 1.0
 */
public class GoToCustomerEditConfirmPageAction2 extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private static final long serialVersionUID = -7590471467226420782L;

	/**
	 * 会員情報リスト
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private List<GoToUpdateCustomerConfirmDTO> userInfoList = new ArrayList<GoToUpdateCustomerConfirmDTO>();

	/**
	 * 苗字
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String lastName;

	/**
	 * 名前
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String firstName;

	/**
	 * 電話番号
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String userTel;

	/**
	 * メールアドレス
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String userEmail;

	/**
	 * 性別
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private int gender;

	/**
	 * ユーザーID
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String userId;

	/**
	 * ユーザーパスワード
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String userPassword;

	/**
	 * 新苗字
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String newLastName;

	/**
	 * 新名前
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String newFirstName;

	/**
	 * 新電話番号
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String newUserTel;

	/**
	 * 新メールアドレス
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String newUserEmail;

	/**
	 * 新性別
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private int newGender;

	/**
	 * 新ユーザID
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String newUserID;

	/**
	 * 新ユーザーパスワード
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String newUserPass;

	/**
	 * 新確認パスワード
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String newConfirmPass;

	/**
	 * エラーメッセージ
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String errorMessage;

	/**
	 * エラーメッセージ1
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String errorMessage1;

	/**
	 * エラーメッセージ2
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String errorMessage2;

	/**
	 * 新性別(String)
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String newGenderStr;

	/**
	 * セッション情報
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * 実行メソッド
	 *
	 * @since 2015/04/16
	 * @return result 結果
	 * @throws SQLException
	 */
	public String execute() throws SQLException {
		String result = ERROR;
		if (!sessionMap.containsKey("userId")) {
			errorMessage = "ログアウトが完了しています。予約画面から再度お手続きお願い致します";
			return result;
		}
		GoToUpdateCustomerConfirmDAO dao = new GoToUpdateCustomerConfirmDAO();
		userInfoList = dao.selectUserInfo((int) sessionMap.get("accountNumber"));
		lastName = userInfoList.get(0).getLastName();
		firstName = userInfoList.get(0).getFirstName();
		userTel = userInfoList.get(0).getUserTel();
		userEmail = userInfoList.get(0).getUserEmail();
		gender = userInfoList.get(0).getGender();
		userId = userInfoList.get(0).getUserId();
		userPassword = userInfoList.get(0).getUserPassword();
		Boolean idCheck = true;
		if (!newUserID.isEmpty()) {
			idCheck = dao.isCustomerIDCheck(newUserID);
		}
		if (!newUserPass.equals(newConfirmPass) && !newUserPass.isEmpty()) {
			errorMessage1 = "パスワードと確認用パスワードが不一致です。";
			return result;
		}
		if (!idCheck) {
			errorMessage2 = "希望AccountIDは既に登録されています。";
			return result;
		}
		if (newGender == 0 || newGender == 1) {
			if (newGender == 0) {
				newGenderStr = "Man";
			} else if (newGender == 1) {
				newGenderStr = "Woman";
			}
		}
		result = SUCCESS;
		return result;
	}

	/**
	 * 苗字取得メソッド
	 *
	 * @return lastName 苗字
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 苗字登録メソッド
	 *
	 * @param lastName
	 *            苗字
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 名前取得メソッド
	 *
	 * @return firstName 名前
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 名前登録メソッド
	 *
	 * @param firstName
	 *            名前
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 電話番号取得メソッド
	 *
	 * @return userTel 電話番号
	 */
	public String getUserTel() {
		return userTel;
	}

	/**
	 * 電話番号登録メソッド
	 *
	 * @param userTel
	 *            電話番号
	 */
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	/**
	 * メールアドレス取得メソッド
	 *
	 * @return userEmail メールアドレス
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * メールアドレス登録メソッド
	 *
	 * @param userEmail
	 *            メールアドレス
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * 性別取得メソッド
	 *
	 * @return gender 性別
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * 性別登録メソッド
	 *
	 * @param gender
	 *            性別
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * ユーザーID取得メソッド
	 *
	 * @return userId ユーザーID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザーID登録メソッド
	 *
	 * @param userId
	 *            ユーザーID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * ユーザーパスワード取得メソッド
	 *
	 * @return userPassword ユーザーパスワード
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * ユーザーパスワード登録メソッド
	 *
	 * @param userPassword
	 *            ユーザーパスワード
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * エラーメッセージ取得メソッド
	 *
	 * @return errorMessage1 エラーメッセージ
	 */
	public String getErrorMessage1() {
		return errorMessage1;
	}

	/**
	 * 新苗字取得メソッド
	 *
	 * @param newLastName
	 *            新苗字
	 */
	public String getNewLastName() {
		return newLastName;
	}

	/**
	 * 新苗字登録メソッド
	 *
	 * @return newLastName 新苗字
	 */
	public void setNewLastName(String newLastName) {
		this.newLastName = newLastName;
	}

	/**
	 * 新名前取得メソッド
	 *
	 * @param newFirstName
	 *            新名前名前
	 */
	public String getNewFirstName() {
		return newFirstName;
	}

	/**
	 * 新名前登録メソッド
	 *
	 * @return newFirstName 新名前
	 */
	public void setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
	}

	/**
	 * 新電話番号取得メソッド
	 *
	 * @param newUserTel
	 *            新電話番号
	 */
	public String getNewUserTel() {
		return newUserTel;
	}

	/**
	 * 新電話番号登録メソッド
	 *
	 * @return newUserTel 新電話番号
	 */
	public void setNewUserTel(String newUserTel) {
		this.newUserTel = newUserTel;
	}

	/**
	 * 新メールアドレス取得メソッド
	 *
	 * @param newUserEmail
	 *            新メールアドレス
	 */
	public String getNewUserEmail() {
		return newUserEmail;
	}

	/**
	 * 新メールアドレス登録メソッド
	 *
	 * @return newUserEmail 新メールアドレスメール
	 */
	public void setNewUserEmail(String newUserEmail) {
		this.newUserEmail = newUserEmail;
	}

	/**
	 * 新性別取得メソッド
	 *
	 * @param newGender
	 *            新性別
	 */
	public int getNewGender() {
		return newGender;
	}

	/**
	 * 新性別登録メソッド
	 *
	 * @return newGender 新性別
	 */
	public void setNewGender(int newGender) {
		this.newGender = newGender;
	}

	/**
	 * 新ユーザーID取得メソッド
	 *
	 * @param newGender
	 *            新ユーザーID
	 */
	public String getNewUserID() {
		return newUserID;
	}

	/**
	 * 新ユーザーID登録メソッド
	 *
	 * @return newGender 新ユーザーID
	 */
	public void setNewUserID(String newUserID) {
		this.newUserID = newUserID;
	}

	/**
	 * 新ユーザーパスワード取得メソッド
	 *
	 * @param newUserPass
	 *            新ユーザーパスワード
	 */
	public String getNewUserPass() {
		return newUserPass;
	}

	/**
	 * 新ユーザーパスワード登録メソッド
	 *
	 * @return newUserPass 新ユーザーパスワード
	 */
	public void setNewUserPass(String newUserPass) {
		this.newUserPass = newUserPass;
	}

	/**
	 * 新確認パスワード取得メソッド
	 *
	 * @param newConfirmPass
	 *            新確認パスワード
	 */
	public String getNewConfirmPass() {
		return newConfirmPass;
	}

	/**
	 * 新確認パスワード登録メソッド
	 *
	 * @return newConfirmPass 新確認パスワード
	 */
	public void setNewConfirmPass(String newConfirmPass) {
		this.newConfirmPass = newConfirmPass;
	}

	/**
	 * 新エラーメッセージ1登録メソッド
	 *
	 * @param errorMessage1
	 *            新メッセージ1
	 */
	public void setErrorMessage1(String errorMessage1) {
		this.errorMessage1 = errorMessage1;
	}

	/**
	 * 新エラーメッセージ2取得メソッド
	 *
	 * @param errorMessage2
	 *            新エラーメッセージ2
	 */
	public String getErrorMessage2() {
		return errorMessage2;
	}

	/**
	 * 新エラーメッセージ2登録メソッド
	 *
	 * @param errorMessage2
	 *            新メッセージ2
	 */
	public void setErrorMessage2(String errorMessage2) {
		this.errorMessage2 = errorMessage2;
	}

	/**
	 * 会員情報リスト取得メソッド
	 *
	 * @param userInfoList
	 *            会員情報リスト
	 */
	public List<GoToUpdateCustomerConfirmDTO> getUserInfoList() {
		return userInfoList;
	}

	/**
	 * セッション情報登録メソッド
	 *
	 * @param session
	 *            セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

	/**
	 * 新性別取得メソッド
	 *
	 * @param newGenderStr新性別
	 */
	public String getNewGenderStr() {
		return newGenderStr;
	}

	/**
	 * エラーメッセージ取得メソッド
	 *
	 * @return errorMessage エラーメッセージ
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
}
