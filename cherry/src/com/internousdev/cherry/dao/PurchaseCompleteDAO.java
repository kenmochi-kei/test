package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.cherry.dto.CartInfoDTO;
import com.internousdev.cherry.util.DBConnector;

public class PurchaseCompleteDAO {

	private DBConnector db = new DBConnector();

	private Connection con = db.getConnection();

	/**
	 * カートテーブルを購入履歴に登録するメソッド
	 *
	 * @param userId
	 * @return cartList 1.カートテーブルを取得 2.購入履歴に登録
	 */

	public ArrayList<CartInfoDTO> getCartInfo(String userId) throws SQLException {
		ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();

		String sql = "SELECT * from cart_info where user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setUserId(rs.getString("user_id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setUpdateDate(rs.getDate("update_date"));
				dto.setRegistDate(rs.getDate("regist_date"));

				// コンソールに処理を表示
				System.out.println("------getCartInfo");
				System.out.println(dto.getUserId());
				System.out.println(dto.getProductId());
				System.out.println(dto.getProductCount());
				System.out.println(dto.getPrice());
				System.out.println(dto.getUpdateDate());
				System.out.println(dto.getRegistDate());
				System.out.println("------------------");
				//

				cartList.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}
		return cartList;

	}

	/**
	 * 購入情報保存
	 *
	 * @param cartList
	 * @return ret
	 */

	public int setPurchseHistory(List<CartInfoDTO> cartList) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = null;
		/*--------------------------------------------------------------------------------------
		 * int型でActionからcartListを引数で受け取る
		 * 変数名retの初期値を0(未処理なら0のまま)
		 --------------------------------------------------------------------------------------*/
		int ret = 0;

		/*--------------------------------------------------------------------------------------
		 * for文でcatListを回し、カート情報の件数ぶん検索をかける→件数処理がretに入る
		 --------------------------------------------------------------------------------------*/
		try {
			for (int i = 0; i < cartList.size(); i++) {
				sql = "INSERT INTO purchase_history_info(user_id,price,product_id,product_count,regist_date,update_date) VALUES(?,?,?,?,NOW(),NOW())";
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, cartList.get(i).getUserId());
				ps.setInt(2, cartList.get(i).getPrice());
				ps.setInt(3, cartList.get(i).getProductId());
				ps.setInt(4, cartList.get(i).getProductCount());

				/* コンソールに処理を表示------------------------------- */
				System.out.println("----setPurchseHistory");
				System.out.println(cartList.get(i).getUserId());
				System.out.println(cartList.get(i).getPrice());
				System.out.println(cartList.get(i).getProductId());
				System.out.println(cartList.get(i).getProductCount());
				System.out.println("------------------------");
				/*------------------------------------------------------*/

				/*--------------------------------------------------------------------------------------
				 * += 以上が実行され登録されるたびに足す処理
				--------------------------------------------------------------------------------------*/
				ret += ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return ret;
	}
}
