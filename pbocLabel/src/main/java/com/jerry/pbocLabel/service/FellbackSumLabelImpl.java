package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.dict.DictFellbackSum;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.FellbackSumEnum;
import com.jerry.pbocLabel.util.MapUtils;

public class FellbackSumLabelImpl {

	private static Logger log = LoggerFactory.getLogger(FellbackSumLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：违约信息汇总");
		Integer CNT_BREAK_INFO_BAD = 0;
		Integer CNT_BREAK_INFO_AD = 0;
		Integer CNT_BREAK_INFO_GUARANTEE = 0;
		if (!pbocVo.getFellbackSum().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getFellbackSum()) {
				log.debug("违约信息汇总展示：{}", map);
				String sign = MapUtils.getStringFromMap(map, FellbackSumEnum.SIGN.field);
				Integer count = MapUtils.getIntegerFromMap(map, FellbackSumEnum.COUNT.field);
				if (sign.equals(DictFellbackSum.sign_0) && count > 0) {
					/**
					 * 违约信息中存在呆账的账户数
					 */
					CNT_BREAK_INFO_BAD = count;
				}
				if (sign.equals(DictFellbackSum.sign_1) && count > 0) {
					/**
					 * 违约信息中存在资产处置的账户数
					 */
					CNT_BREAK_INFO_AD = count;
				}
				if (sign.equals(DictFellbackSum.sign_2) && count > 0) {
					/**
					 * 违约信息中存在保证人代偿的账户数
					 */
					CNT_BREAK_INFO_GUARANTEE = count;
				}
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.CNT_BREAK_INFO_BAD.field, CNT_BREAK_INFO_BAD, PbocLabelEnum.CNT_BREAK_INFO_BAD.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_BREAK_INFO_AD.field, CNT_BREAK_INFO_AD, PbocLabelEnum.CNT_BREAK_INFO_AD.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_BREAK_INFO_GUARANTEE.field, CNT_BREAK_INFO_GUARANTEE, PbocLabelEnum.CNT_BREAK_INFO_GUARANTEE.fieldDesc);
	}
}
