package com.jerry.pbocLabel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.dict.DictAwardCreditInfo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.AwardCreditInfoEnum;
import com.jerry.pbocLabel.util.ArrayUtils;
import com.jerry.pbocLabel.util.DateUtils;
import com.jerry.pbocLabel.util.MapUtils;

/*
 * 人行报文信息：贷记卡、准贷记卡指标解析
 */
public class AwardCreditInfoLabelImpl {

	private static Logger log = LoggerFactory
			.getLogger(AwardCreditInfoLabelImpl.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo,
			Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：贷记卡、准贷记卡指标解析");

		// 逾期基本信息
		Integer CNT_ACCOUNT_SCARD_ODU_NOW = 0;
		Integer CNT_ACCOUNT_CARD_ODU_NOW = 0;
		Integer CNT_ACCOUNT_CARD_ABNORMAL = 0;
		Integer CNT_ACCOUNT_SCARD_ABNORMAL = 0;

		// 账龄相关指标
		Integer CNT_NODU_ACCOUNT_CARD_AGE6 = 0;
		Integer CNT_NODU_ACCOUNT_SCARD_AGE6 = 0;
		Integer CNT_NODU_ACCOUNT_CARD_AGE12 = 0;
		Integer CNT_NODU_ACCOUNT_SCARD_AGE12 = 0;
		Integer CNT_ACCOUNT_NORMAL_CARD_AGE12 = 0;
		Integer CNT_ACCOUNT_NORMAL_SCARD_AGE12 = 0;
		Integer CNT_ACCOUNT_NORMAL_CARD_AGE24 = 0;
		Integer CNT_ACCOUNT_NORMAL_SCARD_AGE24 = 0;
		Integer MONTH_AGE_SCARD = 0;
		Integer MONTH_AGE_CARD = 0;
		Integer MONTH_AGE_NORMAL_SCARD = 0;
		Integer MONTH_AGE_NORMAL_CARD = 0;

		// 月数相关指标
		Integer MONTH_ODU_ACCOUNT_SCARD = 9999;
		Integer MONTH_ODU_ACCOUNT_CARD = 9999;

		// 逾期账户数相关指标
		Integer CNT_ODU_ACCOUNT_CARD_IN3M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_IN24M = 0;

		Integer CNT_ODU_ACCOUNT_SCARD_IN3M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_IN24M = 0;

		Integer CNT_ODU_ACCOUNT_CARD_IN24M_MAX = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_IN24M_MAX = 0;

		Integer CNT_ACCT_CARD_M3 = 0;
		Integer CNT_ACCT_SCARD_M3 = 0;
		Integer CNT_ACCT_LOAN_M2E_IN3M = 0;
		Integer CNT_ACCT_LOAN_M2E_IN6M = 0;
		Integer CNT_ACCT_CARD_M2E_IN6M = 0;
		Integer CNT_ACCT_CARD_M2E_IN6M_2TP = 0;
		Integer CNT_ACCT_CARD_M2E_IN12M = 0;
		Integer CNT_ACCT_CARD_M2E_IN12M_3TP = 0;
		Integer CNT_ACCT_CARD_M1E_IN12M_6TP = 0;
		Integer CNT_ACCT_CARD_M3_IN24M = 0;
		Integer CNT_ACCT_SCARD_M3_IN24M = 0;
		Integer CNT_ACCT_CARD_M3_OUT24M = 0;
		Integer CNT_ACCT_SCARD_M3_OUT24M = 0;

		// 逾期次数相关指标
		Integer CNT_ODU_ACCOUNT_CARD_M2E_IN3M = 0;

		Integer CNT_ODU_ACCOUNT_CARD_M1E_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M2E_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M3E_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M4E_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M5E_IN6M = 0;

		Integer CNT_ODU_ACCOUNT_CARD_M3_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M4_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M5_IN6M = 0;

		Integer CNT_ODU_ACCOUNT_CARD_M1E_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M2E_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M3E_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M4E_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M5E_IN12M = 0;

		Integer CNT_ODU_ACCOUNT_CARD_M3_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M4_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M5_IN12M = 0;

		Integer CNT_ODU_ACCOUNT_CARD_M3_IN24M = 0;

		Integer CNT_ODU_ACCOUNT_CARD_M2 = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M3 = 0;

		Integer CNT_ODU_ACCOUNT_SCARD_M2 = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M3 = 0;

		Integer CNT_ODU_ACCOUNT_SCARD_M2E_IN3M = 0;

		Integer CNT_ODU_ACCOUNT_SCARD_M1E_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M2E_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M3E_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M4E_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M5E_IN6M = 0;

		Integer CNT_ODU_ACCOUNT_SCARD_M3_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M4_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M5_IN6M = 0;

		Integer CNT_ODU_ACCOUNT_SCARD_M1E_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M2E_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M3E_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M4E_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M5E_IN12M = 0;

		Integer CNT_ODU_ACCOUNT_SCARD_M3_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M4_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M5_IN12M = 0;

		Integer CNT_ODU_ACCOUNT_SCARD_M3_IN24M = 0;

		Integer CNT_ODU_ACCOUNT_CARD_M3_OUT24M = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_M3_OUT24M = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M1_IN24M = 0;

		Integer MONTH_ODU_ACCOUNT_CARD_MAX = 0;
		Integer MONTH_ODU_ACCOUNT_SCARD_MAX = 0;
		Integer CNT_ODU_ACCOUNT_CARD_M1_IN6M = 0;

		// 额度使用率相关指标
		Integer CNT_ACCOUNT_CARD_LV80 = 0;
		Integer CNT_ACCOUNT_SCARD_LV80 = 0;
		Integer LV_CREDLIMIT_NORMAL_CARD_TOTAL_LIMIT = 0; // 评分卡贷记卡未销户总计算额度
		Integer LV_CREDLIMIT_NORMAL_CARD_USED_LIMIT = 0; // 评分卡贷记卡未销户总已使用额度
		Integer LV_CREDLIMIT_NORMAL_SCARD_TOTAL_LIMIT = 0; // 评分卡贷记卡未销户总计算额度
		Integer LV_CREDLIMIT_NORMAL_SCARD_USED_LIMIT = 0; // 评分卡贷记卡未销户总已使用额度

		// 其他指标
		Integer CNT_ODU_ACCOUNT_CARD_AMT100 = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_AMT100 = 0;
		Integer CNT_ODU_ACCOUNT_CARD_AMT500 = 0;
		Integer CNT_ODU_ACCOUNT_SCARD_AMT500 = 0;
		Integer CNT_MAX_LOAN_ACCOUNT_CARD_IN6M = 0;
		Integer CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M = 0;
		Boolean IF_CARD_REPORT_UPDATE_IN24MONTH = true;
		Boolean IF_SCARD_REPORT_UPDATE_IN24MONTH = true;

		Integer CNT_ACCOUNT_CARD_ODU_NOW_MAXAMT = 0;

		// 核准记录数
		Integer CNT_CARD_APPROVE_IN6M = 0;
		Integer CNT_SCARD_APPROVE_IN6M = 0;
		Integer CNT_CARD_APPROVE_IN3M = 0;
		Integer CNT_SCARD_APPROVE_IN3M = 0;

		// 他行卡计算
		Integer CNT_AMT_CARD_OBANK = 0;
		Integer CNT_AMT_CARD_OBANK_HIGHEST = 0;
		Integer CNT_AMT_OBANK_SECOND = 0;
		Integer CNT_AMT_CARD_OBANK_LOWEST = 0;
		Integer CRED_LIMIT_OBANK_ONE = 0;
		Integer COUNT_currency = 0;
		Integer CRED_LIMIT_OBANK_DOUBLE = 0;
		Integer CRED_LIMIT_OBANK_MULTI_MODE = 0;
		Integer CRED_LIMIT_OBANK_MULTI_MEDIAN = 0;
		Integer CRED_LIMIT_OBANK_SUM = 0;

		ArrayList<Integer> CREDITLIMITAMOUNT_LIST = new ArrayList<Integer>();
		ArrayList<Integer> OPENDATEDiffMonth_LIST = new ArrayList<Integer>();

		// 早期风险预警指标
		Integer AMT_ACCOUNT_CARD_M1E = 0;
		Integer AMT_ACCOUNT_CARD_M2E = 0;
		Integer AMT_ACCOUNT_CARD_M3E = 0;
		Integer AMT_ACCOUNT_CARD_M4E = 0;
		Integer AMT_ACCOUNT_CARD_M4 = 0;
		Integer AMT_ACCOUNT_CARD_M5 = 0;

		Integer AMT_ACCOUNT_SCARD_M1E = 0;
		Integer AMT_ACCOUNT_SCARD_M2E = 0;
		Integer AMT_ACCOUNT_SCARD_M3E = 0;
		Integer AMT_ACCOUNT_SCARD_M4E = 0;
		Integer AMT_ACCOUNT_SCARD_M4 = 0;
		Integer AMT_ACCOUNT_SCARD_M5 = 0;

		Integer CNT_ACCOUNT_CARD_ABNORMAL_ZF_ODU300 = 0;
		Integer CNT_ACCOUNT_CARD_ABNORMAL_DJ_ODU300 = 0;
		Integer CNT_ACCOUNT_CARD_ABNORMAL_DZ_ODU300 = 0;
		Integer CNT_ACCOUNT_CARD_ABNORMAL_DB = 0;

		Integer CNT_ACCOUNT_SCARD_ABNORMAL_ZF_ODU300 = 0;
		Integer CNT_ACCOUNT_SCARD_ABNORMAL_DJ_ODU300 = 0;
		Integer CNT_ACCOUNT_SCARD_ABNORMAL_DZ_ODU300 = 0;
		Integer CNT_ACCOUNT_SCARD_ABNORMAL_DB = 0;

		Integer CNT_ACCOUNT_USEDLIMT_500K_AVG_IN6M = 0;

		double LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK = 0.0;
		Integer LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_shared = 0;
		Integer LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_used = 0;

		Integer CNT_PAYMENT_MIN = 0;
		Integer CNT_ACCOUNT_TOTAL = 0;
		Integer CNT_ACCOUNT_CARD_LOW_LIMIT_DALIAN = 0;
		Integer CNT_ACCOUNT_CARD_DALIAN = 0;

		// 额度计算
		Integer CRED_LIMIT_LARGE_INSTALMENT = 0;
		Integer CRED_LIMIT_LARGE_INSTALMENT_USED = 0;

		Integer CREDITLIMITAMOUNT = 0;
		if (!pbocVo.getAwardCreditInfo().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getAwardCreditInfo()) {
				log.debug("授信情况 展示:{}", map);
				String ACCOUNTSTATE = MapUtils.getStringFromMap(map,
						AwardCreditInfoEnum.ACCOUNTSTATE.field);
				String CURRENCY = MapUtils.getStringFromMap(map,
						AwardCreditInfoEnum.CURRENCY.field);
				String FINANCEORG = MapUtils.getStringFromMap(map,
						AwardCreditInfoEnum.FINANCEORG.field);
				String LATESTPERFORMANCE_ACCOUNTSTATE = MapUtils
						.getStringFromMap(
								MapUtils.getMapFromMap(
										map,
										AwardCreditInfoEnum.LATESTPERFORMANCE.field),
								AwardCreditInfoEnum.LATESTPERFORMANCE_ACCOUNTSTATE.field);
				String LATESTPERFORMANCE_REPAYMENTTYPE = MapUtils
						.getStringFromMap(
								MapUtils.getMapFromMap(
										map,
										AwardCreditInfoEnum.LATESTPERFORMANCE.field),
								AwardCreditInfoEnum.LATESTPERFORMANCE_REPAYMENTTYPE.field);
				List OVERDUERECORDLIST = MapUtils.getListFromMap(map,
						AwardCreditInfoEnum.OVERDUERECORDLIST.field);
				List SPECIALTRADELIST = MapUtils.getListFromMap(map,
						AwardCreditInfoEnum.SPECIALTRADELIST.field);
				Map LARGESPECIALSTAGE = MapUtils.getMapFromMap(map,
						AwardCreditInfoEnum.LARGESPECIALSTAGE.field);
				Integer OPENDATEDiffMonth;
				try {
					OPENDATEDiffMonth = DateUtils.getdateDiffMonth(
							pbocBaseInfoPO.getReportCreateTime(),
							MapUtils.getStringFromMap(map,
									AwardCreditInfoEnum.OPENDATE.field),
							DateUtils.DATE_FORMAT_3, DateUtils.DATE_FORMAT_6);
				} catch (Exception e) {
					log.error("日期解析发生错误,错误日期为{},跳过当前记录", MapUtils
							.getStringFromMap(map,
									AwardCreditInfoEnum.OPENDATE.field));
					continue;
				}
				if (OPENDATEDiffMonth < 0) {
					log.error("出现错误日期信息,时间差为{},错误日期为{}", OPENDATEDiffMonth,
							MapUtils.getStringFromMap(map,
									AwardCreditInfoEnum.OPENDATE.field));
					continue;
				}
				CREDITLIMITAMOUNT = MapUtils.getIntegerFromMap(map,
						AwardCreditInfoEnum.CREDITLIMITAMOUNT.field);
				Integer REPAYINFO_USEDCREDITLIMITAMOUNT = MapUtils
						.getIntegerFromMap(
								MapUtils.getMapFromMap(map,
										AwardCreditInfoEnum.REPAYINFO.field),
								AwardCreditInfoEnum.REPAYINFO_USEDCREDITLIMITAMOUNT.field);
				Integer REPAYINFO_SHARECREDITLIMITAMOUNT = MapUtils
						.getIntegerFromMap(
								MapUtils.getMapFromMap(map,
										AwardCreditInfoEnum.REPAYINFO.field),
								AwardCreditInfoEnum.REPAYINFO_SHARECREDITLIMITAMOUNT.field);
				Integer REPAYINFO_SCHEDULEDPAYMENTAMOUNT = MapUtils
						.getIntegerFromMap(
								MapUtils.getMapFromMap(map,
										AwardCreditInfoEnum.REPAYINFO.field),
								AwardCreditInfoEnum.REPAYINFO_SCHEDULEDPAYMENTAMOUNT.field);
				Integer REPAYINFO_ACTUALPAYMENTAMOUNT = MapUtils
						.getIntegerFromMap(
								MapUtils.getMapFromMap(map,
										AwardCreditInfoEnum.REPAYINFO.field),
								AwardCreditInfoEnum.REPAYINFO_ACTUALPAYMENTAMOUNT.field);
				Integer REPAYINFO_CURROVERDUECYC = MapUtils.getIntegerFromMap(
						MapUtils.getMapFromMap(map,
								AwardCreditInfoEnum.REPAYINFO.field),
						AwardCreditInfoEnum.REPAYINFO_CURROVERDUECYC.field);
				Integer REPAYINFO_CURROVERDUEAMOUNT = MapUtils
						.getIntegerFromMap(
								MapUtils.getMapFromMap(map,
										AwardCreditInfoEnum.REPAYINFO.field),
								AwardCreditInfoEnum.REPAYINFO_CURROVERDUEAMOUNT.field);
				Integer REPAYINFO_LATEST6MONTHUSEDAVGAMOUNT = MapUtils
						.getIntegerFromMap(
								MapUtils.getMapFromMap(map,
										AwardCreditInfoEnum.REPAYINFO.field),
								AwardCreditInfoEnum.REPAYINFO_LATEST6MONTHUSEDAVGAMOUNT.field);
				String GUARANTEETYPE = MapUtils.getStringFromMap(map,
						AwardCreditInfoEnum.GUARANTEETYPE.field);
				Integer LARGESPECIALSTAGE_AMOUNT = MapUtils.getIntegerFromMap(
						LARGESPECIALSTAGE,
						AwardCreditInfoEnum.LARGESPECIALSTAGE_AMOUNT.field);
				Integer LARGESPECIALSTAGE_USEDLIMITAMOUNT = MapUtils
						.getIntegerFromMap(
								LARGESPECIALSTAGE,
								AwardCreditInfoEnum.LARGESPECIALSTAGE_USEDLIMITAMOUNT.field);

				/**
				 * 不区分账户类型
				 */
				// 未销户信用卡近6个月平均使用额度超过50万账户数
				if (!ACCOUNTSTATE.equals(DictAwardCreditInfo.accountState_4)
						&& !LATESTPERFORMANCE_ACCOUNTSTATE
								.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_XH)
						&& REPAYINFO_LATEST6MONTHUSEDAVGAMOUNT >= 500000) {
					CNT_ACCOUNT_USEDLIMT_500K_AVG_IN6M++;
				}
				// 最低还款（本月实还款比本月应还款值±相差5%（含））账户数
				if (CURRENCY.equals(DictAwardCreditInfo.CURRENCY_RMB)
						&& REPAYINFO_SCHEDULEDPAYMENTAMOUNT > 0) {
					if (REPAYINFO_SCHEDULEDPAYMENTAMOUNT >= REPAYINFO_ACTUALPAYMENTAMOUNT * 0.95
							&& REPAYINFO_SCHEDULEDPAYMENTAMOUNT <= REPAYINFO_ACTUALPAYMENTAMOUNT * 1.05) {
						CNT_PAYMENT_MIN++;
					}
				}
				// 实际已用账户数 CNT_ACCOUNT_TOTAL
				if (CURRENCY.equals(DictAwardCreditInfo.CURRENCY_RMB)
						&& REPAYINFO_SCHEDULEDPAYMENTAMOUNT > 0) {
					CNT_ACCOUNT_TOTAL++;
				}
				// CNT_ACCOUNT_CARD_LOW_LIMIT_DALIAN 小额卡用卡记录数
				if (CREDITLIMITAMOUNT > 0 && CREDITLIMITAMOUNT < 10000) {
					if (Math.max(REPAYINFO_USEDCREDITLIMITAMOUNT,
							REPAYINFO_LATEST6MONTHUSEDAVGAMOUNT) > CREDITLIMITAMOUNT * 0.5) {
						CNT_ACCOUNT_CARD_LOW_LIMIT_DALIAN++;
					}
				}
				/**
				 * 大额专项分期信息 largeSpecialStage
				 */
				if (GUARANTEETYPE.equals(DictAwardCreditInfo.GUARANTEETYPE_1)
						&& ACCOUNTSTATE
								.equals(DictAwardCreditInfo.accountState_12)) {
					// 大额专项分期额度（抵押类）
					CRED_LIMIT_LARGE_INSTALMENT = CRED_LIMIT_LARGE_INSTALMENT
							+ LARGESPECIALSTAGE_AMOUNT;
					// 大额专项分期已用金额（抵押类）
					CRED_LIMIT_LARGE_INSTALMENT_USED = CRED_LIMIT_LARGE_INSTALMENT_USED
							+ LARGESPECIALSTAGE_USEDLIMITAMOUNT;
				}
				// 他行卡-总授信额度
				if (!Pattern.matches(DictAwardCreditInfo.FINANCEORG_AZaZ_regex,
						FINANCEORG)) {
					CRED_LIMIT_OBANK_SUM += CREDITLIMITAMOUNT;
				}

				/**
				 * 贷记卡
				 */
				if (MapUtils.getStringFromMap(map,
						AwardCreditInfoEnum.TYPE.field).equals(
						DictAwardCreditInfo.type_R2)) {
					log.debug("开始贷记卡指标计算：begin");
					if (REPAYINFO_CURROVERDUECYC > 0
							&& DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_1TOZ
									.contains(LATESTPERFORMANCE_REPAYMENTTYPE)) {
						/**
						 * 贷记卡当前逾期的账户数
						 */

						CNT_ACCOUNT_CARD_ODU_NOW++;
						/**
						 * 贷记卡当前存在逾期且金额大于等于100元的次数
						 */
						if (REPAYINFO_CURROVERDUEAMOUNT >= 100) {
							CNT_ODU_ACCOUNT_CARD_AMT100++;
						}
						/**
						 * 贷记卡当前存在逾期且金额大于等于500元的次数
						 */
						if (REPAYINFO_CURROVERDUEAMOUNT >= 500) {
							CNT_ODU_ACCOUNT_CARD_AMT500++;
						}
					}
					if (DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_1TOZ
							.contains(LATESTPERFORMANCE_REPAYMENTTYPE)) {
						/**
						 * 贷记卡账户当前逾期金额的最大值
						 */
						if (REPAYINFO_CURROVERDUEAMOUNT > 0) {
							CNT_ACCOUNT_CARD_ODU_NOW_MAXAMT = Math.max(
									CNT_ACCOUNT_CARD_ODU_NOW_MAXAMT,
									REPAYINFO_CURROVERDUEAMOUNT);
						}
					}
					/**
					 * 高风险状态的贷记卡账户数（冻结、止付、银行止付、呆账、司法追偿）
					 */
					if ((ACCOUNTSTATE
							.equals(DictAwardCreditInfo.accountState_3)
							| ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_2)
							| ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_31)
							| ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_5) | ACCOUNTSTATE
								.equals(DictAwardCreditInfo.accountState_8))
							&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty()
									| LATESTPERFORMANCE_ACCOUNTSTATE
											.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_11)
									| LATESTPERFORMANCE_ACCOUNTSTATE
											.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_10)
									| LATESTPERFORMANCE_ACCOUNTSTATE
											.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_11YH)
									| LATESTPERFORMANCE_ACCOUNTSTATE
											.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_DZ) | LATESTPERFORMANCE_ACCOUNTSTATE
										.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_8))) {
						CNT_ACCOUNT_CARD_ABNORMAL++;
					}
					/**
					 * 贷记卡账户最长账龄（月）
					 */
					MONTH_AGE_CARD = Math
							.max(MONTH_AGE_CARD, OPENDATEDiffMonth);
					// 账龄≥n个月且状态正常的贷记账户数
					if (ACCOUNTSTATE
							.equals(DictAwardCreditInfo.accountState_12)
							| (ACCOUNTSTATE.isEmpty() && LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_12))) {
						/**
						 * 账龄≥12个月且状态正常的贷记卡账户数
						 */
						if (OPENDATEDiffMonth >= 12) {
							CNT_ACCOUNT_NORMAL_CARD_AGE12++;
						}
						/**
						 * 账龄≥24个月且状态正常的贷记卡账户数
						 */
						if (OPENDATEDiffMonth >= 24) {
							CNT_ACCOUNT_NORMAL_CARD_AGE24++;
						}
						/**
						 * 状态正常的贷记卡账户最长账龄（月）
						 */
						MONTH_AGE_NORMAL_CARD = Math.max(MONTH_AGE_NORMAL_CARD,
								OPENDATEDiffMonth);
					}
					/**
					 * 核准记录数
					 */
					if (OPENDATEDiffMonth <= 6) {
						/**
						 * 近6个月贷记卡核准记录数
						 */
						CNT_CARD_APPROVE_IN6M++;
					}
					if (OPENDATEDiffMonth <= 3) {
						/**
						 * 近3个月贷记卡核准记录数
						 */
						CNT_CARD_APPROVE_IN3M++;
					}
					/**
					 * 有效他行卡
					 */
					if (ACCOUNTSTATE
							.equals(DictAwardCreditInfo.accountState_12)
							&& OPENDATEDiffMonth >= 6
							&& !Pattern.matches(
									DictAwardCreditInfo.FINANCEORG_AZaZ_regex,
									FINANCEORG)) {
						/**
						 * 有效他行卡数量
						 */
						CNT_AMT_CARD_OBANK++;
						/**
						 * 有效他行卡-最高额度
						 */
						CNT_AMT_CARD_OBANK_HIGHEST = Math.max(
								CNT_AMT_CARD_OBANK_HIGHEST, CREDITLIMITAMOUNT);
						/**
						 * 有效他行卡-次高额度
						 */
						if (CNT_AMT_CARD_OBANK_HIGHEST > CREDITLIMITAMOUNT) {
							CNT_AMT_OBANK_SECOND = Math.max(
									CNT_AMT_OBANK_SECOND, CREDITLIMITAMOUNT);
						}
						/**
						 * 有效他行卡-最低额度
						 */
						if (CREDITLIMITAMOUNT > 0) {
							if (CNT_AMT_CARD_OBANK_LOWEST <= 0) {
								CNT_AMT_CARD_OBANK_LOWEST = CREDITLIMITAMOUNT;
							} else {
								CNT_AMT_CARD_OBANK_LOWEST = Math.min(
										CNT_AMT_CARD_OBANK_LOWEST,
										CREDITLIMITAMOUNT);
							}
						}
						/**
						 * 有效他行卡-单卡额度
						 */
						// 有效他行卡-双卡额度
						// 有效他行卡-多卡额度（众数）
						// 有效他行卡-多卡额度（中位数）
						if (CREDITLIMITAMOUNT >= 3000) {
							COUNT_currency += 1;
							CREDITLIMITAMOUNT_LIST.add(CREDITLIMITAMOUNT);
							OPENDATEDiffMonth_LIST.add(OPENDATEDiffMonth);

						}

					}
					/**
					 * 早期风险预警
					 */
					if (REPAYINFO_CURROVERDUECYC == 1
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_1))) {
						/**
						 * 贷记卡当前状态为逾期M1的逾期金额
						 */
						AMT_ACCOUNT_CARD_M1E = AMT_ACCOUNT_CARD_M1E
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUECYC == 2
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_2))) {
						/**
						 * 贷记卡当前状态为逾期M2的逾期金额
						 */
						AMT_ACCOUNT_CARD_M2E = AMT_ACCOUNT_CARD_M2E
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUECYC == 3
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_3))) {
						/**
						 * 贷记卡当前状态为逾期M3的逾期金额
						 */
						AMT_ACCOUNT_CARD_M3E = AMT_ACCOUNT_CARD_M3E
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUECYC == 4
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_4))) {
						/**
						 * 贷记卡当前状态为逾期M4的逾期金额
						 */
						AMT_ACCOUNT_CARD_M4E = AMT_ACCOUNT_CARD_M4E
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUECYC >= 4
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_4TOZ))) {
						/**
						 * 贷记卡当前状态为逾期M4+的逾期金额
						 */
						AMT_ACCOUNT_CARD_M4 = AMT_ACCOUNT_CARD_M4
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUECYC >= 5
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_5TOZ))) {
						/**
						 * 贷记卡当前状态为逾期M5+的逾期金额
						 */
						AMT_ACCOUNT_CARD_M5 = AMT_ACCOUNT_CARD_M5
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}

					if (REPAYINFO_CURROVERDUEAMOUNT >= 300
							&& ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_3)
							&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty() | LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_11))) {
						/**
						 * 贷记卡当前状态为止付且逾期金额在300元及以上的账户数
						 */
						CNT_ACCOUNT_CARD_ABNORMAL_ZF_ODU300++;

					}
					if (REPAYINFO_CURROVERDUEAMOUNT >= 300
							&& ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_2)
							&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty() | LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_10))) {
						/**
						 * 贷记卡当前状态为冻结且逾期金额在300元及以上的账户数
						 */
						CNT_ACCOUNT_CARD_ABNORMAL_DJ_ODU300++;
					}
					if (REPAYINFO_CURROVERDUEAMOUNT >= 300
							&& ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_5)
							&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty() | LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_4))) {
						/**
						 * 贷记卡当前状态为呆账且逾期金额在300元及以上的账户数
						 */
						CNT_ACCOUNT_CARD_ABNORMAL_DZ_ODU300++;
					}
					// LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK
					// 非本行名下所有贷记卡真实使用额度
					if (FINANCEORG.length() > 2) {
						LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_shared = LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_shared
								+ REPAYINFO_SHARECREDITLIMITAMOUNT;

						if (REPAYINFO_SCHEDULEDPAYMENTAMOUNT >= REPAYINFO_ACTUALPAYMENTAMOUNT * 0.95
								&& REPAYINFO_SCHEDULEDPAYMENTAMOUNT <= REPAYINFO_ACTUALPAYMENTAMOUNT * 1.05
								&& REPAYINFO_USEDCREDITLIMITAMOUNT >= REPAYINFO_ACTUALPAYMENTAMOUNT * 0.95
								&& REPAYINFO_USEDCREDITLIMITAMOUNT <= REPAYINFO_ACTUALPAYMENTAMOUNT * 1.05) {
							LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_used = LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_used
									+ REPAYINFO_SCHEDULEDPAYMENTAMOUNT;
						} else {
							LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_used = LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_used
									+ REPAYINFO_USEDCREDITLIMITAMOUNT;
						}
					}
					// CNT_ACCOUNT_CARD_DALIAN 贷记卡使用张数
					if (Math.max(REPAYINFO_USEDCREDITLIMITAMOUNT,
							REPAYINFO_LATEST6MONTHUSEDAVGAMOUNT) > 300) {
						CNT_ACCOUNT_CARD_DALIAN++;
					}

					/**
					 * 特殊交易信息 SPECIALTRADELIST
					 */
					// CNT_ACCOUNT_CARD_ABNORMAL_DB 贷记卡、准贷记卡当前状态为担保人代偿以资抵债账户数
					for (int i = 0; i < SPECIALTRADELIST.size(); i++) {
						String SPECIALTRADELIST_TYPE = MapUtils
								.getStringFromMap(
										(Map) ArrayUtils.getObjectFromList(
												SPECIALTRADELIST, i),
										AwardCreditInfoEnum.SPECIALTRADELIST_TYPE.field);
						if (SPECIALTRADELIST_TYPE
								.equals(DictAwardCreditInfo.SPECIALTRADELIST_TYPE_DBRDH)
								| SPECIALTRADELIST_TYPE
										.equals(DictAwardCreditInfo.SPECIALTRADELIST_TYPE_YZDZ)) {
							CNT_ACCOUNT_CARD_ABNORMAL_DB++;
						}
					}

					// 账龄≥n个月且从未逾期的贷记卡账户数
					Integer CNT_NODU_ACCOUNT_CARD_AGE6_IS = 1;
					Integer CNT_NODU_ACCOUNT_CARD_AGE12_IS = 1;
					// 逾期账户数计算
					Integer CNT_ODU_ACCOUNT_CARD_IN3M_IS = 0;
					Integer CNT_ODU_ACCOUNT_CARD_IN6M_IS = 0;
					Integer CNT_ODU_ACCOUNT_CARD_IN12M_IS = 0;
					Integer CNT_ODU_ACCOUNT_CARD_IN24M_IS = 0;
					Integer CNT_ODU_ACCOUNT_CARD_IN24M_MAX_TEMP = 0;
					Integer CNT_MAX_LOAN_ACCOUNT_CARD_IN6M_TEMP = 0;
					Integer CNT_ACCT_CARD_M3_IS = 0;
					Integer CNT_ACCT_LOAN_M2E_IN3M_IS = 0;
					Integer CNT_ACCT_LOAN_M2E_IN6M_IS = 0;
					Integer CNT_ACCT_CARD_M2E_IN6M_TEMP = 0;
					Integer CNT_ACCT_CARD_M2E_IN12M_TEMP = 0;
					Integer CNT_ACCT_CARD_M3_IN24M_TEMP = 0;
					Integer CNT_ACCT_CARD_M3_OUT24M_TEMP = 0;

					Integer CNT_ACCT_CARD_M2E_IN6M_2TP_TEMP = 0;
					Integer CNT_ACCT_CARD_M2E_IN6M_2TP_COUNT = 0;
					Integer CNT_ACCT_CARD_M2E_IN12M_3TP_TEMP = 0;
					Integer CNT_ACCT_CARD_M2E_IN12M_3TP_COUNT = 0;
					Integer CNT_ACCT_CARD_M1E_IN12M_6TP_TEMP = 0;
					Integer CNT_ACCT_CARD_M1E_IN12M_6TP_COUNT = 0;

					for (int i = 0; i < OVERDUERECORDLIST.size(); i++) {
						String OVERDUERECORDLIST_REPAYMENTSTATUS = MapUtils
								.getStringFromMap(
										(Map) ArrayUtils.getObjectFromList(
												OVERDUERECORDLIST, i),
										AwardCreditInfoEnum.OVERDUERECORDLIST_REPAYMENTSTATUS.field);
						Integer ReportCreateTime_OVERDUERECORDLIST_MONTH_diff;
						try {
							ReportCreateTime_OVERDUERECORDLIST_MONTH_diff = DateUtils
									.getdateDiffMonth(
											pbocBaseInfoPO
													.getReportCreateTime(),
											MapUtils.getStringFromMap(
													(Map) OVERDUERECORDLIST
															.get(i),
													AwardCreditInfoEnum.OVERDUERECORDLIST_MONTH.field),
											DateUtils.DATE_FORMAT_3,
											DateUtils.DATE_FORMAT_5);
						} catch (Exception e) {
							log.error(
									"日期计算错误错误，跳过当前记录处理，错误记录ReportCreateTime_OVERDUERECORDLIST_MONTH_diff为{}",
									(Map) OVERDUERECORDLIST.get(i));
							continue;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff < 0) {
							log.error(
									"日期存在问题,错误日期为{},计算时间差为{}",
									MapUtils.getStringFromMap(
											(Map) OVERDUERECORDLIST.get(i),
											AwardCreditInfoEnum.OVERDUERECORDLIST_MONTH.field),
									ReportCreateTime_OVERDUERECORDLIST_MONTH_diff);
							continue;
						}
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							/**
							 * 账龄≥n个月且从未逾期的贷记卡账户数
							 */
							CNT_NODU_ACCOUNT_CARD_AGE6_IS = 0;
							CNT_NODU_ACCOUNT_CARD_AGE12_IS = 0;
						}
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_2TOZ
								.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 贷记卡账户出现过M2+逾期次数
							 */
							CNT_ODU_ACCOUNT_CARD_M2++;
						}
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 贷记卡账户出现过M3+逾期次数
							 */
							CNT_ODU_ACCOUNT_CARD_M3++;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 3
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 最近3个月贷记卡逾期账户数
							 */
							CNT_ODU_ACCOUNT_CARD_IN3M_IS = 1;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 最近6个月贷记卡逾期账户数
							 */
							CNT_ODU_ACCOUNT_CARD_IN6M_IS = 1;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 最近12个月贷记卡逾期账户数
							 */
							CNT_ODU_ACCOUNT_CARD_IN12M_IS = 1;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 24
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 最近24个月贷记卡逾期账户数
							 */
							CNT_ODU_ACCOUNT_CARD_IN24M_IS = 1;
						}
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 历史存在逾期3期及以上贷记卡账户数
							 */
							CNT_ACCT_CARD_M3_IS = 1;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 3
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_2
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 近3个月存在逾期2期的贷记卡账户数
							 */
							CNT_ACCT_LOAN_M2E_IN3M_IS = 1;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_2
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 近3个月存在逾期2期的贷记卡账户数
							 */
							CNT_ACCT_LOAN_M2E_IN6M_IS = 1;
						}

						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 24
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 最近24个月贷记卡账户最大逾期次数
							 */
							CNT_ODU_ACCOUNT_CARD_IN24M_MAX_TEMP++;
						}
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 贷记卡账户最高逾期期数
							 */
							if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TO7
									.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
								MONTH_ODU_ACCOUNT_CARD_MAX = Math
										.max(MONTH_ODU_ACCOUNT_CARD_MAX,
												Integer.valueOf(OVERDUERECORDLIST_REPAYMENTSTATUS));
							}
							if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_GTOZ
									.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
								MONTH_ODU_ACCOUNT_CARD_MAX = Math.max(
										MONTH_ODU_ACCOUNT_CARD_MAX, 7);
							}
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 24
								&& (!OVERDUERECORDLIST_REPAYMENTSTATUS
										.isEmpty() && !DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_Other
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS))) {
							/**
							 * 人行征信信用卡信息24个月内存在更新
							 */
							IF_CARD_REPORT_UPDATE_IN24MONTH = false;
						}
						/**
						 * 距最近一次贷记卡账户逾期的月数
						 */
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.length()
								- DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
										.replace(
												OVERDUERECORDLIST_REPAYMENTSTATUS,
												new String()).length() > 0) {
							MONTH_ODU_ACCOUNT_CARD = Math
									.min(MONTH_ODU_ACCOUNT_CARD,
											ReportCreateTime_OVERDUERECORDLIST_MONTH_diff);
						}
						/**
						 * 最近3个月贷记卡账户逾期2期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 3
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_2
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M2E_IN3M++;
						}
						/**
						 * 最近6个月贷记卡账户逾期3期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_CARD_M3_IN6M++;
						}
						/**
						 * 最近6个月贷记卡账户逾期4期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_4TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_CARD_M4_IN6M++;
						}
						/**
						 * 最近6个月贷记卡账户逾期5期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_5TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_CARD_M5_IN6M++;
						}
						/**
						 * 最近6个月贷记卡账户逾期1期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M1E_IN6M++;
						}
						/**
						 * 最近6个月贷记卡账户逾期2期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_2
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M2E_IN6M++;
							CNT_ACCT_CARD_M2E_IN6M_2TP_COUNT++;
						}
						/**
						 * 最近6个月贷记卡账户逾期3期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M3E_IN6M++;
						}
						/**
						 * 最近6个月贷记卡账户逾期4期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_4
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M4E_IN6M++;
						}
						/**
						 * 最近6个月贷记卡账户逾期5期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_5
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M5E_IN6M++;
						}
						/**
						 * 近6个月贷记卡账户逾期1期及以上的次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M1_IN6M++;

						}

						/**
						 * 最近12个月贷记卡账户逾期1期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M1E_IN12M++;
							CNT_ACCT_CARD_M1E_IN12M_6TP_COUNT++;

						}
						/**
						 * 最近12个月贷记卡账户逾期2期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_2
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M2E_IN12M++;
							CNT_ACCT_CARD_M2E_IN12M_TEMP = 1;
							CNT_ACCT_CARD_M2E_IN12M_3TP_COUNT++;

						}
						/**
						 * 最近12个月贷记卡账户逾期3期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M3E_IN12M++;
						}
						/**
						 * 最近12个月贷记卡账户逾期4期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_4
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M4E_IN12M++;
						}
						/**
						 * 最近12个月贷记卡账户逾期5期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_5
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_CARD_M5E_IN12M++;
						}
						/**
						 * 最近12个月贷记卡账户逾期3期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_CARD_M3_IN12M++;
						}
						/**
						 * 最近12个月贷记卡账户逾期4期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_4TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_CARD_M4_IN12M++;
						}
						/**
						 * 最近12个月贷记卡账户逾期5期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_5TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_CARD_M5_IN12M++;
						}
						/**
						 * 最近24个月贷记卡账户逾期3期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 24
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_CARD_M3_IN24M++;
							CNT_ACCT_CARD_M3_IN24M_TEMP = 1;
						}
						/**
						 * 贷记卡单卡近6个月累计最高逾期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_MAX_LOAN_ACCOUNT_CARD_IN6M_TEMP++;
						}
						/**
						 * 24个月以外贷记卡账户逾期3期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff > 24
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_CARD_M3_OUT24M++;
							// 24个月以外逾期3期及以上的贷记卡账户数
							CNT_ACCT_CARD_M3_OUT24M_TEMP = 1;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 24
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							// 近24个月贷记卡账户逾期1期及以上的次数
							CNT_ODU_ACCOUNT_CARD_M1_IN24M++;

						}
						/**
						 * 近6个月存在逾期2期记录的贷记卡账户数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_2
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ACCT_CARD_M2E_IN6M_TEMP = 1;
						}
					}
					/**
					 * 近6个月存在逾期2期记录大于等于2次的贷记卡账户数
					 */
					if (CNT_ACCT_CARD_M2E_IN6M_2TP_COUNT >= 2) {
						CNT_ACCT_CARD_M2E_IN6M_2TP_TEMP = 1;
					}
					CNT_ACCT_CARD_M2E_IN6M_2TP = CNT_ACCT_CARD_M2E_IN6M_2TP
							+ CNT_ACCT_CARD_M2E_IN6M_2TP_TEMP;
					/**
					 * 近12个月存在逾期2期记录大于等于3次的贷记卡账户数
					 */
					if (CNT_ACCT_CARD_M2E_IN12M_3TP_COUNT >= 3) {
						CNT_ACCT_CARD_M2E_IN12M_3TP_TEMP = 1;
					}
					CNT_ACCT_CARD_M2E_IN12M_3TP = CNT_ACCT_CARD_M2E_IN12M_3TP
							+ CNT_ACCT_CARD_M2E_IN12M_3TP_TEMP;
					/**
					 * 近12个月存在逾期1期记录大于等于6次的贷记卡账户数
					 */
					if (CNT_ACCT_CARD_M1E_IN12M_6TP_COUNT >= 6) {
						CNT_ACCT_CARD_M1E_IN12M_6TP_TEMP = 1;
					}
					CNT_ACCT_CARD_M1E_IN12M_6TP = CNT_ACCT_CARD_M1E_IN12M_6TP
							+ CNT_ACCT_CARD_M1E_IN12M_6TP_TEMP;

					/**
					 * 最近3个月贷记卡逾期账户数
					 */
					CNT_ODU_ACCOUNT_CARD_IN3M = CNT_ODU_ACCOUNT_CARD_IN3M
							+ CNT_ODU_ACCOUNT_CARD_IN3M_IS;
					/**
					 * 最近6个月贷记卡逾期账户数
					 */
					CNT_ODU_ACCOUNT_CARD_IN6M = CNT_ODU_ACCOUNT_CARD_IN6M
							+ CNT_ODU_ACCOUNT_CARD_IN6M_IS;
					/**
					 * 最近12个月贷记卡逾期账户数
					 */
					CNT_ODU_ACCOUNT_CARD_IN12M = CNT_ODU_ACCOUNT_CARD_IN12M
							+ CNT_ODU_ACCOUNT_CARD_IN12M_IS;
					/**
					 * 最近24个月贷记卡逾期账户数
					 */
					CNT_ODU_ACCOUNT_CARD_IN24M = CNT_ODU_ACCOUNT_CARD_IN24M
							+ CNT_ODU_ACCOUNT_CARD_IN24M_IS;
					/**
					 * 历史存在逾期3期及以上贷记卡账户数
					 */
					CNT_ACCT_CARD_M3 = CNT_ACCT_CARD_M3 + CNT_ACCT_CARD_M3_IS;
					/**
					 * 近3个月存在逾期2期的贷记卡账户数
					 */
					CNT_ACCT_LOAN_M2E_IN3M = CNT_ACCT_LOAN_M2E_IN3M
							+ CNT_ACCT_LOAN_M2E_IN3M_IS;
					/**
					 * 近6个月存在逾期2期记录的贷记卡账户数
					 */
					CNT_ACCT_LOAN_M2E_IN6M = CNT_ACCT_LOAN_M2E_IN6M
							+ CNT_ACCT_LOAN_M2E_IN6M_IS;
					/**
					 * 近12个月存在逾期2期记录的贷记卡账户数
					 */
					CNT_ACCT_CARD_M2E_IN12M = CNT_ACCT_CARD_M2E_IN12M
							+ CNT_ACCT_CARD_M2E_IN12M_TEMP;
					/**
					 * 最近24个月贷记卡账户最大逾期次数
					 */
					CNT_ODU_ACCOUNT_CARD_IN24M_MAX = Math.max(
							CNT_ODU_ACCOUNT_CARD_IN24M_MAX,
							CNT_ODU_ACCOUNT_CARD_IN24M_MAX_TEMP);
					/**
					 * 账龄≥6个月且从未逾期的贷记卡账户数
					 */
					if (OPENDATEDiffMonth >= 6) {
						CNT_NODU_ACCOUNT_CARD_AGE6 = CNT_NODU_ACCOUNT_CARD_AGE6
								+ CNT_NODU_ACCOUNT_CARD_AGE6_IS;
					}
					/**
					 * 账龄≥12个月且从未逾期的贷记卡账户数
					 */
					if (OPENDATEDiffMonth >= 12) {
						CNT_NODU_ACCOUNT_CARD_AGE12 = CNT_NODU_ACCOUNT_CARD_AGE12
								+ CNT_NODU_ACCOUNT_CARD_AGE12_IS;
					}
					/**
					 * 贷记卡单卡近6个月累计最高逾期次数
					 */
					CNT_MAX_LOAN_ACCOUNT_CARD_IN6M = Math.max(
							CNT_MAX_LOAN_ACCOUNT_CARD_IN6M,
							CNT_MAX_LOAN_ACCOUNT_CARD_IN6M_TEMP);
					/**
					 * 近6个月存在逾期2期记录的贷记卡账户数
					 */
					CNT_ACCT_CARD_M2E_IN6M = CNT_ACCT_CARD_M2E_IN6M
							+ CNT_ACCT_CARD_M2E_IN6M_TEMP;
					/**
					 * 近24个月逾期3期及以上的贷记卡账户数
					 */
					CNT_ACCT_CARD_M3_IN24M = CNT_ACCT_CARD_M3_IN24M
							+ CNT_ACCT_CARD_M3_IN24M_TEMP;
					/**
					 * 24个月以外逾期3期及以上的贷记卡账户数
					 */
					CNT_ACCT_CARD_M3_OUT24M = CNT_ACCT_CARD_M3_OUT24M
							+ CNT_ACCT_CARD_M3_OUT24M_TEMP;
					/**
					 * 总额度与已使用额度计算
					 */
					Integer TEMP_CREDITLIMITAMOUNT = CREDITLIMITAMOUNT;
					Integer TEMP_USED_CREDITLIMITAMOUNT = REPAYINFO_USEDCREDITLIMITAMOUNT;
					log.debug(
							"当前账户额度：{},当前账户已使用额度：{},当前账户累计额度为：{},累计已使用额度为：{}",
							TEMP_CREDITLIMITAMOUNT,
							TEMP_USED_CREDITLIMITAMOUNT,
							LV_CREDLIMIT_NORMAL_CARD_TOTAL_LIMIT,
							LV_CREDLIMIT_NORMAL_CARD_USED_LIMIT);
					// 额度使用率≥n%的贷记卡账户数
					if (TEMP_CREDITLIMITAMOUNT > 0) {
						if (TEMP_USED_CREDITLIMITAMOUNT * 1.0
								/ TEMP_CREDITLIMITAMOUNT * 1.0 >= 0.8) {
							/**
							 * 额度使用率≥80%的贷记卡账户数
							 */
							CNT_ACCOUNT_CARD_LV80++;
						}
					}
				}
				/**
				 * 准贷记卡
				 */
				if (MapUtils.getStringFromMap(map,
						AwardCreditInfoEnum.TYPE.field).equals(
						DictAwardCreditInfo.type_R3)) {
					log.debug("开始准贷记卡指标计算：begin");
					if (REPAYINFO_CURROVERDUECYC > 0
							&& DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_3TOZ
									.contains(LATESTPERFORMANCE_REPAYMENTTYPE)) {
						/**
						 * 准贷记卡当前逾期的账户数
						 */
						CNT_ACCOUNT_SCARD_ODU_NOW++;
						/**
						 * 准贷记卡当前存在逾期且金额大于等于100元的次数
						 */
						if (REPAYINFO_CURROVERDUEAMOUNT >= 100) {
							CNT_ODU_ACCOUNT_SCARD_AMT100++;
						}
						/**
						 * 准贷记卡当前存在逾期且金额大于等于500元的次数
						 */
						if (REPAYINFO_CURROVERDUEAMOUNT >= 500) {
							CNT_ODU_ACCOUNT_SCARD_AMT500++;
						}
					}
					/**
					 * 准贷记卡账户最长账龄（月）
					 */
					MONTH_AGE_SCARD = Math.max(MONTH_AGE_SCARD,
							OPENDATEDiffMonth);
					// 账龄≥n个月且状态正常的准贷记账户数
					if (ACCOUNTSTATE
							.equals(DictAwardCreditInfo.accountState_12)
							| (ACCOUNTSTATE.isEmpty() && LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_12))) {
						/**
						 * 账龄≥12个月且状态正常的准贷记账户数
						 */
						if (OPENDATEDiffMonth >= 12) {
							CNT_ACCOUNT_NORMAL_SCARD_AGE12++;
						}
						/**
						 * 账龄≥24个月且状态正常的准贷记账户数
						 */
						if (OPENDATEDiffMonth >= 24) {
							CNT_ACCOUNT_NORMAL_SCARD_AGE24++;
						}
						/**
						 * 状态正常的准贷记卡账户最长账龄（月）
						 */
						MONTH_AGE_NORMAL_SCARD = Math.max(
								MONTH_AGE_NORMAL_SCARD, OPENDATEDiffMonth);
					}
					/**
					 * 核准记录数
					 */
					if (OPENDATEDiffMonth <= 6) {
						/**
						 * 近6个月准贷记卡核准记录数
						 */
						CNT_SCARD_APPROVE_IN6M++;
					}
					if (OPENDATEDiffMonth <= 3) {
						/**
						 * 近3个月准贷记卡核准记录数
						 */
						CNT_SCARD_APPROVE_IN3M++;
					}

					/**
					 * 高风险状态的贷记卡账户数（冻结、止付、银行止付、呆账、司法追偿）
					 */
					if ((ACCOUNTSTATE
							.equals(DictAwardCreditInfo.accountState_3)
							| ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_2)
							| ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_31)
							| ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_5) | ACCOUNTSTATE
								.equals(DictAwardCreditInfo.accountState_8))
							&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty()
									| LATESTPERFORMANCE_ACCOUNTSTATE
											.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_11)
									| LATESTPERFORMANCE_ACCOUNTSTATE
											.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_10)
									| LATESTPERFORMANCE_ACCOUNTSTATE
											.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_11YH)
									| LATESTPERFORMANCE_ACCOUNTSTATE
											.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_DZ) | LATESTPERFORMANCE_ACCOUNTSTATE
										.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_8))) {
						CNT_ACCOUNT_SCARD_ABNORMAL++;
					}
					/**
					 * 早期风险预警
					 */
					if (REPAYINFO_CURROVERDUECYC == 1
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_1))) {
						/**
						 * 准贷记卡当前状态为逾期M1的逾期金额
						 */
						AMT_ACCOUNT_SCARD_M1E = AMT_ACCOUNT_SCARD_M1E
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUECYC == 2
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_2))) {
						/**
						 * 准贷记卡当前状态为逾期M2的逾期金额
						 */
						AMT_ACCOUNT_SCARD_M2E = AMT_ACCOUNT_SCARD_M2E
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUECYC == 3
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_3))) {
						/**
						 * 准贷记卡当前状态为逾期M3的逾期金额
						 */
						AMT_ACCOUNT_SCARD_M3E = AMT_ACCOUNT_SCARD_M3E
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUECYC == 4
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_4))) {
						/**
						 * 准贷记卡当前状态为逾期M4的逾期金额
						 */
						AMT_ACCOUNT_SCARD_M4E = AMT_ACCOUNT_SCARD_M4E
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUECYC >= 4
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_4TOZ))) {
						/**
						 * 准贷记卡当前状态为逾期M4+的逾期金额
						 */
						AMT_ACCOUNT_SCARD_M4 = AMT_ACCOUNT_SCARD_M4
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUECYC >= 5
							&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
									.equals(DictAwardCreditInfo.LATESTPERFORMANCE_REPAYMENTTYPE_5TOZ))) {
						/**
						 * 准贷记卡当前状态为逾期M5+的逾期金额
						 */
						AMT_ACCOUNT_SCARD_M5 = AMT_ACCOUNT_SCARD_M5
								+ REPAYINFO_CURROVERDUEAMOUNT;
					}
					if (REPAYINFO_CURROVERDUEAMOUNT >= 300
							&& ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_3)
							&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty() | LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_11))) {
						/**
						 * 准贷记卡当前状态为止付且逾期金额在300元及以上的账户数
						 */
						CNT_ACCOUNT_SCARD_ABNORMAL_ZF_ODU300++;

					}
					if (REPAYINFO_CURROVERDUEAMOUNT >= 300
							&& ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_2)
							&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty() | LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_10))) {
						/**
						 * 准贷记卡当前状态为冻结且逾期金额在300元及以上的账户数
						 */
						CNT_ACCOUNT_SCARD_ABNORMAL_DJ_ODU300++;
					}
					if (REPAYINFO_CURROVERDUEAMOUNT >= 300
							&& ACCOUNTSTATE
									.equals(DictAwardCreditInfo.accountState_5)
							&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty() | LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictAwardCreditInfo.LASTESTPERFORMANCE_ACCOUNTSTATE_4))) {
						/**
						 * 准贷记卡当前状态为呆账且逾期金额在300元及以上的账户数
						 */
						CNT_ACCOUNT_SCARD_ABNORMAL_DZ_ODU300++;
					}
					/**
					 * 特殊交易信息 SPECIALTRADELIST
					 */
					// CNT_ACCOUNT_SCARD_ABNORMAL_DB 准贷记卡当前状态为担保人代偿以资抵债账户数
					for (int i = 0; i < SPECIALTRADELIST.size(); i++) {
						String SPECIALTRADELIST_TYPE = MapUtils
								.getStringFromMap(
										(Map) ArrayUtils.getObjectFromList(
												OVERDUERECORDLIST, i),
										AwardCreditInfoEnum.SPECIALTRADELIST_TYPE.field);
						if (SPECIALTRADELIST_TYPE
								.equals(DictAwardCreditInfo.SPECIALTRADELIST_TYPE_DBRDH)
								| SPECIALTRADELIST_TYPE
										.equals(DictAwardCreditInfo.SPECIALTRADELIST_TYPE_YZDZ)) {
							CNT_ACCOUNT_SCARD_ABNORMAL_DB++;
						}
					}

					// 账龄≥n个月且从未逾期的准贷记卡账户数
					Integer CNT_NODU_ACCOUNT_SCARD_AGE6_IS = 1;
					Integer CNT_NODU_ACCOUNT_SCARD_AGE12_IS = 1;
					// 逾期账户数计算
					Integer CNT_ODU_ACCOUNT_SCARD_IN3M_IS = 0;
					Integer CNT_ODU_ACCOUNT_SCARD_IN6M_IS = 0;
					Integer CNT_ODU_ACCOUNT_SCARD_IN12M_IS = 0;
					Integer CNT_ODU_ACCOUNT_SCARD_IN24M_IS = 0;
					Integer CNT_ACCT_SCARD_M3_IS = 0;
					Integer CNT_ODU_ACCOUNT_SCARD_IN24M_MAX_TEMP = 0;
					Integer CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M_TEMP = 0;
					Integer CNT_ACCT_SCARD_M3_IN24M_TEMP = 0;
					Integer CNT_ACCT_SCARD_M3_OUT24M_TEMP = 0;

					for (int i = 0; i < OVERDUERECORDLIST.size(); i++) {
						String OVERDUERECORDLIST_REPAYMENTSTATUS = MapUtils
								.getStringFromMap(
										(Map) ArrayUtils.getObjectFromList(
												OVERDUERECORDLIST, i),
										AwardCreditInfoEnum.OVERDUERECORDLIST_REPAYMENTSTATUS.field);
						Integer ReportCreateTime_OVERDUERECORDLIST_MONTH_diff;
						try {
							ReportCreateTime_OVERDUERECORDLIST_MONTH_diff = DateUtils
									.getdateDiffMonth(
											pbocBaseInfoPO
													.getReportCreateTime(),
											MapUtils.getStringFromMap(
													(Map) OVERDUERECORDLIST
															.get(i),
													AwardCreditInfoEnum.OVERDUERECORDLIST_MONTH.field),
											DateUtils.DATE_FORMAT_3,
											DateUtils.DATE_FORMAT_5);
						} catch (Exception e) {
							log.error(
									"日期计算错误错误，跳过当前记录处理，错误记录ReportCreateTime_OVERDUERECORDLIST_MONTH_diff为{}",
									(Map) OVERDUERECORDLIST.get(i));
							continue;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff < 0) {
							log.error(
									"日期存在问题,错误日期为{},计算时间差为{}",
									MapUtils.getStringFromMap(
											(Map) OVERDUERECORDLIST.get(i),
											AwardCreditInfoEnum.OVERDUERECORDLIST_MONTH.field),
									ReportCreateTime_OVERDUERECORDLIST_MONTH_diff);
							continue;
						}
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							/**
							 * 账龄≥N个月且从未逾期的准贷记卡账户数
							 */
							CNT_NODU_ACCOUNT_SCARD_AGE6_IS = 0;
							CNT_NODU_ACCOUNT_SCARD_AGE12_IS = 0;
						}
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 准贷记卡账户出现过M2+逾期次数
							 */
							CNT_ODU_ACCOUNT_SCARD_M2++;
						}
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 准贷记卡账户出现过M3+逾期次数
							 */
							CNT_ODU_ACCOUNT_SCARD_M3++;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 3
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 最近3个月准贷记卡逾期账户数
							 */
							CNT_ODU_ACCOUNT_SCARD_IN3M_IS = 1;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 最近6个月准贷记卡逾期账户数
							 */
							CNT_ODU_ACCOUNT_SCARD_IN6M_IS = 1;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 最近12个月准贷记卡逾期账户数
							 */
							CNT_ODU_ACCOUNT_SCARD_IN12M_IS = 1;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 24
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 最近24个月准贷记卡逾期账户数
							 */
							CNT_ODU_ACCOUNT_SCARD_IN24M_IS = 1;
						}
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 历史存在逾期3期及以上准贷记卡账户数
							 */
							CNT_ACCT_SCARD_M3_IS = 1;
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 24
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 最近24个月准贷记卡账户最大逾期次数
							 */
							CNT_ODU_ACCOUNT_SCARD_IN24M_MAX_TEMP++;
						}
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							/**
							 * 准贷记卡账户最高逾期期数
							 */
							if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TO7
									.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
								MONTH_ODU_ACCOUNT_SCARD_MAX = Math
										.max(MONTH_ODU_ACCOUNT_SCARD_MAX,
												Integer.valueOf(OVERDUERECORDLIST_REPAYMENTSTATUS));
							}
							if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_GTOZ
									.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
								MONTH_ODU_ACCOUNT_SCARD_MAX = Math.max(
										MONTH_ODU_ACCOUNT_SCARD_MAX, 7);
							}
						}
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 24
								&& (!OVERDUERECORDLIST_REPAYMENTSTATUS
										.isEmpty() && !DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_Other
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS))) {
							/**
							 * 人行征信准贷记卡信息24个月内是否无更新
							 */
							IF_SCARD_REPORT_UPDATE_IN24MONTH = false;
						}
						/**
						 * 距最近一次准贷记卡账户逾期的月数
						 */
						if (DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.length()
								- DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.replace(
												OVERDUERECORDLIST_REPAYMENTSTATUS,
												new String()).length() > 0) {
							MONTH_ODU_ACCOUNT_SCARD = Math
									.min(MONTH_ODU_ACCOUNT_SCARD,
											ReportCreateTime_OVERDUERECORDLIST_MONTH_diff);
						}
						/**
						 * 最近3个月准贷记卡账户逾期2期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 3
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_2
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M2E_IN3M++;
						}
						/**
						 * 最近6个月准贷记卡账户逾期3期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_SCARD_M3_IN6M++;
						}
						/**
						 * 最近6个月准贷记卡账户逾期4期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_4TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_SCARD_M4_IN6M++;
						}
						/**
						 * 最近6个月准贷记卡账户逾期5期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_5TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_SCARD_M5_IN6M++;
						}
						/**
						 * 最近12个月准贷记卡账户逾期1期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M1E_IN12M++;
						}
						/**
						 * 最近6个月准贷记卡账户逾期1期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_1
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M1E_IN6M++;
						}
						/**
						 * 最近6个月准贷记卡账户逾期2期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_2
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M2E_IN6M++;
						}
						/**
						 * 最近6个月准贷记卡账户逾期3期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M3E_IN6M++;
						}
						/**
						 * 最近6个月准贷记卡账户逾期4期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_4
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M4E_IN6M++;
						}
						/**
						 * 最近6个月准贷记卡账户逾期5期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_5
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M5E_IN6M++;
						}
						/**
						 * 最近12个月准贷记卡账户逾期2期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_2
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M2E_IN12M++;
						}
						/**
						 * 最近12个月准贷记卡账户逾期3期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M3E_IN12M++;
						}
						/**
						 * 最近12个月准贷记卡账户逾期4期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_4
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M4E_IN12M++;
						}
						/**
						 * 最近12个月准贷记卡账户逾期5期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_5
										.equals(OVERDUERECORDLIST_REPAYMENTSTATUS)) {
							CNT_ODU_ACCOUNT_SCARD_M5E_IN12M++;
						}
						/**
						 * 最近12个月准贷记卡账户逾期3期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_SCARD_M3_IN12M++;
						}
						/**
						 * 最近12个月准贷记卡账户逾期4期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_4TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_SCARD_M4_IN12M++;
						}
						/**
						 * 最近12个月准贷记卡账户逾期5期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 12
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_5TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_SCARD_M5_IN12M++;
						}
						/**
						 * 最近24个月准贷记卡账户逾期3期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 24
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_SCARD_M3_IN24M++;
							// 近24个月逾期3期及以上的准贷记卡账户数
							CNT_ACCT_SCARD_M3_IN24M_TEMP = 1;
						}
						/**
						 * 24个月以外准贷记卡账户逾期3期及以上次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff > 24
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_ODU_ACCOUNT_SCARD_M3_OUT24M++;
							CNT_ACCT_SCARD_M3_OUT24M_TEMP = 1;
						}
						/**
						 * 准贷记卡单卡近6个月累计最高逾期次数
						 */
						if (ReportCreateTime_OVERDUERECORDLIST_MONTH_diff <= 6
								&& DictAwardCreditInfo.OVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
										.contains(OVERDUERECORDLIST_REPAYMENTSTATUS)
								&& !OVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
							CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M_TEMP++;
						}
					}
					/**
					 * 最近3个月准贷记卡逾期账户数
					 */
					CNT_ODU_ACCOUNT_SCARD_IN3M = CNT_ODU_ACCOUNT_SCARD_IN3M
							+ CNT_ODU_ACCOUNT_SCARD_IN3M_IS;
					/**
					 * 最近6个月准贷记卡逾期账户数
					 */
					CNT_ODU_ACCOUNT_SCARD_IN6M = CNT_ODU_ACCOUNT_SCARD_IN6M
							+ CNT_ODU_ACCOUNT_SCARD_IN6M_IS;
					/**
					 * 最近12个月准贷记卡逾期账户数
					 */
					CNT_ODU_ACCOUNT_SCARD_IN12M = CNT_ODU_ACCOUNT_SCARD_IN12M
							+ CNT_ODU_ACCOUNT_SCARD_IN12M_IS;
					/**
					 * 最近24个月准贷记卡逾期账户数
					 */
					CNT_ODU_ACCOUNT_SCARD_IN24M = CNT_ODU_ACCOUNT_SCARD_IN24M
							+ CNT_ODU_ACCOUNT_SCARD_IN24M_IS;
					/**
					 * 历史存在逾期3期及以上准贷记卡账户数
					 */
					CNT_ACCT_SCARD_M3 = CNT_ACCT_SCARD_M3
							+ CNT_ACCT_SCARD_M3_IS;
					/**
					 * 最近24个月准贷记卡账户最大逾期次数
					 */
					CNT_ODU_ACCOUNT_SCARD_IN24M_MAX = Math.max(
							CNT_ODU_ACCOUNT_SCARD_IN24M_MAX,
							CNT_ODU_ACCOUNT_SCARD_IN24M_MAX_TEMP);
					/**
					 * 账龄≥6个月且从未逾期的准贷记卡账户数
					 */
					if (OPENDATEDiffMonth >= 6) {
						CNT_NODU_ACCOUNT_SCARD_AGE6 = CNT_NODU_ACCOUNT_SCARD_AGE6
								+ CNT_NODU_ACCOUNT_SCARD_AGE6_IS;
					}
					/**
					 * 账龄≥12个月且从未逾期的准贷记卡账户数
					 */
					if (OPENDATEDiffMonth >= 12) {
						CNT_NODU_ACCOUNT_SCARD_AGE12 = CNT_NODU_ACCOUNT_SCARD_AGE12
								+ CNT_NODU_ACCOUNT_SCARD_AGE12_IS;
					}
					/**
					 * 准贷记卡单卡近6个月累计最高逾期次数
					 */
					CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M = Math.max(
							CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M,
							CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M_TEMP);
					/**
					 * 近24个月逾期3期及以上的准贷记卡账户数
					 */
					CNT_ACCT_SCARD_M3_IN24M = CNT_ACCT_SCARD_M3_IN24M
							+ CNT_ACCT_SCARD_M3_IN24M_TEMP;
					/**
					 * 24个月以外逾期3期及以上的准贷记卡账户数
					 */
					CNT_ACCT_SCARD_M3_OUT24M = CNT_ACCT_SCARD_M3_OUT24M
							+ CNT_ACCT_SCARD_M3_OUT24M_TEMP;

					/**
					 * 准贷记卡总额度与已使用额度计算
					 */
					Integer TEMP_CREDITLIMITAMOUNT = CREDITLIMITAMOUNT;
					Integer TEMP_USED_CREDITLIMITAMOUNT = REPAYINFO_USEDCREDITLIMITAMOUNT;
					LV_CREDLIMIT_NORMAL_SCARD_TOTAL_LIMIT = LV_CREDLIMIT_NORMAL_SCARD_TOTAL_LIMIT
							+ TEMP_CREDITLIMITAMOUNT;
					LV_CREDLIMIT_NORMAL_SCARD_USED_LIMIT = LV_CREDLIMIT_NORMAL_SCARD_USED_LIMIT
							+ +TEMP_USED_CREDITLIMITAMOUNT;
					log.debug(
							"当前账户额度：{},当前账户已使用额度：{},当前账户累计额度为：{},累计已使用额度为：{}",
							TEMP_CREDITLIMITAMOUNT,
							TEMP_USED_CREDITLIMITAMOUNT,
							LV_CREDLIMIT_NORMAL_SCARD_TOTAL_LIMIT,
							LV_CREDLIMIT_NORMAL_SCARD_USED_LIMIT);
					// 额度使用率≥n%的准贷记卡账户数
					if (TEMP_CREDITLIMITAMOUNT > 0) {
						if (TEMP_USED_CREDITLIMITAMOUNT * 1.0
								/ TEMP_CREDITLIMITAMOUNT * 1.0 >= 0.8) {
							/**
							 * 额度使用率≥80%的准贷记卡账户数
							 */
							CNT_ACCOUNT_SCARD_LV80++;
						}
					}
				}
			}
			// 有效他行卡-单卡额度
			if (COUNT_currency == 1) {
				CRED_LIMIT_OBANK_ONE = CREDITLIMITAMOUNT;
			} else {
				CRED_LIMIT_OBANK_ONE = -1;
			}
			// 有效他行卡-双卡额度
			if (COUNT_currency == 2) {
				CRED_LIMIT_OBANK_DOUBLE = ArrayUtils.getDoubleAmount(
						CREDITLIMITAMOUNT_LIST, OPENDATEDiffMonth_LIST);

			} else {
				CRED_LIMIT_OBANK_DOUBLE = -1;
			}
			// 有效他行卡-多卡额度（众数）
			if (COUNT_currency >= 3) {
				CRED_LIMIT_OBANK_MULTI_MODE = ArrayUtils.getManyCardAmount(
						CREDITLIMITAMOUNT_LIST, COUNT_currency);

			} else {
				CRED_LIMIT_OBANK_MULTI_MODE = -1;
			}
			// 有效他行卡-多卡额度（中位数）
			if (COUNT_currency >= 3) {
				CRED_LIMIT_OBANK_MULTI_MEDIAN = ArrayUtils
						.getManyCardAmountMedian(CREDITLIMITAMOUNT_LIST,
								COUNT_currency);

			} else {
				CRED_LIMIT_OBANK_MULTI_MEDIAN = -1;
			}
		}
		/**
		 * 指标二次计算
		 */
		// 非本行名下所有贷记卡真实使用额度
		if (LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_shared > 0) {
			LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK = LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_used
					* 1.0
					/ LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK_temp_shared;
		}

		// 逾期基本信息
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_CARD_ODU_NOW.field,
				CNT_ACCOUNT_CARD_ODU_NOW,
				PbocLabelEnum.CNT_ACCOUNT_CARD_ODU_NOW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_SCARD_ODU_NOW.field,
				CNT_ACCOUNT_SCARD_ODU_NOW,
				PbocLabelEnum.CNT_ACCOUNT_SCARD_ODU_NOW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_CARD_ODU_NOW_MAXAMT.field,
				CNT_ACCOUNT_CARD_ODU_NOW_MAXAMT,
				PbocLabelEnum.CNT_ACCOUNT_CARD_ODU_NOW_MAXAMT.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_CARD_ABNORMAL.field,
				CNT_ACCOUNT_CARD_ABNORMAL,
				PbocLabelEnum.CNT_ACCOUNT_CARD_ABNORMAL.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_SCARD_ABNORMAL.field,
				CNT_ACCOUNT_SCARD_ABNORMAL,
				PbocLabelEnum.CNT_ACCOUNT_SCARD_ABNORMAL.fieldDesc);
		// 账龄相关指标
		pbocRspPO.addIndex(PbocLabelEnum.CNT_NODU_ACCOUNT_CARD_AGE6.field,
				CNT_NODU_ACCOUNT_CARD_AGE6,
				PbocLabelEnum.CNT_NODU_ACCOUNT_CARD_AGE6.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_NODU_ACCOUNT_CARD_AGE12.field,
				CNT_NODU_ACCOUNT_CARD_AGE12,
				PbocLabelEnum.CNT_NODU_ACCOUNT_CARD_AGE12.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_CARD_AGE12.field,
				CNT_ACCOUNT_NORMAL_CARD_AGE12,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_CARD_AGE12.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_CARD_AGE24.field,
				CNT_ACCOUNT_NORMAL_CARD_AGE24,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_CARD_AGE24.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_AGE_CARD.field, MONTH_AGE_CARD,
				PbocLabelEnum.MONTH_AGE_CARD.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_AGE_NORMAL_CARD.field,
				MONTH_AGE_NORMAL_CARD,
				PbocLabelEnum.MONTH_AGE_NORMAL_CARD.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_NODU_ACCOUNT_SCARD_AGE6.field,
				CNT_NODU_ACCOUNT_SCARD_AGE6,
				PbocLabelEnum.CNT_NODU_ACCOUNT_SCARD_AGE6.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_NODU_ACCOUNT_SCARD_AGE12.field,
				CNT_NODU_ACCOUNT_SCARD_AGE12,
				PbocLabelEnum.CNT_NODU_ACCOUNT_SCARD_AGE12.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_SCARD_AGE12.field,
				CNT_ACCOUNT_NORMAL_SCARD_AGE12,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_SCARD_AGE12.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_SCARD_AGE24.field,
				CNT_ACCOUNT_NORMAL_SCARD_AGE24,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_SCARD_AGE24.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_AGE_SCARD.field,
				MONTH_AGE_SCARD, PbocLabelEnum.MONTH_AGE_SCARD.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_AGE_NORMAL_SCARD.field,
				MONTH_AGE_NORMAL_SCARD,
				PbocLabelEnum.MONTH_AGE_NORMAL_SCARD.fieldDesc);

		// 月数相关指标
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_ODU_ACCOUNT_CARD.field,
				MONTH_ODU_ACCOUNT_CARD,
				PbocLabelEnum.MONTH_ODU_ACCOUNT_CARD.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_ODU_ACCOUNT_SCARD.field,
				MONTH_ODU_ACCOUNT_SCARD,
				PbocLabelEnum.MONTH_ODU_ACCOUNT_SCARD.fieldDesc);

		// 逾期账户数相关指标
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_IN3M.field,
				CNT_ODU_ACCOUNT_CARD_IN3M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_IN6M.field,
				CNT_ODU_ACCOUNT_CARD_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_IN12M.field,
				CNT_ODU_ACCOUNT_CARD_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_IN24M.field,
				CNT_ODU_ACCOUNT_CARD_IN24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_IN24M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_CARD_M3.field,
				CNT_ACCT_CARD_M3, PbocLabelEnum.CNT_ACCT_CARD_M3.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN3M.field,
				CNT_ACCT_LOAN_M2E_IN3M,
				PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN6M.field,
				CNT_ACCT_LOAN_M2E_IN6M,
				PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_IN24M_MAX.field,
				CNT_ODU_ACCOUNT_CARD_IN24M_MAX,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_IN24M_MAX.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_IN3M.field,
				CNT_ODU_ACCOUNT_SCARD_IN3M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_IN6M.field,
				CNT_ODU_ACCOUNT_SCARD_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_IN12M.field,
				CNT_ODU_ACCOUNT_SCARD_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_IN24M.field,
				CNT_ODU_ACCOUNT_SCARD_IN24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_IN24M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_SCARD_M3.field,
				CNT_ACCT_SCARD_M3, PbocLabelEnum.CNT_ACCT_SCARD_M3.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_IN24M_MAX.field,
				CNT_ODU_ACCOUNT_SCARD_IN24M_MAX,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_IN24M_MAX.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_CARD_M2E_IN6M.field,
				CNT_ACCT_CARD_M2E_IN6M,
				PbocLabelEnum.CNT_ACCT_CARD_M2E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_CARD_M2E_IN6M_2TP.field,
				CNT_ACCT_CARD_M2E_IN6M_2TP,
				PbocLabelEnum.CNT_ACCT_CARD_M2E_IN6M_2TP.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_CARD_M2E_IN12M.field,
				CNT_ACCT_CARD_M2E_IN12M,
				PbocLabelEnum.CNT_ACCT_CARD_M2E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_CARD_M2E_IN12M_3TP.field,
				CNT_ACCT_CARD_M2E_IN12M_3TP,
				PbocLabelEnum.CNT_ACCT_CARD_M2E_IN12M_3TP.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_CARD_M1E_IN12M_6TP.field,
				CNT_ACCT_CARD_M1E_IN12M_6TP,
				PbocLabelEnum.CNT_ACCT_CARD_M1E_IN12M_6TP.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_SCARD_M3_IN24M.field,
				CNT_ACCT_SCARD_M3_IN24M,
				PbocLabelEnum.CNT_ACCT_SCARD_M3_IN24M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_CARD_M3_OUT24M.field,
				CNT_ACCT_CARD_M3_OUT24M,
				PbocLabelEnum.CNT_ACCT_CARD_M3_OUT24M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_SCARD_M3_OUT24M.field,
				CNT_ACCT_SCARD_M3_OUT24M,
				PbocLabelEnum.CNT_ACCT_SCARD_M3_OUT24M.fieldDesc);

		// 逾期次数相关指标
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M2E_IN3M.field,
				CNT_ODU_ACCOUNT_CARD_M2E_IN3M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M2E_IN3M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M1E_IN6M.field,
				CNT_ODU_ACCOUNT_CARD_M1E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M1E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M2E_IN6M.field,
				CNT_ODU_ACCOUNT_CARD_M2E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M2E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3E_IN6M.field,
				CNT_ODU_ACCOUNT_CARD_M3E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M4E_IN6M.field,
				CNT_ODU_ACCOUNT_CARD_M4E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M4E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M5E_IN6M.field,
				CNT_ODU_ACCOUNT_CARD_M5E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M5E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M1_IN6M.field,
				CNT_ODU_ACCOUNT_CARD_M1_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M1_IN6M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3_IN6M.field,
				CNT_ODU_ACCOUNT_CARD_M3_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M4_IN6M.field,
				CNT_ODU_ACCOUNT_CARD_M4_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M4_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M5_IN6M.field,
				CNT_ODU_ACCOUNT_CARD_M5_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M5_IN6M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M1E_IN12M.field,
				CNT_ODU_ACCOUNT_CARD_M1E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M1E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M2E_IN12M.field,
				CNT_ODU_ACCOUNT_CARD_M2E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M2E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3E_IN12M.field,
				CNT_ODU_ACCOUNT_CARD_M3E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M4E_IN12M.field,
				CNT_ODU_ACCOUNT_CARD_M4E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M4E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M5E_IN12M.field,
				CNT_ODU_ACCOUNT_CARD_M5E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M5E_IN12M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3_IN12M.field,
				CNT_ODU_ACCOUNT_CARD_M3_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M4_IN12M.field,
				CNT_ODU_ACCOUNT_CARD_M4_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M4_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M5_IN12M.field,
				CNT_ODU_ACCOUNT_CARD_M5_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M5_IN12M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3_IN24M.field,
				CNT_ODU_ACCOUNT_CARD_M3_IN24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3_IN24M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3_OUT24M.field,
				CNT_ODU_ACCOUNT_CARD_M3_OUT24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3_OUT24M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M1_IN24M.field,
				CNT_ODU_ACCOUNT_CARD_M1_IN24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M1_IN24M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3.field,
				CNT_ODU_ACCOUNT_CARD_M3,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M3.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3.field,
				CNT_ODU_ACCOUNT_SCARD_M3,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M2.field,
				CNT_ODU_ACCOUNT_CARD_M2,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_M2.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M2.field,
				CNT_ODU_ACCOUNT_SCARD_M2,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M2.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M2E_IN3M.field,
				CNT_ODU_ACCOUNT_SCARD_M2E_IN3M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M2E_IN3M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M1E_IN6M.field,
				CNT_ODU_ACCOUNT_SCARD_M1E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M1E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M2E_IN6M.field,
				CNT_ODU_ACCOUNT_SCARD_M2E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M2E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3E_IN6M.field,
				CNT_ODU_ACCOUNT_SCARD_M3E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M4E_IN6M.field,
				CNT_ODU_ACCOUNT_SCARD_M4E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M4E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M5E_IN6M.field,
				CNT_ODU_ACCOUNT_SCARD_M5E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M5E_IN6M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3_IN6M.field,
				CNT_ODU_ACCOUNT_SCARD_M3_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M4_IN6M.field,
				CNT_ODU_ACCOUNT_SCARD_M4_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M4_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M5_IN6M.field,
				CNT_ODU_ACCOUNT_SCARD_M5_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M5_IN6M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M1E_IN12M.field,
				CNT_ODU_ACCOUNT_SCARD_M1E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M1E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M2E_IN12M.field,
				CNT_ODU_ACCOUNT_SCARD_M2E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M2E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3E_IN12M.field,
				CNT_ODU_ACCOUNT_SCARD_M3E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M4E_IN12M.field,
				CNT_ODU_ACCOUNT_SCARD_M4E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M4E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M5E_IN12M.field,
				CNT_ODU_ACCOUNT_SCARD_M5E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M5E_IN12M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3_IN12M.field,
				CNT_ODU_ACCOUNT_SCARD_M3_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M4_IN12M.field,
				CNT_ODU_ACCOUNT_SCARD_M4_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M4_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M5_IN12M.field,
				CNT_ODU_ACCOUNT_SCARD_M5_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M5_IN12M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3_IN24M.field,
				CNT_ODU_ACCOUNT_SCARD_M3_IN24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3_IN24M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3_OUT24M.field,
				CNT_ODU_ACCOUNT_SCARD_M3_OUT24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_M3_OUT24M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.MONTH_ODU_ACCOUNT_CARD_MAX.field,
				MONTH_ODU_ACCOUNT_CARD_MAX,
				PbocLabelEnum.MONTH_ODU_ACCOUNT_CARD_MAX.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_ODU_ACCOUNT_SCARD_MAX.field,
				MONTH_ODU_ACCOUNT_SCARD_MAX,
				PbocLabelEnum.MONTH_ODU_ACCOUNT_SCARD_MAX.fieldDesc);
		// 额度使用率相关指标
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_CARD_LV80.field,
				CNT_ACCOUNT_CARD_LV80,
				PbocLabelEnum.CNT_ACCOUNT_CARD_LV80.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_SCARD_LV80.field,
				CNT_ACCOUNT_SCARD_LV80,
				PbocLabelEnum.CNT_ACCOUNT_SCARD_LV80.fieldDesc);

		pbocRspPO.addIndex(
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_CARD_TOTAL_LIMIT.field,
				LV_CREDLIMIT_NORMAL_CARD_TOTAL_LIMIT,
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_CARD_TOTAL_LIMIT.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_CARD_USED_LIMIT.field,
				LV_CREDLIMIT_NORMAL_CARD_USED_LIMIT,
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_CARD_USED_LIMIT.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_SCARD_TOTAL_LIMIT.field,
				LV_CREDLIMIT_NORMAL_SCARD_TOTAL_LIMIT,
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_SCARD_TOTAL_LIMIT.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_SCARD_USED_LIMIT.field,
				LV_CREDLIMIT_NORMAL_SCARD_USED_LIMIT,
				PbocLabelEnum.LV_CREDLIMIT_NORMAL_SCARD_USED_LIMIT.fieldDesc);

		// 其他指标
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_AMT100.field,
				CNT_ODU_ACCOUNT_CARD_AMT100,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_AMT100.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_AMT500.field,
				CNT_ODU_ACCOUNT_CARD_AMT500,
				PbocLabelEnum.CNT_ODU_ACCOUNT_CARD_AMT500.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_AMT500.field,
				CNT_ODU_ACCOUNT_SCARD_AMT500,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_AMT500.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_MAX_LOAN_ACCOUNT_CARD_IN6M.field,
				CNT_MAX_LOAN_ACCOUNT_CARD_IN6M,
				PbocLabelEnum.CNT_MAX_LOAN_ACCOUNT_CARD_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.IF_CARD_REPORT_UPDATE_IN24MONTH.field,
				IF_CARD_REPORT_UPDATE_IN24MONTH,
				PbocLabelEnum.IF_CARD_REPORT_UPDATE_IN24MONTH.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_AMT100.field,
				CNT_ODU_ACCOUNT_SCARD_AMT100,
				PbocLabelEnum.CNT_ODU_ACCOUNT_SCARD_AMT100.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M.field,
				CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M,
				PbocLabelEnum.CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.IF_SCARD_REPORT_UPDATE_IN24MONTH.field,
				IF_SCARD_REPORT_UPDATE_IN24MONTH,
				PbocLabelEnum.IF_SCARD_REPORT_UPDATE_IN24MONTH.fieldDesc);

		// 核准记录数
		pbocRspPO.addIndex(PbocLabelEnum.CNT_CARD_APPROVE_IN6M.field,
				CNT_CARD_APPROVE_IN6M,
				PbocLabelEnum.CNT_CARD_APPROVE_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_SCARD_APPROVE_IN6M.field,
				CNT_SCARD_APPROVE_IN6M,
				PbocLabelEnum.CNT_SCARD_APPROVE_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_CARD_APPROVE_IN3M.field,
				CNT_CARD_APPROVE_IN3M,
				PbocLabelEnum.CNT_CARD_APPROVE_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_SCARD_APPROVE_IN3M.field,
				CNT_SCARD_APPROVE_IN3M,
				PbocLabelEnum.CNT_SCARD_APPROVE_IN3M.fieldDesc);

		// 他行卡计算
		pbocRspPO.addIndex(PbocLabelEnum.CNT_AMT_CARD_OBANK.field,
				CNT_AMT_CARD_OBANK, PbocLabelEnum.CNT_AMT_CARD_OBANK.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_AMT_CARD_OBANK_HIGHEST.field,
				CNT_AMT_CARD_OBANK_HIGHEST,
				PbocLabelEnum.CNT_AMT_CARD_OBANK_HIGHEST.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_AMT_OBANK_SECOND.field,
				CNT_AMT_OBANK_SECOND,
				PbocLabelEnum.CNT_AMT_OBANK_SECOND.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_AMT_CARD_OBANK_LOWEST.field,
				CNT_AMT_CARD_OBANK_LOWEST,
				PbocLabelEnum.CNT_AMT_CARD_OBANK_LOWEST.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CRED_LIMIT_OBANK_ONE.field,
				CRED_LIMIT_OBANK_ONE,
				PbocLabelEnum.CRED_LIMIT_OBANK_ONE.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CRED_LIMIT_OBANK_DOUBLE.field,
				CRED_LIMIT_OBANK_DOUBLE,
				PbocLabelEnum.CRED_LIMIT_OBANK_DOUBLE.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CRED_LIMIT_OBANK_MULTI_MODE.field,
				CRED_LIMIT_OBANK_MULTI_MODE,
				PbocLabelEnum.CRED_LIMIT_OBANK_MULTI_MODE.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CRED_LIMIT_OBANK_MULTI_MEDIAN.field,
				CRED_LIMIT_OBANK_MULTI_MEDIAN,
				PbocLabelEnum.CRED_LIMIT_OBANK_MULTI_MEDIAN.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CRED_LIMIT_OBANK_SUM.field,
				CRED_LIMIT_OBANK_SUM,
				PbocLabelEnum.CRED_LIMIT_OBANK_SUM.fieldDesc);

		// 早期风险预警
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_CARD_M1E.field,
				AMT_ACCOUNT_CARD_M1E,
				PbocLabelEnum.AMT_ACCOUNT_CARD_M1E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_CARD_M2E.field,
				AMT_ACCOUNT_CARD_M2E,
				PbocLabelEnum.AMT_ACCOUNT_CARD_M2E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_CARD_M3E.field,
				AMT_ACCOUNT_CARD_M3E,
				PbocLabelEnum.AMT_ACCOUNT_CARD_M3E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_CARD_M4E.field,
				AMT_ACCOUNT_CARD_M4E,
				PbocLabelEnum.AMT_ACCOUNT_CARD_M4E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_CARD_M4.field,
				AMT_ACCOUNT_CARD_M4,
				PbocLabelEnum.AMT_ACCOUNT_CARD_M4.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_CARD_M5.field,
				AMT_ACCOUNT_CARD_M5,
				PbocLabelEnum.AMT_ACCOUNT_CARD_M5.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_SCARD_M1E.field,
				AMT_ACCOUNT_SCARD_M1E,
				PbocLabelEnum.AMT_ACCOUNT_SCARD_M1E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_SCARD_M2E.field,
				AMT_ACCOUNT_SCARD_M2E,
				PbocLabelEnum.AMT_ACCOUNT_SCARD_M2E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_SCARD_M3E.field,
				AMT_ACCOUNT_SCARD_M3E,
				PbocLabelEnum.AMT_ACCOUNT_SCARD_M3E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_SCARD_M4E.field,
				AMT_ACCOUNT_SCARD_M4E,
				PbocLabelEnum.AMT_ACCOUNT_SCARD_M4E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_SCARD_M4.field,
				AMT_ACCOUNT_SCARD_M4,
				PbocLabelEnum.AMT_ACCOUNT_SCARD_M4.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_SCARD_M5.field,
				AMT_ACCOUNT_SCARD_M5,
				PbocLabelEnum.AMT_ACCOUNT_SCARD_M5.fieldDesc);

		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_CARD_ABNORMAL_ZF_ODU300.field,
				CNT_ACCOUNT_CARD_ABNORMAL_ZF_ODU300,
				PbocLabelEnum.CNT_ACCOUNT_CARD_ABNORMAL_ZF_ODU300.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_CARD_ABNORMAL_DJ_ODU300.field,
				CNT_ACCOUNT_CARD_ABNORMAL_DJ_ODU300,
				PbocLabelEnum.CNT_ACCOUNT_CARD_ABNORMAL_DJ_ODU300.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_CARD_ABNORMAL_DZ_ODU300.field,
				CNT_ACCOUNT_CARD_ABNORMAL_DZ_ODU300,
				PbocLabelEnum.CNT_ACCOUNT_CARD_ABNORMAL_DZ_ODU300.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_SCARD_ABNORMAL_ZF_ODU300.field,
				CNT_ACCOUNT_SCARD_ABNORMAL_ZF_ODU300,
				PbocLabelEnum.CNT_ACCOUNT_SCARD_ABNORMAL_ZF_ODU300.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_SCARD_ABNORMAL_DJ_ODU300.field,
				CNT_ACCOUNT_SCARD_ABNORMAL_DJ_ODU300,
				PbocLabelEnum.CNT_ACCOUNT_SCARD_ABNORMAL_DJ_ODU300.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_SCARD_ABNORMAL_DZ_ODU300.field,
				CNT_ACCOUNT_SCARD_ABNORMAL_DZ_ODU300,
				PbocLabelEnum.CNT_ACCOUNT_SCARD_ABNORMAL_DZ_ODU300.fieldDesc);

		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_USEDLIMT_500K_AVG_IN6M.field,
				CNT_ACCOUNT_USEDLIMT_500K_AVG_IN6M,
				PbocLabelEnum.CNT_ACCOUNT_USEDLIMT_500K_AVG_IN6M.fieldDesc);
		pbocRspPO
				.addIndex(
						PbocLabelEnum.LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK.field,
						LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK,
						PbocLabelEnum.LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_PAYMENT_MIN.field,
				CNT_PAYMENT_MIN, PbocLabelEnum.CNT_PAYMENT_MIN.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_TOTAL.field,
				CNT_ACCOUNT_TOTAL, PbocLabelEnum.CNT_ACCOUNT_TOTAL.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_CARD_LOW_LIMIT_DALIAN.field,
				CNT_ACCOUNT_CARD_LOW_LIMIT_DALIAN,
				PbocLabelEnum.CNT_ACCOUNT_CARD_LOW_LIMIT_DALIAN.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_CARD_DALIAN.field,
				CNT_ACCOUNT_CARD_DALIAN,
				PbocLabelEnum.CNT_ACCOUNT_CARD_DALIAN.fieldDesc);
		// 大额专项分期信息
		pbocRspPO.addIndex(PbocLabelEnum.CRED_LIMIT_LARGE_INSTALMENT.field,
				CRED_LIMIT_LARGE_INSTALMENT,
				PbocLabelEnum.CRED_LIMIT_LARGE_INSTALMENT.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CRED_LIMIT_LARGE_INSTALMENT_USED.field,
				CRED_LIMIT_LARGE_INSTALMENT_USED,
				PbocLabelEnum.CRED_LIMIT_LARGE_INSTALMENT_USED.fieldDesc);
		// 特殊交易信息
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_CARD_ABNORMAL_DB.field,
				CNT_ACCOUNT_CARD_ABNORMAL_DB,
				PbocLabelEnum.CNT_ACCOUNT_CARD_ABNORMAL_DB.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_SCARD_ABNORMAL_DB.field,
				CNT_ACCOUNT_SCARD_ABNORMAL_DB,
				PbocLabelEnum.CNT_ACCOUNT_SCARD_ABNORMAL_DB.fieldDesc);
	}
}
