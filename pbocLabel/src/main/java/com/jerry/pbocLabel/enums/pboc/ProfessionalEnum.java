package com.jerry.pbocLabel.enums.pboc;

/**
 * 职业信息
 * @author chenliang
 *
 */
public enum ProfessionalEnum {
	
	EMPLOYER("employer","工作单位","String"),			
	EMPLOYERADDRESS("employeraddress","单位地址","String"),			
	OCCUPATION("occupation","职业","String"),			
	INDUSTRY("industry","行业","String"),			
	DUTY("duty","职务","String"),			
	TITLE("title","职称","String"),			
	STARTYEAR("startyear","进入本单位年份","String"),			
	GETTIME("gettime","信息更新日期","String"),			
	COMPANYTYPE("companytype","单位性质","String"),			
	COMPANYPHONE("companyphone","单位电话","String");		
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	ProfessionalEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
		
}
