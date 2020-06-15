package com.jerry.pbocLabel.enums.pboc;

/**
 * 身份信息
 * @author chenliang
 *
 */
public enum IdentityEnum {
	
	GENDER("gender","性别","String"),
	BIRTHDAY("birthday","出生日期","String"),
	MARITALSTATE("maritalState","婚姻状况","String"),
	MOBILE("mobile","手机号码","String"),
	OFFICETELEPHONENO("officeTelephoneNo","单位电话","String"),
	HOMETELEPHONENO("homeTelephoneNo","住宅电话","String"),
	EDULEVEL("eduLevel","学历","String"),
	EDUDEGREE("eduDegree","学位","String"),
	POSTADDRESS("postAddress","通讯地址","String"),
	REGISTEREADDRESS("registereAddress","户籍地址","String"),
	EMAILADDRESS("emailAddress","电子邮箱","String"),
	EMPLOYMENT("employment","就业情况","String"),
	NATIONALITY("nationality","国籍","String"),
	PHONENUMBERLIST("phoneNumberList","手机号码集合信息","List"),
	
	//phoneNumberList-手机号码集合信息
	PHONENUMBERLIST_PHONENUMBER("phoneNumber","手机号码","String"),
	PHONENUMBERLIST_GETTIME("getTime","信息更新日期","String"),
	PHONENUMBERLIST_ACCOUNT("account","与父对象的id关联","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	IdentityEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
