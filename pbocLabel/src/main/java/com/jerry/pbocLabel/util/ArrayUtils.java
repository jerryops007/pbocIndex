package com.jerry.pbocLabel.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.enums.pboc.ContratInfoEnum;

@SuppressWarnings("rawtypes")
public class ArrayUtils {

	private final static Logger logger = LoggerFactory
			.getLogger(ArrayUtils.class);

	// @ActionMethod(name = "计算字符数组元素存在的次数")
	// @ActionMethodParameter(names = { "对象数组", "统计的数组元素" })
	public static int trim(List<String> list, String str) {
		if (list == null) {
			return 0;
		} else {
			int i = 0;
			for (String s : list) {
				if (s.equalsIgnoreCase(str)) {
					i++;
				}
			}
			return i;
		}
	}

	// @ActionMethod(name = "字符数组元素去重")
	// @ActionMethodParameter(names = { "对象数组" })
	public static List<String> removeRepeat(List<String> list) {
		if (list == null) {
			return new ArrayList<String>();
		}
		List<String> result = new ArrayList<String>();
		for (String str : list) {
			if (!result.contains(str)) {
				result.add(str);
			}
		}
		return result;
	}

	// @SuppressWarnings("rawtypes")
	// @ActionMethod(name = "List对象获取指定Index内容-返回Map")
	// @ActionMethodParameter(names = { "List对象", "Index编号" })
	public static <T> Object getObjectFromList(List<T> list, Integer i) {
		if (list == null) {
			return new HashMap();
		} else if (list.size() == 0 || i < 0) {
			return new HashMap();
		} else if (list.size() <= i) {
			return new HashMap();
		} else {
			return list.get(i);
		}
	}

	// @ActionMethod(name = "List对象获取指定Index内容-返回String")
	// @ActionMethodParameter(names = { "List对象", "Index编号" })
	public static <T> String getStringObjectFromList(List<T> list, Integer i) {
		if (list == null || list.size() <= 0) {
			return new String();
		} else {
			if (i < 0 || list.size() <= i) {
				return new String();
			} else {
				return list.get(i).toString();
			}
		}
	}

	// @ActionMethod(name = "List对象获取指定index-返回List")
	// @ActionMethodParameter(names = { "List对象", "Index编号" })
	public static <T> Object getListObjectFromList(List<T> list, Integer i) {
		if (list == null) {
			return new ArrayList<T>();
		} else if (list.size() == 0 || i < 0) {
			return new ArrayList<T>();
		} else if (list.size() <= i) {
			return new ArrayList<T>();
		} else {
			return list.get(i);
		}
	}

	// @ActionMethod(name = "数组截取-根据起始位和结束位返回子数组")
	// @ActionMethodParameter(names = { "List对象", "起始位i", "结束位j" })
	public static <T> List<T> subArray(List<T> list, int i, int j) {
		if (list == null || list.size() <= 0) {
			return new ArrayList<T>();
		} else {
			if (i <= j && i >= 0 && j < list.size()) {
				return list.subList(i, (j + 1));
			} else {
				return new ArrayList<T>();

			}
		}
	}

	// @ActionMethod(name = "数组截取-根据起始位截取到数组末尾")
	// @ActionMethodParameter(names = { "List对象", "起始位i" })
	public static <T> List<T> subArrayToEnd(List<T> list, int i) {
		if (list == null || list.size() <= 0) {
			return new ArrayList<T>();
		} else {
			if (i >= 0 && i < list.size()) {
				return list.subList(i, list.size());
			} else {
				return new ArrayList<T>();
			}
		}
	}

	// @ActionMethod(name = "列表中存在M1+逾期次数")
	// @ActionMethodParameter(names = { "List对象" })
	public static Integer listM1Num(List<String> list) {
		List<String> state = Arrays.asList("1", "2", "3", "4", "5", "6", "7",
				"G", "D", "Z", "B");
		Integer overNum = 0;
		for (String unit : list) {
			if (state.contains(unit)) {
				overNum++;
			}
		}
		return overNum;
	}

	// @ActionMethod(name = "列表中存在M2+逾期次数")
	// @ActionMethodParameter(names = { "List对象" })
	public static Integer listM2Num(List<String> list) {
		List<String> state = Arrays.asList("2", "3", "4", "5", "6", "7", "G",
				"D", "Z", "B");
		Integer overNum = 0;
		for (String unit : list) {
			if (state.contains(unit)) {
				overNum++;
			}
		}
		return overNum;
	}

