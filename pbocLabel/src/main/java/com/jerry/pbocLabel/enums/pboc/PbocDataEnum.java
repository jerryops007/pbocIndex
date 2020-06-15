package com.jerry.pbocLabel.enums.pboc;

public enum PbocDataEnum {
	
	MESSAGEHEADER("messageHeader","报告头描述","Map"),
	IDENTITY("identity","身份信息","Map"),
	SPOUSE("spouse","配偶信息","List"),
	RESIDENCE("residence","居住信息","List"),
	PROFESSIONAL("professional","职业信息","List"),
	CREDITSUMMARYCUE("creditSummaryCue","信用汇总提示","Map"),
	FELLBACKSUM("fellbackSum","违约信息汇总","List"),
	OVERDUESUM("overdueSum","逾期(透支)信息汇总","List"),
	SHAREANDDEBTSUM("shareAndDebtSum","授信及负债信息汇总描述","List"),
	REFUNDDUTYSUM("refundDutySum","相关还款责任信息汇总描述","List"),
	PUBLICINFORMATIONSUM("publicInformationSum","公共信息概要汇总信息","List"),
	LASTTIMEQUERY("lastTimeQuery","上一次查询信息","Map"),
	RECOVEREDMESSAGE("recoveredMessage","被追偿信息","List"),
	CONTRATINFO("contratInfo","贷款合同信息","List"),
	AWARDCREDITINFO("awardCreditInfo","授信情况","List"),
	AGREEMENTBASICINFO("agreementBasicInfo","授信协议基本信息","List"),
	REPAYMENTDUTY("repaymentDuty","相关还款责任信息","List"),
	ACCFUND("accFund","住房公积金参缴记录","List"),
	RECORDDETAIL("recordDetail","信贷审批查询记录明细","List"),
	NUMANALYSIS("numAnalysis","字段解读","Map"),
	QUERYREQ("queryReq","查询信息","Map"),
	RESTCRETNO("restCretNo","其它证件信息","List"),
	ANTIFRAUDWARNING("antiFraudWarning","防欺诈警示","Map"),
	OBJECTIONPROMPT("objectionPrompt","异议提示信息","Map"),
	CALCULATESEGMENT("calculateSegment","计算项信息","Map"),
	DETAILQUERYREASON("detailQueryReason","查询记录汇总","List"),
	ADMINPUNISHMENT("adminPunishment","行政处罚记录","List"),
	CIVILJUDGEMENT("civilJudgement","民事判决记录","List"),
	FORCEEXECUTION("forceExecution","强制执行记录","List"),
	TAXARREAR("taxArrear","欠税记录","List"),
	SALVATION("salvation","低保救助记录","List"),
	COMPETENCE("competence","执业资格记录","List"),
	ADMINAWARD("adminAward","行政奖励记录","List"),
	OTHERDISSENTINFO("otherDissentInfo","其它标注及声明信息","List"),
	TELPAYMENT("telPayment","后付费业务","List");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	PbocDataEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}


}
