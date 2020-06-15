package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.TelPaymentEnum;
import com.jerry.pbocLabel.util.MapUtils;

public class TelPaymentLabelImpl {

	private static Logger log = LoggerFactory.getLogger(TelPaymentLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：后付费业务指标计算");
		Integer CNT_OWE_LAST6M_IN24M = 0;
		if (!pbocVo.getTelPayment().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getTelPayment()) {
				log.debug("后付费业务 展示:{}", map);
				if (MapUtils.getStringFromMap(map, TelPaymentEnum.STATUS24.field).replace("#", "").replace("N", "").replace("*", "").replace("C", "")
						.length() > 6) {
					CNT_OWE_LAST6M_IN24M++;
				}
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.CNT_OWE_LAST6M_IN24M.field, CNT_OWE_LAST6M_IN24M, PbocLabelEnum.CNT_OWE_LAST6M_IN24M.fieldDesc);
	}
}
