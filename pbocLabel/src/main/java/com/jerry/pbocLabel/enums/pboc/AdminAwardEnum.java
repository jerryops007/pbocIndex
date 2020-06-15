package com.jerry.pbocLabel.enums.pboc;

/**
 * 行政奖励记录
 * @author chenliang
 *
 */
public enum AdminAwardEnum {
	
	ORGANNAME("organname","奖励机构","String"),		
	CONTENT("content","奖励内容","String"),		
	BEGINDATE("begindate","生效日期","String"),		
	ENDDATE("enddate","截止日期","String"),		
	DISSENTINFOLIST("dissentInfolist","标注及声明信息","List"),
	
	//dissentInfolist-标注及声明信息
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	AdminAwardEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
