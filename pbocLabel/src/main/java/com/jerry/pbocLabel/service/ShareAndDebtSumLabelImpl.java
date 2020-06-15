package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.dict.DictShareAndDebtSum;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.ShareAndDebtSumEnum;
import com.jerry.pbocLabel.util.MapUtils;

public class ShareAndDebtSumLabelImpl {

	private static Logger log = LoggerFactory
			.getLogger(ShareAndDebtSumLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo,
			Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：授信及负债信息汇总描述");
		Boolean IF_NO_USE_CREDIT = false;
		Integer CNT_ORG_LEGAL_PERSON = 0;
		Integer CRED_LIMIT_TOTAL = 0;
		Integer CRED_LIMIT_TOTAL_USED = 0;
		double LV_CREDLIMIT_NORMAL_CARD_AVG = 0.0;
		double LV_CREDLIMIT_NORMAL_CARD = 0;

		Integer AMT_BALANCE_TOTAL = 0;
		double LV_NORMAL_LOAN_USED_LIMIT = 0.0;
		double LV_CREDLIMIT_NORMAL_CRAD_MAX = 0.0;

		Integer LV_NORMAL_LOAN_USED_LIMIT_balance_temp = 0;
		Integer LV_NORMAL_LOAN_USED_LIMIT_creditLimit_temp = 0;

		Integer CNT_ORG_LOAN_MGT = 0;

		Integer AMT_CARD_RECENT_BALANCE = 0;

		Integer SUM_USED_LIMIT_CARD_AVG_IN6M = 0;
		Integer SUM_USED_LIMIT_SCARD_AVG_IN6M = 0;

		if (!pbocVo.getShareAndDebtSum().isEmpty()) {
			String SUMTYPE;
			Integer ACCOUNTCOUNT;
			Integer IF_NO_USE_CREDIT_TEMP = 0;
			for (Map<String, Object> map : pbocVo.getShareAndDebtSum()) {
				log.debug("授信及负债信息汇总描述  展示:{}", map);
				SUMTYPE = MapUtils.getStringFromMap(map,
						ShareAndDebtSumEnum.SUMTYPE.field);
				ACCOUNTCOUNT = MapUtils.getIntegerFromMap(map,
						ShareAndDebtSumEnum.ACCOUNTCOUNT.field);
				Integer CREDITLIMIT = MapUtils.getIntegerFromMap(map,
						ShareAndDebtSumEnum.CREDITLIMIT.field);
				Integer USEDCREDITLIMIT = MapUtils.getIntegerFromMap(map,
						ShareAndDebtSumEnum.USEDCREDITLIMIT.field);
				Integer FINANCEORGCOUNT = MapUtils.getIntegerFromMap(map,
						ShareAndDebtSumEnum.FINANCEORGCOUNT.field);
				Integer BALANCE = MapUtils.getIntegerFromMap(map,
						ShareAndDebtSumEnum.BALANCE.field);
				Integer LAST6MONTHUSEDAVGAMOUNT = MapUtils.getIntegerFromMap(
						map, ShareAndDebtSumEnum.LAST6MONTHUSEDAVGAMOUNT.field);
				/**
				 * 是否为 曾持有信用卡已销卡且目前并未持有任何信用卡
				 */
				if (SUMTYPE.equals(DictShareAndDebtSum.sumType_4)
						&& ACCOUNTCOUNT == 0) {
					IF_NO_USE_CREDIT = true;
				}
				if (SUMTYPE.equals(DictShareAndDebtSum.sumType_4)) {
					IF_NO_USE_CREDIT_TEMP = 1;
				}
				if (SUMTYPE.equals(DictShareAndDebtSum.sumType_4)
						| SUMTYPE.equals(DictShareAndDebtSum.sumType_5)) {
					/**
					 * 当前发卡法人机构数
					 */
					CNT_ORG_LEGAL_PERSON = CNT_ORG_LEGAL_PERSON
							+ FINANCEORGCOUNT;
					/**
					 * 总授信额度
					 */
					CRED_LIMIT_TOTAL = CRED_LIMIT_TOTAL + CREDITLIMIT;
					/**
					 * 总透支余额
					 */
					CRED_LIMIT_TOTAL_USED = CRED_LIMIT_TOTAL_USED
							+ USEDCREDITLIMIT;
				}
				if (SUMTYPE.equals(DictShareAndDebtSum.sumType_1)
						| SUMTYPE.equals(DictShareAndDebtSum.sumType_2)
						| SUMTYPE.equals(DictShareAndDebtSum.sumType_3)) {
					/**
					 * 当前贷款管理机构数
					 */
					CNT_ORG_LOAN_MGT = CNT_ORG_LOAN_MGT + FINANCEORGCOUNT;
				}
				/**
				 * 未销户贷记卡额度使用率
				 */
				if (SUMTYPE.equals(DictShareAndDebtSum.sumType_4)) {
					if (CREDITLIMIT != 0) {
						LV_CREDLIMIT_NORMAL_CARD_AVG = USEDCREDITLIMIT * 1.0
								/ CREDITLIMIT * 1.0;
						LV_CREDLIMIT_NORMAL_CARD = USEDCREDITLIMIT * 1.0
								/ CREDITLIMIT * 1.0;
					} else {
						LV_CREDLIMIT_NORMAL_CARD_AVG = 0.0;
						LV_CREDLIMIT_NORMAL_CARD = 0.0;
					}
				}
				/**
				 * 信用类负债总额
				 */
				AMT_BALANCE_TOTAL = AMT_BALANCE_TOTAL + USEDCREDITLIMIT
						+ BALANCE;
				/**
				 * 贷记卡负债
				 */
				if (SUMTYPE.equals(DictShareAndDebtSum.sumType_4)) {
					AMT_CARD_RECENT_BALANCE = Math.max(USEDCREDITLIMIT,
							LAST6MONTHUSEDAVGAMOUNT);
				}
				/**
				 * 名下贷款余额占合同总额的比例
				 */
				if (BALANCE > 0
						&& (SUMTYPE.equals(DictShareAndDebtSum.sumType_1)
								| SUMTYPE.equals(DictShareAndDebtSum.sumType_2) | SUMTYPE
									.equals(DictShareAndDebtSum.sumType_3))) {
					LV_NORMAL_LOAN_USED_LIMIT_balance_temp = LV_NORMAL_LOAN_USED_LIMIT_balance_temp
							+ BALANCE;
					LV_NORMAL_LOAN_USED_LIMIT_creditLimit_temp = LV_NORMAL_LOAN_USED_LIMIT_creditLimit_temp
							+ CREDITLIMIT;
				}
				/**
				 * 贷记卡当前最大使用率
				 */
				if (CREDITLIMIT > 0
						&& SUMTYPE.equals(DictShareAndDebtSum.sumType_4)) {
					if (USEDCREDITLIMIT > LAST6MONTHUSEDAVGAMOUNT
							&& LAST6MONTHUSEDAVGAMOUNT > 0) {
						LV_CREDLIMIT_NORMAL_CRAD_MAX = USEDCREDITLIMIT * 1.0
								/ CREDITLIMIT;
					} else {
						LV_CREDLIMIT_NORMAL_CRAD_MAX = LAST6MONTHUSEDAVGAMOUNT
								* 1.0 / CREDITLIMIT;
					}
				}
				/**
				 * 贷记卡最近6个月平均使用额度 准贷记卡最近6个月平均使用额度
				 */
				if (SUMTYPE.equals(DictShareAndDebtSum.sumType_4)) {
					SUM_USED_LIMIT_CARD_AVG_IN6M = LAST6MONTHUSEDAVGAMOUNT;
				}
				if (SUMTYPE.equals(DictShareAndDebtSum.sumType_5)) {
					SUM_USED_LIMIT_SCARD_AVG_IN6M = LAST6MONTHUSEDAVGAMOUNT;
				}
			}
			/**
			 * type为4的记录不存在时,IF_NO_USE_CREDIT 为true
			 */
			if (IF_NO_USE_CREDIT_TEMP == 0) {
				IF_NO_USE_CREDIT = true;
			}
		} else {
			/**
			 * ShareAndDebtSum为空值不存在时,IF_NO_USE_CREDIT 为true
			 */
			IF_NO_USE_CREDIT = true;
		}

		/**
		 * 名下贷款余额占合同总额的比例计算
		 */
		if (LV_NORMAL_LOAN_USED_LIMIT_creditLimit_temp > 0) {
			LV_NORMAL_LOAN_USED_LIMIT = LV_NORMAL_LOAN_USED_LIMIT_balance_temp
					* 1.0 / LV_NORMAL_LOAN_USED_LIMIT_creditLimit_temp;
		}

		pbocRspPO.addIndex(PbocLabelEnum.IF_NO_USE_CREDIT.field,
				IF_NO_USE_CREDIT, PbocLabelEnum.IF_NO_USE_CREDIT.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_LEGAL_PERSON.field,
				CNT_ORG_LEGAL_PERSON,
				PbocLabelEnum.CNT_ORG_LEGAL_PERSON.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CRED_LIMIT_TOTAL.field,
				CRED_LIMIT_TOTAL, PbocLabelEnum.CRED_LIMIT_TOTAL.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CRED_LIMIT_TOTAL_USED.field,
				CRED_LIMIT_TOTAL_USED,
				PbocLabelEnum.CRED_LIMIT_TOTAL_USED.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.LV_CREDLIMIT_NORMAL_CARD_AVG.field,
				LV_CREDLIMIT_NORMAL_CARD_AVG,
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_CARD_AVG.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.LV_CREDLIMIT_NORMAL_CARD.field,
				LV_CREDLIMIT_NORMAL_CARD,
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_CARD.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_LOAN_MGT.field,
				CNT_ORG_LOAN_MGT, PbocLabelEnum.CNT_ORG_LOAN_MGT.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.SUM_USED_LIMIT_CARD_AVG_IN6M.field,
				SUM_USED_LIMIT_CARD_AVG_IN6M,
				PbocLabelEnum.SUM_USED_LIMIT_CARD_AVG_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.SUM_USED_LIMIT_SCARD_AVG_IN6M.field,
				SUM_USED_LIMIT_SCARD_AVG_IN6M,
				PbocLabelEnum.SUM_USED_LIMIT_SCARD_AVG_IN6M.fieldDesc);
		/**
		 * 早期风险预警指标
		 */
		pbocRspPO.addIndex(PbocLabelEnum.AMT_BALANCE_TOTAL.field,
				AMT_BALANCE_TOTAL, PbocLabelEnum.AMT_BALANCE_TOTAL.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_CARD_RECENT_BALANCE.field,
				AMT_CARD_RECENT_BALANCE,
				PbocLabelEnum.AMT_CARD_RECENT_BALANCE.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.LV_NORMAL_LOAN_USED_LIMIT.field,
				LV_NORMAL_LOAN_USED_LIMIT,
				PbocLabelEnum.LV_NORMAL_LOAN_USED_LIMIT.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.LV_CREDLIMIT_NORMAL_CRAD_MAX.field,
				LV_CREDLIMIT_NORMAL_CRAD_MAX,
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_CRAD_MAX.fieldDesc);
	}
}
