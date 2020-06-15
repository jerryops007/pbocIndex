package com.jerry.pbocLabel.enums.pboc;

/**
 * 强制执行记录
 * @author chenliang
 *
 */
public enum ForceExecutionEnum {
 
	COURT("court","执行法院","String"),
	CASEREASON("caseReason","执行案由","String"),
	REGISTERDATE("registerDate","立案日期","String"),
	CLOSEDTYPE("closedType","结案方式","String"),
	CASESTATE("caseState","案件状态","String"),
	CLOSEDDATE("closedDate","结案日期","String"),
	ENFORCEOBJECT("enforceObject","申请执行标的","String"),
	ENFORCEOBJECTMONEY("enforceObjectMoney","申请执行标的金额","BigDecimal"),
	ALREADYENFORCEOBJECT("alreadyEnforceObject","已执行标的","String"),
	ALREADYENFORCEOBJECTMONEY("alreadyEnforceObjectMoney","已执行标的金额","BigDecimal"),
	DISSENTINFOLIST("dissentInfolist","标注及声明信息","List"),
	
	//dissentInfolist-标注及声明信息
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	ForceExecutionEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}	
	
}
