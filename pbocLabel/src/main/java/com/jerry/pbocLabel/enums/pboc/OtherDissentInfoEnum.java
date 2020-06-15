package com.jerry.pbocLabel.enums.pboc;

/**
 * 其它标注及声明信息
 * @author chenliang
 *
 */
public enum OtherDissentInfoEnum {
	
	content("content","标注内容","String"),			
	getTime("getTime","添加日期","String"),			
	type("type","标注及声明类型","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	OtherDissentInfoEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
	
}
