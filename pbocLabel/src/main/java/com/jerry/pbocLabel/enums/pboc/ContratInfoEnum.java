package com.jerry.pbocLabel.enums.pboc;

/**
 * 贷款合同信息
 * @author chenliang
 *
 */
public enum ContratInfoEnum {

	FINANCEORG("financeOrg","贷款机构","String"),
	ACCOUNT("account","业务号","String"),
	CONTRATTYPE("contratType","贷款类型","String"),
	ACCOUNTSTATE("accountState","账户状态","String"),
	TYPE("type","贷款种类细分","String"),
	CURRENCY("currency","币种","String"),
	OPENDATE("openDate","发放日期","String"),
	ENDDATE("endDate","到期日期","String"),
	CREDITLIMITAMOUNT("creditLimitAmount","合同金额","BigDecimal"),
	GUARANTEETYPE("guaranteeType","担保方式","String"),
	PAYMENTRATING("paymentRating","还款频率","String"),
	PAYMENTCYC("paymentCyc","还款期数","String"),
	CURRACCOUNTINFO("currAccountInfo","当前账户信息","Map"),
	CURROVERDUE("currOverdue","当前逾期信息","Map"),
	STATE("state","还款记录明细","Map"),
	ORGTYPE("orgType","机构类型","String"),
	COVERDUERECORDLIST("coverdueRecordlist","逾期记录","List"),
	BACKSTART("backStart","开始时间","String"),
	BACKEND("backEnd","结束时间","String"),
	SPECIALTRADELIST("specialTradelist","特殊交易","List"),
	DISSENTINFOLIST("dissentInfolist","异议标注","List"),
	LATESTPERFORMANCE("latestPerformance","最新表现信息段","Map"),
	PROTOCOLNUM("protocolNum","授信协议编号","String"),
	ACCOUNTID("accountId","账户标识（授信协议基本信息段）","String"),
	REPAYMENTMETHOD("repaymentMethod","还款方式","String"),
	GRANTSHAPE("grantShape","贷款发放形式","String"),
	COMMONLOANMARK("commonLoanMark","共同借款标志","String"),
		
	//currAccountInfo-当前账户信息
	CURRACCOUNTINFO_STATEENDDATE("stateEndDate","状态截止日","String"),
	CURRACCOUNTINFO_STATEENDMONTH("stateEndMonth","状态截止月/转出月","String"),
	CURRACCOUNTINFO_CLASS5STATE("class5State","五级分类","String"),
	CURRACCOUNTINFO_BALANCE("balance","本金余额","BigDecimal"),
	CURRACCOUNTINFO_REMAINPAYMENTCYC("remainPaymentCyc","剩余还款期数","Integer"),
	CURRACCOUNTINFO_SCHEDULEDPAYMENTAMOUNT("scheduledPaymentAmount","本月应还款","BigDecimal"),
	CURRACCOUNTINFO_SCHEDULEDPAYMENTDATE("scheduledPaymentDate","应还款日","String"),
	CURRACCOUNTINFO_ACTUALPAYMENTAMOUNT("actualPaymentAmount","本月实还款","BigDecimal"),
	CURRACCOUNTINFO_RECENTPAYDATE("recentPayDate","最近一次还款日期","String"),
	
	//CurrOverdue-当前逾期信息
	CURROVERDUE_CURROVERDUECYC("currOverdueCyc","当前逾期期数","Integer"),
	CURROVERDUE_CURROVERDUEAMOUNT("currOverdueAmount","当前逾期金额","BigDecimal"),
	CURROVERDUE_OVERDUE31TO60AMOUNT("overdue31To60Amount","逾期31-60天未归还贷款本金","BigDecimal"),
	CURROVERDUE_OVERDUE61TO90AMOUNT("overdue61To90Amount","逾期61-90天未归还贷款本金","BigDecimal"),
	CURROVERDUE_OVERDUE91TO180AMOUNT("overdue91To180Amount","逾期91-180天未归还贷款本金","BigDecimal"),
	CURROVERDUE_OVERDUEOVER180AMOUNT("overdueOver180Amount","逾期180天以上未归还贷款本金","BigDecimal"),
	CURROVERDUE_ACCOUNT("Account","与主对象id关联","String"),
	
