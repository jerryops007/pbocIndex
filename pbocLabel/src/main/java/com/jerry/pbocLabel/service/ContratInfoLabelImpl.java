package com.jerry.pbocLabel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.dict.DictContratInfo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.ContratInfoEnum;
import com.jerry.pbocLabel.util.ArrayUtils;
import com.jerry.pbocLabel.util.DateUtils;
import com.jerry.pbocLabel.util.MapUtils;

/*
 * 人行报文信息：贷款信息指标解析
 */
public class ContratInfoLabelImpl {

	private static Logger log = LoggerFactory
			.getLogger(ContratInfoLabelImpl.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo,
			Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：开始贷款信息指标解析");

		// 账户数计算
		Integer CNT_ACCOUNT_LOAN_HO = 0;
		Integer CNT_ACCOUNT_NORMAL_LOAN_HO = 0;
		Integer CNT_ACCOUNT_NORMAL_LOAN_CR = 0;
		Integer CNT_ACCOUNT_NORMAL_LOAN_SL = 0;
		Integer CNT_ACCOUNT_NORMAL_LOAN_CF = 0;
		Integer CNT_ACCOUNT_NORMAL_LOAN_CL = 0;
		Integer CNT_ACCOUNT_LOAN_CF = 0;
		Integer CNT_ACCOUNT_LOAN_SL = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_AMT500 = 0;
		Integer AMT_CREDLIMIT_NORMAL_LOAN_MO = 0;
		Integer CNT_ACCT_LOAN_M2E_IN6M_2TP = 0;
		Integer CNT_ACCT_LOAN_M2E_IN12M_3TP = 0;
		Integer CNT_ACCT_LOAN_M1E_IN12M_6TP = 0;
		Integer CNT_ACCT_LOAN_M3_IN24M = 0;
		Integer CNT_ACCT_LOAN_M3_OUT24M = 0;

		// 月数相关指标计算
		Integer MONTH_ODU_ACCOUNT_LOAN = 9999;

		// 额度使用率指标计算
		Integer CNT_ACCOUNT_LOAN_LV80 = 0;
		Integer CNT_ACCOUNT_LOAN_LV80_CR = 0;

		// 账龄相关指标计算
		Integer MONTH_AGE_NORMAL_LOAN = 0;
		Integer CNT_ACCOUNT_NORMAL_LOAN_AGE24 = 0;
		Integer CNT_NODU_ACCOUNT_LOAN_AGE6 = 0;
		Integer CNT_NODU_ACCOUNT_LOAN_AGE12 = 0;
		Integer CNT_ACCOUNT_LOAN_AGE12_OP = 0;

		Integer MONTH_AGE_LOAN = 0;

		// 逾期次数指标计算、
		Integer CNT_ODU_ACCOUNT_LOAN_IN3M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_CR_IN3M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M2_IN3M = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M1_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M2_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M3_IN6M = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_M1E_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M2E_IN6M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M3E_IN6M = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_M4_IN6M = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M1E_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M2E_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M3E_IN12M = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_M3_IN12M = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M4_IN12M = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_M3_IN24M = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_IN24M = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_IN12M_CF = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_IN12M_SL = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_IN24M_MAX = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_IN24M_CF = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_IN24M_SL = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_M2 = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M3 = 0;

		Integer CNT_ACCOUNT_LOAN_ODU_NOW = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_M3_OUT24M = 0;

		Integer MONTH_ODU_ACCOUNT_LOAN_MAX = 0;
		Integer CNT_ODU_ACCOUNT_LOAN_M1_IN24M = 0;

		// 历史存在逾期3期及以上贷款账户数
		Integer CNT_ACCT_LOAN_M3 = 0;
		// 近3个月存在逾期2期的贷款账户数
		Integer CNT_ACCT_LOAN_M2E_IN3M = 0;
		Integer CNT_ACCT_LOAN_M2E_IN6M = 0;
		Integer CNT_ACCT_LOAN_M2E_IN12M = 0;

		// 五级分类指标
		Integer CNT_ACCOUNT_LOAN_SEC = 0;
		Integer CNT_ACCOUNT_LOAN_SUS = 0;
		Integer CNT_ACCOUNT_LOAN_LOSS = 0;
		Integer CNT_ACCOUNT_LOAN_ATTENTION = 0;
		Integer CNT_ACCOUNT_LOAN_ABNORMAL = 0;
		Integer CNT_ACCT_LOAN_ABNORMAL = 0;
		Integer CNT_ACCT_LOAN_ABNORMAL_MANDATORY = 0;
		Integer CNT_LOAN_NON_COLLATERAL_20P = 0;
		Integer CNT_LOAN_COMMERCIAL_20P = 0;
		Integer CNT_LOAN_NORMAL_GUARANTEE = 0;

		// 其他指标
		Boolean IF_LOAN_REPORT_UPDATE_IN24MONTH = true;
		Integer CNT_ACCOUNT_NORMAL_LOAN_AGE24_MO = 0;

		// 贷款发放机构数
		Integer CNT_ORG_LOAN_NORMAL_CF = 0;
		Integer CNT_ORG_LOAN_NORMAL_SM = 0;

		// 核准记录数
		Integer CNT_LOAN_APPROVE_IN3M = 0;
		Integer CNT_LOAN_APPROVE_IN6M = 0;
		Integer CNT_ORG_LOAN_APPROVE_IN6M = 0;
		ArrayList<String> CNT_ORG_LOAN_APPROVE_IN6M_TEMP_ORGCODE = new ArrayList<String>();
		// 金额相关指标
		Integer CNT_ACCOUNT_LOAN_ODU_NOW_MAXAMT = 0;
		Integer CNT_LOAN_BALANCE = 0;
		Integer CNT_LOAN_BALANCE_XF = 0;
		Integer CNT_MORTGAGE_BALANCE = 0;
		Integer CNT_LOAN_BALANCE_OTHER = 0;
		Integer CNT_MORTGAGE_AMT_NEW = 0;
		Integer CNT_MORTGAGE_PAY_NEW = 0;
		Integer CNT_MORTGAGE_DURATION_NEW = 0;
		Integer CNT_LOAN_AMT_NEW = 0;
		Integer CNT_LOAN_PAY_NEW = 0;
		Integer CNT_LOAN_DURATION_NEW = 0;

		ArrayList<String> CNT_ORG_LOAN_NORMAL_CF_TEMP_ORGCODE = new ArrayList<String>();
		ArrayList<String> CNT_ORG_LOAN_NORMAL_SM_TEMP_ORGCODE = new ArrayList<String>();

		Integer AMT_CREDLIMIT_NORMAL_LOAN_MO_TEMP = 0;
		Integer AMT_CREDLIMIT_NORMAL_LOAN_MO_ORGCODE_TEMP = 0;

		Integer CNT_MORTGAGE_AMT_NEW_MONTH_TEMP = 9999;
		Integer CNT_LOAN_AMT_NEW_MONTH_TEMP = 9999;
		Integer AMT_MORTGAGE_CONTRACT = 0;
		Integer AMT_MORTGAGE_CONTRACT_OBANK = 0;
		Integer AMT_MORTGAGE_PAYMENT_MONTHLY = 0;
		Integer AMT_MORTGAGE_PAYMENT_MONTHLY_OBANK = 0;
		Integer AMT_LOAN_BALANCE_CREDIT = 0;
		Integer AMT_LOAN_BALANCE_XF = 0;

		// 早期风险预警
		Integer AMT_ACCOUNT_LOAN_M1E = 0;
		Integer AMT_ACCOUNT_LOAN_M2E = 0;
		Integer AMT_ACCOUNT_LOAN_M3E = 0;
		Integer AMT_ACCOUNT_LOAN_M4 = 0;

		Integer CNT_ACCOUNT_LOAN_ABNORMAL_ZF_ODU300 = 0;
		Integer CNT_ACCOUNT_LOAN_ABNORMAL_DJ_ODU300 = 0;
		Integer CNT_ACCOUNT_LOAN_ABNORMAL_DZ_ODU300 = 0;
		Integer CNT_ACCOUNT_LOAN_ABNORMAL_DB = 0;

		Integer CNT_ACCOUNT_LOAN_5000 = 0;
		Integer CNT_ACCOUNT_LOAN_NO_HOUSE_CAR = 0;
		Integer CNT_LOAN_TRUST = 0;

		Integer AMT_LOAN_NON_COLLATERAL_BALANCE = 0;

		Integer CNT_ODU_ACCOUNT_LOAN_G = 0;

		for (Map<String, Object> mapunit : pbocVo.getContratInfo()) {
			log.debug("授信情况 展示:{}", mapunit);
			String ACCOUNTSTATE = MapUtils.getStringFromMap(mapunit,
					ContratInfoEnum.ACCOUNTSTATE.field);
			String LATESTPERFORMANCE_ACCOUNTSTATE = MapUtils.getStringFromMap(
					MapUtils.getMapFromMap(mapunit,
							ContratInfoEnum.LATESTPERFORMANCE.field),
					ContratInfoEnum.LATESTPERFORMANCE_ACCOUNTSTATE.field);
			String LATESTPERFORMANCE_CLASS5STATE = MapUtils.getStringFromMap(
					MapUtils.getMapFromMap(mapunit,
							ContratInfoEnum.LATESTPERFORMANCE.field),
					ContratInfoEnum.LATESTPERFORMANCE_CLASS5STATE.field);
			String LATESTPERFORMANCE_REPAYMENTTYPE = MapUtils.getStringFromMap(
					MapUtils.getMapFromMap(mapunit,
							ContratInfoEnum.LATESTPERFORMANCE.field),
					ContratInfoEnum.LATESTPERFORMANCE_REPAYMENTTYPE.field);
			List<Map> COVERDUERECORDLIST = MapUtils.getListFromMap(mapunit,
					ContratInfoEnum.COVERDUERECORDLIST.field);
			List<Map> SPECIALTRADELIST = MapUtils.getListFromMap(mapunit,
					ContratInfoEnum.SPECIALTRADELIST.field);
			Integer CREDITLIMITAMOUNT = MapUtils.getIntegerFromMap(mapunit,
					ContratInfoEnum.CREDITLIMITAMOUNT.field);
			String COMMONLOANMARK = MapUtils.getStringFromMap(mapunit,
					ContratInfoEnum.COMMONLOANMARK.field);
			Integer MONTH_AGE_UNIT;
			try {
				MONTH_AGE_UNIT = DateUtils.getdateDiffMonth(pbocBaseInfoPO
						.getReportCreateTime(), MapUtils.getStringFromMap(
						mapunit, ContratInfoEnum.OPENDATE.field),
						DateUtils.DATE_FORMAT_3, DateUtils.DATE_FORMAT_6);
			} catch (Exception e) {
				log.error("日期计算错误错误，跳过当前记录处理，错误记录MONTH_AGE_UNIT为{}", MapUtils
						.getStringFromMap(mapunit,
								ContratInfoEnum.OPENDATE.field));
				continue;
			}
			if (MONTH_AGE_UNIT < 0) {
				log.error("日期存在问题,错误记录为{}", MapUtils.getStringFromMap(mapunit,
						ContratInfoEnum.OPENDATE.field));
				continue;
			}
			String TYPE = MapUtils.getStringFromMap(mapunit,
					ContratInfoEnum.TYPE.field);
			String GUARANTEETYPE = MapUtils.getStringFromMap(mapunit,
					ContratInfoEnum.GUARANTEETYPE.field);
			String ORGTYPE = MapUtils.getStringFromMap(mapunit,
					ContratInfoEnum.ORGTYPE.field);
			String FINANCEORG = MapUtils.getStringFromMap(mapunit,
					ContratInfoEnum.FINANCEORG.field);
			String CONTRATTYPE = MapUtils.getStringFromMap(mapunit,
					ContratInfoEnum.CONTRATTYPE.field);
			Integer CURRACCOUNTINFO_BALANCE = MapUtils.getIntegerFromMap(
					MapUtils.getMapFromMap(mapunit,
							ContratInfoEnum.CURRACCOUNTINFO.field),
					ContratInfoEnum.CURRACCOUNTINFO_BALANCE.field);
			String CURRACCOUNTINFO_CLASS5STATE = MapUtils.getStringFromMap(
					MapUtils.getMapFromMap(mapunit,
							ContratInfoEnum.CURRACCOUNTINFO.field),
					ContratInfoEnum.CURRACCOUNTINFO_CLASS5STATE.field);
			Integer CURRACCOUNTINFO_SCHEDULEDPAYMENTAMOUNT = MapUtils
					.getIntegerFromMap(
							MapUtils.getMapFromMap(mapunit,
									ContratInfoEnum.CURRACCOUNTINFO.field),
							ContratInfoEnum.CURRACCOUNTINFO_SCHEDULEDPAYMENTAMOUNT.field);
			Integer CURROVERDUE_CURROVERDUECYC = MapUtils.getIntegerFromMap(
					MapUtils.getMapFromMap(mapunit,
							ContratInfoEnum.CURROVERDUE.field),
					ContratInfoEnum.CURROVERDUE_CURROVERDUECYC.field);
			Integer CURROVERDUE_CURROVERDUEAMOUNT = MapUtils.getIntegerFromMap(
					MapUtils.getMapFromMap(mapunit,
							ContratInfoEnum.CURROVERDUE.field),
					ContratInfoEnum.CURROVERDUE_CURROVERDUEAMOUNT.field);
			/**
			 * 非循环指标
			 */
			if (TYPE.equals(DictContratInfo.type_11)
					| TYPE.equals(DictContratInfo.type_12)
					| TYPE.equals(DictContratInfo.type_13)) {
				/**
				 * 住房贷款账户数
				 */
				CNT_ACCOUNT_LOAN_HO++;
				/**
				 * 未结清住房贷款账户数
				 */
				if (ACCOUNTSTATE.equals(DictContratInfo.accountState_1)
						| (ACCOUNTSTATE.isEmpty() && LATESTPERFORMANCE_ACCOUNTSTATE
								.equals(DictContratInfo.accountState_1))) {
					CNT_ACCOUNT_NORMAL_LOAN_HO++;
				}

			}
			/**
			 * 当前贷款存在逾期且逾期金额大于等于500元的次数
			 */
			if (CURROVERDUE_CURROVERDUECYC > 0
					&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
							.contains(LATESTPERFORMANCE_REPAYMENTTYPE)) {
				if (CURROVERDUE_CURROVERDUEAMOUNT >= 500) {
					CNT_ODU_ACCOUNT_LOAN_AMT500++;
				}
			}
			/**
			 * 贷款账户当前逾期金额的最大值
			 */
			if (DictContratInfo.LATESTPERFORMANCE_REPAYMENTTYPE_1TOZ
					.contains(LATESTPERFORMANCE_REPAYMENTTYPE)) {
				if (CURROVERDUE_CURROVERDUEAMOUNT > 0) {
					CNT_ACCOUNT_LOAN_ODU_NOW_MAXAMT = Math.max(
							CNT_ACCOUNT_LOAN_ODU_NOW_MAXAMT,
							CURROVERDUE_CURROVERDUEAMOUNT);
				}
			}
			/**
			 * 未结清有抵押贷款户均合同金额
			 */
			if (ACCOUNTSTATE.equals(DictContratInfo.accountState_1)
					| (ACCOUNTSTATE.isEmpty() && LATESTPERFORMANCE_ACCOUNTSTATE
							.equals(DictContratInfo.accountState_1))) {
				if (!GUARANTEETYPE.equals(DictContratInfo.guaranteeType_4)) {
					AMT_CREDLIMIT_NORMAL_LOAN_MO_ORGCODE_TEMP++;
					AMT_CREDLIMIT_NORMAL_LOAN_MO_TEMP = AMT_CREDLIMIT_NORMAL_LOAN_MO_TEMP
							+ CREDITLIMITAMOUNT;
				}
			}
			/**
			 * 当前贷款余额
			 */
			CNT_LOAN_BALANCE = CNT_LOAN_BALANCE + CURRACCOUNTINFO_BALANCE;
			/**
			 * 当前房贷余额
			 */
			if (TYPE.equals(DictContratInfo.type_11)
					| TYPE.equals(DictContratInfo.type_12)
					| TYPE.equals(DictContratInfo.type_13)) {
				CNT_MORTGAGE_BALANCE = CNT_MORTGAGE_BALANCE
						+ CURRACCOUNTINFO_BALANCE;
			}
			/**
			 * 当前消费类贷款余额
			 */
			if (!TYPE.isEmpty() && TYPE.contains(DictContratInfo.type_XF)) {
				CNT_LOAN_BALANCE_XF = CNT_LOAN_BALANCE_XF
						+ CURRACCOUNTINFO_BALANCE;
			}
			/**
			 * 当前消费类( "个人汽车消费贷款", "消费性农户贷款", "其他个人消费贷款"）贷款余额
			 */
			if (TYPE.contains(DictContratInfo.type_21)
					| TYPE.contains(DictContratInfo.type_53)
					| TYPE.contains(DictContratInfo.type_91)) {
				AMT_LOAN_BALANCE_XF = AMT_LOAN_BALANCE_XF
						+ CURRACCOUNTINFO_BALANCE;
			}

			/**
			 * 当前无抵质押类负债余额
			 */
			if (GUARANTEETYPE.equals(DictContratInfo.guaranteeType_3)
					| GUARANTEETYPE.equals(DictContratInfo.guaranteeType_4)
					| GUARANTEETYPE.equals(DictContratInfo.guaranteeType_7)) {
				CNT_LOAN_BALANCE_OTHER = CNT_LOAN_BALANCE_OTHER
						+ CURRACCOUNTINFO_BALANCE;
			}
			/**
			 * 非抵质押类负债余额（早期风险预警的担保方式与人行拒绝不同）
			 */
			if (!GUARANTEETYPE.equals(DictContratInfo.guaranteeType_1)
					&& !GUARANTEETYPE.equals(DictContratInfo.guaranteeType_2)) {
				AMT_LOAN_NON_COLLATERAL_BALANCE = AMT_LOAN_NON_COLLATERAL_BALANCE
						+ CURRACCOUNTINFO_BALANCE;
			}
			/**
			 * 信用贷款余额（信用/免担保类）
			 */
			if (GUARANTEETYPE.equals(DictContratInfo.guaranteeType_4)) {
				AMT_LOAN_BALANCE_CREDIT += CURRACCOUNTINFO_BALANCE;
			}
			/**
			 * 当前未结清无抵质押贷款合同金额超20万的贷款笔数除(1-抵押，2-质押外）
			 */
			if (!GUARANTEETYPE.equals(DictContratInfo.guaranteeType_1)
					&& !GUARANTEETYPE.equals(DictContratInfo.guaranteeType_2)
					&& !ACCOUNTSTATE.equals(DictContratInfo.accountState_3)
					&& CREDITLIMITAMOUNT >= 200000) {
				CNT_LOAN_NON_COLLATERAL_20P++;
			}
			/**
			 * 未结清贷款类型为经营性贷款且合同金额超过30万（含）的笔数
			 */
			if (TYPE.equals(DictContratInfo.type_41)
					&& TYPE.equals(DictContratInfo.type_52)
					&& !ACCOUNTSTATE.equals(DictContratInfo.accountState_3)
					&& CREDITLIMITAMOUNT >= 300000) {
				CNT_LOAN_COMMERCIAL_20P++;
			}
			/**
			 * 当前正常的信用、保证类贷款笔数
			 */
			if ((GUARANTEETYPE.equals(DictContratInfo.guaranteeType_3) | GUARANTEETYPE
					.equals(DictContratInfo.guaranteeType_4))
					&& ACCOUNTSTATE.equals(DictContratInfo.accountState_1)) {
				CNT_LOAN_NORMAL_GUARANTEE++;
			}

			/**
			 * 最近一次
			 */
			if (ACCOUNTSTATE.equals(DictContratInfo.accountState_1)
					&& FINANCEORG.length() > 2) {
				if (TYPE.equals(DictContratInfo.type_11)
						| TYPE.equals(DictContratInfo.type_12)
						| TYPE.equals(DictContratInfo.type_13)) {
					if (CNT_MORTGAGE_AMT_NEW_MONTH_TEMP > MONTH_AGE_UNIT) {
						CNT_MORTGAGE_AMT_NEW_MONTH_TEMP = MONTH_AGE_UNIT;
						/**
						 * 最近一次本行正常在续房贷的合同金额
						 */
						CNT_MORTGAGE_AMT_NEW = CREDITLIMITAMOUNT;
						/**
						 * 最近一次本行正常在续房贷的月还款额
						 */
						CNT_MORTGAGE_PAY_NEW = CURRACCOUNTINFO_SCHEDULEDPAYMENTAMOUNT;
						/**
						 * 最近一次本行正常在续房贷的已发放月数
						 */
						CNT_MORTGAGE_DURATION_NEW = MONTH_AGE_UNIT;
					}
				}
				if (TYPE.equals(DictContratInfo.type_41)
						| TYPE.equals(DictContratInfo.type_21)
						| TYPE.equals(DictContratInfo.type_91)
						| TYPE.equals(DictContratInfo.type_51)
						| TYPE.equals(DictContratInfo.type_52)
						| TYPE.equals(DictContratInfo.type_53)) {
					if (CNT_LOAN_AMT_NEW_MONTH_TEMP > MONTH_AGE_UNIT) {
						CNT_MORTGAGE_AMT_NEW_MONTH_TEMP = MONTH_AGE_UNIT;
						/**
						 * 最近一次本行正常在续贷款的合同金额（经营性贷款、消费贷款和农户贷款）
						 */
						CNT_LOAN_AMT_NEW = CREDITLIMITAMOUNT;
						/**
						 * 最近一次本行正常在续贷款的月还款额（经营性贷款、消费贷款和农户贷款）
						 */
						CNT_LOAN_PAY_NEW = CURRACCOUNTINFO_SCHEDULEDPAYMENTAMOUNT;
						/**
						 * 最近一次本行正常在续贷款的已还款月数（经营性贷款、消费贷款和农户贷款）
						 */
						CNT_LOAN_DURATION_NEW = MONTH_AGE_UNIT;
					}
				}

			}

			if (ACCOUNTSTATE.equals(DictContratInfo.accountState_1)
					| (ACCOUNTSTATE.isEmpty() && LATESTPERFORMANCE_ACCOUNTSTATE
							.equals(DictContratInfo.accountState_1))) {
				/**
				 * 状态正常条件
				 */
				if (GUARANTEETYPE
						.equalsIgnoreCase(DictContratInfo.guaranteeType_4)) {
					/* 状态正常的无抵押贷款账户数 */
					CNT_ACCOUNT_NORMAL_LOAN_CR++;
				}
				if (ORGTYPE.equals(DictContratInfo.orgType_51)) {
					/* 状态正常的小额贷款公司贷款账户数 */
					CNT_ACCOUNT_NORMAL_LOAN_SL++;
				}
				if (ORGTYPE.equals(DictContratInfo.orgType_24)) {
					/* 状态正常的消费金融公司贷款账户数 */
					CNT_ACCOUNT_NORMAL_LOAN_CF++;
				}
				if (TYPE.equals(DictContratInfo.type_91)) {
					/* 状态正常的个人消费贷款账户数 */
					CNT_ACCOUNT_NORMAL_LOAN_CL++;
				}
				// 状态正常的贷款账户最长账龄（月）
				if (MONTH_AGE_UNIT >= 12
						&& TYPE.equals(DictContratInfo.type_41)
						&& (CONTRATTYPE.equals(DictContratInfo.contratType_D1)
								| CONTRATTYPE
										.equals(DictContratInfo.contratType_R1) | CONTRATTYPE
									.equals(DictContratInfo.contratType_R4))) {
					// 账龄≥12个月且状态正常的经营性贷款账户数
					CNT_ACCOUNT_LOAN_AGE12_OP++;
				}
				MONTH_AGE_NORMAL_LOAN = Math.max(MONTH_AGE_NORMAL_LOAN,
						MONTH_AGE_UNIT);
				if (MONTH_AGE_UNIT >= 24) {
					// 账龄≥24个月且状态正常的贷款账户数
					CNT_ACCOUNT_NORMAL_LOAN_AGE24++;
				}
				if (MONTH_AGE_UNIT >= 24
						&& !GUARANTEETYPE
								.equals(DictContratInfo.guaranteeType_4)
						&& (CONTRATTYPE.equals(DictContratInfo.contratType_D1)
								| CONTRATTYPE
										.equals(DictContratInfo.contratType_R1) | CONTRATTYPE
									.equals(DictContratInfo.contratType_R4))) {
					// 账龄≥24个月且状态正常的有抵押贷款账户数
					CNT_ACCOUNT_NORMAL_LOAN_AGE24_MO++;
				}

			}
			if (ORGTYPE.equals(DictContratInfo.orgType_24)) {
				/* 消费金融公司贷款账户数 */
				CNT_ACCOUNT_LOAN_CF++;
			}
			if (ORGTYPE.equals(DictContratInfo.orgType_51)) {
				/* 小额贷款公司贷款账户数 */
				CNT_ACCOUNT_LOAN_SL++;
			}
			if (CURRACCOUNTINFO_CLASS5STATE
					.equals(DictContratInfo.curraccountinfo_class5state_13)
					&& (LATESTPERFORMANCE_CLASS5STATE.isEmpty() | LATESTPERFORMANCE_CLASS5STATE
							.equals(DictContratInfo.LATESTPERFORMANCE_CLASS5STATE_3))) {
				/* 五级分类为次级的贷款账户数 */
				CNT_ACCOUNT_LOAN_SEC++;
			}
			if (CURRACCOUNTINFO_CLASS5STATE
					.equals(DictContratInfo.curraccountinfo_class5state_14)
					&& (LATESTPERFORMANCE_CLASS5STATE.isEmpty() | LATESTPERFORMANCE_CLASS5STATE
							.equals(DictContratInfo.LATESTPERFORMANCE_CLASS5STATE_4))) {
				/* 五级分类为可疑的贷款账户数 */
				CNT_ACCOUNT_LOAN_SUS++;
			}
			if (CURRACCOUNTINFO_CLASS5STATE
					.equals(DictContratInfo.curraccountinfo_class5state_15)
					&& (LATESTPERFORMANCE_CLASS5STATE.isEmpty() | LATESTPERFORMANCE_CLASS5STATE
							.equals(DictContratInfo.LATESTPERFORMANCE_CLASS5STATE_5))) {
				/* 五级分类为损失的贷款账户数 */
				CNT_ACCOUNT_LOAN_LOSS++;
			}
			if (CURRACCOUNTINFO_CLASS5STATE
					.equals(DictContratInfo.curraccountinfo_class5state_2)
					&& (LATESTPERFORMANCE_CLASS5STATE.isEmpty() | LATESTPERFORMANCE_CLASS5STATE
							.equals(DictContratInfo.LATESTPERFORMANCE_CLASS5STATE_2))) {
				/* 五级分类为关注的贷款账户数 */
				CNT_ACCOUNT_LOAN_ATTENTION++;
			}
			if ((ACCOUNTSTATE.equals(DictContratInfo.accountState_4) | ACCOUNTSTATE
					.equals(DictContratInfo.accountState_8))
					&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty()
							| LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_DZ) | LATESTPERFORMANCE_ACCOUNTSTATE
								.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_SFZC))) {
				/* 高风险状态的贷款账户数（呆账、司法追偿） */
				CNT_ACCOUNT_LOAN_ABNORMAL++;
			}
			if ((ACCOUNTSTATE.equals(DictContratInfo.accountState_4)
					| ACCOUNTSTATE.equals(DictContratInfo.accountState_5)
					| ACCOUNTSTATE.equals(DictContratInfo.accountState_6) | ACCOUNTSTATE
						.equals(DictContratInfo.accountState_8))
					&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty()
							| LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_DZ)
							| LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_SFZC)
							| LATESTPERFORMANCE_ACCOUNTSTATE
									.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_ZCZF) | LATESTPERFORMANCE_ACCOUNTSTATE
								.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_DBWBZ))) {
				/* 高风险状态的贷款账户数（呆账、转出/银行止付、担保物不足、司法追偿） */
				CNT_ACCT_LOAN_ABNORMAL++;
			}
			if ((ACCOUNTSTATE.equals(DictContratInfo.accountState_7))
					&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty() | LATESTPERFORMANCE_ACCOUNTSTATE
							.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_JZPC))) {
				/* 强制平仓的贷款账户数 */
				CNT_ACCT_LOAN_ABNORMAL_MANDATORY++;
			}

			if (ORGTYPE.equals(DictContratInfo.orgType_24)
					&& !ACCOUNTSTATE.equals(DictContratInfo.accountState_3)) {
				/* 未结清消费金融公司贷款的管理机构数 */
				CNT_ORG_LOAN_NORMAL_CF_TEMP_ORGCODE.add(FINANCEORG);
			}
			if (ORGTYPE.equals(DictContratInfo.orgType_51)
					&& !ACCOUNTSTATE.equals(DictContratInfo.accountState_3)) {
				/* 未结清小额贷款公司贷款的管理机构数 */
				CNT_ORG_LOAN_NORMAL_SM_TEMP_ORGCODE.add(FINANCEORG);
			}
			if (MONTH_AGE_UNIT <= 3) {
				/* 近3个月贷款核准记录数 */
				CNT_LOAN_APPROVE_IN3M++;
			}
			if (MONTH_AGE_UNIT <= 6) {
				/* 近6个月贷款核准记录数 */
				CNT_LOAN_APPROVE_IN6M++;
			}
			if (MONTH_AGE_UNIT <= 6) {
				/* 近6个月贷款核准机构数 */
				CNT_ORG_LOAN_APPROVE_IN6M_TEMP_ORGCODE.add(FINANCEORG);
			}

			if (DictContratInfo.LATESTPERFORMANCE_REPAYMENTTYPE_1TOZ
					.contains(LATESTPERFORMANCE_REPAYMENTTYPE)
					&& CURROVERDUE_CURROVERDUECYC > 0) {
				/**
				 * 贷款当前逾期的账户数
				 */
				CNT_ACCOUNT_LOAN_ODU_NOW++;
			}
			/**
			 * 早期风险预警指标
			 */
			// AMT_ACCOUNT_LOAN_M1E 贷款当前状态为逾期M1的逾期金额
			if (CURROVERDUE_CURROVERDUECYC == 1
					&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
							.equals(DictContratInfo.LATESTPERFORMANCE_REPAYMENTTYPE_1))) {
				AMT_ACCOUNT_LOAN_M1E = AMT_ACCOUNT_LOAN_M1E
						+ CURROVERDUE_CURROVERDUEAMOUNT;
			}
			// AMT_ACCOUNT_LOAN_M2E 贷款当前状态为逾期M2的逾期金额
			if (CURROVERDUE_CURROVERDUECYC == 2
					&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
							.equals(DictContratInfo.LATESTPERFORMANCE_REPAYMENTTYPE_2))) {
				AMT_ACCOUNT_LOAN_M2E = AMT_ACCOUNT_LOAN_M2E
						+ CURROVERDUE_CURROVERDUEAMOUNT;
			}
			// AMT_ACCOUNT_LOAN_M3E 贷款当前状态为逾期M3的逾期金额
			if (CURROVERDUE_CURROVERDUECYC == 3
					&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | LATESTPERFORMANCE_REPAYMENTTYPE
							.equals(DictContratInfo.LATESTPERFORMANCE_REPAYMENTTYPE_3))) {
				AMT_ACCOUNT_LOAN_M3E = AMT_ACCOUNT_LOAN_M3E
						+ CURROVERDUE_CURROVERDUEAMOUNT;
			}
			// AMT_ACCOUNT_LOAN_M4 贷款当前状态为逾期M4+的逾期金额
			if (CURROVERDUE_CURROVERDUECYC >= 4
					&& (LATESTPERFORMANCE_REPAYMENTTYPE.isEmpty() | DictContratInfo.LATESTPERFORMANCE_REPAYMENTTYPE_4TOZ
							.contains(LATESTPERFORMANCE_REPAYMENTTYPE))) {
				AMT_ACCOUNT_LOAN_M4 = AMT_ACCOUNT_LOAN_M4
						+ CURROVERDUE_CURROVERDUEAMOUNT;
			}
			// CNT_ACCOUNT_LOAN_ABNORMAL_ZF_ODU300 贷款当前状态为止付且逾期金额在300元及以上的账户数
			if (ACCOUNTSTATE.equals(DictContratInfo.accountState_ZF)
					&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty() | LATESTPERFORMANCE_ACCOUNTSTATE
							.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_ZF))
					&& CURROVERDUE_CURROVERDUEAMOUNT >= 300) {
				CNT_ACCOUNT_LOAN_ABNORMAL_ZF_ODU300++;
			}
			// CNT_ACCOUNT_LOAN_ABNORMAL_DJ_ODU300 贷款当前状态为冻结且逾期金额在300元及以上的账户数
			if (ACCOUNTSTATE.equals(DictContratInfo.accountState_DJ)
					&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty() | LATESTPERFORMANCE_ACCOUNTSTATE
							.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_DJ))
					&& CURROVERDUE_CURROVERDUEAMOUNT >= 300) {
				CNT_ACCOUNT_LOAN_ABNORMAL_DJ_ODU300++;
			}
			// CNT_ACCOUNT_LOAN_ABNORMAL_DZ_ODU300 贷款当前状态为呆账且逾期金额在300元及以上的账户数
			if (ACCOUNTSTATE.equals(DictContratInfo.accountState_DZ)
					&& (LATESTPERFORMANCE_ACCOUNTSTATE.isEmpty() | LATESTPERFORMANCE_ACCOUNTSTATE
							.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_DZ))
					&& CURROVERDUE_CURROVERDUEAMOUNT >= 300) {
				CNT_ACCOUNT_LOAN_ABNORMAL_DZ_ODU300++;
			}
			// CNT_ACCOUNT_LOAN_ABNORMAL_DB 贷款当前状态为担保人代偿以资抵债账户数
			for (int i = 0; i < SPECIALTRADELIST.size(); i++) {
				String SPECIALTRADELIST_TYPE = MapUtils
						.getStringFromMap((Map) ArrayUtils.getObjectFromList(
								SPECIALTRADELIST, i),
								ContratInfoEnum.SPECIALTRADELIST_TYPE.field);
				if (SPECIALTRADELIST_TYPE
						.equals(DictContratInfo.SPECIALTRADELIST_TYPE_DBRDH)
						| SPECIALTRADELIST_TYPE
								.equals(DictContratInfo.SPECIALTRADELIST_TYPE_YZDZ)) {
					CNT_ACCOUNT_LOAN_ABNORMAL_DB++;
				}
			}
			// CNT_ACCOUNT_LOAN_5000 未结清贷款的发放金额小于等于5000笔数
			if (!ACCOUNTSTATE.equals(DictContratInfo.accountState_3)
					&& !LATESTPERFORMANCE_ACCOUNTSTATE
							.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_JQ)
					&& CREDITLIMITAMOUNT <= 5000 && CREDITLIMITAMOUNT > 0) {
				CNT_ACCOUNT_LOAN_5000++;
			}
			// CNT_ACCOUNT_LOAN_NO_HOUSE_CAR 未结清非房贷、车贷的贷款笔数
			if (!ACCOUNTSTATE.equals(DictContratInfo.accountState_3)
					&& !LATESTPERFORMANCE_ACCOUNTSTATE
							.equals(DictContratInfo.LATESTPERFORMANCE_ACCOUNTSTATE_JQ)
					&& (!TYPE.equals(DictContratInfo.type_11)
							| !TYPE.equals(DictContratInfo.type_12)
							| !TYPE.equals(DictContratInfo.type_13) | !TYPE
								.equals(DictContratInfo.type_21))) {
				CNT_ACCOUNT_LOAN_NO_HOUSE_CAR++;
			}
			// CNT_LOAN_TRUST 未结清信托贷款账户数
			if (!ACCOUNTSTATE.equals(DictContratInfo.accountState_3)
					&& FINANCEORG.contains(DictContratInfo.FINANCEORG_XT)) {
				CNT_LOAN_TRUST++;
			}

			/**
			 * 循环指标
			 */
			Integer CNT_NODU_ACCOUNT_LOAN_AGE6_TEMP = 0;
			Integer CNT_NODU_ACCOUNT_LOAN_AGE12_TEMP = 0;
			if (MONTH_AGE_UNIT >= 6) {
				CNT_NODU_ACCOUNT_LOAN_AGE6_TEMP = 1;
			}
			if (MONTH_AGE_UNIT >= 12) {
				CNT_NODU_ACCOUNT_LOAN_AGE12_TEMP = 1;
			}
			Integer CNT_ACCOUNT_ODU_LOAN_SL_IN12M_TEMP_IS = 0;
			Integer CNT_ACCOUNT_ODU_LOAN_CF_IN12M_TEMP_IS = 0;
			Integer CNT_ODU_ACCOUNT_LOAN_IN24M_MAX_TEMP = 0;
			Integer CNT_ACCOUNT_ODU_LOAN_SL_IN24M_TEMP_IS = 0;
			Integer CNT_ACCOUNT_ODU_LOAN_CF_IN24M_TEMP_IS = 0;
			Integer CNT_ODU_ACCOUNT_LOAN_IN24M_TEMP = 0;

			Integer CNT_ODU_ACCOUNT_LOAN_IN3M_TEMP = 0;
			Integer CNT_ODU_ACCOUNT_LOAN_CR_IN3M_TEMP = 0;
			Integer CNT_ODU_ACCOUNT_LOAN_IN6M_TEMP = 0;
			Integer CNT_ODU_ACCOUNT_LOAN_IN12M_TEMP = 0;
			Integer CNT_ACCT_LOAN_M3_TEMP = 0;
			Integer CNT_ACCT_LOAN_M2E_IN3M_TEMP = 0;
			Integer CNT_ACCT_LOAN_M2E_IN6M_TEMP = 0;
			Integer CNT_ACCT_LOAN_M2E_IN12M_TEMP = 0;
			Integer CNT_ACCT_LOAN_M2E_IN6M_2TP_TEMP = 0;
			Integer CNT_ACCT_LOAN_M2E_IN12M_3TP_TEMP = 0;
			Integer CNT_ACCT_LOAN_M3_IN24M_TEMP = 0;
			Integer CNT_ACCT_LOAN_M3_OUT24M_TEMP = 0;
			Integer AMT_MORTGAGE_CONTRACT_TEMP_N_COUNT = 0;
			Integer AMT_MORTGAGE_CONTRACT_OBANK_TEMP_N_COUNT = 0;

			Integer CNT_ACCT_LOAN_M2E_IN6M_2TP_COUNT = 0;
			Integer CNT_ACCT_LOAN_M2E_IN12M_3TP_COUNT = 0;
			Integer CNT_ACCT_LOAN_M1E_IN12M_6TP_TEMP = 0;
			Integer CNT_ACCT_LOAN_M1E_IN12M_6TP_COUNT = 0;

			for (int i = 0; i < COVERDUERECORDLIST.size(); i++) {
				Integer ReportCreateTime_COVERDUERECORDLIST_MONTH_diff;
				try {
					ReportCreateTime_COVERDUERECORDLIST_MONTH_diff = DateUtils
							.getdateDiffMonth(
									pbocBaseInfoPO.getReportCreateTime(),
									MapUtils.getStringFromMap(
											(Map) ArrayUtils.getObjectFromList(
													COVERDUERECORDLIST, i),
											ContratInfoEnum.COVERDUERECORDLIST_MONTH.field),
									DateUtils.DATE_FORMAT_3,
									DateUtils.DATE_FORMAT_5);
				} catch (Exception e) {
					log.error("日期存在问题,错误日期记录为{}", (Map) ArrayUtils
							.getObjectFromList(COVERDUERECORDLIST, i));
					continue;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff < 0) {
					log.error(
							"日期存在问题,错误日期为{},计算时间差为{}",
							MapUtils.getStringFromMap(
									(Map) ArrayUtils.getObjectFromList(
											COVERDUERECORDLIST, i),
									ContratInfoEnum.COVERDUERECORDLIST_MONTH.field),
							ReportCreateTime_COVERDUERECORDLIST_MONTH_diff);
					continue;
				}
				String COVERDUERECORDLIST_REPAYMENTSTATUS = MapUtils
						.getStringFromMap(
								(Map) ArrayUtils.getObjectFromList(
										COVERDUERECORDLIST, i),
								ContratInfoEnum.COVERDUERECORDLIST_REPAYMENTSTATUS.field);
				/**
				 * 最近3个月
				 */
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 3
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& (CONTRATTYPE.equals(DictContratInfo.contratType_D1)
								| CONTRATTYPE
										.equals(DictContratInfo.contratType_R1) | CONTRATTYPE
									.equals(DictContratInfo.contratType_R4))) {
					// 最近3个月贷款逾期账户数
					CNT_ODU_ACCOUNT_LOAN_IN3M_TEMP = 1;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 3
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_2
								.equals(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 最近3个月贷款账户逾期2期次数
					CNT_ODU_ACCOUNT_LOAN_M2_IN3M++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 3
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& GUARANTEETYPE
								.equals(DictContratInfo.guaranteeType_4)) {
					// 最近3个月无抵押贷款逾期账户数
					CNT_ODU_ACCOUNT_LOAN_CR_IN3M_TEMP = 1;
				}

				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 3
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_2
								.equals(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 近3个月存在逾期2期的贷款账户数
					CNT_ACCT_LOAN_M2E_IN3M_TEMP = 1;
				}
				/**
				 * 最近6个月
				 */
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& (CONTRATTYPE.equals(DictContratInfo.contratType_D1)
								| CONTRATTYPE
										.equals(DictContratInfo.contratType_R1) | CONTRATTYPE
									.equals(DictContratInfo.contratType_R4))) {
					// 最近6个月贷款逾期账户数
					CNT_ODU_ACCOUNT_LOAN_IN6M_TEMP = 1;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_4TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 最近6个月贷款账户逾期3期及以上次数
					CNT_ODU_ACCOUNT_LOAN_M4_IN6M++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 最近6个月贷款账户逾期3期及以上次数
					CNT_ODU_ACCOUNT_LOAN_M3_IN6M++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_2TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 最近6个月贷款账户逾期2期及以上次数
					CNT_ODU_ACCOUNT_LOAN_M2_IN6M++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 最近6个月贷款账户逾期1期及以上次数
					CNT_ODU_ACCOUNT_LOAN_M1_IN6M++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& COVERDUERECORDLIST_REPAYMENTSTATUS
								.equals(DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_3)) {
					// 最近6个月贷款账户逾期3期次数
					CNT_ODU_ACCOUNT_LOAN_M3E_IN6M++;
				}

				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& COVERDUERECORDLIST_REPAYMENTSTATUS
								.equals(DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_2)) {
					// 最近6个月贷款账户逾期2期次数
					CNT_ODU_ACCOUNT_LOAN_M2E_IN6M++;
					CNT_ACCT_LOAN_M2E_IN6M_2TP_COUNT++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& COVERDUERECORDLIST_REPAYMENTSTATUS
								.equals(DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1)) {
					// 最近6个月贷款账户逾期1期次数
					CNT_ODU_ACCOUNT_LOAN_M1E_IN6M++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_2
								.equals(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 近6个月存在逾期2期的贷款账户数
					CNT_ACCT_LOAN_M2E_IN6M_TEMP = 1;
				}
				if (ACCOUNTSTATE.equals(DictContratInfo.accountState_1)
						&& FINANCEORG.length() > 2
						&& (COMMONLOANMARK
								.equals(DictContratInfo.COMMONLOANMARK_1) | COMMONLOANMARK
								.equals(DictContratInfo.COMMONLOANMARK_5))
						&& (TYPE.equals(DictContratInfo.type_11) | TYPE
								.equals(DictContratInfo.type_12))
						&& ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_N
								.equals(COVERDUERECORDLIST_REPAYMENTSTATUS)) {
					// 本行正常在续贷款的合同金额
					// 还款状态N的个数
					AMT_MORTGAGE_CONTRACT_TEMP_N_COUNT++;
				}
				if (ACCOUNTSTATE.equals(DictContratInfo.accountState_1)
						&& FINANCEORG.length() == 2
						&& (COMMONLOANMARK
								.equals(DictContratInfo.COMMONLOANMARK_1) | COMMONLOANMARK
								.equals(DictContratInfo.COMMONLOANMARK_5))
						&& (TYPE.equals(DictContratInfo.type_11) | TYPE
								.equals(DictContratInfo.type_12))
						&& ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 6
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_N
								.equals(COVERDUERECORDLIST_REPAYMENTSTATUS)) {
					// 他行正常在续贷款的合同金额
					// 还款状态N的个数
					AMT_MORTGAGE_CONTRACT_OBANK_TEMP_N_COUNT++;
				}

				/**
				 * 最近12个月
				 */
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 12
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 最近12个月贷款逾期账户数
					CNT_ODU_ACCOUNT_LOAN_IN12M_TEMP = 1;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 12
						&& COVERDUERECORDLIST_REPAYMENTSTATUS
								.equals(DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1)) {
					// 最近12个月贷款账户逾期1期次数
					CNT_ODU_ACCOUNT_LOAN_M1E_IN12M++;
					CNT_ACCT_LOAN_M1E_IN12M_6TP_COUNT++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 12
						&& COVERDUERECORDLIST_REPAYMENTSTATUS
								.equals(DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_2)) {
					// 最近12个月贷款账户逾期2期次数
					CNT_ODU_ACCOUNT_LOAN_M2E_IN12M++;
					// 近12个月存在逾期2期记录的贷款账户数
					CNT_ACCT_LOAN_M2E_IN12M_TEMP = 1;
					// 近12个月存在逾期2期记录大于等于3次的贷款账户数
					CNT_ACCT_LOAN_M2E_IN12M_3TP_COUNT++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 12
						&& COVERDUERECORDLIST_REPAYMENTSTATUS
								.equals(DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_3)) {
					// 最近12个月贷款账户逾期3期次数
					CNT_ODU_ACCOUNT_LOAN_M3E_IN12M++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 12
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 最近12个月贷款账户逾期3期及以上次数
					CNT_ODU_ACCOUNT_LOAN_M3_IN12M++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 12
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 最近12个月贷款账户逾期4期及以上次数
					CNT_ODU_ACCOUNT_LOAN_M4_IN12M++;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 12
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& ORGTYPE.equals(DictContratInfo.orgType_24)) {
					// 最近12个月消费金融公司贷款逾期账户数
					CNT_ACCOUNT_ODU_LOAN_CF_IN12M_TEMP_IS = 1;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 12
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& ORGTYPE.equals(DictContratInfo.orgType_51)) {
					// 最近12个月小额贷款公司贷款逾期账户数
					CNT_ACCOUNT_ODU_LOAN_SL_IN12M_TEMP_IS = 1;
				}
				/**
				 * 最近24个月
				 */
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 24
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& (CONTRATTYPE.equals(DictContratInfo.contratType_D1)
								| CONTRATTYPE
										.equals(DictContratInfo.contratType_R1) | CONTRATTYPE
									.equals(DictContratInfo.contratType_R4))) {
					// 最近24个月贷款账户最大逾期次数
					CNT_ODU_ACCOUNT_LOAN_IN24M_MAX_TEMP++;
					// 最近24个月贷款逾期账户数
					CNT_ODU_ACCOUNT_LOAN_IN24M_TEMP = 1;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 24
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& ORGTYPE.equals(DictContratInfo.orgType_24)) {
					// 最近24个月消费金融公司贷款逾期账户数
					CNT_ACCOUNT_ODU_LOAN_CF_IN24M_TEMP_IS = 1;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 24
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& ORGTYPE.equals(DictContratInfo.orgType_51)) {
					// 最近24个月小额贷款公司贷款逾期账户数
					CNT_ACCOUNT_ODU_LOAN_SL_IN24M_TEMP_IS = 1;
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 24
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 最近24个月贷款账户逾期3期及以上次数
					CNT_ODU_ACCOUNT_LOAN_M3_IN24M++;
					CNT_ACCT_LOAN_M3_IN24M_TEMP = 1;

				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 24
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 最近24个月贷款账户逾期1期及以上次数
					CNT_ODU_ACCOUNT_LOAN_M1_IN24M++;
				}

				/**
				 * 24个月以外
				 */
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff > 24
						&& DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 24个月以外贷款账户逾期3期及以上次数
					CNT_ODU_ACCOUNT_LOAN_M3_OUT24M++;
					// 24个月以外逾期3期及以上的贷款账户数
					CNT_ACCT_LOAN_M3_OUT24M_TEMP = 1;
				}

				/**
				 * 最近N个月
				 */
				if (DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_2TOZ
						.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& (CONTRATTYPE.equals(DictContratInfo.contratType_D1)
								| CONTRATTYPE
										.equals(DictContratInfo.contratType_R1) | CONTRATTYPE
									.equals(DictContratInfo.contratType_R4))) {
					// 贷款账户出现过M2+逾期次数
					CNT_ODU_ACCOUNT_LOAN_M2++;
				}
				if (DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
						.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& (CONTRATTYPE.equals(DictContratInfo.contratType_D1)
								| CONTRATTYPE
										.equals(DictContratInfo.contratType_R1) | CONTRATTYPE
									.equals(DictContratInfo.contratType_R4))) {
					// 贷款账户出现过M3+逾期次数
					CNT_ODU_ACCOUNT_LOAN_M3++;
				}
				if (DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_3TOZ
						.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()) {
					// 历史存在逾期3期及以上贷款账户数
					CNT_ACCT_LOAN_M3_TEMP = 1;
				}

				if (DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
						.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& (CONTRATTYPE.equals(DictContratInfo.contratType_D1)
								| CONTRATTYPE
										.equals(DictContratInfo.contratType_R1) | CONTRATTYPE
									.equals(DictContratInfo.contratType_R4))) {
					/*
					 * 贷记卡账户最高逾期期数
					 */
					if (DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_GTOZ
							.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)) {
						MONTH_ODU_ACCOUNT_LOAN_MAX = Math.max(7,
								MONTH_ODU_ACCOUNT_LOAN_MAX);
					}
					if (DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TO7
							.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)) {
						MONTH_ODU_ACCOUNT_LOAN_MAX = Math.max(Integer
								.valueOf(COVERDUERECORDLIST_REPAYMENTSTATUS),
								MONTH_ODU_ACCOUNT_LOAN_MAX);
					}
				}
				/**
				 * 最近一次
				 */
				if (DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
						.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)
						&& !COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty()
						&& (CONTRATTYPE.equals(DictContratInfo.contratType_D1)
								| CONTRATTYPE
										.equals(DictContratInfo.contratType_R1) | CONTRATTYPE
									.equals(DictContratInfo.contratType_R4))) {
					// 距最近一次贷款账户逾期的月数
					MONTH_ODU_ACCOUNT_LOAN = Math.min(MONTH_ODU_ACCOUNT_LOAN,
							ReportCreateTime_COVERDUERECORDLIST_MONTH_diff);
				}
				if (ReportCreateTime_COVERDUERECORDLIST_MONTH_diff <= 24
						&& (!COVERDUERECORDLIST_REPAYMENTSTATUS.isEmpty() && !DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_Other
								.contains(COVERDUERECORDLIST_REPAYMENTSTATUS))) {
					/**
					 * 人行征信贷款信息24个月内是否无更新
					 */
					IF_LOAN_REPORT_UPDATE_IN24MONTH = false;
				}
				/**
				 * 账龄相关
				 */
				if (DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
						.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)) {
					// 账龄≥6个月且从未逾期的贷款账户数
					CNT_NODU_ACCOUNT_LOAN_AGE6_TEMP = 0;
				}
				if (DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_1TOZ
						.contains(COVERDUERECORDLIST_REPAYMENTSTATUS)) {
					// 账龄≥12个月且从未逾期的贷款账户数
					CNT_NODU_ACCOUNT_LOAN_AGE12_TEMP = 0;
				}

				/**
				 * 还款状态
				 */
				if (DictContratInfo.COVERDUERECORDLIST_REPAYMENTSTATUS_G
						.equals(COVERDUERECORDLIST_REPAYMENTSTATUS)) {
					// 人行报告中贷款还款状态为“G”出现的次数
					CNT_ODU_ACCOUNT_LOAN_G++;
				}
			}

			// 近6个月存在逾期2期记录大于等于2次的贷款账户数
			if (CNT_ACCT_LOAN_M2E_IN6M_2TP_COUNT >= 2) {
				CNT_ACCT_LOAN_M2E_IN6M_2TP_TEMP = 1;
			}
			CNT_ACCT_LOAN_M2E_IN6M_2TP = CNT_ACCT_LOAN_M2E_IN6M_2TP
					+ CNT_ACCT_LOAN_M2E_IN6M_2TP_TEMP;
			// 近12个月存在逾期2期记录大于等于3次的贷款账户数
			if (CNT_ACCT_LOAN_M2E_IN12M_3TP_COUNT >= 3) {
				CNT_ACCT_LOAN_M2E_IN12M_3TP_TEMP = 1;
			}
			CNT_ACCT_LOAN_M2E_IN12M_3TP = CNT_ACCT_LOAN_M2E_IN12M_3TP
					+ CNT_ACCT_LOAN_M2E_IN12M_3TP_TEMP;
			// 近12个月存在逾期1期记录大于等于6次的贷款账户数
			if (CNT_ACCT_LOAN_M1E_IN12M_6TP_COUNT >= 6) {
				CNT_ACCT_LOAN_M1E_IN12M_6TP_TEMP = 1;
			}
			CNT_ACCT_LOAN_M1E_IN12M_6TP = CNT_ACCT_LOAN_M1E_IN12M_6TP
					+ CNT_ACCT_LOAN_M1E_IN12M_6TP_TEMP;
			/**
			 * 本行正常在续贷款
			 */
			if (AMT_MORTGAGE_CONTRACT_TEMP_N_COUNT == 6
					| AMT_MORTGAGE_CONTRACT_TEMP_N_COUNT == 7) {
				// 本行正常在续贷款额的合同金额
				AMT_MORTGAGE_CONTRACT += CREDITLIMITAMOUNT;
				// 本行正常在续贷款的月还款额
				AMT_MORTGAGE_PAYMENT_MONTHLY += CURRACCOUNTINFO_SCHEDULEDPAYMENTAMOUNT;

			}
			/**
			 * 他行正常在续贷款
			 */
			if (AMT_MORTGAGE_CONTRACT_OBANK_TEMP_N_COUNT == 6
					| AMT_MORTGAGE_CONTRACT_OBANK_TEMP_N_COUNT == 7) {
				// 他行正常在续贷款的合同金额
				AMT_MORTGAGE_CONTRACT_OBANK += CREDITLIMITAMOUNT;
				// 他行正常在续贷款的月还款额
				AMT_MORTGAGE_PAYMENT_MONTHLY_OBANK += CURRACCOUNTINFO_SCHEDULEDPAYMENTAMOUNT;
			}

			// 最近12个月消费金融公司贷款逾期账户数
			CNT_ODU_ACCOUNT_LOAN_IN12M_CF = CNT_ODU_ACCOUNT_LOAN_IN12M_CF
					+ CNT_ACCOUNT_ODU_LOAN_CF_IN12M_TEMP_IS;
			// 最近12个月小额贷款公司贷款逾期账户数
			CNT_ODU_ACCOUNT_LOAN_IN12M_SL = CNT_ODU_ACCOUNT_LOAN_IN12M_SL
					+ CNT_ACCOUNT_ODU_LOAN_SL_IN12M_TEMP_IS;
			// 最近24个月贷款账户最大逾期次数
			CNT_ODU_ACCOUNT_LOAN_IN24M_MAX = Math.max(
					CNT_ODU_ACCOUNT_LOAN_IN24M_MAX,
					CNT_ODU_ACCOUNT_LOAN_IN24M_MAX_TEMP);
			// 最近24个月消费金融公司贷款逾期账户数
			CNT_ODU_ACCOUNT_LOAN_IN24M_CF = CNT_ODU_ACCOUNT_LOAN_IN24M_CF
					+ CNT_ACCOUNT_ODU_LOAN_CF_IN24M_TEMP_IS;
			// 最近24个月小额贷款公司贷款逾期账户数
			CNT_ODU_ACCOUNT_LOAN_IN24M_SL = CNT_ODU_ACCOUNT_LOAN_IN24M_SL
					+ CNT_ACCOUNT_ODU_LOAN_SL_IN24M_TEMP_IS;
			// 最近24个月贷款逾期账户数
			CNT_ODU_ACCOUNT_LOAN_IN24M = CNT_ODU_ACCOUNT_LOAN_IN24M
					+ CNT_ODU_ACCOUNT_LOAN_IN24M_TEMP;
			// 最近3个月贷款逾期账户数
			CNT_ODU_ACCOUNT_LOAN_IN3M = CNT_ODU_ACCOUNT_LOAN_IN3M
					+ CNT_ODU_ACCOUNT_LOAN_IN3M_TEMP;
			// 最近6个月贷款逾期账户数
			CNT_ODU_ACCOUNT_LOAN_IN6M = CNT_ODU_ACCOUNT_LOAN_IN6M
					+ CNT_ODU_ACCOUNT_LOAN_IN6M_TEMP;
			// 最近12个月贷款逾期账户数
			CNT_ODU_ACCOUNT_LOAN_IN12M = CNT_ODU_ACCOUNT_LOAN_IN12M
					+ CNT_ODU_ACCOUNT_LOAN_IN12M_TEMP;
			// 过去3个月无抵押贷款逾期账户数
			CNT_ODU_ACCOUNT_LOAN_CR_IN3M = CNT_ODU_ACCOUNT_LOAN_CR_IN3M
					+ CNT_ODU_ACCOUNT_LOAN_CR_IN3M_TEMP;
			// 近3个月存在逾期2期的贷款账户数
			CNT_ACCT_LOAN_M2E_IN3M = CNT_ACCT_LOAN_M2E_IN3M
					+ CNT_ACCT_LOAN_M2E_IN3M_TEMP;
			// 近6个月存在逾期2期记录的贷款账户数
			CNT_ACCT_LOAN_M2E_IN6M = CNT_ACCT_LOAN_M2E_IN6M
					+ CNT_ACCT_LOAN_M2E_IN6M_TEMP;
			// 历史存在逾期3期及以上贷款账户数
			CNT_ACCT_LOAN_M3 = CNT_ACCT_LOAN_M3 + CNT_ACCT_LOAN_M3_TEMP;
			// 近12个月存在逾期2期记录的贷款账户数
			CNT_ACCT_LOAN_M2E_IN12M = CNT_ACCT_LOAN_M2E_IN12M
					+ CNT_ACCT_LOAN_M2E_IN12M_TEMP;
			// 近6个月存在逾期2期记录大于等于2次的贷款账户数
			CNT_ACCT_LOAN_M2E_IN6M_2TP = CNT_ACCT_LOAN_M2E_IN12M
					+ CNT_ACCT_LOAN_M2E_IN12M_TEMP;
			// 近24个月逾期3期及以上的贷款账户数
			CNT_ACCT_LOAN_M3_IN24M = CNT_ACCT_LOAN_M3_IN24M
					+ CNT_ACCT_LOAN_M3_IN24M_TEMP;
			// 24个月以外逾期3期及以上的贷款账户数
			CNT_ACCT_LOAN_M3_OUT24M = CNT_ACCT_LOAN_M3_OUT24M
					+ CNT_ACCT_LOAN_M3_OUT24M_TEMP;

			/**
			 * 账龄判断
			 */
			if (MONTH_AGE_UNIT >= 6) {
				// 账龄≥6个月且从未逾期的贷款账户数
				CNT_NODU_ACCOUNT_LOAN_AGE6 = CNT_NODU_ACCOUNT_LOAN_AGE6
						+ CNT_NODU_ACCOUNT_LOAN_AGE6_TEMP;
			}
			if (MONTH_AGE_UNIT >= 12) {
				// 账龄≥12个月且从未逾期的贷款账户数
				CNT_NODU_ACCOUNT_LOAN_AGE12 = CNT_NODU_ACCOUNT_LOAN_AGE12
						+ CNT_NODU_ACCOUNT_LOAN_AGE12_TEMP;
			}
			// 贷款账户最长账龄（月）
			MONTH_AGE_LOAN = Math.max(MONTH_AGE_LOAN, MONTH_AGE_UNIT);
			/**
			 * 未偿金额占比≥80%
			 */
			if (CONTRATTYPE.equals(DictContratInfo.contratType_D1)
					| CONTRATTYPE.equals(DictContratInfo.contratType_R1)
					| CONTRATTYPE.equals(DictContratInfo.contratType_R4)) {
				if (CREDITLIMITAMOUNT > 0
						&& CURRACCOUNTINFO_BALANCE * 1.0 / CREDITLIMITAMOUNT
								* 1.0 >= 0.8) {
					// 未偿金额占比≥80%贷款账户数
					CNT_ACCOUNT_LOAN_LV80++;
					if (GUARANTEETYPE.equals(DictContratInfo.guaranteeType_4)) {
						// 未偿金额占比≥80%无抵押贷款账户数
						CNT_ACCOUNT_LOAN_LV80_CR++;
					}
				}
			}
		}
		/**
		 * 贷款发放机构数
		 */
		// 未结清消费金融公司贷款的管理机构数
		CNT_ORG_LOAN_NORMAL_CF = ArrayUtils.removeRepeat(
				CNT_ORG_LOAN_NORMAL_CF_TEMP_ORGCODE).size();
		// 未结清小额贷款公司贷款的管理机构数
		CNT_ORG_LOAN_NORMAL_SM = ArrayUtils.removeRepeat(
				CNT_ORG_LOAN_NORMAL_SM_TEMP_ORGCODE).size();
		/**
		 * 核准记录数
		 */
		// 近6个月贷款核准机构数
		CNT_ORG_LOAN_APPROVE_IN6M = ArrayUtils.removeRepeat(
				CNT_ORG_LOAN_APPROVE_IN6M_TEMP_ORGCODE).size();

		/**
		 * 未结清有抵押贷款户均合同金额
		 */
		if (AMT_CREDLIMIT_NORMAL_LOAN_MO_ORGCODE_TEMP > 0) {
			AMT_CREDLIMIT_NORMAL_LOAN_MO = AMT_CREDLIMIT_NORMAL_LOAN_MO_TEMP
					/ AMT_CREDLIMIT_NORMAL_LOAN_MO_ORGCODE_TEMP;
		}

		// 账户数计算
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_HO.field,
				CNT_ACCOUNT_LOAN_HO,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_HO.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_HO.field,
				CNT_ACCOUNT_NORMAL_LOAN_HO,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_HO.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_CR.field,
				CNT_ACCOUNT_NORMAL_LOAN_CR,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_CR.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_SL.field,
				CNT_ACCOUNT_NORMAL_LOAN_SL,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_SL.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_CF.field,
				CNT_ACCOUNT_NORMAL_LOAN_CF,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_CF.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_CL.field,
				CNT_ACCOUNT_NORMAL_LOAN_CL,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_CL.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_CF.field,
				CNT_ACCOUNT_LOAN_CF,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_CF.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_SL.field,
				CNT_ACCOUNT_LOAN_SL,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_SL.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_CL.field,
				CNT_ACCOUNT_NORMAL_LOAN_CL,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_CL.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.AMT_CREDLIMIT_NORMAL_LOAN_MO.field,
				AMT_CREDLIMIT_NORMAL_LOAN_MO,
				PbocLabelEnum.AMT_CREDLIMIT_NORMAL_LOAN_MO.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_AMT500.field,
				CNT_ODU_ACCOUNT_LOAN_AMT500,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_AMT500.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_ODU_NOW_MAXAMT.field,
				CNT_ACCOUNT_LOAN_ODU_NOW_MAXAMT,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ODU_NOW_MAXAMT.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ABNORMAL_ZF_ODU300.field,
				CNT_ACCOUNT_LOAN_ABNORMAL_ZF_ODU300,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ABNORMAL_ZF_ODU300.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ABNORMAL_DJ_ODU300.field,
				CNT_ACCOUNT_LOAN_ABNORMAL_DJ_ODU300,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ABNORMAL_DJ_ODU300.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ABNORMAL_DZ_ODU300.field,
				CNT_ACCOUNT_LOAN_ABNORMAL_DZ_ODU300,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ABNORMAL_DZ_ODU300.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_ABNORMAL_DB.field,
				CNT_ACCOUNT_LOAN_ABNORMAL_DB,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ABNORMAL_DB.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN6M_2TP.field,
				CNT_ACCT_LOAN_M2E_IN6M_2TP,
				PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN6M_2TP.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN12M_3TP.field,
				CNT_ACCT_LOAN_M2E_IN12M_3TP,
				PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN12M_3TP.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_LOAN_M3_OUT24M.field,
				CNT_ACCT_LOAN_M3_OUT24M,
				PbocLabelEnum.CNT_ACCT_LOAN_M3_OUT24M.fieldDesc);

		// 月数相关指标计算
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_ODU_ACCOUNT_LOAN.field,
				MONTH_ODU_ACCOUNT_LOAN,
				PbocLabelEnum.MONTH_ODU_ACCOUNT_LOAN.fieldDesc);

		// 额度使用率指标计算
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_LV80.field,
				CNT_ACCOUNT_LOAN_LV80,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_LV80.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_LV80_CR.field,
				CNT_ACCOUNT_LOAN_LV80_CR,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_LV80_CR.fieldDesc);

		// 账龄相关指标计算
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_AGE_NORMAL_LOAN.field,
				MONTH_AGE_NORMAL_LOAN,
				PbocLabelEnum.MONTH_AGE_NORMAL_LOAN.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_AGE24.field,
				CNT_ACCOUNT_NORMAL_LOAN_AGE24,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_AGE24.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_NODU_ACCOUNT_LOAN_AGE6.field,
				CNT_NODU_ACCOUNT_LOAN_AGE6,
				PbocLabelEnum.CNT_NODU_ACCOUNT_LOAN_AGE6.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_NODU_ACCOUNT_LOAN_AGE12.field,
				CNT_NODU_ACCOUNT_LOAN_AGE12,
				PbocLabelEnum.CNT_NODU_ACCOUNT_LOAN_AGE12.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_AGE12_OP.field,
				CNT_ACCOUNT_LOAN_AGE12_OP,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_AGE12_OP.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_AGE_LOAN.field, MONTH_AGE_LOAN,
				PbocLabelEnum.MONTH_AGE_LOAN.fieldDesc);

		// 逾期次数指标计算、
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN3M.field,
				CNT_ODU_ACCOUNT_LOAN_IN3M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_CR_IN3M.field,
				CNT_ODU_ACCOUNT_LOAN_CR_IN3M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_CR_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN3M.field,
				"CNT_ACCT_LOAN_M2E_IN3M",
				PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN6M.field,
				CNT_ACCT_LOAN_M2E_IN6M,
				PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M2_IN3M.field,
				CNT_ODU_ACCOUNT_LOAN_M2_IN3M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M2_IN3M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN6M.field,
				CNT_ODU_ACCOUNT_LOAN_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M4_IN6M.field,
				CNT_ODU_ACCOUNT_LOAN_M4_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M4_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3_IN6M.field,
				CNT_ODU_ACCOUNT_LOAN_M3_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M2_IN6M.field,
				CNT_ODU_ACCOUNT_LOAN_M2_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M2_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M1_IN6M.field,
				CNT_ODU_ACCOUNT_LOAN_M1_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M1_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3E_IN6M.field,
				CNT_ODU_ACCOUNT_LOAN_M3E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M2E_IN6M.field,
				CNT_ODU_ACCOUNT_LOAN_M2E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M2E_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M1E_IN6M.field,
				CNT_ODU_ACCOUNT_LOAN_M1E_IN6M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M1E_IN6M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN12M.field,
				CNT_ODU_ACCOUNT_LOAN_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M1E_IN12M.field,
				CNT_ODU_ACCOUNT_LOAN_M1E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M1E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M2E_IN12M.field,
				CNT_ODU_ACCOUNT_LOAN_M2E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M2E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3E_IN12M.field,
				CNT_ODU_ACCOUNT_LOAN_M3E_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3E_IN12M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3_IN12M.field,
				CNT_ODU_ACCOUNT_LOAN_M3_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3_IN12M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M4_IN12M.field,
				CNT_ODU_ACCOUNT_LOAN_M4_IN12M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M4_IN12M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN24M.field,
				CNT_ODU_ACCOUNT_LOAN_IN24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN24M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN12M_CF.field,
				CNT_ODU_ACCOUNT_LOAN_IN12M_CF,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN12M_CF.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN12M_SL.field,
				CNT_ODU_ACCOUNT_LOAN_IN12M_SL,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN12M_SL.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3_IN24M.field,
				CNT_ODU_ACCOUNT_LOAN_M3_IN24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3_IN24M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M1_IN24M.field,
				CNT_ODU_ACCOUNT_LOAN_M1_IN24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M1_IN24M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN24M_MAX.field,
				CNT_ODU_ACCOUNT_LOAN_IN24M_MAX,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN24M_MAX.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN24M_CF.field,
				CNT_ODU_ACCOUNT_LOAN_IN24M_CF,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN24M_CF.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN24M_SL.field,
				CNT_ODU_ACCOUNT_LOAN_IN24M_SL,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_IN24M_SL.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M2.field,
				CNT_ODU_ACCOUNT_LOAN_M2,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M2.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3.field,
				CNT_ODU_ACCOUNT_LOAN_M3,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_LOAN_M3.field,
				CNT_ACCT_LOAN_M3, PbocLabelEnum.CNT_ACCT_LOAN_M3.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN12M.field,
				CNT_ACCT_LOAN_M2E_IN12M,
				PbocLabelEnum.CNT_ACCT_LOAN_M2E_IN12M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_ODU_NOW.field,
				CNT_ACCOUNT_LOAN_ODU_NOW,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ODU_NOW.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3_OUT24M.field,
				CNT_ODU_ACCOUNT_LOAN_M3_OUT24M,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_M3_OUT24M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.MONTH_ODU_ACCOUNT_LOAN_MAX.field,
				MONTH_ODU_ACCOUNT_LOAN_MAX,
				PbocLabelEnum.MONTH_ODU_ACCOUNT_LOAN_MAX.fieldDesc);

		// 五级分类指标
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_SEC.field,
				CNT_ACCOUNT_LOAN_SEC,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_SEC.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_SUS.field,
				CNT_ACCOUNT_LOAN_SUS,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_SUS.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_LOSS.field,
				CNT_ACCOUNT_LOAN_LOSS,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_LOSS.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_ATTENTION.field,
				CNT_ACCOUNT_LOAN_ATTENTION,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ATTENTION.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_ABNORMAL.field,
				CNT_ACCOUNT_LOAN_ABNORMAL,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_ABNORMAL.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCT_LOAN_ABNORMAL.field,
				CNT_ACCT_LOAN_ABNORMAL,
				PbocLabelEnum.CNT_ACCT_LOAN_ABNORMAL.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCT_LOAN_ABNORMAL_MANDATORY.field,
				CNT_ACCT_LOAN_ABNORMAL_MANDATORY,
				PbocLabelEnum.CNT_ACCT_LOAN_ABNORMAL_MANDATORY.fieldDesc);

		// 其他指标
		pbocRspPO.addIndex(PbocLabelEnum.IF_LOAN_REPORT_UPDATE_IN24MONTH.field,
				IF_LOAN_REPORT_UPDATE_IN24MONTH,
				PbocLabelEnum.IF_LOAN_REPORT_UPDATE_IN24MONTH.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_AGE24_MO.field,
				CNT_ACCOUNT_NORMAL_LOAN_AGE24_MO,
				PbocLabelEnum.CNT_ACCOUNT_NORMAL_LOAN_AGE24_MO.fieldDesc);

		// 贷款发放机构数
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_LOAN_NORMAL_CF.field,
				CNT_ORG_LOAN_NORMAL_CF,
				PbocLabelEnum.CNT_ORG_LOAN_NORMAL_CF.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_LOAN_NORMAL_SM.field,
				CNT_ORG_LOAN_NORMAL_SM,
				PbocLabelEnum.CNT_ORG_LOAN_NORMAL_SM.fieldDesc);

		// 核准记录数
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_APPROVE_IN3M.field,
				CNT_LOAN_APPROVE_IN3M,
				PbocLabelEnum.CNT_LOAN_APPROVE_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_APPROVE_IN6M.field,
				CNT_LOAN_APPROVE_IN6M,
				PbocLabelEnum.CNT_LOAN_APPROVE_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_LOAN_APPROVE_IN6M.field,
				CNT_ORG_LOAN_APPROVE_IN6M,
				PbocLabelEnum.CNT_ORG_LOAN_APPROVE_IN6M.fieldDesc);

		// 金额相关指标
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_BALANCE.field,
				CNT_LOAN_BALANCE, PbocLabelEnum.CNT_LOAN_BALANCE.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_BALANCE_XF.field,
				CNT_LOAN_BALANCE_XF,
				PbocLabelEnum.CNT_LOAN_BALANCE_XF.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_MORTGAGE_BALANCE.field,
				CNT_MORTGAGE_BALANCE,
				PbocLabelEnum.CNT_MORTGAGE_BALANCE.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_BALANCE_OTHER.field,
				CNT_LOAN_BALANCE_OTHER,
				PbocLabelEnum.CNT_LOAN_BALANCE_OTHER.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_MORTGAGE_AMT_NEW.field,
				CNT_MORTGAGE_AMT_NEW,
				PbocLabelEnum.CNT_MORTGAGE_AMT_NEW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_MORTGAGE_PAY_NEW.field,
				CNT_MORTGAGE_PAY_NEW,
				PbocLabelEnum.CNT_MORTGAGE_PAY_NEW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_MORTGAGE_DURATION_NEW.field,
				CNT_MORTGAGE_DURATION_NEW,
				PbocLabelEnum.CNT_MORTGAGE_DURATION_NEW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_AMT_NEW.field,
				CNT_LOAN_AMT_NEW, PbocLabelEnum.CNT_LOAN_AMT_NEW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_PAY_NEW.field,
				CNT_LOAN_PAY_NEW, PbocLabelEnum.CNT_LOAN_PAY_NEW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_DURATION_NEW.field,
				CNT_LOAN_DURATION_NEW,
				PbocLabelEnum.CNT_LOAN_DURATION_NEW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_MORTGAGE_CONTRACT_OBANK.field,
				AMT_MORTGAGE_CONTRACT_OBANK,
				PbocLabelEnum.AMT_MORTGAGE_CONTRACT_OBANK.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_MORTGAGE_CONTRACT.field,
				AMT_MORTGAGE_CONTRACT,
				PbocLabelEnum.AMT_MORTGAGE_CONTRACT.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_MORTGAGE_PAYMENT_MONTHLY.field,
				AMT_MORTGAGE_PAYMENT_MONTHLY,
				PbocLabelEnum.AMT_MORTGAGE_PAYMENT_MONTHLY.fieldDesc);
		pbocRspPO.addIndex(
				PbocLabelEnum.AMT_MORTGAGE_PAYMENT_MONTHLY_OBANK.field,
				AMT_MORTGAGE_PAYMENT_MONTHLY_OBANK,
				PbocLabelEnum.AMT_MORTGAGE_PAYMENT_MONTHLY_OBANK.fieldDesc);

		// 早期风险预警
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_LOAN_M1E.field,
				AMT_ACCOUNT_LOAN_M1E,
				PbocLabelEnum.AMT_ACCOUNT_LOAN_M1E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_LOAN_M2E.field,
				AMT_ACCOUNT_LOAN_M2E,
				PbocLabelEnum.AMT_ACCOUNT_LOAN_M2E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_LOAN_M3E.field,
				AMT_ACCOUNT_LOAN_M3E,
				PbocLabelEnum.AMT_ACCOUNT_LOAN_M3E.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_ACCOUNT_LOAN_M4.field,
				AMT_ACCOUNT_LOAN_M4,
				PbocLabelEnum.AMT_ACCOUNT_LOAN_M4.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_5000.field,
				CNT_ACCOUNT_LOAN_5000,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_5000.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCOUNT_LOAN_NO_HOUSE_CAR.field,
				CNT_ACCOUNT_LOAN_NO_HOUSE_CAR,
				PbocLabelEnum.CNT_ACCOUNT_LOAN_NO_HOUSE_CAR.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_TRUST.field, CNT_LOAN_TRUST,
				PbocLabelEnum.CNT_LOAN_TRUST.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_LOAN_NON_COLLATERAL_BALANCE.field,
				AMT_LOAN_NON_COLLATERAL_BALANCE,
				PbocLabelEnum.AMT_LOAN_NON_COLLATERAL_BALANCE.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_LOAN_BALANCE_CREDIT.field,
				AMT_LOAN_BALANCE_CREDIT,
				PbocLabelEnum.AMT_LOAN_BALANCE_CREDIT.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.AMT_LOAN_BALANCE_XF.field,
				AMT_LOAN_BALANCE_XF,
				PbocLabelEnum.AMT_LOAN_BALANCE_XF.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_NON_COLLATERAL_20P.field,
				CNT_LOAN_NON_COLLATERAL_20P,
				PbocLabelEnum.CNT_LOAN_NON_COLLATERAL_20P.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_COMMERCIAL_20P.field,
				CNT_LOAN_COMMERCIAL_20P,
				PbocLabelEnum.CNT_LOAN_COMMERCIAL_20P.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_NORMAL_GUARANTEE.field,
				CNT_LOAN_NORMAL_GUARANTEE,
				PbocLabelEnum.CNT_LOAN_NORMAL_GUARANTEE.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_G.field,
				CNT_ODU_ACCOUNT_LOAN_G,
				PbocLabelEnum.CNT_ODU_ACCOUNT_LOAN_G.fieldDesc);
	}
}
