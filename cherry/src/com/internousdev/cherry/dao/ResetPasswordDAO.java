package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.cherry.dto.UserInfoDTO;
import com.internousdev.cherry.util.DBConnector;

public class ResetPasswordDAO  {

	UserInfoDTO userInfoDTO = new UserInfoDTO();
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	//userIdをDBから取得する
	public UserInfoDTO UserInfoByUserId(String userId){

	String sql="SELECT * FROM user_info where user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			ResultSet resultSet=ps.executeQuery();

		if(resultSet.next()){
			userInfoDTO.setUserId(resultSet.getString("user_id"));
			return userInfoDTO;
		}

		}catch(Exception e){
			e.printStackTrace();
		}
			return userInfoDTO;
		}

	//ユーザーIDを元にして新しいパスワードをDBにセットする
	public void updatePassword(String userId,String password){

	String sql="UPDATE user_info SET password =? where user_id= ?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2,userId);
			ps.executeUpdate();



		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
		}
}

