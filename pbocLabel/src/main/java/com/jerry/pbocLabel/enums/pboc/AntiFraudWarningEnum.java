package com.jerry.pbocLabel.enums.pboc;

/**
 * 防欺诈警示
 * @author chenliang
 *
 */
public enum AntiFraudWarningEnum {
	
	ANTISIGN("antiSign","防欺诈警示标志","String"),	 	
	ANTIPHONE("antiPhone","防欺诈警示联系电话","String"),	 	
	ANTIEFFECTIVEDATE("antiEffectiveDate","防欺诈警示生效日期","String"),		
	ANTICLOSINGDATE("antiClosingDate","防欺诈警示截止日期","String");
	
	public String field;
	public String fieldDesc;
	public String fieldType;
	
	AntiFraudWarningEnum(String field, String fieldDesc,String fieldType){
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
	
}
