package com.internousdev.solare.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ReturnTopAction トップ画面に遷移するアクション
 *
 * @since 2015/04/15
 * @version 1.0
 */
public class ReturnTopAction extends ActionSupport {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private static final long serialVersionUID = -9078684200857393863L;

	/**
	 * 結果
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	public String result;

	/**
	 * 実行メソッド
	 *
	 * @return result 結果
	 */
	public String execute() {
		result = SUCCESS;

		return result;

	}
}
