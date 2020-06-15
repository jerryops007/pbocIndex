package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.TaxArrearEnum;
import com.jerry.pbocLabel.util.MapUtils;

public class TaxArrearLabelImpl {

	private static Logger log = LoggerFactory.getLogger(TaxArrearLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：欠税记录");
		Integer AMT_TAX = 0;

		if (!pbocVo.getAccFund().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getSalvation()) {
				log.debug("欠税记录展示：{}", map);
				Integer TAXARREAAMOUNT = MapUtils.getIntegerFromMap(map, TaxArrearEnum.TAXARREAAMOUNT.field);
				/**
				 * 欠税总额
				 */
				AMT_TAX = AMT_TAX + TAXARREAAMOUNT;
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.AMT_TAX.field, AMT_TAX, PbocLabelEnum.AMT_TAX.fieldDesc);
	}
}
