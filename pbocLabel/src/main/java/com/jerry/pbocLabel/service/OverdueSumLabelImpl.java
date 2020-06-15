package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.OverdueSumEnum;
import com.jerry.pbocLabel.util.MapUtils;

public class OverdueSumLabelImpl {

	private static Logger log = LoggerFactory
			.getLogger(OverdueSumLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo,
			Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：逾期(透支)信息汇总");
		Integer AMT_MAXOVERDUE_MONTH = 0;
		if (!pbocVo.getOverdueSum().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getOverdueSum()) {
				log.debug("逾期(透支)信息汇总 展示:{}", map);
				Integer HIGHESTOVERDUEAMOUNTPERMON = MapUtils
						.getIntegerFromMap(map,
								OverdueSumEnum.HIGHESTOVERDUEAMOUNTPERMON.field);
				/**
				 * 单月最高逾期总额
				 */
				AMT_MAXOVERDUE_MONTH = Math.max(AMT_MAXOVERDUE_MONTH,
						HIGHESTOVERDUEAMOUNTPERMON);
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.AMT_MAXOVERDUE_MONTH.field,
				AMT_MAXOVERDUE_MONTH,
				PbocLabelEnum.AMT_MAXOVERDUE_MONTH.fieldDesc);
	}
}
