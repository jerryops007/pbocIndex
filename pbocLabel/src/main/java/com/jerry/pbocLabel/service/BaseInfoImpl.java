package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.MessageHeaderEnum;
import com.jerry.pbocLabel.util.MapUtils;
import com.jerry.pbocLabel.util.StringUtil;

/*
 * 人行报文基本信息 
 */
public class BaseInfoImpl {

	private static Logger log = LoggerFactory.getLogger(BaseInfoImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：人行报文基本信息提取 ");
		log.debug("人行报文头信息 ：{}", pbocVo.getMessageHeader());
		String report_date = MapUtils.getStringFromMap(pbocVo.getMessageHeader(), MessageHeaderEnum.REPORTCREATETIME.field).replace("T", " ").trim();
		pbocBaseInfoPO.setReportCreateTime(report_date);
		log.debug("人行报告时间：{}", pbocBaseInfoPO.getReportCreateTime());
		pbocRspPO.addIndex(PbocLabelEnum.REPORT_DATE.field, StringUtil.isNotEmpty(report_date) ? report_date : "缺失",
				PbocLabelEnum.REPORT_DATE.fieldDesc);
	}

}
