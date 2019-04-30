package com.sjxie.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class commentUtil {
	static String format = "yyyy-MM-dd HH:mm:ss";
	
	public static String formateDate(Date time) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(time);
		return dateString;
	}
}
