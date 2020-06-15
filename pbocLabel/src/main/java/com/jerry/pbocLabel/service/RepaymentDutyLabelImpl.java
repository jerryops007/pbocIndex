package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.dict.DictRepaymentDuty;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.RepaymentDutyEnum;
import com.jerry.pbocLabel.util.MapUtils;

public class RepaymentDutyLabelImpl {

	private static Logger log = LoggerFactory.getLogger(RepaymentDutyLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：相关还款责任信息");
		Integer CNT_LOAN_GUARANTEE_SEC = 0;
		Integer CNT_LOAN_GUARANTEE_SUS = 0;
		Integer CNT_LOAN_GUARANTEE_LOSS = 0;
		Integer CNT_LOAN_GUARANTEE_ATTENTION = 0;
		Integer CNT_GUARENTEE_BALANCE = 0;

		if (pbocVo.getRepaymentDuty() != null && !pbocVo.getRepaymentDuty().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getRepaymentDuty()) {
				log.debug("相关还款责任信息 展示:{}", map);
				String FIVELEVELSERIES = MapUtils.getStringFromMap(map, RepaymentDutyEnum.FIVELEVELSERIES.field);
				Integer BALANCE = MapUtils.getIntegerFromMap(map, RepaymentDutyEnum.BALANCE.field);
				if (FIVELEVELSERIES.equals(DictRepaymentDuty.fiveLevelSeries_3)) {
					/**
					 * 对外担保信息中五级分类为次级的贷款数
					 */
					CNT_LOAN_GUARANTEE_SEC++;
				}
				if (FIVELEVELSERIES.equals(DictRepaymentDuty.fiveLevelSeries_4)) {
					/**
					 * 对外担保信息中五级分类为可疑的贷款数
					 */
					CNT_LOAN_GUARANTEE_SUS++;
				}
				if (FIVELEVELSERIES.equals(DictRepaymentDuty.fiveLevelSeries_5)) {
					/**
					 * 对外担保信息中五级分类为损失的贷款数
					 */
					CNT_LOAN_GUARANTEE_LOSS++;
				}
				if (FIVELEVELSERIES.equals(DictRepaymentDuty.fiveLevelSeries_2)) {
					/**
					 * 对外担保信息中五级分类为关注的贷款账户数
					 */
					CNT_LOAN_GUARANTEE_ATTENTION++;
				}
				/**
				 * 当前对外担保余额
				 */
				CNT_GUARENTEE_BALANCE = CNT_GUARENTEE_BALANCE + BALANCE;
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_GUARANTEE_SEC.field, CNT_LOAN_GUARANTEE_SEC, PbocLabelEnum.CNT_LOAN_GUARANTEE_SEC.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_GUARANTEE_SUS.field, CNT_LOAN_GUARANTEE_SUS, PbocLabelEnum.CNT_LOAN_GUARANTEE_SUS.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_GUARANTEE_LOSS.field, CNT_LOAN_GUARANTEE_LOSS, PbocLabelEnum.CNT_LOAN_GUARANTEE_LOSS.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_GUARANTEE_ATTENTION.field, CNT_LOAN_GUARANTEE_ATTENTION,
				PbocLabelEnum.CNT_LOAN_GUARANTEE_ATTENTION.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_GUARENTEE_BALANCE.field, CNT_GUARENTEE_BALANCE, PbocLabelEnum.CNT_GUARENTEE_BALANCE.fieldDesc);
	}
}
