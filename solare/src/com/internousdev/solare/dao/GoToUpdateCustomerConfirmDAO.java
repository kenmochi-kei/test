package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.solare.dto.GoToUpdateCustomerConfirmDTO;
import com.internousdev.solare.util.DBConnector;

/**
 * GoToUpdateCustomerConfirmDAO 会員情報リストから会員情報を検索するためのクラス
 *
 * @author 岡部吉男
 * @since 2015/04/20
 * @version 1.0
 */
public class GoToUpdateCustomerConfirmDAO {

	/**
	 * 会員情報リスト
	 *
	 * @author 岡部吉男
	 * @since 2015/04/20
	 * @version 1.0
	 */
	private List<GoToUpdateCustomerConfirmDTO> userInfoList = new ArrayList<GoToUpdateCustomerConfirmDTO>();

	/**
	 * 会員情報検索メソッド
	 *
	 * @author 岡部吉男
	 * @since 2015/04/20
	 * @return userInfoList 会員情報リスト
	 */
	public List<GoToUpdateCustomerConfirmDTO> selectUserInfo(int accountNumber) {
		GoToUpdateCustomerConfirmDTO dto = new GoToUpdateCustomerConfirmDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from customer_info where account_number=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto.setLastName(rs.getString(5));
				dto.setFirstName(rs.getString(6));
				dto.setUserTel(rs.getString(9));
				dto.setUserEmail(rs.getString(7));
				dto.setGender(rs.getInt(8));
				dto.setUserId(rs.getString(2));
				dto.setUserPassword(rs.getString(3));
				userInfoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userInfoList;
	}

	/**
	 * 会員情報検索メソッド
	 *
	 * @author 岡部吉男
	 * @since 2015/04/20
	 * @return result 結果
	 * @throws Exception
	 */
	public boolean isCustomerIDCheck(String userId) throws SQLException {
		boolean result = true;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try {
			String sql = "select * from customerid_info where customer_id=?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = false;
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
}