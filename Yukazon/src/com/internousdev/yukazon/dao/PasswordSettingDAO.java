package com.internousdev.yukazon.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.yukazon.dto.PasswordSettingDTO;
import com.internousdev.yukazon.util.DBConnector;

public class PasswordSettingDAO {
	//ログイン情報取得元データベース"db"
	private DBConnector db=new DBConnector();
	//"db"に接続する"con"
	private Connection con=db.getConnection();
	//ログイン情報格納DTO
	private PasswordSettingDTO dto=new PasswordSettingDTO();

	/**
	 * ユーザ情報取得メソッド(getLoginUserInfo)
	 *PasswordSettingActionに呼ばれている
	 */
	//secretQuestionConfirm.jspで入力した情報を当てはめる
	public PasswordSettingDTO getUpdateLoginUserInfo(String loginUserId,String secretQuestion,String secretAnswer){
		//sqlにある"login_user_transaction"テーブルのlogin_id=? AND login_pass=?を"sql"に代入
		String sql="SELECT*FROM login_user_transaction where login_id=? AND seacret_question=? AND seacret_answer=?";
		try{
			//上の"sql"に接続することを"ps"に代入
			PreparedStatement ps=con.prepareStatement(sql);
			//接続した"ps"にそれぞれ当てはめてみる
			ps.setString(1,loginUserId);
			ps.setString(2,secretQuestion);
			ps.setString(3,secretAnswer);
			//当てはめた事を"rs"に代入
			ResultSet rs=ps.executeQuery();
			//"rs"を"dto"に0から参照してみる
			if(rs.next()){
				//2. PasswordSettingDTOの"setLoginId"に当てはめる  ↓1."login_id"カラムを呼び出して
				dto.setLoginId(rs.getString("login_id"));
				dto.setSecretQuestion(rs.getString("seacret_question"));
				dto.setSecretAnswer(rs.getString("seacret_answer"));
				//もし呼び出した"login_id"カラムがnullと等しくなかったら
				if(!(rs.getString("login_id").equals(null))){
					//PasswordSettingDTOの"setUpdateLoginFlg"は"true"
					dto.setUpdateLoginFlg(true);
				}
			}
				//例外が起きて"sql"に接続できなかったら標準例外メソッドの"printStackTrace"を呼び出す
		}catch(Exception e){
			e.printStackTrace();
		}
		//try,catchの結果を"dto"に格納
		return dto;
	}

	//PasswordSettingDAOで取得した情報結果が"dto"に格納されている
	// "dto"情報はprivateにしているため呼び出せるようにしておく
	public PasswordSettingDTO PasswordSettingDTO(){
			return dto;
		}
}
