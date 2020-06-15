package com.jerry.pbocLabel.enums.pboc;

/**
 * 信用汇总提示
 * @author chenliang
 *
 */
public enum CreditSummaryCueEnum {
	
	HOUSELOANCOUNT("houseLoanCount","个人住房贷款笔数","Integer"),		
	COMHOUSELOANCOUNT("comHouseLoanCount","个人商用房贷款笔数","Integer"),		
	OTHERLOANCOUNT("otherLoanCount","其他贷款笔数","Integer"),		
	FIRSTLOANOPENMONTH("firstLoanOpenMonth","首笔个人住房贷款发放月份","String"),		
	LOANCARDCOUNT("loancardCount","贷记卡账户数","Integer"),		
	FIRSTLOANCARDOPENMONTH("firstLoancardOpenMonth","首张贷记卡发卡月份","String"),		
	STANDARDLOANCARDCOUNT("standardLoancardCount","准贷记卡账户数","Integer"),		
	FIRSTSTANDARDLOANCARDOPENMONTH("firstStandardLoancardOpenMonth","首张准贷记卡发卡月份","String"),		
	ANNOUNCECOUNT("announceCount","本人声明数目","Integer"),		
	DISSENTCOUNT("dissentCount","异议标注数目","Integer"),		
	FIRSTCOMHOUSELOANOPENMONTH("firstcomHouseLoanOpenMonth","首笔个人商用房贷款（包括商住两用房）发放月份","String"),		
	FIRSTOTHERLOANCOUNTOPENMONTH("firstotherLoanCountOpenMonth","首笔其它贷款发放月份","String"),		
	OTHERTYPECOUNT("otherTypeCount","业务类型为其他的账户数","String"),		
	OTHERTYPEOPENMONTH("otherTypeOpenMonth","业务类型为其他的发放月份","String"),		
	TOTAL("total","账户数合计","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	CreditSummaryCueEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
}
