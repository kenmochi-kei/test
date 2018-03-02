package com.internousdev.solare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.solare.dto.ReservationInfoDTO;
import com.internousdev.solare.util.DBConnector;

/**
 * EditReservationInfoDAO ユーザー予約情報リストから情報を検索し取得、変更を行うためのクラス
 *
 * @since 2015/04/20
 * @version 1.0
 */
public class EditReservationInfoDAO {

	/**
	 * ユーザー予約情報リスト
	 *

	 * @since 2015/04/20
	 * @version 1.0
	 */
	private List<ReservationInfoDTO> reservationInfoList = new ArrayList<ReservationInfoDTO>();

	/**
	 * ユーザー予約情報検索メソッド
	 *

	 * @since 2015/04/20
	 * @return result 結果
	 * @throws SQLException
	 */
	public boolean getReservationInfoList(int accountNumber) throws SQLException {
		boolean result = false;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try {
			String sql = "select * from reservation_info where account_number=? AND reservation_date > now()";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReservationInfoDTO dto = new ReservationInfoDTO();
				dto.setCustomerReservationNumber(rs.getInt(2));
				dto.setNumberOfPeople(rs.getInt(5));
				dto.setCourseNumber(rs.getInt(4));
				dto.setReservationDateTimestamp(rs.getTimestamp(8));
				dto.setReservationTime(rs.getInt(10));
				reservationInfoList.add(dto);
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!(con == null)) {
				con.close();
			}
		}
		for (int i = 0; i < reservationInfoList.size(); i++) {
		}
		return result;
	}

	/**
	 * ユーザー予約情報変更メソッド
	 *

	 * @since 2015/04/20
	 */
	public void editReservationInfo(String reservationDateTimeStamp, int cosutomerRervationNumber, int courseNumber,
			int numberOfPpl, int reservationTimeInt) {
		try {
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();
			String sql = "update reservation_info set reservation_date= '" + reservationDateTimeStamp
					+ "',course_number=?,number_of_ppl=?,reservation_time=? where customer_reservation_number=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, courseNumber);
			ps.setInt(2, numberOfPpl);
			ps.setInt(3, reservationTimeInt);
			ps.setInt(4, cosutomerRervationNumber);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 予約情報編集リスト取得メソッド
	 *

	 * @since 2015/04/20
	 * @return reservationInfoList 予約情報編集リスト
	 */
	public List<ReservationInfoDTO> getReservationInfoList() {
		return reservationInfoList;
	}
}
