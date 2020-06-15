package com.jerry.pbocLabel.enums.pboc;

/**
 * 民事判决记录
 * @author chenliang
 *
 */
public enum CivilJudgementEnum {
	
	COURT("court","立案法院","String"),
	CASEREASON("caseReason","案由","String"),
	REGISTERDATE("registerDate","立案日期","String"),
	CLOSEDTYPE("closedType","结案方式","String"),
	CASERESULT("caseResult","判决/调解结果","String"),
	CASEVALIDATEDATE("caseValidatedate","判决/调解生效日期","String"),
	SUITOBJECT("suitObject","诉讼标的","String"),
	SUITOBJECTMONEY("suitObjectMoney","诉讼标的金额","BigDecimal"),
	DISSENTINFOLIST("dissentInfolist","标注及声明信息","List"),
	
	//dissentInfolist-标注及声明信息
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");

	public String field;
	public String fieldDesc;
	public String fieldType;
	
	CivilJudgementEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
