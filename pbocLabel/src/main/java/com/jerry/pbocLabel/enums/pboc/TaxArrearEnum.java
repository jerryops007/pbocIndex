package com.jerry.pbocLabel.enums.pboc;

/**
 * 欠税记录
 * @author chenliang
 *
 */
public enum TaxArrearEnum {

	ORGANNAME("organname","主管税务机关","String"),		
	TAXARREAAMOUNT("taxArreaAmount","欠税总额","BigDecimal"),		
	REVENUEDATE("revenuedate","欠税统计日期","String"),		
	DISSENTINFOLIST("dissentInfolist","标注及声明信息","List"),
	
	//dissentInfolist-标注及声明信息
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	TaxArrearEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
