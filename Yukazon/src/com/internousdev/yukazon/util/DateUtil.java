package com.internousdev.yukazon.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 現在時刻取得メソッド
	 *
	 * @return String
	 */
	public String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		return sdf.format(date);
	}
 }

