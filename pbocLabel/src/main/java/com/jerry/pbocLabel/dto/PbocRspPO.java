package com.jerry.pbocLabel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * 人行报文解析结果包装对象
 * 
 * @author lpwang
 *
 */
public class PbocRspPO {

	private static Logger log = LoggerFactory.getLogger(PbocRspPO.class);

	private String status = "true";
	private long cost_time = 0;
	private String execption_message = new String();
	private JSONObject pboc_index = new JSONObject();

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getCost_time() {
		return cost_time;
	}

	public void setCost_time(long cost_time) {
		this.cost_time = cost_time;
	}

	public String getExecption_message() {
		return execption_message;
	}

	public void setExecption_message(String execption_message) {
		this.execption_message = execption_message;
	}

	public JSONObject getPboc_index() {
		return pboc_index;
	}

	public void setPboc_index(JSONObject pboc_index) {
		this.pboc_index = pboc_index;
	}

	public void addIndex(String key, Object value, String keyStr) {
		if (pboc_index == null) {
			pboc_index = new JSONObject();
		}
		log.info("指标名称：{},指标代码：{},指标取值：{}", keyStr, key, value);
		pboc_index.put(key, value);
	}

}
