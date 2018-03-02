package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.cherry.dto.UserInfoDTO;
import com.internousdev.cherry.util.DBConnector;

public class UserInfoDAO {
	public DBConnector db = new DBConnector();
	public Connection con = null;

	public boolean registerUser(UserInfoDTO userInfoDTO) throws SQLException {
		boolean result = false;
		int updateCount = 0;

		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, regist_date) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, NOW())";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userInfoDTO.getUserId());
			ps.setString(2, userInfoDTO.getPassword());
			ps.setString(3, userInfoDTO.getFamilyName());
			ps.setString(4, userInfoDTO.getFirstName());
			ps.setString(5, userInfoDTO.getFamilyNameKana());
			ps.setString(6, userInfoDTO.getFirstNameKana());
			ps.setBoolean(7, userInfoDTO.isSex());
			ps.setString(8, userInfoDTO.getEmail());

			System.out.println(userInfoDTO.getFirstName());

			updateCount = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}

		if (updateCount == 1) {
			result = true;

		}

		return result;
	}

	public int update(String password, String userId) {
		int result = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE user_info SET password = ? WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, userId);
			int i = ps.executeUpdate();

			if (i > 0) {
				System.out.println(i + "件変更されました。");
				result = i;

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;

	}

	public List<UserInfoDTO> select(String password, String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM user_info WHERE password = ? AND user_id = ?";
		List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTOList.add(userInfoDTO);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		try {
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return userInfoDTOList;
	}

	public ArrayList<UserInfoDTO> userInfo(String userId) {
		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
		Connection con = db.getConnection();

		String sql = "SELECT family_name,first_name,family_name_kana,first_name_kana,sex,email FROM user_info WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				UserInfoDTO userInfodto = new UserInfoDTO();
				userInfodto.setFamilyName(rs.getString("familyName"));
				userInfodto.setFirstName(rs.getString("firstName"));
				userInfodto.setFamilyNameKana(rs.getString("familyNameKana"));
				userInfodto.setFirstNameKana(rs.getString("firstNameKana"));
				userInfodto.setSex(rs.getBoolean("sex"));
				userInfodto.setEmail(rs.getString("email"));
				userInfoDTO.add(userInfodto);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		try {
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return userInfoDTO;

	}

	public boolean existsUserId(String userId) throws SQLException {
		boolean result = false;
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