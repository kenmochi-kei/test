package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.cherry.util.DBConnector;

public class CartDeleteDAO {

	private DBConnector db = new DBConnector();

	private Connection con = db.getConnection();

	/**
	 * カートの情報を全て削除
	 *
	 * @param user_id
	 */

	public void deleteCartInfo(String userId) {

		String sql = "DELETE FROM cart_info WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		try {
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	/**
	 * カート内の商品を１つずつ削除するメソッド
	 *
	 * @param userId
	 * @param productId
	 */
	public void deleteSeparate(String userId, String productId) {
		String sql = "DELETE FROM cart_info WHERE user_id = ? AND product_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, productId);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		try {
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
