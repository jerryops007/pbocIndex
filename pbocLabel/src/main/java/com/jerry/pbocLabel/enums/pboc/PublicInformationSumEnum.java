package com.jerry.pbocLabel.enums.pboc;

/**
 * 公共信息概要汇总信息
 * @author chenliang
 *
 */
public enum PublicInformationSumEnum {
		
	TYPE("type","公共信息类型","String"),				
	INFORMATIONNUMBER("informationNumber","记录数","Integer"),				
	MONEYINVOLVED("moneyInvolved","涉及金额","BigDecimal");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	PublicInformationSumEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
	

}
