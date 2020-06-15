package com.jerry.pbocLabel.enums.pboc;

/**
 * 配偶信息
 * @author chenliang
 *
 */
public enum SpouseEnum {
	
	NAME("name","姓名","String"),		
	CERTTYPE("certtype","信用主体配偶的证件类型","String"),
	CERTNO("certtype","证件号码","String"),			
	EMPLOYER("employer","工作单位","String"),			
	TELEPHONENO("telephoneno","联系电话","String");		

	public String field;
	public String fieldDesc;
	public String fieldType;
	
	SpouseEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
	
}
