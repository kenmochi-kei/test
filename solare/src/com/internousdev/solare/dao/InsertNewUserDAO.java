package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.solare.dto.LoginDTO;
import com.internousdev.solare.util.DBConnector;

/**
 * InsertNewUserDAO ユーザーIDの重複がないかチェックし、なければ新規登録情報をDBに格納する
 *
 * @since 2015/04/16
 * @version 1.0
 */
public class InsertNewUserDAO {

	/**
	 * 会員情報リスト
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 */
	List<LoginDTO> userInfoList = new ArrayList<LoginDTO>();

	/**
	 * ユーザーID重複チェックメソッド
	 *
	 * @since 2015/04/16
	 * @version 1.0
	 * @return result 結果
	 * @throws SQLException
	 */
	public boolean isUserIDcheck(String userId) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		boolean result = true;
		try {
			String sql = "select * from customerID_info where customer_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	/**
	 * 会員情報登録メソッド
	 *
	 * @since 2015/04/16
	 * @return result 登録結果
	 * @throws SQLException
	 */
	public boolean isInsertCustomerInfo(String userId, String userPassword, String uniqueID, String lastName,
			String firstName, String userEmail, int gender, String userTel) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int rsCount = 0;
		boolean result = false;
		try {

			String sql = "insert into customer_info(customer_id,acc_password,user_uuid,last_name,first_name,customer_mailaddress,customer_gender,phone_number,register_date) value(?,?,?,?,?,?,?,?,now())";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userPassword);
			ps.setString(3, uniqueID);
			ps.setString(4, lastName);
			ps.setString(5, firstName);
			ps.setString(6, userEmail);
			ps.setInt(7, gender);
			ps.setString(8, userTel);
			rsCount = ps.executeUpdate();
			if (rsCount > 0) {
				result = isInsertCustomerIDinfo(uniqueID, userId);
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
	 * 会員情報登録メソッド
	 *
	 * @since 2015/04/16
	 * @return result 登録結果
	 * @throws SQLException
	 */
	public boolean isInsertCustomerInfo(String userId, String userPassword, String lastName, String firstName)
			throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String user_name = lastName + firstName;
		int rsCount = 0;
		boolean result = false;
		try {

			String sql = "insert into user(user_id,password,user_name)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userPassword);
			ps.setString(3, user_name);

			rsCount = ps.executeUpdate();
			if (rsCount > 0) {
				result = isInsertCustomerIDinfo(userId);
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
	private boolean isInsertCustomerIDinfo(String uniqueID, String userId) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		boolean result = true;
		int rsCount = 0;
		try {
			String sql = "insert into customerid_info(customer_id,user_uuid,insert_date) value(?,?,now())";
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

	/**
	 * openconnect用の会員ID管理テーブル操作メソッド
	 *
	 * @since 2015/04/16
	 * @return result 登録結果
	 * @throws SQLException
	 */
	private boolean isInsertCustomerIDinfo(String userId) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		boolean result = true;
		int rsCount = 0;
		try {
			String sql = "insert into user(user_id,insert_date) value(?,?,now())";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
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
