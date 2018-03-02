package com.internousdev.solare.action;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.internousdev.solare.dao.InsertNewUserDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToNewUserConfirmAction 新規登録情報の確認用のクラス
 *
 * @since 2015/04/15
 * @version 1.0
 */
public class GoToNewUserConfirmPageAction extends ActionSupport {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private static final long serialVersionUID = -1933095895608383936L;

	/**
	 * 氏名
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String fullName;

	/**
	 * 名前
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String lastName;

	/**
	 * 苗字
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String firstName;

	/**
	 * メールアドレス
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String userEmail;

	/**
	 * 性別
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private int gender;

	/**
	 * ユーザーID
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String userId;

	/**
	 * パスワード
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String userPassword;

	/**
	 * パスワード2
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String userPass2;

	/**
	 * 電話番号
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String userTel;

	/**
	 * メッセージ
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String msg;

	/**
	 * メッセージ2
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String msg2;

	/**
	 * 性別(String)
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String genderStr;

	/**
	 * 来店日時
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String reservationDate;

	/**
	 * コース番号
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private int courseNumber;

	/**
	 * 来店時間
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String reservationTime;

	/**
	 * 予約人数
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private int numberOfPeople;

	/**
	 * コース(String)
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String courseString;

	/**
	 * ユーザー遷移先リクエスト
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String userRequest;

	/**
	 * 実行メソッド
	 *
	 * @since 2015/04/15
	 * @return result 結果
	 */
	public String execute() {
		String result = ERROR;

		Pattern pattern = Pattern.compile("-");
		Matcher matcher = pattern.matcher(userTel);
		this.userTel = matcher.replaceAll("");

		if (gender == 0) {
			genderStr = "Man";
		} else {
			genderStr = "Woman";
		}
		fullName = lastName + " " + firstName;
		InsertNewUserDAO dao = new InsertNewUserDAO();
		boolean userIDCheck;
		try {
			userIDCheck = dao.isUserIDcheck(userId);
			if (userPassword.equals(userPass2) && userIDCheck) {
				result = SUCCESS;
			} else if (!userIDCheck) {
				msg = "※ログインIDが既に登録されています。";
				result = ERROR;
			} else {
				msg2 = "※パスワードと確認用パスワードが不一致です。";
				result = ERROR;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 氏名取得メソッド
	 *
	 * @return fullName 氏名
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * 氏名登録メソッド
	 *
	 * @param fullName
	 *            氏名
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	 * @param user_pass
	 *            ユーザーパスワード
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 確認用ユーザーパスワード登録メソッド
	 *
	 * @param userPass2
	 *            確認パスワード
	 */
	public void setUserPass2(String userPass2) {
		this.userPass2 = userPass2;
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
	 * @param user_tel
	 *            電話番号
	 */
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	/**
	 * エラーメッセージ取得メソッド
	 *
	 * @return msg エラーメッセージ
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * エラーメッセージ取得メソッド
	 *
	 * @return msg2 エラーメッセージ
	 */
	public String getMsg2() {
		return msg2;
	}

	/**
	 * 性別取得メソッド
	 *
	 * @return genderStr 性別
	 */
	public String getGenderStr() {
		return genderStr;
	}

	/**
	 * 性別登録メソッド
	 *
	 * @param genderStr
	 *            性別
	 */
	public void setGenderStr(String genderStr) {
		this.genderStr = genderStr;
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
	 * 苗字取得メソッド
	 *
	 * @return lastName 苗字
	 */
	public String getLastName() {
		return lastName;
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
	 * 来店日時取得メソッド
	 *
	 * @return reservationDate 来店日時
	 */
	public String getReservationDate() {
		return reservationDate;
	}

	/**
	 * 来店日時登録メソッド
	 *
	 * @param reservationDate
	 *            来店日時
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * コース番号取得メソッド
	 *
	 * @return courseNumber コース番号
	 */
	public int getCourseNumber() {
		return courseNumber;
	}

	/**
	 * コース番号登録メソッド
	 *
	 * @param courseNumber
	 *            コース番号
	 */
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * 予約時間取得メソッド
	 *
	 * @return reservationTime 予約時間
	 */
	public String getReservationTime() {
		return reservationTime;
	}

	/**
	 * 予約時間登録メソッド
	 *
	 * @param reservationTime
	 *            予約時間
	 */
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	/**
	 * 予約人数取得メソッド
	 *
	 * @return numberOfPeople 予約人数
	 */
	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	/**
	 * 予約人数登録メソッド
	 *
	 * @param numberOfPeople
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * コース番号取得メソッド
	 *
	 * @return courseString コース番号
	 */
	public String getCourseString() {
		return courseString;
	}

	/**
	 * コース番号登録メソッド
	 *
	 * @param courseString
	 *            コース番号
	 */
	public void setCourseString(String courseString) {
		this.courseString = courseString;
	}

	/**
	 * ユーザー遷移先リクエスト情報取得メソッド
	 *
	 * @return userRequest ユーザー遷移先リクエスト情報
	 */
	public String getUserRequest() {
		return userRequest;
	}

	/**
	 * ユーザー遷移先リクエスト情報登録メソッド
	 *
	 * @param userRequest
	 *            ユーザー遷移先リクエスト
	 */
	public void setUserRequest(String userRequest) {
		this.userRequest = userRequest;
	}
}
