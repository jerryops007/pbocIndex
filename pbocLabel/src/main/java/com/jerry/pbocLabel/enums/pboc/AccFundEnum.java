package com.jerry.pbocLabel.enums.pboc;

/**
 * 住房公积金参缴记录
 * @author chenliang
 *
 */
public enum AccFundEnum {
	
	AREA("area","参缴地","String"),
	REGISTERDATE("registerDate","参缴日期","String"),
	FIRSTMONTH("firstMonth","初缴月份","String"),
	TOMONTH("toMonth","缴至月份","String"),
	STATE("state","缴费状态","String"),
	PAY("pay","月缴存额","Decimal"),
	OWNPERCENT("ownPercent","个人缴存比例","String"),
	COMPERCENT("comPercent","单位缴存比例","String"),
	ORGANNAME("organname","缴费单位","String"),
	GETTIME("getTime","信息更新日期","String");
	
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	AccFundEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}


}
