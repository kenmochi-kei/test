package com.internousdev.cherry.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author internousdev
 * @author yuzan-sakurai
 *
 */
public class DateUtil {
	public String getDate(){
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		return simpleDateFormat.format(date);
	}

}
