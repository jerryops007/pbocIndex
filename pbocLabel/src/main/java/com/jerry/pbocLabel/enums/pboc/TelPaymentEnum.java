package com.jerry.pbocLabel.enums.pboc;

/**
 * 后付费业务
 * @author chenliang
 *
 */
public enum TelPaymentEnum {
	
	ORGANNAME("organname","机构名称","String"),
	TYPE("type","业务类型","String"),
	REGISTERDATE("registerDate","开通日期","String"),
	STATE("state","当前缴费状态","String"),
	ARREARMONEY("arrearMoney","当前欠费金额","String"),
	ARREARMONTHS("arrearMonths","当前欠费月数","String"),
	STATUS24("status24","最近24个月缴费状态","String"),
	GETTIME("getTime","记账年月","String"),
	ACCOUNTTYPE("accountType","后付费账户类型","String"),
	DISSENTINFOLIST("dissentInfolist","标注及声明信息","List"),
	
	//dissentInfolist-标注及声明信息
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	TelPaymentEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
