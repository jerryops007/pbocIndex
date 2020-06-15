package com.jerry.pbocLabel.enums.pboc;

/**
 * 字段解读
 * @author chenliang
 *
 */
public enum NumAnalysisEnum {
	
	RELATIVEPOSITION("relativePosition","相对位置","String"),				
	COMENT("coment","说明条数","String"),				
	NUMBERANALYSIS("numberAnalysis","数字解读","String"),				
	SCOREEXPLAINS("scoreExplains","分数说明信息","List"),

	//scoreExplain-分数说明信息
	SCOREEXPLAIN_EXPLAINMESSAGE("explainMessage","分数说明信息","String"),		
	SCOREEXPLAIN_ACCOUNT("account","与父对象的id关联","String");		
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	NumAnalysisEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}

}
