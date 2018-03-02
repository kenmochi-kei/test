package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.solare.util.DBConnector;

/**
 * UpdateCustomerInfoDAO 会員情報更新
 *
 * @since 2015/04/16
 * @version 1.0
 */
public class UpdateCustomerInfoDAO {

	/**
	 * 会員UniqueID取得メソッド
	 *

	 * @since 2015/04/16
	 * @return result UniqueID
	 */
	public String getUserUniqueID(int accountNumber) throws SQLException {
		String result = null;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from customer_info where account_number = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getString(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
		return result;
	}

	/**
	 * 会員情報更新メソッド
	 *

	 * @since 2015/04/16
	 * @return result 結果
	 */
	public boolean updateCustomerInfo(String newLastName, String newFirstName, String newUserTel, String newUserEmail,
			int newGender, String newUserID, String newUserPass, int accountNumbers) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		boolean result = false;
		int rsCount;
		try {
			String sql = "update customer_info set last_name=?,first_name=?,phone_number=?,customer_mailaddress=?,customer_gender=?,customer_id=?,acc_password=? where account_number=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newLastName);
			ps.setString(2, newFirstName);
			ps.setString(3, newUserTel);
			ps.setString(4, newUserEmail);
			ps.setInt(5, newGender);
			ps.setString(6, newUserID);
			ps.setString(7, newUserPass);
			ps.setInt(8, accountNumbers);
			rsCount = ps.executeUpdate();
			if (rsCount > 0) {
				result = true;
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
	 * 会員ID管理テーブル操作メソッド
	 *

	 * @since 2015/04/16
	 * @return result 登録結果
	 * @throws SQLException
	 */
	public boolean isInsertCustomerIDinfo(String uniqueID, String userId) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		boolean result = true;
		int rsCount = 0;
		try {
			String sql = "insert into customerID_info(customer_id,user_uuid) value(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, uniqueID);
			rsCount = ps.executeUpdate();
			if (rsCount > 0) {
				result = true;
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
