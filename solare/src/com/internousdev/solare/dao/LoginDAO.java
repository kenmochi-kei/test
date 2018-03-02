package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.solare.dto.LoginDTO;
import com.internousdev.solare.util.DBConnector;;

/**
 * LoginDAO ログインするためのクラス
 *
 * @since 2015/04/06
 * @version 1.0
 */
public class LoginDAO {

	/**
	 * 会員情報リスト
	 *
	 * @since 2015/04/06
	 * @version 1.0
	 */
	private List<LoginDTO> userInfoList = new ArrayList<LoginDTO>();

	/**
	 * ログイン情報取得メソッド
	 *
	 * @since 2015/04/06
	 * @return result 結果
	 * @throws SQLException
	 */
	public boolean isLoginCheck(String userId, String userPassword) throws SQLException {
		boolean result = false;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try {
			String sql = "select * from user where user_id=? AND password=?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userPassword);

			ResultSet rs = ps.executeQuery();
			LoginDTO dto = new LoginDTO();
			while (rs.next()) {
				result = true;
				dto.setAccountNumber(rs.getInt(1));
				dto.setUserId(rs.getString(2));
				dto.setUserPassword(rs.getString(3));
				dto.setLastName(rs.getString(5));
				userInfoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
		return result;
	}

	/**
	 * ユーザー情報リスト取得メソッド
	 *
	 * @since 2015/04/06
	 * @return userInfoList 会員情報リスト
	 */
	public List<LoginDTO> getUserInfoList() {
		return userInfoList;
	}
}

