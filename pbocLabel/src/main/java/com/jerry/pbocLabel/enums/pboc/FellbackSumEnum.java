package com.jerry.pbocLabel.enums.pboc;

/**
 * 违约信息汇总
 * @author chenliang
 *
 */
public enum FellbackSumEnum {
    
	COUNT("count","笔数","Integer"),		
	BALANCE("balance","余额","BigDecimal"),			
	SIGN("sign","标志","String");		

	public String field;
	public String fieldDesc;
	public String fieldType;
	
	FellbackSumEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
	
}
