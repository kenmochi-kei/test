package com.internousdev.solare.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.DeleteReservationDAO;
import com.internousdev.solare.dao.LeaveDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * LeaveAction
 *会員情報を削除し、退会するアクション
 * @since 2015/04/21
 * @version 1.0
 */
public class LeaveAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/21
	 * @version 1.0
	 */
	private static final long serialVersionUID = -912619185883760095L;


	/**
	 * セッション情報
	 *
	 * @since 2015/04/21
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;


	/**
	 * 実行メソッド
	 *
	 * @return result 結果
	 * @throws SQLException
	 */
	public String execute() throws SQLException {

		DeleteReservationDAO dao2 = new DeleteReservationDAO();
		int reservationNumber = 0;
		dao2.delete((int) sessionMap.get("accountNumber"), reservationNumber);

		LeaveDAO dao = new LeaveDAO();
		String result = ERROR;
		if (sessionMap.containsKey("AccessToken") && sessionMap.containsKey("AccessTokenSecret")) {
			dao.TwitterUserDelete((String) sessionMap.get("AccessToken"), (String) sessionMap.get("AccessTokenSecret"));
		} else {

			try {

				dao.MemberDelete((int) sessionMap.get("accountNumber"), (String) sessionMap.get("userId"));
				sessionMap.clear();
				result = SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		return result;
	}

	/**
	 * セッション情報登録メソッド
	 *
	 * @param sessionMap
	 *            セッション情報
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}
}
