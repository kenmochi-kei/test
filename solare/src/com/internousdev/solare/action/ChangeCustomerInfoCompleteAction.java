package com.internousdev.solare.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.UpdateCustomerInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ChangeCustomerInfoCompleteAction 会員情報を変更するアクション
 *
 * @since 2015/04/16
 * @version 1.0
 */
public class ChangeCustomerInfoCompleteAction extends ActionSupport implements SessionAware {
	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private static final long serialVersionUID = 426238193170242253L;

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
	 * 新ユーザーID
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
	 * エラーメッセージ
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String errorMessage;

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
		boolean uniqueIDinsertFlag = false;
		UpdateCustomerInfoDAO dao = new UpdateCustomerInfoDAO();
		String uniqueID = dao.getUserUniqueID((int) sessionMap.get("accountNumber"));
		if (!newFirstName.isEmpty() && newGender == 0 || newGender == 1 && !newLastName.isEmpty()
				&& !newUserEmail.isEmpty() && !newUserID.isEmpty() && !newUserPass.isEmpty() && !newUserTel.isEmpty()) {
			try {
				if (dao.updateCustomerInfo(newLastName, newFirstName, newUserTel, newUserEmail, newGender, newUserID,
						newUserPass, (int) sessionMap.get("accountNumber"))) {
					if (dao.isInsertCustomerIDinfo(uniqueID, newUserID)) {
						sessionMap.put("userId", newUserID);
						sessionMap.put("userPassword", newUserPass);
						sessionMap.put("lastName", newLastName);
					}
				}
				if (newGender == 0) {
					newGenderStr = "Man";
				} else if (newGender == 1) {
					newGenderStr = "Woman";
				}
				result = SUCCESS;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (newFirstName.isEmpty() && !(newGender == 0)
				|| !(newGender == 1) && newLastName.isEmpty() && newUserEmail.isEmpty() && newUserEmail.isEmpty()
						&& newUserID.isEmpty() && newUserPass.isEmpty() && newUserTel.isEmpty()) {
			errorMessage = "全てのフィールドが未入力です。";
		} else {
			if (!newFirstName.isEmpty()) {
				newFirstName = firstName;
			}
			if (!(newGender == 0) || !(newGender == 1)) {
				newGender = gender;
			}
			if (!newLastName.isEmpty()) {
				newLastName = lastName;
			}
			if (!newUserEmail.isEmpty()) {
				newUserEmail = userEmail;
			}
			if (!newUserID.isEmpty()) {
				newUserID = userId;
			} else {
				uniqueIDinsertFlag = true;
			}
			if (!newUserPass.isEmpty()) {
				newUserPass = userPassword;
			}
			if (!newUserTel.isEmpty()) {
				newUserTel = userTel;
			}
			if (newGender == 0) {
				newGenderStr = "Man";
			} else if (newGender == 1) {
				newGenderStr = "Woman";
			}
			try {
				if (dao.updateCustomerInfo(newLastName, newFirstName, newUserTel, newUserEmail, newGender, newUserID,
						newUserPass, (int) sessionMap.get("accountNumber"))) {
					if (uniqueIDinsertFlag) {
						if (dao.isInsertCustomerIDinfo(uniqueID, newUserID)) {
							sessionMap.put("userId", newUserID);
							sessionMap.put("userPassword", newUserPass);
							sessionMap.put("lastName", newLastName);
						}
					}
					result = SUCCESS;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
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
	 * 苗字登録メソッド
	 *
	 * @param lastName
	 *            苗字
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * 電話番号登録メソッド
	 *
	 * @param userTel
	 *            電話番号
	 */
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	/**
	 * メールアドレス登録メソッド
	 *
	 * @param mailAddress
	 *            メールアドレス
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * 性別登録メソッド
	 *
	 * @param genderInt
	 *            性別
	 */
	public void setGender(int gender) {
		this.gender = gender;
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
	 * ユーザーパスワード登録メソッド
	 *
	 * @param userPassword
	 *            ユーザーパスワード
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 新苗字登録メソッド
	 *
	 * @param newLastName
	 *            新苗字
	 */
	public void setNewLastName(String newLastName) {
		this.newLastName = newLastName;
	}

	/**
	 * 新名前登録メソッド
	 *
	 * @param newFirstName
	 *            新名前
	 */
	public void setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
	}

	/**
	 * 新電話番号登録メソッド
	 *
	 * @param newUserTel
	 *            新電話番号
	 */
	public void setNewUserTel(String newUserTel) {
		this.newUserTel = newUserTel;
	}

	/**
	 * 新メールアドレス登録メソッド
	 *
	 * @param newUserEmail
	 *            新メールアドレス
	 */
	public void setNewUserEmail(String newUserEmail) {
		this.newUserEmail = newUserEmail;
	}

	/**
	 * 新性別登録メソッド
	 *
	 * @param newGender
	 *            新性別
	 */
	public void setNewGender(int newGender) {
		this.newGender = newGender;
	}

	/**
	 * 新ユーザーID登録メソッド
	 *
	 * @param newUserID
	 *            新ユーザーID
	 */
	public void setNewUserID(String newUserID) {
		this.newUserID = newUserID;
	}

	/**
	 * 新ユーザーパスワード登録メソッド
	 *
	 * @param newUserPass
	 *            新ユーザーパスワード
	 */
	public void setNewUserPass(String newUserPass) {
		this.newUserPass = newUserPass;
	}

	/**
	 * エラーメッセージ取得メソッド
	 *
	 * @param errorMessage
	 *            エラーメッセージ
	 */
	public String getErrorMessage() {
		return errorMessage;
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
	 * 新名前取得メソッド
	 *
	 * @param newFirstName
	 *            新名前
	 */
	public String getNewFirstName() {
		return newFirstName;
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
	 * 新メールアドレス取得メソッド
	 *
	 * @param newUserEmail
	 *            新メールアドレス
	 */
	public String getNewUserEmail() {
		return newUserEmail;
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
	 * 新ユーザーIDメソッド
	 *
	 * @param newUserID
	 *            新ユーザーID
	 */
	public String getNewUserID() {
		return newUserID;
	}

	/**
	 * 新性別(String)メソッド
	 *
	 * @param newGenderStr
	 *            新性別(String)
	 */
	public String getNewGenderStr() {
		return newGenderStr;
	}
}