	//state-还款记录明细
	STATE_DELQ1("delq1","还款状态","CHAR"),
	STATE_DELQ2("delq2","还款状态","CHAR"),
	STATE_DELQ3("delq3","还款状态","CHAR"),
	STATE_DELQ4("delq4","还款状态","CHAR"),
	STATE_DELQ5("delq5","还款状态","CHAR"),
	STATE_DELQ6("delq6","还款状态","CHAR"),
	STATE_DELQ7("delq7","还款状态","CHAR"),
	STATE_DELQ8("delq8","还款状态","CHAR"),
	STATE_DELQ9("delq9","还款状态","CHAR"),
	STATE_DELQ10("delq10","还款状态","CHAR"),
	STATE_DELQ11("delq11","还款状态","CHAR"),
	STATE_DELQ12("delq12","还款状态","CHAR"),
	STATE_DELQ13("delq13","还款状态","CHAR"),
	STATE_DELQ14("delq14","还款状态","CHAR"),
	STATE_DELQ15("delq15","还款状态","CHAR"),
	STATE_DELQ16("delq16","还款状态","CHAR"),
	STATE_DELQ17("delq17","还款状态","CHAR"),
	STATE_DELQ18("delq18","还款状态","CHAR"),
	STATE_DELQ19("delq19","还款状态","CHAR"),
	STATE_DELQ20("delq20","还款状态","CHAR"),
	STATE_DELQ21("delq21","还款状态","CHAR"),
	STATE_DELQ22("delq22","还款状态","CHAR"),
	STATE_DELQ23("delq23","还款状态","CHAR"),
	STATE_DELQ24("delq24","还款状态","CHAR"),
	STATE_BACKSTART("backStart","开始时间","String"),		
	STATE_BACKEND("backEnd","结束时间","String"),
		
	//coverduerecordlist-逾期记录
	COVERDUERECORDLIST_ACCOUNTCOUNT("accountCount","笔数/账号数","Integer"),
	COVERDUERECORDLIST_MONTH("month","月份","String"),
	COVERDUERECORDLIST_LASTMONTHS("lastMonths","持续月份","Integer"),
	COVERDUERECORDLIST_AMOUNT("amount","金额","BigDecimal"),
	COVERDUERECORDLIST_ACCOUNT("account","业务编号","String"),
	COVERDUERECORDLIST_REPAYMENTSTATUS("repaymentStatus","还款状态","String"),
	
	//specialtradelist-特殊交易
	SPECIALTRADELIST_TYPE("type","类型","String"),
	SPECIALTRADELIST_GETTIME("getTime","发生日期","String"),
	SPECIALTRADELIST_CHANGINGMONTHS("changingMonths","变更月数","Integer"),
	SPECIALTRADELIST_CHANGINGAMOUNT("changingAmount","发生金额","BigDecimal"),
	SPECIALTRADELIST_ACCOUNT("account","业务号","String"),
	SPECIALTRADELIST_CONTENT("content","明细记录","String"),
	
	//latestperformance-最新表现信息段
	LATESTPERFORMANCE_ACCOUNTSTATE("accountState","账户状态","String"),
	LATESTPERFORMANCE_CLOSINGDATE("closingDate","关闭日期","String"),
	LATESTPERFORMANCE_MOUTHOUT("mouthOut","转出月份","String"),
	LATESTPERFORMANCE_BALANCE("balance","余额","BigDecimal"),
	LATESTPERFORMANCE_LASTTIMEREPAYMENTDATE("lastTimeRepaymentDate","最近一次还款日期","String"),
	LATESTPERFORMANCE_LASTTIMEREPAYMENTAMOUNT("lastTimeRepaymentAmount","最近一次还款金额","BigDecimal"),
	LATESTPERFORMANCE_CLASS5STATE("class5State","五级分类","String"),
	LATESTPERFORMANCE_REPAYMENTTYPE("repaymentType","还款状态","String"),
	LATESTPERFORMANCE_MESSAGEREPORTDATE("messageReportDate","信息报告日期","String"),
	
	//dissentInfolist-异议标注
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");

	public String field;
	public String fieldDesc;
	public String fieldType;
	
	ContratInfoEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
}
