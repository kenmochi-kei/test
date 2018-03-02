/**
 *
 */
package com.internousdev.solare.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.util.CreditCard;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 予約内容確認画面へ遷移するためのクラス
 *
 * @since 2016/04/18
 */
public class GoToReservationConfirmationPageAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private static final long serialVersionUID = -2826532760505482223L;

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
	 * 支払い方法
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String pay;

	/**
	 * クレジットカード種別
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String card;

	/**
	 * クレジットカード番号
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String cardNumber;

	/**
	 * 有効期限(月)
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String cardMonth;

	/**
	 * 有効期限(年)
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String cardYear;

	/**
	 * クレジットカード名義
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String cardHolder;

	/**
	 * セキュリティコード
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String securityCode;

	/**
	 * トークン
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String token;

	/**
	 * エラーメッセージ
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String cardErrorMessage;

	/**
	 * カレンダー
	 *
	 * @since 2016/04/18
	 * @version 1.0
	 */
	private String calendar;

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
	 * 支払い方法未選択時のエラーメッセージ
	 *
	 * @since 2017/10/04
	 * @version 1.1
	 */
	private String payNotFundErrorMessage;

	/**
	 * セッションから予約情報を取得する。 クレジットカード情報に未入力があればエラーメッセージを表示し、エラーを返す。
	 * 引数にてクレジットカード番号を指定する事で該当するものが存在するか確認できます。
	 *
	 * @since 2016/04/18
	 * @return 結果
	 */
	public String execute() {

		/*
		 * セッションから予約コース番号を取得する
		 */
		courseNumber = (int) sessionMap.get("CourseNumber");

		/*
		 * セッションから予約時間を取得する
		 */
		reservationTime = (String) sessionMap.get("ReservationTime");

		/*
		 * セッションから予約人数を取得する
		 */
		numberOfPeople = (int) sessionMap.get("NumberOfPeople");

		/*
		 * セッションから予約コースを取得する
		 */
		courseString = (String) sessionMap.get("CourseString");

		/*
		 * セッションから予約日付を取得する
		 */
		calendar = (String) sessionMap.get("Calendar");
		String expirationDate = cardMonth + cardYear;

		/*
		 * セッションにクレジットカード種別を保存する
		 */
		sessionMap.put("Card", card);

		/*
		 * セッションにクレジットカード番号を保存する
		 */
		sessionMap.put("CardNumber", cardNumber);

		/*
		 * セッションに有効期限（月）を保存する
		 */
		sessionMap.put("CardMonth", cardMonth);

		/*
		 * セッションに有効期限（年）を保存する
		 */
		sessionMap.put("CardYear", cardYear);

		/*
		 * セッションにクレジットカード名義を保存する
		 */
		sessionMap.put("CardHolder", cardHolder);

		/*
		 * セッションにセキュリティコードを保存する
		 */
		sessionMap.put("SecurityCode", securityCode);

		/*
		 * @return SUCCESS/ERROR すべて成功した場合にSUCCESS 一つでも失敗した場合にERRORを返します。
		 */

		if(pay == null) {
			payNotFundErrorMessage = "お支払い方法が未選択です。";
			return ERROR;
		}

		if (!pay.equals("Cash")) {

			/*
			 * カード番号もしくは有効期限が未入力だったらエラーを返す。
			 */
			if (!cardNumber.equals("")) {
				if (card.equals("") || cardHolder.equals("") || cardNumber.equals("") || cardYear.equals("")
						|| cardMonth.equals("") || securityCode.equals("")) {
					cardErrorMessage = "クレジットカード情報に未入力の項目があります。";
					return ERROR;
				}
			}

			CreditCard creditCard = new CreditCard();

			/*
			 * 引数にてクレジットカード番号を指定する事で該当するものが存在するか確認できます。
			 */
			if (creditCard.isExists(cardNumber)) {

				// insert処理
				creditCard.add(cardNumber, cardHolder, expirationDate, securityCode, (String) sessionMap.get("UserID"));
				// トークンを取得
				token = creditCard.getToken();

			} else {
				return ERROR;
			}
		}

		// 支払い方法の値をSessionに格納
		sessionMap.put("pay", pay);

		return SUCCESS;

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
	 * 支払い方法取得メソッド
	 *
	 * @return pay 支払い方法
	 */
	public String getPay() {
		return pay;
	}

	/**
	 * 支払い方法登録メソッド
	 *
	 * @return pay 支払い方法
	 */
	public void setPay(String pay) {
		this.pay = pay;
	}

	/**
	 * クレジットカード種別取得メソッド
	 *
	 * @return card クレジットカード種別
	 */
	public String getCard() {
		return card;
	}

	/**
	 * クレジットカード種別登録メソッド
	 *
	 * @return card クレジットカード種別
	 */
	public void setCard(String card) {
		this.card = card;
	}

	/**
	 * クレジットカード番号取得メソッド
	 *
	 * @return cardNumber クレジットカード番号
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * クレジットカード番号登録メソッド
	 *
	 * @return cardNumber クレジットカード番号
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * 有効期限（月）取得メソッド
	 *
	 * @return cardMonth 有効期限（月）
	 */
	public String getCardMonth() {
		return cardMonth;
	}

	/**
	 * 有効期限（月）登録メソッド
	 *
	 * @return cardMonth 有効期限（月）
	 */
	public void setCardMonth(String cardMonth) {
		this.cardMonth = cardMonth;
	}

	/**
	 * 有効期限（年）取得メソッド
	 *
	 * @return cardMonth 有効期限（年）
	 */
	public String getCardYear() {
		return cardYear;
	}

	/**
	 * 有効期限（年）登録メソッド
	 *
	 * @return cardMonth 有効期限（年）
	 */
	public void setCardYear(String cardYear) {
		this.cardYear = cardYear;
	}

	/**
	 * クレジットカード名義取得メソッド
	 *
	 * @return cardHolder クレジットカード名義
	 */
	public String getCardHolder() {
		return cardHolder;
	}

	/**
	 * クレジットカード名義登録メソッド
	 *
	 * @return cardHolder クレジットカード名義
	 */
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	/**
	 * セキュリティコード取得メソッド
	 *
	 * @return securityCode セキュリティコード
	 */
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * セキュリティコード登録メソッド
	 *
	 * @return securityCode セキュリティコード
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	/**
	 * トークン取得メソッド
	 *
	 * @return token トークン
	 */
	public String getToken() {
		return token;
	}

	/**
	 * トークン登録メソッド
	 *
	 * @return token トークン
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * エラーメッセージ取得メソッド
	 *
	 * @return cardErrorMessage エラーメッセージ
	 */
	public String getCardErrorMessage() {
		return cardErrorMessage;
	}

	/**
	 * エラーメッセージ登録メソッド
	 *
	 * @return cardErrorMessage エラーメッセージ
	 */
	public void setCardErrorMessage(String cardErrorMessage) {
		this.cardErrorMessage = cardErrorMessage;
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

	public String getPayNotFundErrorMessage() {
		return payNotFundErrorMessage;
	}

	public void setPayNotFundErrorMessage(String payNotFundErrorMessage) {
		this.payNotFundErrorMessage = payNotFundErrorMessage;
	}

}
