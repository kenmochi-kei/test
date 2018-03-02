package com.internousdev.solare.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.InsertNewUserDAO;
import com.internousdev.solare.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * NewUserRegisterCompleteAction
 *入力した新規登録情報をDAOに渡しDBに格納するアクション
 * @since 2015/04/15
 * @version 1.0
 */
public class NewUserRegisterCompleteAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private static final long serialVersionUID = -2614892180726126452L;

	/**
	 * 苗字
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String lastName;

	/**
	 * 名前
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
	 * ユーザーパスワード
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String userPassword;

	/**
	 * 電話番号
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String userTel;

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
	 * 予約時間
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
	 * UUID
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String uniqueID;

	/**
	 * 実行メソッド
	 *
	 * @return result 結果
	 */
	public String execute() throws Exception {
		String result = ERROR;


		InsertNewUserDAO dao = new InsertNewUserDAO();

		dao.isInsertCustomerInfo(userId, userPassword, lastName, firstName);

		dao.isInsertCustomerInfo(userId, userPassword, uniqueID, lastName, firstName,userEmail, gender, userTel);
		new ArrayList<LoginDTO>();
			result = SUCCESS;
			return result;
	}

	/**
	 * セッション情報登録メソッド
	 *
	 * @param sessionMap
	 *            セッション情報
	 */
	public void setSession(Map<String, Object> session) {
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
	 *            ユーザーPass
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
	 * メールアドレス登録メソッド
	 *
	 * @param userEmail
	 *            メールアドレス
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * 性別情報登録メソッド
	 *
	 * @param gender
	 *            性別
	 */
	public void setGender(int gender) {
		this.gender = gender;
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
	 * 予約日時取得メソッド
	 *
	 * @param reservationDate
	 *            予約日時
	 */
	public String getReservationDate() {
		return reservationDate;
	}

	/**
	 * 予約日付登録メソッド
	 *
	 * @param reservationDate
	 *            来店日時
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * コース番号メソッド
	 *
	 * @param courseNumber
	 *            コース番号
	 */
	public int getCourseNumber() {
		return courseNumber;
	}

	/**
	 * コースナンバー登録メソッド
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
	 * @param reservationTime
	 *            予約時間
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
	 * @param numberOfPeople
	 *            予約人数
	 */
	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	/**
	 * 予約人数登録メソッド
	 *
	 * @param reservationTime
	 *            予約人数
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * コース番号取得メソッド（String）
	 *
	 * @param courseString
	 *            コース番号（String）
	 */
	public String getCourseString() {
		return courseString;
	}

	/**
	 * コース番号登録メソッド（String）
	 *
	 * @param courseString
	 *            コース番号（String）
	 */
	public void setCourseString(String courseString) {
		this.courseString = courseString;
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

	/**
	 * ユーザー遷移先リクエスト登録メソッド
	 *
	 * @param userRequest
	 *            コース番号
	 */
	public String getUserRequest() {
		return userRequest;
	}

	public String getUniqueID() {
		return uniqueID;
	}

}
