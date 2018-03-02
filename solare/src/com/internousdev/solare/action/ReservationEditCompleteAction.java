package com.internousdev.solare.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.EditReservationInfoDAO;
import com.internousdev.solare.dao.ReservationCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ReservationEditCompleteAction 既に同一日時に予約があるかをチェックするアクション
 * @since 2015/04/23
 * @version 1.0
 */
public class ReservationEditCompleteAction extends ActionSupport implements SessionAware{

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/23
	 * @version 1.0
	 */
	private static final long serialVersionUID = 2467623904397385447L;

	/**
	 *
	 */

	/**
	 * セッション情報
	 *
	 * @since 2015/04/23
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * メッセージ
	 *
	 * @since 2015/04/23
	 * @version 1.0
	 */
	private String message;

	/**
	 * 予約番号
	 *
	 * @since 2015/04/23
	 * @version 1.0
	 */
	private int customerReservationNumber;
	
	/**
	 * コース番号
	 *
	 * @since 2015/04/23
	 * @version 1.0
	 */
	private int courseNumber;
	
	/**
	 * 予約人数
	 *
	 * @since 2015/04/23
	 * @version 1.0
	 */
	private int numberOfPeople;
	
	/**
	 * 予約日
	 *
	 * @since 2015/04/23
	 * @version 1.0
	 */
	private String reservationDate;
	
	/**
	 * 予約時間
	 *
	 * @since 2015/04/23
	 * @version 1.0
	 */
	private String reservationTime;

	/**
	 * コース番号（A,B,C）
	 *
	 * @since 2015/04/23
	 * @version 1.0
	 */
	private String courseNumberString;
	
	/**
	 *実行メソッド
	 */
	public String execute() throws ParseException {
		String result = ERROR;
		String reservationDateTimeStamp;
		int reservationTimeInt = 0;
		switch (courseNumber) {
		case 0:
			reservationTimeInt = 60;
			break;
		case 1:
			reservationTimeInt = 60;
			break;
		case 2:
			reservationTimeInt = 120;
			break;
		default:
			break;
		}
		reservationDateTimeStamp = reservationDate + " " + reservationTime;
		EditReservationInfoDAO dao = new EditReservationInfoDAO();
		ReservationCompleteDAO dao2 = new ReservationCompleteDAO();
		try {
			if (dao2.isCheckUserReservation((int) sessionMap.get("accountNumber"), reservationDateTimeStamp)) {
				dao.editReservationInfo(reservationDateTimeStamp, customerReservationNumber, courseNumber, numberOfPeople, reservationTimeInt);
			} else {
				message = "既に同一日時にご予約を頂いております。";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result = SUCCESS;
		return result;
	}

	/**
	 * セッション情報登録メソッド
	 *
	 * @return session セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

	/**
	 * 予約番号取得メソッド
	 *
	 * @return customerReservationNumber 予約番号
	 */
	public int getCustomerReservationNumber() {
		return customerReservationNumber;
	}

	/**
	 * 予約番号登録メソッド
	 *
	 * @param customerReservationNumber
	 *            予約番号
	 */
	public void setCustomerReservationNumber(int customerReservationNumber) {
		this.customerReservationNumber = customerReservationNumber;
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
	 *            予約人数
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * 予約日取得メソッド
	 *
	 * @return reservationDate 予約日
	 */
	public String getReservationDate() {
		return reservationDate;
	}

	/**
	 * 予約日登録メソッド
	 *
	 * @param reservationDate
	 *            予約日
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
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
	 * コース番号（A,B,C）取得メソッド
	 *
	 * @return courseNumberString コース番号（A,B,C）
	 */
	public String getCourseNumberString() {
		return courseNumberString;
	}

	/**
	 * コース番号（A,B,C）登録メソッド
	 *
	 * @param courseNumberString
	 *            コース番号（A,B,C）
	 */
	public void setCourseNumberString(String courseNumberString) {
		this.courseNumberString = courseNumberString;
	}

	/**
	 * メッセージ取得メソッド
	 *
	 * @return message メッセージ
	 */
	public String getMessage() {
		return message;
	}
}
