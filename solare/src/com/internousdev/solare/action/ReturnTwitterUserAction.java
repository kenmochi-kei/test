package com.internousdev.solare.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ReturnTwitterUserAction リターンツイッターユーザーアクション
 *
 * @since 2015/04/16
 * @version 1.0
 */
public class ReturnTwitterUserAction extends ActionSupport {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private static final long serialVersionUID = 7816114245486167376L;
	/**
	 *
	 */

	/**
	 * 結果
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private String result;

	/**
	 * 実行メソッド
	 *
	 * @return result 結果
	 * @throws Exception
	 */
	public String execute() throws Exception {
		result = SUCCESS;
		return result;
	}

}
