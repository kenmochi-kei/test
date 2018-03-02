package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.cherry.dto.ProductDTO;
import com.internousdev.cherry.util.DBConnector;

public class Product_InfoDAO {

	//初期設定
	private DBConnector db = new DBConnector();
	private Connection con = null;

//	private ProductDTO pro_detail;

/*----------------------------------------------------------------------------------------------------------------------
 * 商品一覧表示する
 * -------------------------------------------------------------------------------------------------------------------*/
	public List<ProductDTO> pro_list() throws Exception{

		List<ProductDTO> proList = new ArrayList<ProductDTO>();

		try {

			//フィールドの情報を使ってデータベースへ接続
			con = db.getConnection();


			//SQL準備
			String sql = "SELECT * from product_info order by id desc";


			PreparedStatement pStmt = con.prepareStatement(sql);

			//実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {

				int def_id = rs.getInt("ID");
				int product_id = rs.getInt("PRODUCT_ID");
				String product_name = rs.getString("PRODUCT_NAME");
				String product_name_kana = rs.getString("PRODUCT_NAME_KANA");
				String product_description = rs.getString("PRODUCT_DESCRIPTION");
				int category_id = rs.getInt("CATEGORY_ID");
				int price = rs.getInt("PRICE");
				int stock = rs.getInt("stock");
				String image_file_name = rs.getString("IMAGE_FILE_NAME");
				String release_date = rs.getString("release_date");
				String release_company = rs.getString("release_company");
				String status = rs.getString("status");
				String regist_date = rs.getString("regist_date");
				String update_date = rs.getString("update_date");

				ProductDTO pro_list = new ProductDTO(def_id, product_id, product_name, product_name_kana, product_description, category_id, price, stock, image_file_name, release_date, release_company, status, regist_date, update_date);

				proList.add(pro_list);


			}

			return proList;


		} finally {
			//データベース切断
			if(con != null){
				try{
					con.close();
				} catch(SQLException e){
					e.printStackTrace();
				}	//catch
			}	//if
		}	//finally



	}	//pro_list

/*----------------------------------------------------------------------------------------------------------------------
 * 商品詳細を表示する
 * -------------------------------------------------------------------------------------------------------------------*/
	public ProductDTO pro_detail(int pro_id) throws Exception{

		ProductDTO dto = new ProductDTO();

		try {

			//フィールドの情報を使ってデータベースへ接続
			con = db.getConnection();


			//SQL準備
			String sql = "SELECT * from product_info where id = ?";


			PreparedStatement ps = con.prepareStatement(sql);

			//「？」に使用する値を設定し、SQL完成
			ps.setInt(1, pro_id);

			//実行
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {

				dto.setDef_id(rs.getInt("id"));
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setProduct_name(rs.getString("PRODUCT_NAME"));
				dto.setProduct_name_kana(rs.getString("PRODUCT_NAME_KANA"));
				dto.setProduct_description(rs.getString("PRODUCT_DESCRIPTION"));
				dto.setCategory_id(rs.getInt("CATEGORY_ID"));
				dto.setPrice(rs.getInt("PRICE"));
				dto.setStock(rs.getInt("stock"));
				dto.setImage_file_name(rs.getString("IMAGE_FILE_NAME"));
				dto.setRelease_date(rs.getString("release_date"));
				dto.setRelease_company(rs.getString("release_company"));
				dto.setStatus(rs.getString("status"));
				dto.setRegist_date(rs.getString("regist_date"));
				dto.setUpdate_date(rs.getString("update_date"));


			}

		} finally {
			//データベース切断
			if(con != null){
				try{
					con.close();
				} catch(SQLException e){
					e.printStackTrace();
				}	//catch
			}	//if
		}	//finally

		return  dto;

	}	//pro_list



/*----------------------------------------------------------------------------------------------------------------------
 * CategoryIdに対応したDTOの中身を取得する
 *  @param productId
 *  @return productInfoDTOList
 * -------------------------------------------------------------------------------------------------------------------*/
	public List<ProductDTO> selectByCategoryId(int categoryId) {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	List<ProductDTO> proList = new ArrayList<ProductDTO>();

	if(categoryId == 1) {
		proList = this.selectAll();

	} else {
		String sql = "SELECT *  FROM product_info WHERE category_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setDef_id(rs.getInt("id"));
				productDTO.setProduct_id(rs.getInt("product_id"));
				productDTO.setProduct_name(rs.getString("product_name"));
				productDTO.setProduct_name_kana(rs.getString("product_name_kana"));
				productDTO.setProduct_description(rs.getString("product_description"));
				productDTO.setCategory_id(rs.getInt("category_id"));
				productDTO.setPrice(rs.getInt("price"));
				productDTO.setImage_file_name(rs.getString("image_file_name"));
				productDTO.setRelease_date(rs.getString("release_date"));
				productDTO.setRelease_company(rs.getString("release_company"));
				productDTO.setRegist_date(rs.getString("regist_date"));
				productDTO.setUpdate_date(rs.getString("update_date"));

				proList.add(productDTO);

			}

		} catch(SQLException e) {
			e.printStackTrace();

		}

		try {
			con.close();

		} catch(SQLException e) {
			e.printStackTrace();

		}
	}
	return proList;
}

private List<ProductDTO> selectAll() {
	// TODO 自動生成されたメソッド・スタブ
	return null;
}
}	//Product_InfoDAO
