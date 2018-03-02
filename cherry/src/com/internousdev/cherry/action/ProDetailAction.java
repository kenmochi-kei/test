package com.internousdev.cherry.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.Product_InfoDAO;
import com.internousdev.cherry.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ProDetailAction extends ActionSupport implements SessionAware{

	//商品ID(Primary Keyのほう)
	private String id;

	//商品ID
	private int productId;

	//カテゴリーID
    private int categoryId;

	//セッション
	private Map<String,Object> session;

	//商品一覧
	ProductDTO pro_detail = new ProductDTO();

	//購入個数
	private ArrayList<Integer> count = new ArrayList<>();

	//商品一覧リスト
	private List<ProductDTO> proList=new ArrayList<ProductDTO>();

	//関連商品一覧リスト(similarInfoDTOList)

    private ArrayList<ProductDTO> similarInfoDTOList = new ArrayList<ProductDTO>();

	//商品重複フラグ
	private boolean duplicationFlg;


	public String execute() throws SQLException{
		Product_InfoDAO dao=new Product_InfoDAO();
		int pro_id = Integer.parseInt(id.toString());

		try {
			pro_detail = dao.pro_detail(pro_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.put("pro_detail", pro_detail);

		//暫定でセッション値セット//
//		session.put("loginFlg",true);
//		session.put("userId","a");

		/*if(!(session.containsKey("userId"))){
			return ERROR;
 	}*/
		/*if(!(session.containsKey("loginFlg"))){
			session.put("loginFlg", false);

			if(!(boolean) (session.get("loginFlg"))&&session.containsKey("userId")){
				session.put("userId", session.get("tempUserId").toString());
			}
		}*/


		//ここから、目標の商品がすでにカートに入っているかどうか確認
		/*CartInfoDAO cartInfoDAO = new CartInfoDAO();
		if(session.containsKey("loginFlg")) {
			duplicationFlg = cartInfoDAO.isAlreadyIntoCart(session.get("userId").toString(), productId);
		} else {
			duplicationFlg = cartInfoDAO.isAlreadyIntoTempCart(session.get("userId").toString(), productId);
		}*/

		//ここから、購入個数を在庫に応じて変えるよう記述
		for(int i = 1; i <= pro_detail.getStock(); i++) {
			if (i > pro_detail.getStock()) {
				break;
			}
			count.add(i);
		}

		/*-----------------------------------------------
		 *関連商品を表示する
		 * pro_detailにあるcategory_idを取り出す
		 * category_idを引数にしてDBから同じカテゴリーの商品詳細を取得
		 *
		-------------------------------------------------*/
		if(session.containsKey("pro_detail")){
//			String categoryId = String.valueOf(session.get("category_id"));

			Product_InfoDAO productInfo=new Product_InfoDAO();
			//categoryIdをDAOに渡し、リストにしてアクションに返す
//			proList=productInfo.selectByCategoryId(Integer.parseInt(categoryId));
			proList=productInfo.selectByCategoryId(pro_detail.getCategory_id());

			//Iterator<ProductDTO> の宣言
			Iterator<ProductDTO> iterator=proList.iterator();
			//関連商品3つまで表示
			for(int i=0;i<3;i++){
				if(iterator.hasNext()){
					ProductDTO productDTO=(ProductDTO)iterator.next();
					//現在の商品と一致しないものを取得
					if(pro_id!=productDTO.getProduct_id()){
                        //関連商品DTOに格納
						similarInfoDTOList.add(productDTO);

					}else{
						i--;
						continue;
					}
					}else{
						break;
					}

				}
		}
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public ProductDTO getPro_detail() {
		return pro_detail;
	}

	public void setPro_detail(ProductDTO pro_detail) {
		this.pro_detail = pro_detail;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ArrayList<Integer> getCount() {
		return count;
	}

	public void setCount(ArrayList<Integer> count) {
		this.count = count;
	}

	public boolean isDuplicationFlg() {
		return duplicationFlg;
	}

	public void setDuplicationFlg(boolean duplicationFlg) {
		this.duplicationFlg = duplicationFlg;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<ProductDTO> getProList() {
		return proList;
	}

	public void setProList(List<ProductDTO> proList) {
		this.proList = proList;
	}

	public ArrayList<ProductDTO> getSimilarInfoDTOList() {
		return similarInfoDTOList;
	}

	public void setSimilarInfoDTOList(ArrayList<ProductDTO> similarInfoDTOList) {
		this.similarInfoDTOList = similarInfoDTOList;
	}



}
