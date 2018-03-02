package com.internousdev.solare.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.dao.GoToCustomerInfoEditDAO;
import com.internousdev.solare.dto.GoToCustomerInfoEditDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * GoToCustomerInfoEditAction 会員情報変更ページに遷移するアクション
 *
 * @since 2015/04/15
 * @version 1.0
 */
public class GoToCustomerEditPageAction extends ActionSupport implements SessionAware {

	/**
	 * 生成されたシリアルナンバー
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private static final long serialVersionUID = 2955789766562741008L;

	/**
	 * セッション情報
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private Map<String, Object> sessionMap;

	/**
	 * 会員情報リスト
	 *
	 * @since 2015/04/15
	 * @version 1.0
	 */
	private List<GoToCustomerInfoEditDTO> userInfoList = new ArrayList<GoToCustomerInfoEditDTO>();

	/**
	 * 実行メソッド
	 *
	 * @since 2015/04/15
	 * @return result 結果
	 */
	public String execute() {
		String result = ERROR;

		if (!sessionMap.containsKey("userId") && !sessionMap.containsKey("AccessToken")) {
			result = "notSession";
			return result;
		}
		GoToCustomerInfoEditDAO dao = new GoToCustomerInfoEditDAO();
		dao.select((int) sessionMap.get("accountNumber"));
		userInfoList.addAll(dao.getUserInfoList());
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
	 * 会員情報リスト取得メソッド
	 *
	 * @return userInfoList 会員情報
	 */
	public List<GoToCustomerInfoEditDTO> getUserInfoList() {
		return userInfoList;
	}
}