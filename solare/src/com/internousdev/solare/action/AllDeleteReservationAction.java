package com.internousdev.solare.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.DeleteReservationDAO;
import com.internousdev.solare.dto.ReservationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * AllDeleteReservationAction すべての予約情報を取り消すアクション
 *
 * @since 2015/04/14
 * @version 1.0
 */
public class AllDeleteReservationAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private static final long serialVersionUID = 6012778132245740299L;
	/**
	 * セッション情報
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
		DeleteReservationDAO dao = new DeleteReservationDAO();
		List<ReservationInfoDTO> deleteReservationInfoList = new ArrayList<ReservationInfoDTO>();
		try {
			deleteReservationInfoList.addAll(dao.getAllDleteReservationInfo((int) sessionMap.get("accountNumber")));
			dao.allDelete((int) sessionMap.get("accountNumber"));
			Iterator<ReservationInfoDTO> delInfoIterator = deleteReservationInfoList.iterator();
			while (delInfoIterator.hasNext()) {
				int customerReservationNumber = delInfoIterator.next().getCustomerReservationNumber();
				int numberOfPpl = delInfoIterator.next().getNumberOfPeople();
				dao.refleshSeatInfo(numberOfPpl, customerReservationNumber);
			}
			result = SUCCESS;
		} catch (SQLException e) {
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
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}
}
