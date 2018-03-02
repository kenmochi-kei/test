package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.internousdev.solare.util.DBConnector;

/**
 * ReservationCompleteDAO 予約の可否をチェックし、問題がなければ予約情報をDBに格納するためのクラス
 *
 * @since 2015/04/16
 * @version 1.0
 */
public class ReservationCompleteDAO {

	/**
	 * 同一日時予約チェックメソッド
	 *
	 * @since 2015/04/16
	 * @return result 予約の可否
	 */
	public boolean isCheckUserReservation(int accountNumber, String reservationDateTimeStamp) throws SQLException {
		boolean result = true;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from reservation_info where account_number=? and reservation_date='"
				+ reservationDateTimeStamp + "' and reservation_date > now()";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
		return result;
	}

	/**
	 * ユーザーフルネーム取得メソッド
	 *
	 * @since 2015/04/16
	 * @return result ユーザーフルネーム
	 * @throws SQLException
	 */
	public HashMap<String, String> getUserInfo(int accountNumber) throws SQLException {
		String fullName = null;
		String lastName = null;
		String firstName = null;
		String userTel = null;
		HashMap<String, String> userInfoMap = new HashMap<String, String>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try {
			String sql = "select * from customer_info where account_number=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lastName = rs.getString(5);
				firstName = rs.getString(6);
				userTel = rs.getString(9);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
		fullName = lastName + " " + firstName;
		userInfoMap.put("fullName", fullName);
		userInfoMap.put("userTel", userTel);
		return userInfoMap;
	}

	/**
	 * ユーザー予約情報数検索メソッド
	 *
	 * @since 2015/04/16
	 * @return result ユーザー予約件数
	 * @throws SQLException
	 */
	public int checkReservationCount(int accountNumber) throws SQLException {
		int rsCount = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try {
			String sql = "select * from reservation_info where account_number=? and reservation_date > now()";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rsCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
		return rsCount;
	}

	/**
	 * 予約情報登録メソッド
	 *
	 * @since 2015/04/16
	 * @param numberOfPeople2
	 * @return rsCount 登録結果
	 * @throws SQLException
	 */
	public boolean isInsertReservation(int accountNumber, int reservationNumber, int courseNumber, int numberOfPeople,
			String fullName, String userTel, String reservationDate, String reservationDateTimeStamp,
			int reservationTime) throws SQLException {
		boolean result = false;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try {
			String sql = "insert into reservation_info(customer_reservation_number,account_number,course_number,number_of_ppl,full_name,phone_number,reservation_date,reservation_dayofweek,reservation_time,register_date) value (?,?,?,?,?,?,?,WEEKDAY(?),?,now())";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reservationNumber);
			ps.setInt(2, accountNumber);
			ps.setInt(3, courseNumber);
			ps.setInt(4, numberOfPeople);
			ps.setString(5, fullName);
			ps.setString(6, userTel);
			ps.setString(7, reservationDateTimeStamp);
			ps.setString(8, reservationDate);
			ps.setInt(9, reservationTime);

			int rsCount = 0;
			rsCount = ps.executeUpdate();
			if (rsCount > 0) {
				updateSeatInfo(numberOfPeople, reservationDate);
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
		return result;
	}

	/**
	 * 空席情報テーブル操作メソッド
	 *
	 * @since 2015/04/16
	 * @throws SQLException
	 */
	private void updateSeatInfo(int numberOfPpl, String reservationDate) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try {
			String sql = "update seat_info set remaining_seats = remaining_seats + ? where date = '" + reservationDate
					+ "'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, numberOfPpl);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
	}
}
