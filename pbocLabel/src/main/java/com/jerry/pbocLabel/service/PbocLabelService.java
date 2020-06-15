package com.jerry.pbocLabel.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface PbocLabelService {

	/*
	 * 
	 * @param pboc 2.0人行报文
	 * 
	 * @param params 人行解析额外参数输入项
	 * 
	 * @return 人行解析指标的包装对象
	 */
	public JSONObject PBOC_INDEX(String pboc, Map<String, Object> params);

}
