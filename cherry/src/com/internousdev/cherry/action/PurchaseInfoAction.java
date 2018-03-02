
package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.CartInfoDAO;
import com.internousdev.cherry.dao.DestinationInfoDAO;
import com.internousdev.cherry.dto.CartInfoDTO;
import com.internousdev.cherry.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseInfoAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	private Map<String,Object> session;

	/**
	 * 合計金額
	 */
	private int totalPrice =0;

	/**
	 * 個数
	 */

	private int productCount;

	/**
	 * カート情報一覧
	 */
	private List<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();

	/**
	 * 宛先情報一覧
	 */
	private ArrayList<DestinationInfoDTO> destinationInfoListDTO = new ArrayList<DestinationInfoDTO>();


	private int kessai;



	public String execute() throws SQLException{
		String result = ERROR;
		System.out.println("PurchaseInfoAction--------------");

		/**
		 * 宛先情報取得メソッド
		 */
		if((boolean) session.get("loginFlg")){
		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
		destinationInfoListDTO = destinationInfoDAO.obtainingDestinationInfo(session.get("userId").toString());
		}


		if(destinationInfoListDTO.size() > 0) {
			result = SUCCESS;

		} else if(!(boolean) session.get("loginFlg")) {
			result=ERROR;
			kessai=1;
			return result;

		} else {
			result = "DESTINATION";

		}

		/**
		 * 決済情報取得メソッド
		 */
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		cartList = cartInfoDAO.showUserCartList(session.get("userId").toString());

		/**
		 * カート情報なしの場合
		 */
		if(cartList.size() == 0){
			return "other";
		}

		for(CartInfoDTO dto:cartList) {
			totalPrice +=dto.getPrice() * dto.getProductCount();

		}

		System.out.println("-----------------------");

		return result;

	}

		/**
		 * @return session
		 */
		public Map<String, Object> getSession() {
			return session;
		}

		/**
		 * @param session セットする session
		 */
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}

		/**
		 * @return cartInfoDTOList
		 */
		public List<CartInfoDTO> getCartList() {
			return cartList;
		}

		/**
		 * @param cartInfoDTOList セットする cartInfoDTOList
		 */
		public void setCartList(List<CartInfoDTO> cartList) {
			this.cartList = cartList;
		}

		/**
		 * @return totalPrice
		 */
		public int getTotalPrice() {
			return totalPrice;
		}

		/**
		 * @param totalPrice セットする totalPrice
		 */
		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}

		/**
		 * @return destinationInfoListDTO
		 */
		public ArrayList<DestinationInfoDTO> getDestinationInfoListDTO() {
			return destinationInfoListDTO;
		}

		/**
		 * @param destinationInfoListDTO セットする destinationInfoListDTO
		 */
		public void setDestinationInfoListDTO(ArrayList<DestinationInfoDTO> destinationInfoListDTO) {
			this.destinationInfoListDTO = destinationInfoListDTO;
		}

		/**
		 * @return count
		 */
		public int getProductCount() {
			return productCount;
		}

		/**
		 * @param count セットする count
		 */
		public void setProductCount(int productCount) {
			this.productCount = productCount;
		}



		public int getKessai() {
			return kessai;
		}


		public void setKessai(int kessai) {
			this.kessai = kessai;
		}
	}
