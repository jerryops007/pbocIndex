package com.jerry.pbocLabel.enums.pboc;

/**
 * 居住信息
 * @author chenliang
 *
 */
public enum ResidenceEnum {
   
	ADDRESS("address","居住地址","String"),	
	RESIDENCETYPE("residencetype","居住状况","String"),		
	GETTIME("gettime","信息更新日期","String"),		
	HOMEPHONE("homephone","住宅电话","String");		
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	ResidenceEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
	
}
