package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;

public class CivilJudgementImpl {

	private static Logger log = LoggerFactory.getLogger(CivilJudgementImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：民事判决记录");
		Integer CNT_CIVILJUDGEMENT = 0;

		if (!pbocVo.getAccFund().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getCivilJudgement()) {
				log.debug("民事判决记录展示：{}", map);
				/**
				 * 民事判决记录数
				 */
				CNT_CIVILJUDGEMENT++;
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.CNT_CIVILJUDGEMENT.field, CNT_CIVILJUDGEMENT, PbocLabelEnum.CNT_CIVILJUDGEMENT.fieldDesc);
	}
}
