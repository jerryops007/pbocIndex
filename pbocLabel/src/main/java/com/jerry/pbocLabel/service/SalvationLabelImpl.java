package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;

public class SalvationLabelImpl {

	private static Logger log = LoggerFactory.getLogger(SalvationLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：低保救助记录");
		Integer CNT_SALVATION = 0;

		if (!pbocVo.getAccFund().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getSalvation()) {
				log.debug("低保救助记录展示：{}", map);
				/**
				 * 低保救助记录数
				 */
				CNT_SALVATION++;
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.CNT_SALVATION.field, CNT_SALVATION, PbocLabelEnum.CNT_SALVATION.fieldDesc);
	}
}
