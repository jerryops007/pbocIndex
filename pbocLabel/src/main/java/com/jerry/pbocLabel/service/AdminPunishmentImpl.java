package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;

public class AdminPunishmentImpl {

	private static Logger log = LoggerFactory.getLogger(AdminPunishmentImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：行政处罚记录");
		Integer CNT_ADMINPUNISHMENT = 0;

		if (!pbocVo.getAccFund().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getAdminPunishment()) {
				log.debug("行政处罚记录数展示：{}", map);
				/**
				 * 行政处罚记录数
				 */
				CNT_ADMINPUNISHMENT++;
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ADMINPUNISHMENT.field, CNT_ADMINPUNISHMENT, PbocLabelEnum.CNT_ADMINPUNISHMENT.fieldDesc);
	}
}
