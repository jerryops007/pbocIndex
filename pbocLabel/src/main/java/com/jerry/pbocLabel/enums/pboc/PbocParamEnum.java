package com.jerry.pbocLabel.enums.pboc;

public enum PbocParamEnum {

	bankname("bankname", "银行中文名称", "String"),
	mo_phone("mo_phone", "手机号", "String"),
	BARCODE("barcode", "申请件编码", "String"), 
	CERTTYPE("certtype","身份证","String");

	public String field;
	public String fieldDesc;
	public String fieldType;

	PbocParamEnum(String field, String fieldDesc, String fieldType) {
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
