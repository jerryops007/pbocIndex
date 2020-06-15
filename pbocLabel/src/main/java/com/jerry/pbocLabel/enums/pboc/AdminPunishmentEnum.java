package com.jerry.pbocLabel.enums.pboc;

/**
 * 行政处罚记录
 * @author chenliang
 *
 */
public enum AdminPunishmentEnum {

	ORGANNAME("organname","处罚机构","String"),
	CONTENT("content","处罚内容","String"),
	MONEY("money","处罚金额","BigDecimal"),
	BEGINDATE("beginDate","生效日期","String"),
	ENDDATE("endDate","截止日期","String"),
	RESULT("result","行政复议结果","String"),
	DISSENTINFOLIST("dissentInfolist","标注及声明信息","List"),
	
	//dissentInfolist
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");
		
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	AdminPunishmentEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
