package com.jerry.pbocLabel.enums.pboc;

/**
 * 相关还款责任信息汇总描述
 * @author chenliang
 *
 */
public enum RefundDutySumEnum {
	
	SUMTYPE("sumType","类别","String"),//char				
	ACCOUNTNUMBER("accountNumber","账户数","String"),				
	GUARANTEEAMOUNT("guaranteeAmount","担保金额/还款责任金额","BigDecimal"),				
	BALANCE("balance","余额","BigDecimal");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	RefundDutySumEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
