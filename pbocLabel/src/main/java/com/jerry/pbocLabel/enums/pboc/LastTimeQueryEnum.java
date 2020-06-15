package com.jerry.pbocLabel.enums.pboc;

/**
 * 上一次查询信息
 * @author chenliang
 *
 */
public enum LastTimeQueryEnum {
   
	QUERYDATE("queryDate","上次查询日期","String"),		
	QUERYINSTCODE("queryInstCode","上次查询机构代码","String"),		
	QUERYTYPE("queryType","上次机构查询类型","String"),		
	QUERYREASON("queryReason","上次查询原因","String");	
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	LastTimeQueryEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
	
}
