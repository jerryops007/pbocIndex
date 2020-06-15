package com.jerry.pbocLabel.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@ActionBean(name = "日期相关操作")
//@Service("dateBasicAction")
//@Scope("prototype")
public class DateUtils {

	private final static Logger logger = LoggerFactory
			.getLogger(DateUtils.class);

	public static SimpleDateFormat format_3 = new SimpleDateFormat(
			"yyyy.MM.dd HH:mm:ss");

	public static String DATE_FORMAT_1 = "yyyy-MM-dd";
	public static String DATE_FORMAT_2 = "yyyy-MM";
	public static String DATE_FORMAT_3 = "yyyy.MM.dd HH:mm:ss";
	public static String DATE_FORMAT_4 = "yyyyMMddHHmmssSSS";
	public static String DATE_FORMAT_5 = "yyyy.MM";
	public static String DATE_FORMAT_6 = "yyyy.MM.dd";
	public static String DATE_FORMAT_7 = "yyyy.MM.ddHH:mm:ss";
	public static String DATE_FORMAT_8 = "yyyyMMdd";

	/**
	 * 日期相减返回年
	 * 
	 * @return Integer 日期1-日期2返回返回年
	 */
	public static Integer getdateDiffYear(String date1Str, String date2Str,
			String formate1, String formate2) {
		Integer year = -1;
		SimpleDateFormat sdf1 = new SimpleDateFormat(formate1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(formate2);
		try {
			Date date1 = sdf1.parse(date1Str);
			Date date2 = sdf2.parse(date2Str);
			Calendar calendar1 = Calendar.getInstance();
			Calendar calendar2 = Calendar.getInstance();
			calendar1.setTime(date1);
			calendar2.setTime(date2);
			if (calendar1.compareTo(calendar2) < 0) {
				logger.error("日期1小于日期2");
				return year;
			}
			year = (Integer) calendar1.get(Calendar.YEAR)
					- calendar2.get(Calendar.YEAR);
			int month = calendar1.get(Calendar.MONTH)
					- calendar2.get(Calendar.MONTH);
			if (month < 0) {
				year--;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return year;
	}

	/**
	 * 日期相减返回月
	 * 
	 * @return Integer 日期1-日期2返回月
	 */

	public static Integer getdateDiffMonth(String date1Str, String date2Str,
			String formate1, String formate2) {
		Integer month = -1;
		SimpleDateFormat sdf1 = new SimpleDateFormat(formate1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(formate2);
		try {
			Date date1 = sdf1.parse(date1Str);
			Date date2 = sdf2.parse(date2Str);
			Calendar calendar1 = Calendar.getInstance();
			Calendar calendar2 = Calendar.getInstance();
			calendar1.setTime(date1);
			calendar2.setTime(date2);
			if (calendar1.compareTo(calendar2) < 0) {
				logger.error("日期1小于日期2");
				logger.error("错误日期{}", date2Str);

				return month;
			}
			month = calendar1.get(Calendar.MONTH)
					- calendar2.get(Calendar.MONTH);
			int year = calendar1.get(Calendar.YEAR)
					- calendar2.get(Calendar.YEAR);
			/*
			 * int day = calendar1.get(Calendar.DAY_OF_MONTH) -
			 * calendar2.get(Calendar.DAY_OF_MONTH); if (day < 0) { month--; }
			 */
			if (month < 0) {
				month += 12;
				year--;
			}
			month = year * 12 + month;
		} catch (Exception e) {
			logger.error("日期计算错误-{}", e.getMessage());
			throw new RuntimeException();
		}
		return month;
	}

	/**
	 * 日期字符串减月数返回日期
	 * 
	 * @return Date 日期1-月数返回日期2
	 */

	public static Date getDateReduceMonNum(String dateStr, String format,
			int num) {
		Date resdate = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			Date date = sdf.parse(dateStr);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, -num);
			resdate = calendar.getTime();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return resdate;
	}

	/**
	 * 格式化日期字符串为时间
	 * 
	 * @return Date 格式化日期
	 */

	public static Date getFormatDate(String dateStr, String format) {
		Date resdate = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			resdate = sdf.parse(dateStr);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return resdate;
	}
}
