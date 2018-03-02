package com.internousdev.yukazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.internousdev.yukazon.util.DBConnector;
import com.internousdev.yukazon.util.DateUtil;


public class PasswordSettingCompleteDAO {
	//ログイン情報取得元データベース"db"
	private DBConnector db = new DBConnector();
	//"db"に接続する"con"
	private Connection con = db.getConnection();
	//更新時間に使用"util"
	private DateUtil util = new DateUtil();
	//ログイン情報を格納しておくMap
	public Map<String,Object> session;
	//resultに初期値falseを代入
	private boolean result =false;
	//passwordSetting.jspで入力したlogin_idのpasswordとdateを使用
	private String sql ="UPDATE login_user_transaction SET login_pass = ?,updated_date = ? WHERE login_id = ?";

	/* パスワード更新情報(PasswordUpdateInfo)
	 * PasswordSettingCompleteActionに呼ばれている */

	public boolean PasswordUpdateInfo(String  login_pass,String login_id) throws SQLException{

		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, login_pass);
			ps.setString(2, util.getDate());
			ps.setString(3, login_id);
			int checkUpdate = ps.executeUpdate();

			if(checkUpdate > 0){
				result = true;
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

}

