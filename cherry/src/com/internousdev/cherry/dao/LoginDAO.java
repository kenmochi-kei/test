package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.cherry.dto.UserInfoDTO;
import com.internousdev.cherry.util.DBConnector;

public class LoginDAO {

	public UserInfoDTO select(String userId,
			String password) /* throws SQLException */ {
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from user_info where user_id=? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setEmail(rs.getString("email"));

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} /*
			 * finally { con.close(); }
			 */

		return userInfoDTO;
	}

	public boolean login(UserInfoDTO userInfoDTO) throws SQLException {
		boolean result = false;
		int updateCount = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE user_info SET logined=1 WHERE user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userInfoDTO.getUserId());
			updateCount = ps.executeUpdate();
			if (updateCount > 0) {
				System.out.println("ログイン済み");
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}
		return result;
	}

	public boolean existsUserId(String userId) throws SQLException {
		boolean result = false;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM user_info WHERE user_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}

		return result;
	}

}