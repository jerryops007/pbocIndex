package com.jerry.pbocLabel.enums.pboc;

/**
 * 报告头描述
 * @author chenliang
 *
 */
public enum MessageHeaderEnum {
	
	QUERYTIME("queryTime","查询请求时间","String"),
	REPORTCREATETIME("reportCreateTime","报告时间","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	MessageHeaderEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
	
}
