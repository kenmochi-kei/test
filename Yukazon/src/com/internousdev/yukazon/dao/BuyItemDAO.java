package com.internousdev.yukazon.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.yukazon.dto.BuyItemDTO;
import com.internousdev.yukazon.util.DBConnector;

public class BuyItemDAO {
	//ログイン情報取得元データベース"db"
	private DBConnector db=new DBConnector();
	//"db"に接続する"con"
	private Connection con=db.getConnection();
	//購入情報格納"bdtoList"
	private List<BuyItemDTO> bdtoList=new ArrayList<BuyItemDTO>();

	/**
	 * 商品情報取得メソッド(getBuyItemInfo)!!!!!!!!!!!!!!!
	 *LoginActionに呼ばれている
	 * @return BuyItemDTO
	 */

	public List<BuyItemDTO> getBuyItemInfo(){
		//sqlにある"item_info_transaction"テーブルの"id,item_name,item_price"を"sql"に代入
		String sql="SELECT id,item_name,item_price FROM item_info_transaction";
		try{
			//上の"sql"に接続することを"ps"に代入
			PreparedStatement ps=con.prepareStatement(sql);
			//接続実行した事を"rs"に代入
			ResultSet rs=ps.executeQuery();
			//"rs"を"dto"に参照してみる
			while(rs.next()){
				//ログイン情報格納DTO
				BuyItemDTO dto=new BuyItemDTO();
				//2. BuyItemDTOの"setId"に当てはめる  ↓1."id"カラムを呼び出して
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
			}
		//例外が起きて"sql"に接続できなかったら
		}catch(Exception e){
				//標準例外メソッドの"printStackTrace"を呼び出す
				e.printStackTrace();
		}
		//try,catchの結果を"dto"に格納
		return bdtoList;
	}

	//BuyItemDAOで取得した情報結果が"dto"に格納されている
	// "dto"情報はprivateにしているため呼び出せるようにしておく
	public List<BuyItemDTO> getBuyItemDTO() {
		return bdtoList;
	}

}