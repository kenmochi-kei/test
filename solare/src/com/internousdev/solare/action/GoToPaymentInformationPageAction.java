/**
 *
 */
package com.internousdev.solare.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 予約内容確認画面へ遷移するためのクラス
 *
 * @since 2016/04/18
 */
public class GoToPaymentInformationPageAction extends ActionSupport implements SessionAware {
	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private static final long serialVersionUID = -1373652116839199858L;

	/**
	 * 予約日
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String calendar;

	/**
	 * コース番号
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private int courseNumber;

	/**
	 * 予約時間
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String reservationTime;

	/**
	 * 予約人数
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private int numberOfPeople;

	/**
	 * コース(String)
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String courseString;

	/**
	 * セッション情報
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * ユーザー遷移先リクエスト
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String userRequest;

	/**
	 * 日付未指定時のエラーメッセージ
	 *
	 * @since 2017/10/04
	 * @version 1.1
	 */
	private String seletedDateErrorMessage;

	/**
	 * 日付リスト
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private List<String> tomorrowList = new ArrayList<String>();

	/**
	 * 曜日リスト
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private List<String> nextWeekList = new ArrayList<String>();

	/**
	 * 空席情報リスト
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private List<String> vacancyList = new ArrayList<String>();

	/**
	 * 実行メソッド
	 *
	 * @since 2016/04/18
	 * @return result 結果
	 */

	@SuppressWarnings("unchecked")
	public String execute() {

		/*
		 * セッションに予約コース番号を保存する
		 */
		sessionMap.put("CourseNumber", courseNumber);

		/*
		 * セッションに予約時間を保存する
		 */
		sessionMap.put("ReservationTime", reservationTime);

		/*
		 * セッションに予約人数を保存する
		 */
		sessionMap.put("NumberOfPeople", numberOfPeople);

		/*
		 * セッションに予約コースを保存する
		 */
		sessionMap.put("CourseString", courseString);

		/*
		 * セッションに予約日付を保存する
		 */
		sessionMap.put("Calendar", calendar);

		String result = SUCCESS;

		// 日付が指定されていない場合
		if(calendar.equals("")) {
			seletedDateErrorMessage = "ご予約の日時が指定されてません。";
			tomorrowList = (List<String>) sessionMap.get("tomorrowList");
			nextWeekList = (List<String>) sessionMap.get("nextWeekList");
			vacancyList = (List<String>) sessionMap.get("vacancyList");
			result = ERROR;
		}

		return result;
	}

	/**
	 * 予約日取得メソッド
	 *
	 * @return calendar 予約日
	 */
	public String getCalendar() {
		return calendar;
	}

	/**
	 * 予約日登録メソッド
	 *
	 * @return calendar 予約日
	 */
	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	/**
	 * 予約コース番号取得メソッド
	 *
	 * @return courseNumber コース番号
	 */
	public int getCourseNumber() {
		return courseNumber;
	}

	/**
	 * 予約コース番号登録メソッド
	 *
	 * @return courseNumber コース番号
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
	 * @return reservationTime 予約時間
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
	 * @return numberOfPeople 予約人数
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * コース取得メソッド
	 *
	 * @return courseString コース
	 */
	public String getCourseString() {
		return courseString;
	}

	/**
	 * コース登録メソッド
	 *
	 * @return courseString コース
	 */
	public void setCourseString(String courseString) {
		this.courseString = courseString;
	}

	/**
	 * セッション情報取得メソッド
	 *
	 * @param sessionMap
	 *            セッション情報
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
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
	 * @return userRequest ユーザー遷移先リクエスト情報
	 */
	public void setUserRequest(String userRequest) {
		this.userRequest = userRequest;
	}

	/**
	 * セッション情報登録メソッド
	 *
	 * @param sessionMap
	 *            セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;

	}

	public String getSeletedDateErrorMessage() {
		return seletedDateErrorMessage;
	}

	public void setSeletedDateErrorMessage(String seletedDateErrorMessage) {
		this.seletedDateErrorMessage = seletedDateErrorMessage;
	}

	public List<String> getTomorrowList() {
		return tomorrowList;
	}

	public void setTomorrowList(List<String> tomorrowList) {
		this.tomorrowList = tomorrowList;
	}

	public List<String> getNextWeekList() {
		return nextWeekList;
	}

	public void setNextWeekList(List<String> nextWeekList) {
		this.nextWeekList = nextWeekList;
	}

	public List<String> getVacancyList() {
		return vacancyList;
	}

	public void setVacancyList(List<String> vacancyList) {
		this.vacancyList = vacancyList;
	}

}
