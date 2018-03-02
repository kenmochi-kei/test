package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.solare.util.DBConnector;

/**
 * PaymentInformationDAO 入力されたクレジットカード情報を一時格納テーブルTempに格納すると同時にTempIDを取得する。
 *
 * @since 2016/04/16
 * @version 1.0
 */
public class PaymentInformationDAO implements SessionAware {

	/**
	 * セッション
	 *
	 * @since 2016/04/16
	 * @version 1.0
	 */
	private Map<String, Object> session;

	/**
	 * データベースに接続するためのインターフェース
	 *
	 * @since 2016/04/16
	 * @version 1.0
	 */
	private Connection con;

	/**
	 * 更新件数
	 *
	 * @since 2016/04/16
	 * @version 1.0
	 */
	public int count = 0;

	/**
	 * SQL文
	 *
	 * @since 2016/04/16
	 * @version 1.0
	 */
	private String sql;

	/**
	 * 一時テーブルのID
	 *
	 * @since 2016/04/16
	 * @version 1.0
	 */
	private int tempId;

	/**
	 * SQL文を送るための準備
	 *
	 * @since 2016/04/16
	 * @version 1.0
	 */
	private PreparedStatement ps;

	/**
	 * 有効期限(月/年)
	 *
	 * @since 2016/04/16
	 * @version 1.0
	 */
	private String expirationDate;

	/**
	 * <p>
	 * kuruyamaデータベースのtempテーブルを作成した時刻と現在時刻を比較し、<br>
	 * 作成から1時間以上が経過していれば該当IDの情報を全て削除するメソッド<br>
	 * </p>
	 *
	 * @since 2016/04/16
	 * @return count 削除件数を返します。
	 */
	public int deleteTemp() {
		try {
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();

			String sql = "delete from temp where date < now() - INTERVAL 1 HOUR";
			ps = con.prepareStatement(sql);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 入力された値を一時テーブルtempへ格納すると同時に、tempIdを取得するメソッド
	 *
	 * @since 2016/04/16
	 * @param cardNumber
	 *            クレジットカード番号
	 * @param cardMonth
	 *            有効期限(月)
	 * @param cardYear
	 *            有効期限(年)
	 * @param cardHolder
	 *            クレジットカード名義
	 * @param securityCode
	 *            セキュリティコード
	 * @return tempId 格納に成功した場合にtempIdを返します。
	 */
	public int insertTemp(String cardNumber, String cardMonth, String cardYear, String cardHolder,
			String securityCode) {
		try {
			expirationDate = cardMonth + " / " + cardYear;
			DBConnector db = new DBConnector();
			con = db.getConnection();

			sql = "insert into temp (card_number, expiration_date," + "card_holder,security_code) " + "values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, cardNumber);
			ps.setString(2, expirationDate);
			ps.setString(3, cardHolder);
			ps.setString(4, securityCode);
			count = ps.executeUpdate();
			sql = "SELECT LAST_INSERT_ID() AS LAST";
			ResultSet rs = ps.executeQuery(sql);
			if (rs.next()) {
				tempId = rs.getInt("LAST");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempId;
	}

	/**
	 * セッションを取得するメソッド
	 *
	 * @since 2016/04/16
	 * @return session セッション
	 */
	public Map<String, Object> GetSession() {
		return session;
	}

	/**
	 * セッションを格納するメソッド
	 *
	 * @since 2016/04/16
	 * @param session
	 *            セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * 一時テーブルのIDを取得するメソッド
	 *
	 * @since 2016/04/16
	 * @return tempId 一時テーブルのID
	 */
	public int getTempId() {
		return tempId;
	}
}
