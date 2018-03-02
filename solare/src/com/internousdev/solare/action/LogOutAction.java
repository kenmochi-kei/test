package com.internousdev.solare.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * LogOutAction ログアウトするためのアクション
 *
 * @since 2015/04/15
 * @version 1.0
 */
public class LogOutAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private static final long serialVersionUID = -245486915825324229L;

	/**
	 *
	 */

	/**
	 * セッション情報
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * メッセージ
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String logOutMsg;

	/**
	 * ログアウトフラグ
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String logOutFlag;

	/**
	 * 実行メソッド
	 *
	 * @return result 結果
	 */
	public String execute() {
		String result = ERROR;
		try {
			sessionMap.clear();
			logOutMsg="ログアウトしました。";
			logOutFlag = "logOutComplete";
			result = SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * セッション情報登録メソッド
	 *
	 * @param session
	 *            セッション情報
	 */
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

	/**
	 * エラーメッセージ取得メソッド
	 *
	 * @return logOutMsg エラーメッセージ
	 */
	public String getLogOutMsg() {
		return logOutMsg;
	}

	/**
	 * ログアウトフラグ取得メソッド
	 *
	 * @return logOutFlag ログアウトフラグ
	 */
	public String getLogOutFlag() {
		return logOutFlag;
	}
}


