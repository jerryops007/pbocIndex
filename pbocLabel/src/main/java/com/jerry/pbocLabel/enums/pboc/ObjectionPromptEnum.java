package com.jerry.pbocLabel.enums.pboc;

/**
 * 异议提示信息
 * @author chenliang
 *
 */
public enum ObjectionPromptEnum {
	
	OBJECTIONSIGNNUM("objectionSignNum","异议标注数目","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	ObjectionPromptEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
		 	
}
