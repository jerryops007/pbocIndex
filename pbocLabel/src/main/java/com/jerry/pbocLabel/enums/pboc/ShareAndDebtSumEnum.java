package com.jerry.pbocLabel.enums.pboc;

/**
 * 授信及负债信息汇总描述
 * @author chenliang
 *
 */
public enum ShareAndDebtSumEnum {
    
	FINANCECORPCOUNT("financeCorpCount","贷款法人机构数/发卡法人机构数","Integer"),		
	FINANCEORGCOUNT("financeOrgCount","贷款机构数/发卡机构数","Integer"),		
	ACCOUNTCOUNT("accountCount","笔数/账户数","Integer"),		
	CREDITLIMIT("creditLimit","合同金额/授信总额","BigDecimal"),		
	MAXCREDITLIMITPERORG("maxCreditLimitPerOrg","单家行最高授信额度","BigDecimal"),		
	MINCREDITLIMITPERORG("minCreditLimitPerOrg","单家行最低授信额度","BigDecimal"),		
	BALANCE("balance","余额","BigDecimal"),		
	USEDCREDITLIMIT("usedCreditLimit","已用额度/透支余额","BigDecimal"),		
	LAST6MONTHUSEDAVGAMOUNT("last6MonthUsedAvgAmount","最近6个月平均应还款/最近6个月平均使用额度/最近6个月平均透支余额","BigDecimal"),	
	SUMTYPE("sumType","账户状态","String");//char
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	ShareAndDebtSumEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
}
