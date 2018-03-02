package com.internousdev.solare.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBconnector MySQLとのコネクションを獲得するクラス
 * @since 2015/04/09
 * @version 1.0
 */
public class DBConnector {

	/**
	 * 接続メソッド
	 *
	 * @since 2015/04/09
	 * @return con jdbcドライバ
	 */
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/solare", "root", "mysql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}