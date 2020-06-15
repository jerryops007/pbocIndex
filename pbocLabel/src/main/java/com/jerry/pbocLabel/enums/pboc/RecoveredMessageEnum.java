package com.jerry.pbocLabel.enums.pboc;

/**
 * 被追偿信息
 * @author chenliang
 *
 */
public enum RecoveredMessageEnum {
	
	CLAIMSSHIFTREPAYMENTTYPE("claimsShiftRepaymentType","债权转移时的还款状态","String"),		
	TYPE("type","业务种类","String"),		
	ORGTYPE("orgType","业务管理机构类型","String"),		
	ORGCODE("orgCode","业务管理机构代码","String"),		
	ACCOUNTSTATE("accountState","账户状态","String"),		
	CLAIMSLIMITAMOUNT("claimsLimitAmount","债券金额","BigDecimal"),		
	CLAIMSACCEPTDATE("claimsAcceptDate","开立日期","String"),		
	BALANCE("balance","余额","BigDecimal"),		
	CLOSINGDATE("closingDate","关闭日期","String"),		
	LASTTIMEREPAYMENTDATE("lastTimeRepaymentDate","最近一次还款日期","String"),		
	MESSAGEREPORTDATE("messageReportDate","信息报告日期","String"),		
	SPECIALTRADELIST("specialTradelist","特殊交易信息","List"),		
	DISSENTINFOLIST("dissentInfolist","异议标注","List"),
		
	//specialtradelist-特殊交易信息
	SPECIALTRADELIST_TYPE("type","类型","String"),
	SPECIALTRADELIST_GETTIME("getTime","发生日期","String"),
	SPECIALTRADELIST_CHANGINGMONTHS("changingMonths","变更月数","Integer"),
	SPECIALTRADELIST_CHANGINGAMOUNT("changingAmount","发生金额","BigDecimal"),
	SPECIALTRADELIST_ACCOUNT("account","业务号","String"),
	SPECIALTRADELIST_CONTENT("content","明细记录","String"),
	
	//dissentInfolist-异议标注
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	RecoveredMessageEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
