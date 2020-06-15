package com.jerry.pbocLabel.enums.pboc;

/**
 * 计算项信息
 * @author chenliang
 *
 */
public enum CalculateSegmentEnum {
	
	CALCULATERESULT("calculateResult","返回结果","String"),
	GETTIME("getTime","查询时间","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	CalculateSegmentEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
		

}
