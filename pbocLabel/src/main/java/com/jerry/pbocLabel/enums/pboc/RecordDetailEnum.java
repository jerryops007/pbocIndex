package com.jerry.pbocLabel.enums.pboc;

/**
 * 信贷审批查询记录明细
 * @author chenliang
 *
 */
public enum RecordDetailEnum {
	
	QUERYDATE("queryDate","查询日期","String"),		
	ORGTYPE("orgType","查询机构类型","String"),		
	QUERIER("querier","查询机构","String"),		
	QUERYREASON("queryReason","查询原因","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	RecordDetailEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
