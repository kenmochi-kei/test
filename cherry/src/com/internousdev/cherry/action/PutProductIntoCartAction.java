package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.CartInfoDAO;
import com.internousdev.cherry.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PutProductIntoCartAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();

	// 商品重複フラグ
	private boolean duplicationFlg;

	// 商品ID
	private String productId;

	private String productNameKana;
	private String productName;
	private String productDescription;
	private String price;
	private String imageFileName;
	private String releaseCompany;
	private int count;

	// カートの商品個数
	private int productCount;

	// カートの合計金額
	private int totalPrice = 0;

	public String execute() throws SQLException {
		System.out.println("countは" + count);
		CartInfoDTO dto = new CartInfoDTO();
		CartInfoDAO dao = new CartInfoDAO();
		dto.setProductId(Integer.parseInt(productId.toString()));
		dto.setProductCount(productCount);

		System.out.println("----PutProductIntoCartAction");
		System.out.println("productId:" + productId);
		System.out.println("productNameKana" + productNameKana);
		System.out.println("productName" + productName);
		System.out.println("productDescription" + productDescription);
		System.out.println("price" + price);
		System.out.println("imageFileName" + imageFileName);
		System.out.println("releaseCompany" + releaseCompany);
		System.out.println("loginFlg:" + session.get("loginFlg"));
		System.out.println("userId:" + session.get("userId"));
		System.out.println("duplicationFlg:" + duplicationFlg);
		System.out.println("-----------------------------");

		int iPrice = Integer.parseInt(price);
		if (!(session.containsKey("loginFlg"))) {
			session.put("loginFlg", false);
		}

		/* 櫻井作成メソッド */

		/*
		 * ログインしている際にカートに入れた場合
		 */
		if (session.containsKey("loginFlg") && (boolean) session.get("loginFlg")) {
			/*
			 * カート内の商品の重複を確認
			 */

			boolean dupFlg = dao.isAlreadyIntoCart(session.get("userId").toString(), Integer.parseInt(productId));
			if (!dupFlg) {
				count = dao.putProductIntoCart(session.get("userId").toString(), Integer.parseInt(productId),
						productCount, iPrice);
				cartList = dao.showUserCartList(session.get("userId").toString());
			} else {
				count = dao.UpdateProductCount(session.get("userId").toString(), Integer.parseInt(productId),
						productCount, iPrice);
				cartList = dao.showUserCartList(session.get("userId").toString());
			}
		}
		/*
		 * ログインしていない場合
		 */
		else {
			boolean dupFlg = dao.isAlreadyIntoCart(session.get("tempUserId").toString(), Integer.parseInt(productId));
			if (!dupFlg) {
				count = dao.putProductIntoCart(session.get("tempUserId").toString(), Integer.parseInt(productId),
						productCount, iPrice);
				cartList = dao.showUserCartList(session.get("tempUserId").toString());
			} else {
				count = dao.UpdateProductCount(session.get("tempUserId").toString(), Integer.parseInt(productId),
						productCount, iPrice);
				cartList = dao.showUserCartList(session.get("tempUserId").toString());
			}
		}

		/*
		 * 検証画面で購入個数をマイナスにした場合エラーを返しホームに戻る
		 */
		if (productCount < 0) {
			return "CountError";
		}

		totalPrice = calcTotalPrice(cartList);
		return SUCCESS;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session
	 *            セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	/**
	 * @return cartList
	 */
	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}

	/**
	 * @param cartList
	 *            セットする cartList
	 */
	public void setCartList(ArrayList<CartInfoDTO> cartList) {
		this.cartList = cartList;
	}

	/**
	 * @return duplicationFlg
	 */
	public boolean isDuplicationFlg() {
		return duplicationFlg;
	}

	/**
	 * @param duplicationFlg
	 *            セットする duplicationFlg
	 */
	public void setDuplicationFlg(boolean duplicationFlg) {
		this.duplicationFlg = duplicationFlg;
	}

	/**
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            セットする totalPrice
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * 合計金額を計算するメソッド
	 */
	public int calcTotalPrice(ArrayList<CartInfoDTO> cartList) {
		int totalPrice = 0;
		for (CartInfoDTO dto : cartList) {
			totalPrice += dto.getPrice() * dto.getProductCount();
			System.out.println("合計" + totalPrice + "円");
		}
		return totalPrice;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
