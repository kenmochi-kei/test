package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.solare.util.DBConnector;

/**
 * LeaveDAO Twitterユーザー情報とユーザー情報を削除し、退会するためのクラス
 *
 * @since 2015/04/23
 * @version 1.0
 *
 */
public class LeaveDAO {

	/**
	 * ユーザー情報削除メソッド
	 *
	 * @since 2015/04/23
	 * @return result 結果
	 * @throws SQLException
	 */
	public boolean MemberDelete(int accountNumber, String userId) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int rsCount = 0;
		boolean result = false;
		try {
			String sql = "delete from customer_info where account_number=?";

			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			rsCount = ps.executeUpdate();
			if (rsCount > 0) {
				result = leaveUpdate(userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

	/**
	 * 退会日時更新メソッド
	 *
	 * @since 2015/04/23
	 * @return result 結果
	 * @throws SQLException
	 */
	private boolean leaveUpdate(String userId) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		boolean result = false;
		int count = 0;
		try {
			String sql = "update customerID_info set delete_date = now() where customer_id= '" + userId + "'";
			PreparedStatement ps = con.prepareStatement(sql);
			count = ps.executeUpdate(sql);
			if (count > 0) {
				result = true;
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
	 * Twitterユーザー情報削除メソッド
	 *
	 * @since 2015/04/23
	 * @return result 結果
	 * @throws SQLException
	 */
	public int TwitterUserDelete(String accessToken, String AccessTokenSecret) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int rsCount = 0;
		try {

			String sql = "delete from customer_info where twitter_token=? and twitter_token_secret=?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, accessToken);
			ps.setString(2, AccessTokenSecret);
			rsCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return rsCount;
	}

}