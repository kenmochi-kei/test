package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.solare.dto.GoToCustomerInfoEditDTO;
import com.internousdev.solare.util.DBConnector;

/**
 * GoToCustomerInfoEditDAO 会員情報リストから会員情報を検索するためのクラス
 *
 * @since 2015/04/16
 * @version 1.0
 */
public class GoToCustomerInfoEditDAO {

	/**
	 * 会員情報リスト
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	private List<GoToCustomerInfoEditDTO> userInfoList = new ArrayList<GoToCustomerInfoEditDTO>();

	/**
	 * 会員情報検索メソッド
	 *
	 * @since 2015/04/16
	 */
	public void select(int accountNumber) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try {
			String sql = "select * from customer_info where account_number = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GoToCustomerInfoEditDTO dto = new GoToCustomerInfoEditDTO();
				dto.setUserId(rs.getString(2));
				dto.setLastName(rs.getString(5));
				dto.setFirstName(rs.getString(6));
				dto.setMailAddress(rs.getString(7));
				dto.setGenderInt(rs.getInt(8));
				if (dto.genderInt == 0) {
					dto.setGenderStr("Man");
				} else {
					dto.setGenderStr("Woman");
				}
				userInfoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 会員情報リスト取得メソッド
	 *
	 * @since 2015/04/16
	 * @return userInfoList 会員情報リスト
	 */
	public List<GoToCustomerInfoEditDTO> getUserInfoList() {
		return userInfoList;
	}
}
