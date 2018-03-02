package com.internousdev.solare.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToMyPageAction マイページに遷移するためのアクション
 *
 * @since 2015/04/14
 * @version 1.0
 */
public class GoToMyPageAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private static final long serialVersionUID = -181629140359353269L;

	/**
	 * セッション情報
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * エラーメッセージ
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private String errorMessage;

	/**
	 * ユーザーリクエスト
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private String userRequest;

	/**
	 * カレントページ
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private String currentPage;

	/**
	 * 実行メソッド
	 *
	 * @since 2015/04/14
	 * @return result 結果
	 */
	public String execute() throws Exception {

		String result = ERROR;
		if (sessionMap.containsKey("userId") || sessionMap.containsKey("AccessToken")) {
			result = SUCCESS;
		} else if (!(currentPage == null) && currentPage.equals("reservationComplete")) {
			errorMessage = "お手数ですがもう一度ログインしてください。";
			userRequest = "goMyPage";
		} else {
			userRequest = "goMyPage";
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
	 * エラーメッセージ取得メソッド
	 *
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * ユーザー遷移元情報取得メソッド
	 *
	 * @param currentPage
	 *            遷移元ページ情報
	 */
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * ユーザー遷移先リクエスト情報取得メソッド
	 *
	 * @return userRequest ユーザー遷移先リクエスト情報
	 */
	public String getUserRequest() {
		return userRequest;
	}
}
