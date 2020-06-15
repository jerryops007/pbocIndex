package com.jerry.pbocLabel.enums.pboc;

/**
 * 查询记录汇总
 * @author chenliang
 *
 */
public enum DetailQueryReasonEnum {
	
	QUERYREASONTYPE("queryReason","查询原因","String"),				
	SUMTYPE("sum","数目","Integer"),				
	QUERYINFORMATIONTYPE("queryInformation","查询统计情况描述","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	DetailQueryReasonEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
	
}
