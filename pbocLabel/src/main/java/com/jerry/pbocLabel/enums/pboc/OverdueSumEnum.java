package com.jerry.pbocLabel.enums.pboc;

/**
 * 逾期(透支)信息汇总
 * @author chenliang
 *
 */
public enum OverdueSumEnum {
         
	ACCOUNTCOUNT("accountCount","笔数/账户数","Integer"),		
	ACCOUNTTYPTE("accountTypte","账户状态","String"),//char		
	MONTHS("months","月份数","Integer"),		
	HIGHESTOVERDUEAMOUNTPERMON("highestOverdueAmountPerMon","单月最高逾期总额/单月最高透支总额","BigDecimal"),		
	MAXDURATION("maxDuration","最长逾期月数/最长透支月数","Integer");	
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	OverdueSumEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
	}
