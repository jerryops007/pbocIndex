package com.jerry.pbocLabel.enums.param;

/**
 * 请求输入 额外字段信息枚举
 * 
 * @author chenliang
 *
 */
public enum ReqParamEnum {

	BANKNAME("bankname", "银行名称", "String"), MO_PHONE("mo_phone", "手机号",
			"String"), BARCODE("barcode", "申请件编码", "String"), CERTTYPE(
			"certtype", "身份证", "String");

	public String field;
	public String fieldDesc;
	public String fieldType;

	ReqParamEnum(String field, String fieldDesc, String fieldType) {
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