	// @ActionMethod(name = "列表中存在M3+逾期次数")
	// @ActionMethodParameter(names = { "List对象" })
	public static Integer listM3Num(List<String> list) {
		List<String> state = Arrays.asList("3", "4", "5", "6", "7", "G", "D",
				"Z", "B");
		Integer overNum = 0;
		for (String unit : list) {
			if (state.contains(unit)) {
				overNum++;
			}
		}
		return overNum;
	}

	// @ActionMethod(name = "输入逾期记录map生成最近N期的列表")
	// @ActionMethodParameter(names = { "逾期记录map","最近期数" })
	public static List<String> recentNListFromState(Map<String, Object> map,
			int n) {
		List<String> reslist = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			try {
				reslist.add((String) map.get("delq".concat(String
						.valueOf(24 - i))));
			} catch (Exception e) {
				System.out.println("逾期记录map出现取值错误：" + e);
				logger.error(e.toString());
			}
		}
		return reslist;
	}

	// @ActionMethod(name = "输入逾期记录recordList生成最近N期的列表")
	// @ActionMethodParameter(names = { "近5年逾期记录List","最近期数"，人行报告时间字符串 })
	public static List<String> recentNList(List<Map> list, int n,
			String repotime) {
		List<String> reslist = new ArrayList<String>();
		for (Map mapunit : list) {
			if (DateUtils.getFormatDate(
					MapUtils.getStringFromMap(mapunit,
							ContratInfoEnum.COVERDUERECORDLIST_MONTH.field),
					DateUtils.DATE_FORMAT_5).compareTo(
					DateUtils.getDateReduceMonNum(repotime,
							DateUtils.DATE_FORMAT_3, n)) < 0) {
				reslist.add(MapUtils
						.getStringFromMap(
								mapunit,
								ContratInfoEnum.COVERDUERECORDLIST_REPAYMENTSTATUS.field));
			}
		}
		return reslist;
	}

	// @ActionMethod(name = "有效他行卡-双卡额度")
	// @ActionMethodParameter(names = { "授信额度","月份数")
	public static Integer getDoubleAmount(List<Integer> amounts,
			List<Integer> months) {
		if (amounts == null | months == null) {
			return 0;
		}

		int sum = 0;
		for (Integer month : months) {
			sum = 0;
			if (month < 12) {
				Integer min = Collections.min(amounts);
				return min;
			}

			for (int i = 0; i < amounts.size(); i++) {
				sum += amounts.get(i);
			}
		}
		return sum / amounts.size();
	}

	// @ActionMethod(name = "有效他行卡-多卡额度（众数")
	// @ActionMethodParameter(names = { "授信额度")
	@SuppressWarnings("unused")
	public static Integer getManyCardAmount(List<Integer> list, Integer n) {
		if (list == null) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		String regex;
		Pattern p;
		Matcher m;
		Integer tmp = 0;
		String tot_str = list.toString();
		Integer max_cnt = 0;
		Integer max_str = 0;
		for (Integer str : list) {
			if (tmp == str)
				continue;
			tmp = str;
			regex = String.valueOf(str);
			// 将给定的正则表达式编译并赋值给pattern类
			p = Pattern.compile(regex);
			// 将内容进行匹配
			m = p.matcher(tot_str);
			Integer cnt = 0;
			// 对字符串进行匹配
			while (m.find()) {
				cnt++;

			}

			System.out.println(cnt);
			if (cnt >= max_cnt) {
				max_cnt = cnt;
			}
			// 以值为key 次数为value
			map.put(str, cnt);

		}
		// 最高次数相同的值的和
		Integer sum = 0;
		// 几个次数相同的值
		Integer maxCount = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (max_cnt == entry.getValue()) {
				sum += entry.getKey();
				maxCount++;
			}

		}
		// 计算最高次数相同的值的平均值
		Integer avg = 0;
		if (max_cnt >= 3 | max_cnt >= n / 2) {
			avg = sum / maxCount;
		}

		return avg;

	}

	// @ActionMethod(name = "有效他行卡-多卡额度（中位数")
	// @ActionMethodParameter(names = { "授信额度"，"有效他行卡数量")
	public static Integer getManyCardAmountMedian(List<Integer> list, Integer n) {
		if (list == null) {
			return 0;
		}
		Collections.sort(list);
		Integer value = 0;
		if (n % 2 == 1) {
			value = list.get(((n + 1) / 2) - 1);
		} else {
			value = list.get((n / 2) - 1);
		}

		return value;
	}

}
