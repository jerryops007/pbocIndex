package com.jerry.pbocLabel.enums.pboc;

/**
 * 相关还款责任信息
 * @author chenliang
 *
 */
public enum RepaymentDutyEnum {
	
	IDENTITYSORT("identitySort","主借款人身份类别","String"),
	INSTSORT("instSort","业务管理机构类型","String"),
	BUSINESSCONTROLINST("businessControlInst","业务管理机构","String"),
	BUSINESSTYPE("businessType","业务种类","String"),
	OPENDATE("openDate","开立日期","String"),
	DATEDUE("dateDue","到期日期","String"),
	REFUNDRESPONSIBLE("refundResponsible","相关还款责任人类型","String"),
	CONTRACTNUMBER("contractNumber","保证合同编号","String"),
	REFUNDDUTYMONEY("refundDutyMoney","相关还款责任金额","BigDecimal"),
	CURRENCY("currency","币种","String"),
	BALANCE("balance","余额","BigDecimal"),
	FIVELEVELSERIES("fiveLevelSeries","五级分类","String"),
	ACCOUNTTYPE("accountType","账户类型","String"),
	PAYMENTSTATUS("paymentStatus","还款状态","String"),
	MONTHSOVERDUE("monthsOverdue","逾期月数","int"),
	INFORMATIONREPORTSDATE("informationReportsDate","信息报告日期","String"),
	DISSENTINFOLIST("dissentInfolist","标注及声明信息>","list"),
		
	//dissentInfolist-标注及声明信息
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");
		
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	RepaymentDutyEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

	

}
