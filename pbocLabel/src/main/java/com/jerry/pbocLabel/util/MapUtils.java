package com.jerry.pbocLabel.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

//@ActionBean(name = "Map对象操作")
//@Service("judgeMapAction")
//@Scope("prototype")
@SuppressWarnings("rawtypes")
public class MapUtils {

	private final static Logger logger = LoggerFactory.getLogger(MapUtils.class);

//	@SuppressWarnings("rawtypes")
//	@ActionMethod(name = "从Map对象取值_String")
//	@ActionMethodParameter(names = { "Map对象", "key" })
	
	public static String getStringFromMap(Map map, String key) {
	//	logger.debug("从Map对象取值_String,Map对象为{},key为{}", map, key);
		if (map == null) {
			return new String();
		} else {
			try {
				//logger.debug("从Map对象取值_String,key值信息为{}", JSON.toJSONString(map.keySet()));
				Iterator iterator = map.keySet().iterator();
				while (iterator.hasNext()) {
					if (key.equals(iterator.next().toString()) && map.get(key) != null) {
				//		logger.debug("从Map对象取值_String,key为{},包含当前Key", key);
						return map.get(key).toString();
					}
				}
			} catch (Exception e) {
				logger.error("从Map对象取值_String,发生异常,信息为{}", e.getMessage());
			}
			//logger.info("从Map对象取值_String,key为{},没有包含当前Key", key);
			return new String();
		}
	}

//	@SuppressWarnings("rawtypes")
//	@ActionMethod(name = "从Map对象取值_Map")
//	@ActionMethodParameter(names = { "Map对象", "key" })
	public static Map getMapFromMap(Map map, String key) {
	//	logger.debug("从Map对象取值_Map,Map对象为{},key为{}", map, key);
		if (map == null) {
			return new HashMap();
		} else {
			try {
			//	logger.debug("从Map对象取值_Map,key值信息为{}", JSON.toJSONString(map.keySet()));
				Iterator iterator = map.keySet().iterator();
				while (iterator.hasNext()) {
					if (key.equals(iterator.next().toString()) && map.get(key) != null && !map.get(key).toString().equals(new String())) {
				//		logger.debug("从Map对象取值_Map,key为{},包含当前Key", key);
						return JSONObject.parseObject(map.get(key).toString());
					}
				}
			} catch (Exception e) {
				logger.error("从Map对象取值_Map,发生异常,信息为{}", e.getMessage());
			}
			//logger.info("从Map对象取值_Map,key为{},没有包含当前Key", key);
			return new HashMap();
		}
	}

//	@SuppressWarnings("rawtypes")
//	@ActionMethod(name = "从Map对象取值_List")
//	@ActionMethodParameter(names = { "Map对象", "key" })
	public static List getListFromMap(Map map, String key) {
		//logger.debug("从Map对象取值_List,Map对象为{},key为{}", map, key);
		if (map == null) {
			return new ArrayList();
		} else {
			try {
				//logger.debug("从Map对象取值_List,key值信息为{}", JSON.toJSONString(map.keySet()));
				Iterator iterator = map.keySet().iterator();
				while (iterator.hasNext()) {
					if (key.equals(iterator.next().toString()) && map.get(key) != null) {
						//logger.debug("从Map对象取值_List,key为{},包含当前Key", key);
						return JSONArray.parseArray(map.get(key).toString());
					}
				}
			} catch (Exception e) {
				logger.error("从Map对象取值_List,发生异常,信息为{}", e.getMessage());
			}
		//	logger.info("从Map对象取值_List,key为{},没有包含当前Key", key);
			return new ArrayList();
		}
	}
	
//	@SuppressWarnings("rawtypes")
//	@ActionMethod(name = "从Map对象取值_Integer")
//	@ActionMethodParameter(names = { "Map对象", "key" })
	public static Integer getIntegerFromMap(Map map, String key) {
		//logger.debug("从Map对象取值_Integer,Map对象为{},key为{}", map, key);
		if (map == null) {
			return new Integer(0);
		} else {
			try {
			//	logger.debug("从Map对象取值_Integer,key值信息为{}", JSON.toJSONString(map.keySet()));
				Iterator iterator = map.keySet().iterator();
				while (iterator.hasNext()) {
					if (key.equals(iterator.next().toString()) && map.get(key) != null) {
					//	logger.debug("从Map对象取值_Integer,key为{},包含当前Key", key);
						return Integer.decode(map.get(key).toString());
					} else if(map.get(key).toString().length() == 0){
						return new Integer(0);
					}
				}
			} catch (Exception e) {
				logger.info("从Map对象取值_Integer,发生异常,信息为{}", e.getMessage());
			}
		//	logger.info("从Map对象取值_Integer,key为{},没有包含当前Key", key);
			return new Integer(0);
		}
	}
//	@SuppressWarnings("rawtypes")
//	@ActionMethod(name = "从Map对象取值_Decimal")
//	@ActionMethodParameter(names = { "Map对象", "key" })
	public static BigDecimal getDecimalFromMap(Map map, String key) {
//		logger.debug("从Map对象取值_Decimal,Map对象为{},key为{}", map, key);
		if (map == null) {
			return new BigDecimal(0);
		} else {
			try {
//				logger.debug("从Map对象取值_Decimal,key值信息为{}", JSON.toJSONString(map.keySet()));
				Iterator iterator = map.keySet().iterator();
				while (iterator.hasNext()) {
					if (key.equals(iterator.next().toString()) && map.get(key) != null) {
//						logger.debug("从Map对象取值_Decimal,key为{},包含当前Key", key);
						return new BigDecimal(map.get(key).toString());
					} else if(map.get(key).toString().length() == 0){
						return new BigDecimal(0);
					}
				}
			} catch (Exception e) {
//				logger.info("从Map对象取值_Decimal,发生异常,信息为{}", e.getMessage());
			}
//			logger.info("从Map对象取值_Decimal,key为{},没有包含当前Key", key);
			return new BigDecimal(0);
		}
	}

}
