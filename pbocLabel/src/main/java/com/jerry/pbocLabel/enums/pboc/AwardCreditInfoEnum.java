package com.jerry.pbocLabel.enums.pboc;

public enum AwardCreditInfoEnum {
	
	FINANCEORG("financeOrg","发卡机构","String"),
	ACCOUNT("account","业务号","String"),
	ACCOUNTSTATE("accountState","账户状态","String"),
	CURRENCY("currency","币种","String"),
	OPENDATE("openDate","发卡日期","String"),
	CREDITLIMITAMOUNT("creditLimitAmount","授信额度","BigDecimal"),
	GUARANTEETYPE("guaranteeType","担保方式","String"),
	ORGTYPE("orgType","机构类型","String"),
	REPAYINFO("repayInfo","使用/还款情况","Map"),
	STATE("state","还款记录","Map"),
	OVERDUERECORDLIST("overdueRecordlist","逾期/透支记录","List"),
	BACKSTART("backStart","开始时间","String"),
	BACKEND("backEnd","结束时间","String"),
	BALANCE("balance","呆账余额","String"),
	DISSENTINFOLIST("dissentInfolist","异议标注","List"),
	SPECIALTRADELIST("specialTradelist","特殊交易信息","List"),
	TYPE("type","卡种类型","String"),
	SPECIALEVENTS("specialEvents","特殊事件信息","List"),
	PROTOCOLNUM("protocolNum","授信协议编号（授信协议基本信息段）","String"),
	ACCOUNTID("accountId","账户标识（授信协议基本信息段）","String"),
	LATESTPERFORMANCE("latestPerformance","最新表现信息","Map"),
	LARGESPECIALSTAGE("largeSpecialStage","大额专项分期信息","Map"),
	
	//RepayInfo-使用/还款情况
	REPAYINFO_STATEENDDATE("stateEndDate","状态截止日","String"),
	REPAYINFO_STATEENDMONTH("stateEndMonth","状态截止月","String"),
	REPAYINFO_SHARECREDITLIMITAMOUNT("shareCreditLimitAmount","共享额度","BigDecimal"),
	REPAYINFO_USEDCREDITLIMITAMOUNT("usedCreditLimitAmount","已用额度/透支余额","BigDecimal"),
	REPAYINFO_LATEST6MONTHUSEDAVGAMOUNT("latest6MonthUsedAvgAmount","最近6个月平均使用额度/最近6个月平均透支余额","BigDecimal"),
	REPAYINFO_USEDHIGHESTAMOUNT("usedHighestAmount","最大使用额度/最大透支余额","BigDecimal"),
	REPAYINFO_SCHEDULEPAYMENTDATE("schedulePaymentDate","账单日","String"),
	REPAYINFO_SCHEDULEDPAYMENTAMOUNT("scheduledPaymentAmount","本月应还款","BigDecimal"),
	REPAYINFO_ACTUALPAYMENTAMOUNT("actualPaymentAmount","本月实还款","BigDecimal"),
	REPAYINFO_RECENTPAYDATE("recentPayDate","最近一次还款日期","String"),
	REPAYINFO_CURROVERDUECYC("currOverdueCyc","当期逾期期数","Integer"),
	REPAYINFO_CURROVERDUEAMOUNT("currOverdueAmount","当期逾期金额","BigDecimal"),
	REPAYINFO_OVERDUEOVER180AMOUNT("overdueOver180Amount","逾期180天以上未归还贷款本金","BigDecimal"),
	REPAYINFO_SPECIALBALANCESTAGES("specialBalanceStages","未出单的大额专项分期余额","BigDecimal"),
	REPAYINFO_REMAINREPAYMENTNUM("remainRepaymentNum","剩余还款期数","Integer"),
		
	//SpecialEvents-特殊事件信息
	SPECIALEVENTS_DATEMONTH("dateMonth","特殊事件发生月份","String"),	
	SPECIALEVENTS_TYPE("type","特殊事件类型","String"),
			
	//state-还款记录
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
	
	//overduerecordlist-逾期/透支记录
	OVERDUERECORDLIST_ACCOUNTCOUNT("accountCount","笔数/账号数","Integer"),
	OVERDUERECORDLIST_MONTH("month","月份","String"),
	OVERDUERECORDLIST_LASTMONTHS("lastMonths","持续月份","Integer"),
	OVERDUERECORDLIST_AMOUNT("amount","金额","BigDecimal"),
	OVERDUERECORDLIST_ACCOUNT("account","业务编号","String"),
	OVERDUERECORDLIST_REPAYMENTSTATUS("repaymentStatus","还款状态","String"),
	
	//specialtradelist-特殊交易信息
	SPECIALTRADELIST_TYPE("type","类型","String"),
	SPECIALTRADELIST_GETTIME("getTime","发生日期","String"),
	SPECIALTRADELIST_CHANGINGMONTHS("changingMonths","变更月数","Integer"),
	SPECIALTRADELIST_CHANGINGAMOUNT("changingAmount","发生金额","BigDecimal"),
	SPECIALTRADELIST_ACCOUNT("account","业务号","String"),
	SPECIALTRADELIST_CONTENT("content","明细记录","String"),
	
	//largeSpecialStage-大额专项分期信息
	LARGESPECIALSTAGE_AMOUNT("amount","大额专项分期额度","BigDecimal"),		
	LARGESPECIALSTAGE_EFFECTIVEDATE("effectiveDate","分期额度生效日期","String"),		
	LARGESPECIALSTAGE_DUEDATE("dueDate","分期额度到期日期","String"),		
	LARGESPECIALSTAGE_USEDLIMITAMOUNT("usedLimitAmount","已用分期金额","BigDecimal"),
		
	//LatestPerformance-最新表现信息段
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
	
	AwardCreditInfoEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}


}
