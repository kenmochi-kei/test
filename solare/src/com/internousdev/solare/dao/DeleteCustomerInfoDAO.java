package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.solare.util.DBConnector;

/**
 * DeleteCustomerInfoDAO 会員情報削除
 *
 * @since 2015/04/14
 * @version 1.0
 */
public class DeleteCustomerInfoDAO {

	/**
	 * コネクション
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private Connection con;

	/**
	 * 会員情報削除メソッド
	 *
	 * @since 2015/04/14
	 * @return rsCount 削除件数
	 */
	public int update(int accountNumber) throws SQLException {
		DBConnector db = new DBConnector();
		con = db.getConnection();
		int rsCount = 0;
		try {
			String sql1 = "update customer_info set acc_password=?,last_name=?,first_name=?,customer_mailaddress=?"
					+ ",customer_gender=?,phone_number=?,twitter_token=?,twitter_token_secret=?,register_flag_uuid=?"
					+ ",delete_date=now() where accountNumber=?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql1);
			ps.setString(1, null);
			ps.setString(2, null);
			ps.setString(3, null);
			ps.setString(4, null);
			ps.setInt(5, 0);
			ps.setString(6, null);
			ps.setString(7, null);
			ps.setString(8, null);
			ps.setString(9, null);
			ps.setString(10, null);
			ps.setInt(11, accountNumber);
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
