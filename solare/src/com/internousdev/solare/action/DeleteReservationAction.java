package com.internousdev.solare.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.DeleteReservationDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * DeleteReservationAction 予約情報を削除するアクション
 *
 * @since 2015/04/14
 * @version 1.0
 */
public class DeleteReservationAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private static final long serialVersionUID = -1588599033908343188L;

	/**
	 * セッション情報
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * 予約番号
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private int reservationNumber;

	/**
	 * 実行メソッド
	 *
	 * @since 2015/04/14
	 * @return result 結果
	 */
	public String execute() {
		String result = ERROR;
		DeleteReservationDAO dao = new DeleteReservationDAO();
		try {
			dao.delete((int) sessionMap.get("accountNumber"), reservationNumber);
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

	/**
	 * 予約番号登録メソッド
	 *
	 * @param reservationNumber
	 *            予約番号
	 */
	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
}
