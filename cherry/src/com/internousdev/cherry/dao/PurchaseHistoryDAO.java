package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.cherry.dto.PurchaseHistoryDTO;
import com.internousdev.cherry.util.DBConnector;

/*
 *購入履歴表示
 *購入履歴削除メソッド
 *ソート機能
 */

public class PurchaseHistoryDAO {

/*--------------------------------------------------------------
 * 購入履歴表示メソッド
 * @param userId
 * @purchaseHistoryDTOList
------------------------------------------------ */


	public ArrayList<PurchaseHistoryDTO> getPurchaseHistory(String userId) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<PurchaseHistoryDTO> purchaseHistoryDTOList = new ArrayList<PurchaseHistoryDTO>();

		/*
		 * piはproduct_infoの略
		 * phiはpurchase_history_infoの略
		 */
		String sql = "SELECT phi.id, pi.product_name, pi.product_name_kana, pi.image_file_name,  phi.price, phi.product_count, pi.release_company, pi.release_date, phi.regist_date  FROM purchase_history_info phi LEFT JOIN product_info pi ON phi.product_id = pi.product_id  WHERE phi.user_id = ? ORDER BY regist_date DESC";


		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setPrice(rs.getInt("price"));
				dto.setCount(rs.getInt("product_count"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setRegistDate(rs.getString("regist_date"));
				dto.setProductImage(rs.getString("image_file_name"));

				purchaseHistoryDTOList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			con.close();
		}
		return purchaseHistoryDTOList;
	}

	/*--------------------------------------------------------------
	 *	金額高い順にならびかえるメソッド
	 --------------------------------------------------------------*/
	public ArrayList<PurchaseHistoryDTO> sortPrice(String userId) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<PurchaseHistoryDTO> purchaseHistoryDTOList = new ArrayList<PurchaseHistoryDTO>();

		/*
		 * piはproduct_infoの略
		 * phiはpurchase_history_infoの略
		 */
		String sql = "SELECT phi.id, pi.product_name, pi.product_name_kana, pi.image_file_name,  phi.price, phi.product_count, pi.release_company, pi.release_date, phi.regist_date  FROM purchase_history_info phi LEFT JOIN product_info pi ON phi.product_id = pi.product_id  WHERE phi.user_id = ? ORDER BY price DESC";


		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setPrice(rs.getInt("price"));
				dto.setCount(rs.getInt("product_count"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setRegistDate(rs.getString("regist_date"));
				dto.setProductImage(rs.getString("image_file_name"));

				purchaseHistoryDTOList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			con.close();
		}
		return purchaseHistoryDTOList;
	}



	/*--------------------------------------------------------------
	 * すべて削除するメソッド
	 * @param userId
	 --------------------------------------------------------------*/
	public int deleteHistory(String userId) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "DELETE FROM purchase_history_info where user_id = ?";

		PreparedStatement ps;
		int result = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			result = ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;

	}



	/*--------------------------------------------------------------
	 * 個別削除メソッド
	 * @param id(auto incrementのID)
	 --------------------------------------------------------------*/
	public int deletePart(int id) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "DELETE  FROM purchase_history_info where id = ?";
		PreparedStatement ps;
		int result2 = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			result2 = ps.executeUpdate();
			System.out.println(result2);

			con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return result2;
	}

	/*
	 * 選択削除メソッド
	 * jspからのcheckBoxのchooseListを取得

	public int deleteChoose(List<String> chooseList) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE  FROM purchase_history_info where id = ?";

		PreparedStatement ps;
		int result3 = 0;
		try{
			ps = con.prepareStatement(sql);

			for(int i = 0;i < chooseList.size();i++){
				String chooseId = chooseList.get(i);
				ps.setString(1, chooseId);
				result3 += ps.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result3;
	}
	*/

}























