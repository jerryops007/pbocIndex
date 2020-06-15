package com.jerry.pbocLabel.util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	private static String FLAG = "1";

	/**
	 * 替换字符串指定位置的字符(设置SET_FLAG "000000000")
	 *
	 * @param index
	 *            指定位置
	 * @param res
	 *            需要替换的字符串
	 * @param str
	 *            替换字符
	 * @return
	 */
	public static String replaceIndex(int index, String res, String str) {
		if (res == null) {
			return res;
		}
		if (index > res.length() || index < 1) {
			return res;
		}
		if (str != null) {
			FLAG = str;
		}
		return res.substring(0, index - 1) + FLAG + res.substring(index);
	}

	public static char getCharByIndex(int index, String str) {
		return str.charAt(index - 1);
	}

	public static String buildPhone(String phone) {
		StringBuffer sb = new StringBuffer(phone);
		int i = 0;
		sb.insert(i, "86");
		while ((i = sb.indexOf(",", i + 1)) != -1) {
			sb.insert(i + 1, "86");
		}
		return sb.toString();
	}

	/**
	 * 判断对象是否Empty(null或元素为0)<br>
	 * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
	 *
	 * @param pObj
	 *            待检查对象
	 * @return boolean 返回的布尔值
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object pObj) {
		if (pObj == null) {
			return true;
		}
		if (pObj == "") {
			return true;
		}
		if (pObj instanceof String) {
			if (((String) pObj).length() == 0) {
				return true;
			}
		} else if (pObj instanceof Collection) {
			if (((Collection) pObj).size() == 0) {
				return true;
			}
		} else if (pObj instanceof Map) {
			if (((Map) pObj).size() == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断对象是否为NotEmpty(!null或元素>0)<br>
	 * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
	 *
	 * @param pObj
	 *            待检查对象
	 * @return boolean 返回的布尔值
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Object pObj) {
		if (pObj == null) {
			return false;
		}
		if (pObj == "") {
			return false;
		}
		if (pObj instanceof String) {
			if (((String) pObj).length() == 0) {
				return false;
			}
		} else if (pObj instanceof Collection) {
			if (((Collection) pObj).size() == 0) {
				return false;
			}
		} else if (pObj instanceof Map) {
			if (((Map) pObj).size() == 0) {
				return false;
			}
		} else if (pObj.equals(" ")) {
			return false;
		}
		return true;
	}

	public static String escapeStr(String str) {
		if (str != null && !"".equals(str)) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			String strNoBlank = m.replaceAll("");
			return strNoBlank;
		}else{
			return str;
		}
	}
	
    public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
    }
    
}
