package com.internousdev.yukazon.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.yukazon.dto.LoginDTO;
import com.internousdev.yukazon.util.DBConnector;

public class LoginDAO {
	//ログイン情報取得元データベース"db"
	private DBConnector db=new DBConnector();
	//"db"に接続する"con"
	private Connection con=db.getConnection();
	//ログイン情報格納DTO
	private LoginDTO dto=new LoginDTO();


/**
 * ログインユーザ情報取得メソッド(getLoginUserInfo)
 *LoginActionに呼ばれている
 * @param loginUserId
 * @param loginPassword
 * @return dto
 */

	// home.jspで入力した"loginUserId"と"loginPassword"を当てはめる
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
		//sqlにある"login_user_transaction"テーブルのlogin_id=? AND login_pass=?を"sql"に代入
		String sql="SELECT*FROM login_user_transaction where login_id=? AND login_pass=?";
		try{
			//上の"sql"に接続することを"ps"に代入
			PreparedStatement ps=con.prepareStatement(sql);
			//接続した"ps"にそれぞれ当てはめてみる
			ps.setString(1,loginUserId);
			ps.setString(2, loginPassword);
			//当てはめた事を"rs"に代入
			ResultSet rs=ps.executeQuery();
			//"rs"を"dto"に0から参照してみる
			if(rs.next()){
				//2. LoginDTOの"setLoginId"に当てはめる  ↓1."login_id"カラムを呼び出して
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				//もし呼び出したた"login_id"カラムがnullと等しくなかったら
				if(!(rs.getString("login_id").equals(null))){
					//LoginDTOの"setLoginFlg"は"true"
					dto.setLoginFlg(true);
				}
				//internousでログインしたら管理者とする
				if(rs.getString("login_id").equals("internous") && rs.getString("login_pass").equals("internous01")){
					dto.setLoginMaster(true);
				}
			}
		//例外が起きて"sql"に接続できなかったら
		}catch(Exception e){
			//標準例外メソッドの"printStackTrace"を呼び出す
			//(投げられた例外のクラス名,コンストラクタで渡された「例外の説明」,
			//			呼び出し元メソッドとファイル名や行番号の情報)
			e.printStackTrace();
		}
		//try,catchの結果を"dto"に格納
		return dto;
	}

	//LoginDAOで取得した情報結果が"dto"に格納されている
	// "dto"情報はprivateにしているため呼び出せるようにしておく
	public LoginDTO getLoginDTO(){
			return dto;
		}
}
