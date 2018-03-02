package com.internousdev.solare.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ReturnNewUserAction 新規登録画面に遷移するアクション
 *
 * @since 2015/04/15
 * @version 1.0
 */
public class ReturnNewUserAction extends ActionSupport {

	/**
	 * 生成されたシリアルナンバー
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private static final long serialVersionUID = -7900744430050831489L;
	/**
	 *
	 */

	/**
	 * 結果
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private String result;

	/**
	 * 実行メソッド
	 *
	 * @return result 結果
	 */
	public String execute() throws Exception {
		result =SUCCESS;
		return result;
	}
}
