package com.jerry.pbocLabel.enums.pboc;

/**
 * 低保救助记录
 * @author chenliang
 *
 */
public enum SalvationEnum {
	
	PERSONNELTYPE("personneltype","人员类别","String"),
	AREA("area","所在地","String"),
	ORGANNAME("organname","工作单位","String"),
	MONEY("money","家庭月收入","BigDecimal"),
	REGISTERDATE("registerdate","申请日期","String"),
	PASSDATE("passdate","批准日期","String"),
	GETTIME("getTime","信息更新日期","String"),
	DISSENTINFOLIST("dissentInfolist","标注及声明信息","List"),
	
	//dissentInfolist-标注及声明信息
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	SalvationEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
