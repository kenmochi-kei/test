package com.internousdev.yukazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.yukazon.util.DBConnector;
import com.internousdev.yukazon.util.DateUtil;

public class UserCreateCompleteDAO {
	//ログイン情報取得元データベース"db"
	private DBConnector db = new DBConnector();
	//"db"に接続する"con"
	private Connection con = db.getConnection();
	//時間"util"
	private DateUtil util = new DateUtil();
	//sqlにある"login_user_transaction"テーブルの()を"sql"に代入
	private String sql = "INSERT INTO login_user_transaction (login_id, login_pass,seacret_question,seacret_answer, insert_date) VALUES(?, ?, ? ,? ,?)";

	/* *
	 * 新規ユーザー登録メソッド(createUser)
	 * UserCreateCompleteActionに呼ばれている
	 * */

	//userCreateConfirmで入力した情報を当てはめる
	public void createUser(String loginUserId, String loginUserPassword,String secretQuestion,String secretAnswer) throws SQLException {
		try {
			//↓上の"sql"に接続することを"ps"に代入
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, secretQuestion);
			ps.setString(4, secretAnswer);
			ps.setString(5, util.getDate());
			ps.execute();
		//例外が起きて"sql"に接続できなかったら標準例外メソッドの"printStackTrace"を呼び出す
		} catch(Exception e) {
			e.printStackTrace();
		//接続を切る
		} finally {
			con.close();
		}
	}
}

