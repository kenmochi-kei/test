package com.internousdev.solare.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.DeleteCustomerInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * DeleteCustomerInfoAction 会員情報を削除するアクション
 * 
 * @since 2015/04/14
 * @version 1.0
 */
public class DeleteCustomerInfoAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 * 
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1183259487114112441L;
	/**
	 * セッション情報
	 * 
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * 実行メソッド
	 * 
	 * @since 2015/04/14
	 * @return result 結果
	 */
	public String execute() {
		String result = ERROR;
		DeleteCustomerInfoDAO dao = new DeleteCustomerInfoDAO();
		try {
			dao.update((int) sessionMap.get("accountNumber"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result = SUCCESS;
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
}
