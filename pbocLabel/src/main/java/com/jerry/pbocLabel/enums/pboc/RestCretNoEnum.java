package com.jerry.pbocLabel.enums.pboc;

/**
 * 其它证件信息
 * @author chenliang
 *
 */
public enum RestCretNoEnum {
  
	CERTTYPE("certType","被查询者证件类型","String"),
	CERTNO("certNo","被查询者证件号码","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	RestCretNoEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
