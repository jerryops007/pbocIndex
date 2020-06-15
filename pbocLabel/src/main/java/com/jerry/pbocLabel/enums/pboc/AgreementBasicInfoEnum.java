package com.jerry.pbocLabel.enums.pboc;

/**
 * 授信协议基本信息
 * @author chenliang
 *
 */
public enum AgreementBasicInfoEnum {
 
	PROTOCOLNUMBER("protocolNumber","授信协议编号","String"),
	OPERATIONINSTTYPE("operationInstType","业务管理机构类型","String"),
	OPERATIONINST("operationInst","业务管理机构","String"),
	CREDITFLAG("creditFlag","授信协议标识","String"),
	CREDITLINEPURPOSE("creditLinePurpose","授信额度用途","String"),
	CREDITLINE("creditLine","授信额度","BigDecimal"),
	CURRENCY("currency","币种","String"),
	EFFECTIVEDATE("effectiveDate","生效日期","String"),
	DUEDATE("dueDate","到期日期","String"),
	CREDITSTATE("creditState","授信协议状态","String"),
	USEDPOSITION("usedPosition","已用额度","BigDecimal"),
	CREDITLIMIT("creditLimit","授信限额","BigDecimal"),
	CREDITLIMITNUMBER("creditLimitNumber","授信限额编号","String"),
	DISSENTINFOLIST("dissentInfolist","标注及声明信息","list"),
	
	//dissentInfolist-标注及声明信息
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	AgreementBasicInfoEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
