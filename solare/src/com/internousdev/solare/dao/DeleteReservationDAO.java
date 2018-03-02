package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.solare.dto.ReservationInfoDTO;
import com.internousdev.solare.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

/**
 * DeleteReservationDAO 予約情報削除
 *
 * @since 2015/04/14
 * @version 1.0
 */
public class DeleteReservationDAO extends ActionSupport {

	/**
	 * シリアルナンバー
	 *
	 * @since 2015/04/14
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 削除対象の情報をリスト化するメソッド
	 *
	 * @since 2015/04/14
	 * @param accountNumber
	 * @return deleteReservationList 削除対象予約情報リスト
	 * @throws SQLException
	 */
	public List<ReservationInfoDTO> getAllDleteReservationInfo(int accountNumber) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		List<ReservationInfoDTO> deleteReservationList = new ArrayList<ReservationInfoDTO>();
		try {
			String sql = "select * from reservation_info where account_number=? AND reservation_date > now()";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReservationInfoDTO dto = new ReservationInfoDTO();
				dto.setCustomerReservationNumber(rs.getInt(2));
				dto.setNumberOfPeople(rs.getInt(5));
				deleteReservationList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return deleteReservationList;
	}

	/**
	 * 空席起き情報更新テーブルリフレッシュ操作メソッド
	 * @since 2015/04/14
	 * @param numberOfPpl
	 *            予約人数
	 * @param date
	 *            日時
	 */
	public void refleshSeatInfo(int numberOfPpl, int customerReservationNumber) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "update seat_info set remaining_seats=remaining_seats-? where customer_reservation_number=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numberOfPpl);
			ps.setInt(2, customerReservationNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 予約情報削除メソッド
	 *
	 * @since 2015/04/14
	 * @return rsCount 削除件数
	 */
	public int delete(int account_number, int reservation_num) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int rsCount = 0;
		try {
			String sql = "delete from reservation_info where account_number=? AND customer_reservation_num=?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setInt(1, account_number);
			ps.setInt(2, reservation_num);
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

	/**
	 * 予約情報削除メソッド
	 *
	 * @since 2015/04/14
	 * @return reCount 削除件数
	 */
	public int allDelete(int account_number) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int rsCount = 0;
		try {
			String sql = "delete from reservation_info where account_number=? AND reservation_date > now()";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setInt(1, account_number);
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
