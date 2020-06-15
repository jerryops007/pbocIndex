package com.jerry.pbocLabel.enums.pboc;

/**
 * 执业资格记录
 * @author chenliang
 *
 */
public enum CompetenceEnum {
	
	COMPETENCYNAME("competencyname","执业资格名称","String"),
	GRADE("grade","等级","String"),
	AWARDDATE("awarddate","获得日期","String"),
	ENDDATE("enddate","到期日期","String"),
	REVOKEDATE("revokedate","吊销日期","String"),
	ORGANNAME("organname","颁发机构","String"),
	AREA("area","机构所在地","String"),
	DISSENTINFOLIST("dissentInfolist","标注及声明信息","List"),
	
	//dissentInfolist-标注及声明信息
	DISSENTINFOLIST_CONTENT("content","标注内容","String"),
	DISSENTINFOLIST_GETTIME("getTime","添加日期","String"),
	DISSENTINFOLIST_ACCOUNT("account","关联字段，与父对象id关联","String"),
	DISSENTINFOLIST_TYPE("type","标注及声明类型","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	CompetenceEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
