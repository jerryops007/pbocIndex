package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.dict.DictDetailQueryReason;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.DetailQueryReasonEnum;
import com.jerry.pbocLabel.util.MapUtils;

public class DetailQueryReasonLabelImpl {

	private static Logger log = LoggerFactory.getLogger(DetailQueryReasonLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：查询记录汇总");
		Integer CNT_ORG_FINANCE_APPLY_LOAN_IN1M = 0;
		Integer CNT_ORG_FINANCE_APPLY_CARD_IN1M = 0;

		if (!pbocVo.getDetailQueryReason().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getDetailQueryReason()) {
				log.debug("查询记录信息展示：{}", map);
				String queryReason = MapUtils.getStringFromMap(map, DetailQueryReasonEnum.QUERYREASONTYPE.field);
				String queryInformation = MapUtils.getStringFromMap(map, DetailQueryReasonEnum.QUERYINFORMATIONTYPE.field);
				Integer sum = MapUtils.getIntegerFromMap(map, DetailQueryReasonEnum.SUMTYPE.field);
				/**
				 * 近一个月申请贷款的金融机构数
				 */
				if (queryReason.equals(DictDetailQueryReason.queryReason_1) && queryInformation.equals(DictDetailQueryReason.queryInformation_01)
						&& sum > 0) {
					CNT_ORG_FINANCE_APPLY_LOAN_IN1M = sum;
				}
				/**
				 * 近一个月申请信用卡的金融机构数
				 */
				if (queryReason.equals(DictDetailQueryReason.queryReason_2) && queryInformation.equals(DictDetailQueryReason.queryInformation_01)
						&& sum > 0) {
					CNT_ORG_FINANCE_APPLY_CARD_IN1M = sum;
				}
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_FINANCE_APPLY_LOAN_IN1M.field, CNT_ORG_FINANCE_APPLY_LOAN_IN1M,
				PbocLabelEnum.CNT_ORG_FINANCE_APPLY_LOAN_IN1M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_FINANCE_APPLY_CARD_IN1M.field, CNT_ORG_FINANCE_APPLY_CARD_IN1M,
				PbocLabelEnum.CNT_ORG_FINANCE_APPLY_CARD_IN1M.fieldDesc);
	}
}
