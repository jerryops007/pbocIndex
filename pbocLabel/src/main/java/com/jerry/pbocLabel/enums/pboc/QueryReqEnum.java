package com.jerry.pbocLabel.enums.pboc;

/**
 * 查询信息
 * @author chenliang
 *
 */
public enum QueryReqEnum {
 
	NAME("name","姓名","String"),
	CERTTYPE("certtype","证件类型","String"),
	CERTNO("certNo","证件号码","String"),
	QUERYREASON("queryReason","查询原因","String"),
	QUERYFORMAT("queryFormat","请求参数","Stirng"),
	QUERYORG("queryOrg","查询机构","Stirng"),
	USERCODE("userCode","操作员","String"),
	QUERYRESULTCUE("queryResultCue","结果提示","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	QueryReqEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
 
}
