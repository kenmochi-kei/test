package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.solare.dto.GetSeatInfoDTO;
import com.internousdev.solare.util.DBConnector;

/**
 * GetSeatinfoDAO 空席情報の検索、追加を行うためのクラス
 *
 * @since 2015/04/14
 * @version 1.0
 */
public class SearchInfoDAO {

	/**
	 * 予約情報リスト
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private List<GetSeatInfoDTO> checkRecordList = new ArrayList<GetSeatInfoDTO>();

	/**
	 * 空席情報リスト
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private List<GetSeatInfoDTO> seatInfoList = new ArrayList<GetSeatInfoDTO>();

	/**
	 * 空席情報件数検索メソッド
	 *
	 * @since 2015/04/14
	 * @return reCount 件数
	 * @throws SQLException
	 */
	public int checkRecordNum() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int rsCount = 0;
		String sql = "select * from seat_info where date BETWEEN (CURDATE())+1 AND (CURDATE() + INTERVAL 7 DAY)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GetSeatInfoDTO dto = new GetSeatInfoDTO();
				dto.setDate(rs.getString(1));
				dto.setDayOfWeek(rs.getInt(2));
				dto.setMaxNumberOfPpl(rs.getInt(3));
				dto.setRemainingSeat(rs.getInt(4));
				checkRecordList.add(dto);
				rsCount++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
		return rsCount;
	}

	/**
	 * 空席情報追加メソッド
	 *
	 * @since 2015/04/14
	 * @throws SQLException
	 */
	public void insertRecord(String date) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into seat_info values('" + date + "' + INTERVAL ? DAY,WEEKDAY('" + date
				+ "' + INTERVAL ? DAY),150,0)";
		PreparedStatement ps;
		try {
			for (int j = 1; j < 8; j++) {
				ps = con.prepareStatement(sql);
				ps.setInt(1, j);
				ps.setInt(2, (j));
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
	}

	/**
	 * 空席情報追加メソッド
	 *
	 * @since 2015/04/14
	 * @throws SQLException
	 */
	public void insertZeroRecord() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into seat_info values(now() + INTERVAL ? DAY,WEEKDAY(now() + 1 + INTERVAL ? DAY),150,0)";
		PreparedStatement ps;
		try {
			for (int i = 1; i < 8; i++) {
				ps = con.prepareStatement(sql);
				ps.setInt(1, i);
				ps.setInt(2, i);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
	}

	/**
	 * 空席情報検索メソッド
	 *
	 * @since 2015/04/14
	 * @throws SQLException
	 */
	public void select() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from seat_info where date BETWEEN (CURDATE()) + 1 AND (CURDATE()) + INTERVAL 7 DAY";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GetSeatInfoDTO dto = new GetSeatInfoDTO();
				dto.setDate(rs.getString(1));
				dto.setDayOfWeek(rs.getInt(2));
				dto.setMaxNumberOfPpl(rs.getInt(3));
				dto.setRemainingSeat(rs.getInt(4));
				seatInfoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
	}

	/**
	 * 予約情報リスト取得メソッド
	 *
	 * @since 2015/04/14
	 * @param checkRecordList
	 *            予約情報
	 */
	public List<GetSeatInfoDTO> getCheckRecordList() {
		return checkRecordList;
	}

	/**
	 * 空席情報リスト取得メソッド
	 *
	 * @since 2015/04/14
	 * @param seatInfoList
	 *            空席情報
	 */
	public List<GetSeatInfoDTO> getSeatInfoList() {
		return seatInfoList;
	}
}