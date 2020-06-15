package com.jerry.pbocLabel.enums.label;

/**
 * 人行字段解析标签（人行指标）
 * 
 * @author chenliang
 *
 */
public enum PbocLabelEnum {

	REPORT_DATE("REPORT_DATE", "报告日期", "String"),
	/*
	 * forceExecution
	 */
	CNT_EXECUTE_IN24M("CNT_EXECUTE_IN24M", "最近24个月存在强制执行记录", "Integer"), CNT_EXECUTE_SX(
			"CNT_EXECUTE_SX", "失信被执行人记录数", "Integer"), CNT_EXECUTE_IN12M(
			"CNT_EXECUTE_IN12M", "近12个月强制执行记录数", "Integer"),
	/*
	 * telPayment
	 */
	CNT_OWE_LAST6M_IN24M("CNT_OWE_LAST6M_IN24M",
			"近24个月累计欠费6个月及以上的电信或任一公用事业缴费欠费记录数", "Integer"),
	/*
	 * recordDetail
	 */
	MONTH_APPLY_QUERY_CARD("MONTH_APPLY_QUERY_CARD", "最近一次他行信用卡审批查询距今月数",
			"Integer"), MONTH_APPLY_QUERY_LOAN("MONTH_APPLY_QUERY_LOAN",
			"最近一次他行贷款审批查询距今月数", "Integer"),

	CNT_ORG_APPLY_QUERY_IN1M("CNT_ORG_APPLY_QUERY_IN1M", "近1个月非本行信贷审批查询总计机构数",
			"Integer"), CNT_ORG_APPLY_QUERY_IN12M("CNT_ORG_APPLY_QUERY_IN12M",
			"近12个月非本行信贷审批查询总计机构数", "Integer"), CNT_APPLY_QUERY_IN2M(
			"CNT_APPLY_QUERY_IN2M", "近2个月(60天)非本行信用报告查询次数", "Integer"),

	CNT_APPLY_QUERY_CARD_IN3M("CNT_APPLY_QUERY_CARD_IN3M", "过去3个月他行信用卡审批查询次数",
			"Integer"), CNT_APPLY_QUERY_LOAN_IN3M("CNT_APPLY_QUERY_LOAN_IN3M",
			"过去3个月他行贷款审核查询次数", "Integer"),

	CNT_ORG_APPLY_QUERY_CARD_IN3M("CNT_ORG_APPLY_QUERY_CARD_IN3M",
			"过去3个月他行信用卡审批查询机构数", "Integer"), CNT_ORG_APPLY_QUERY_LOAN_IN3M(
			"CNT_ORG_APPLY_QUERY_LOAN_IN3M", "过去3个月他行贷款审批查询机构数", "Integer"),

	CNT_APPLY_QUERY_CARD_IN6M("CNT_APPLY_QUERY_CARD_IN6M", "过去6个月他行信用卡审批查询次数",
			"Integer"), CNT_APPLY_QUERY_LOAN_IN6M("CNT_APPLY_QUERY_LOAN_IN6M",
			"过去6个月他行贷款审核查询次数", "Integer"),

	CNT_ORG_APPLY_QUERY_CARD_IN6M("CNT_ORG_APPLY_QUERY_CARD_IN6M",
			"过去6个月他行信用卡审批查询机构数", "Integer"), CNT_ORG_APPLY_QUERY_LOAN_IN6M(
			"CNT_ORG_APPLY_QUERY_LOAN_IN6M", "过去6个月他行贷款审批查询机构数", "Integer"),

	MONTH_APPLY_QUERY_GUARANTEE("MONTH_APPLY_QUERY_GUARANTEE",
			"最近一次他行担保资格审查查询距今月数", "Integer"), CNT_QUERY_IN6M("CNT_QUERY_IN6M",
			"近6个月人行查询次数（查询类型为信用卡、贷款、担保）", "Integer"), CNT_QUERY_IN6M_1(
			"CNT_QUERY_IN6M_1", "近6个月人行查询次数（查询类型为信用卡、贷款、担保）-广西农信的特殊要求",
			"Integer"), CNT_QUERY_IN3M("CNT_QUERY_IN3M",
			"近3个月人行查询次数（查询类型为信用卡、贷款、担保）", "Integer"), CNT_ORG_QUERY_IN3M(
			"CNT_ORG_QUERY_IN3M", "近3个月人行查询次数（1个自然月内 同一机构相同原因的查询记录记作一次）",
			"Integer"), CNT_ORG_QUERY_IN6M("CNT_ORG_QUERY_IN6M",
			"近6个月人行查询次数（1个自然月内 同一机构相同原因的查询记录记作一次)", "Integer"),

	CNT_ORG_APPLY_QUERY_IN3M("CNT_ORG_APPLY_QUERY_IN3M", "近3个月他行信贷审批查询总计机构数",
			"Integer"), CNT_ORG_APPLY_QUERY_IN6M("CNT_ORG_APPLY_QUERY_IN6M",
			"近6个月他行信贷审批查询总计机构数", "Integer"), CNT_ORG_APPLY_QUERY_IN3M_1(
			"CNT_ORG_APPLY_QUERY_IN3M_1",
			"近3个月非本行信贷审批查询总计机构数（相比评分卡来说，查询原因多了“担保资格审查”）", "Integer"),

	/**
	 * creditSummaryCue
	 */
	MONTH_CREDIT_HISTORY_LENGTH("MONTH_CREDIT_HISTORY_LENGTH", "信用历史长度",
			"Integer"), IF_NO_PBOC_RECORD("IF_NO_PBOC_RECORD",
			"是否为 无人行征信报告、无信贷记录", "Boolean"), CNT_LOAN_SUM("CNT_LOAN_SUM",
			"当前贷款笔数", "Integer"),
	/**
	 * (10) 授信及负债信息汇总描述(shareAndDebtSum)
	 */
	IF_NO_USE_CREDIT("IF_NO_USE_CREDIT", "是否为 曾持有信用卡已销卡且目前并未持有任何信用卡", "Boolean"), CNT_ORG_LEGAL_PERSON(
			"CNT_ORG_LEGAL_PERSON", "当前发卡法人机构数", "Integer"), CRED_LIMIT_TOTAL(
			"CRED_LIMIT_TOTAL", "总授信额度（贷记卡+准贷记卡）", "Integer"), CRED_LIMIT_TOTAL_USED(
			"CRED_LIMIT_TOTAL_USED", "总透支余额（贷记卡+准贷记卡）", "Integer"), CNT_ORG_LEGAL_PERSON_RATE70(
			"CNT_ORG_LEGAL_PERSON_RATE70", "总额度使用率超过70%的发卡法人机构数", "Integer"), CNT_ORG_LEGAL_PERSON_RATE80(
			"CNT_ORG_LEGAL_PERSON_RATE80", "总额度使用率超过80%的发卡法人机构数", "Integer"), LV_CREDLIMIT_NORMAL_CARD_AVG(
			"LV_CREDLIMIT_NORMAL_CARD_AVG", "未销户信用卡户均额度使用率", "Integer"), LV_CREDLIMIT_NORMAL_CARD(
			"LV_CREDLIMIT_NORMAL_CARD", "未销户贷记卡额度使用率", "double"), CNT_ORG_LOAN_MGT(
			"CNT_ORG_LOAN_MGT", "当前贷款管理机构数", "Integer"), SUM_USED_LIMIT_CARD_AVG_IN6M(
			"SUM_USED_LIMIT_CARD_AVG_IN6M", "贷记卡最近6个月平均使用额度", "Integer"), SUM_USED_LIMIT_SCARD_AVG_IN6M(
			"SUM_USED_LIMIT_SCARD_AVG_IN6M", "准贷记卡最近6个月平均使用额度", "Integer"),

	// 早期风险预警指标
	AMT_BALANCE_TOTAL("AMT_BALANCE_TOTAL", "信用类负债总额", "Integer"), AMT_CARD_RECENT_BALANCE(
			"AMT_CARD_RECENT_BALANCE", "贷记卡负债", "Integer"), LV_NORMAL_LOAN_USED_LIMIT(
			"LV_NORMAL_LOAN_USED_LIMIT", "名下贷款余额占合同总额的比例", "Integer"), LV_CREDLIMIT_NORMAL_CRAD_MAX(
			"LV_CREDLIMIT_NORMAL_CRAD_MAX", "贷记卡当前最大使用率", "Integer"),

	/**
	 * (8) 违约信息汇总(fellbackSum)
	 */
	CNT_BREAK_INFO_BAD("CNT_BREAK_INFO_BAD", "违约信息中存在呆账的账户数", "Integer"), CNT_BREAK_INFO_AD(
			"CNT_BREAK_INFO_AD", "违约信息中存在资产处置的账户数", "Integer"), CNT_BREAK_INFO_GUARANTEE(
			"CNT_BREAK_INFO_GUARANTEE", "违约信息中存在保证人代偿的账户数", "Integer"),
	/**
	 * (40) 查询记录汇总(detailQueryReason)
	 */
	CNT_ORG_FINANCE_APPLY_LOAN_IN1M("CNT_ORG_FINANCE_APPLY_LOAN_IN1M",
			"近一个月申请贷款的金融机构数", "Integer"), CNT_ORG_FINANCE_APPLY_CARD_IN1M(
			"CNT_ORG_FINANCE_APPLY_CARD_IN1M", "近一个月申请信用卡的金融机构数", "Integer"),
	/**
	 * (19) 授信情况(awardCreditInfo)
	 */
	// 逾期基本信息
	CNT_ACCOUNT_SCARD_ODU_NOW("CNT_ACCOUNT_SCARD_ODU_NOW", "准贷记卡当前逾期的账户数",
			"Integer"), CNT_ACCOUNT_CARD_ODU_NOW("CNT_ACCOUNT_CARD_ODU_NOW",
			"贷记卡当前逾期的账户数", "Integer"), CNT_ACCOUNT_CARD_ABNORMAL(
			"CNT_ACCOUNT_CARD_ABNORMAL", "高风险状态的贷记卡账户数（冻结、止付、银行止付、呆账、司法追偿）",
			"Integer"), CNT_ACCOUNT_SCARD_ABNORMAL(
			"CNT_ACCOUNT_SCARD_ABNORMAL", "高风险状态的准贷记卡账户数（冻结、止付、银行止付、呆账、司法追偿）",
			"Integer"),

	// 账龄相关指标
	CNT_NODU_ACCOUNT_CARD_AGE6("CNT_NODU_ACCOUNT_CARD_AGE6",
			"账龄≥6个月且从未逾期的贷记卡账户数", "Integer"), CNT_NODU_ACCOUNT_SCARD_AGE6(
			"CNT_NODU_ACCOUNT_SCARD_AGE6", "账龄≥6个月且从未逾期的准贷记卡账户数", "Integer"), CNT_NODU_ACCOUNT_CARD_AGE12(
			"CNT_NODU_ACCOUNT_CARD_AGE12", "账龄≥12个月且从未逾期的贷记卡账户数", "Integer"), CNT_NODU_ACCOUNT_SCARD_AGE12(
			"CNT_NODU_ACCOUNT_SCARD_AGE12", "账龄≥12个月且从未逾期的准贷记卡账户数", "Integer"), CNT_ACCOUNT_NORMAL_CARD_AGE12(
			"CNT_ACCOUNT_NORMAL_CARD_AGE12", "账龄≥12个月且状态正常的贷记账户数", "Integer"), CNT_ACCOUNT_NORMAL_SCARD_AGE12(
			"CNT_ACCOUNT_NORMAL_SCARD_AGE12", "账龄≥12个月且状态正常的准贷记卡账户数", "Integer"), CNT_ACCOUNT_NORMAL_CARD_AGE24(
			"CNT_ACCOUNT_NORMAL_CARD_AGE24", "账龄≥24个月且状态正常的贷记账户数", "Integer"), CNT_ACCOUNT_NORMAL_SCARD_AGE24(
			"CNT_ACCOUNT_NORMAL_SCARD_AGE24", "账龄≥24个月且状态正常的准贷记卡账户数", "Integer"),

	MONTH_AGE_SCARD("MONTH_AGE_SCARD", "准贷记卡账户最长账龄（月）", "Integer"), MONTH_AGE_CARD(
			"MONTH_AGE_CARD", "贷记卡账户最长账龄（月）", "Integer"), MONTH_AGE_NORMAL_SCARD(
			"MONTH_AGE_NORMAL_SCARD", "状态正常的准贷记卡账户最长账龄（月）", "Integer"), MONTH_AGE_NORMAL_CARD(
			"MONTH_AGE_NORMAL_CARD", "状态正常的贷记卡账户最长账龄（月）", "Integer"),

	// 月数相关指标
	MONTH_ODU_ACCOUNT_SCARD("MONTH_ODU_ACCOUNT_SCARD", "距最近一次准贷记卡账户逾期的月数",
			"Integer"), MONTH_ODU_ACCOUNT_CARD("MONTH_ODU_ACCOUNT_CARD",
			"距最近一次贷记卡账户逾期的月数", "Integer"),

	// 逾期账户数相关指标
	CNT_ODU_ACCOUNT_CARD_IN3M("CNT_ODU_ACCOUNT_CARD_IN3M", "最近3个月贷记卡逾期账户数",
			"Integer"), CNT_ODU_ACCOUNT_CARD_IN6M("CNT_ODU_ACCOUNT_CARD_IN6M",
			"最近6个月贷记卡逾期账户数", "Integer"), CNT_ODU_ACCOUNT_CARD_IN12M(
			"CNT_ODU_ACCOUNT_CARD_IN12M", "最近12个月贷记卡逾期账户数", "Integer"), CNT_ODU_ACCOUNT_CARD_IN24M(
			"CNT_ODU_ACCOUNT_CARD_IN24M", "最近24个月贷记卡逾期账户数", "Integer"), CNT_ACCT_CARD_M3(
			"CNT_ACCT_CARD_M3", "历史存在逾期3期及以上贷记卡账户数", "Integer"),

	CNT_ODU_ACCOUNT_SCARD_IN3M("CNT_ODU_ACCOUNT_SCARD_IN3M", "最近3个月准贷记卡逾期账户数",
			"Integer"), CNT_ODU_ACCOUNT_SCARD_IN6M(
			"CNT_ODU_ACCOUNT_SCARD_IN6M", "最近6个月准贷记卡逾期账户数", "Integer"), CNT_ODU_ACCOUNT_SCARD_IN12M(
			"CNT_ODU_ACCOUNT_SCARD_IN12M", "最近12个月准贷记卡逾期账户数", "Integer"), CNT_ODU_ACCOUNT_SCARD_IN24M(
			"CNT_ODU_ACCOUNT_SCARD_IN24M", "最近24个月准贷记卡逾期账户数", "Integer"), CNT_ACCT_SCARD_M3(
			"CNT_ACCT_SCARD_M3", "历史存在逾期3期及以上准贷记卡账户数", "Integer"), CNT_ACCT_CARD_M2E_IN6M(
			"CNT_ACCT_CARD_M2E_IN6M", "近6个月存在逾期2期记录的贷记卡账户数", "Integer"), CNT_ACCT_CARD_M2E_IN6M_2TP(
			"CNT_ACCT_CARD_M2E_IN6M_2TP", "近6个月存在逾期2期记录大于等于2次的贷记卡账户数",
			"Integer"), CNT_ACCT_CARD_M2E_IN12M("CNT_ACCT_CARD_M2E_IN12M",
			"近12个月存在逾期2期记录的贷记卡账户数", "Integer"), CNT_ACCT_CARD_M2E_IN12M_3TP(
			"CNT_ACCT_CARD_M2E_IN12M_3TP", "近12个月存在逾期2期记录大于等于3次的贷记卡账户数",
			"Integer"), CNT_ACCT_CARD_M1E_IN12M_6TP(
			"CNT_ACCT_CARD_M1E_IN12M_6TP", "近12个月存在逾期1期记录大于等于6次的贷记卡账户数",
			"Integer"), CNT_ACCT_CARD_M3_IN24M("CNT_ACCT_CARD_M3_IN24M",
			"近24个月逾期3期及以上的贷记卡账户数", "Integer"), CNT_ACCT_SCARD_M3_IN24M(
			"CNT_ACCT_SCARD_M3_IN24M", "近24个月逾期3期及以上的准贷记卡账户数", "Integer"), CNT_ACCT_CARD_M3_OUT24M(
			"CNT_ACCT_CARD_M3_OUT24M", "24个月以外逾期3期及以上的贷记卡账户数", "Integer"), CNT_ACCT_SCARD_M3_OUT24M(
			"CNT_ACCT_SCARD_M3_OUT24M", "24个月以外逾期3期及以上的准贷记卡账户数", "Integer"),

	// 逾期次数相关指标
	CNT_ODU_ACCOUNT_CARD_M2E_IN3M("CNT_ODU_ACCOUNT_CARD_M2E_IN3M",
			"最近3个月贷记卡账户逾期2期次数", "Integer"),

	CNT_ODU_ACCOUNT_CARD_M1E_IN6M("CNT_ODU_ACCOUNT_CARD_M1E_IN6M",
			"最近6个月贷记卡账户逾期1期次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M2E_IN6M(
			"CNT_ODU_ACCOUNT_CARD_M2E_IN6M", "最近6个月贷记卡账户逾期2期次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M3E_IN6M(
			"CNT_ODU_ACCOUNT_CARD_M3E_IN6M", "最近6个月贷记卡账户逾期3期次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M4E_IN6M(
			"CNT_ODU_ACCOUNT_CARD_M4E_IN6M", "最近6个月贷记卡账户逾期4期次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M5E_IN6M(
			"CNT_ODU_ACCOUNT_CARD_M5E_IN6M", "最近6个月贷记卡账户逾期5期次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M1_IN6M(
			"CNT_ODU_ACCOUNT_CARD_M1_IN6M", "近6个月贷记卡账户逾期1期及以上的次数", "Integer"),

	CNT_ODU_ACCOUNT_CARD_M3_IN6M("CNT_ODU_ACCOUNT_CARD_M3_IN6M",
			"最近6个月贷记卡账户逾期3期及以上次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M4_IN6M(
			"CNT_ODU_ACCOUNT_CARD_M4_IN6M", "最近6个月贷记卡账户逾期4期及以上次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M5_IN6M(
			"CNT_ODU_ACCOUNT_CARD_M5_IN6M", "最近6个月贷记卡账户逾期5期及以上次数", "Integer"),

	CNT_ODU_ACCOUNT_CARD_M1E_IN12M("CNT_ODU_ACCOUNT_CARD_M1E_IN12M",
			"最近12个月贷记卡账户逾期1期次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M2E_IN12M(
			"CNT_ODU_ACCOUNT_CARD_M2E_IN12M", "最近12个月贷记卡账户逾期2期次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M3E_IN12M(
			"CNT_ODU_ACCOUNT_CARD_M3E_IN12M", "最近12个月贷记卡账户逾期3期次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M4E_IN12M(
			"CNT_ODU_ACCOUNT_CARD_M4E_IN12M", "最近12个月贷记卡账户逾期4期次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M5E_IN12M(
			"CNT_ODU_ACCOUNT_CARD_M5E_IN12M", "最近12个月贷记卡账户逾期5期次数", "Integer"),

	CNT_ODU_ACCOUNT_CARD_M3_IN12M("CNT_ODU_ACCOUNT_CARD_M3_IN12M",
			"最近12个月贷记卡账户逾期3期及以上次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M4_IN12M(
			"CNT_ODU_ACCOUNT_CARD_M4_IN12M", "最近12个月贷记卡账户逾期4期及以上次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M5_IN12M(
			"CNT_ODU_ACCOUNT_CARD_M5_IN12M", "最近12个月贷记卡账户逾期5期及以上次数", "Integer"),

	CNT_ODU_ACCOUNT_CARD_M3_IN24M("CNT_ODU_ACCOUNT_CARD_M3_IN24M",
			"最近24个月贷记卡账户逾期3期及以上次数", "Integer"),

	CNT_ODU_ACCOUNT_CARD_M3("CNT_ODU_ACCOUNT_CARD_M3", "贷记卡账户出现过M3+逾期次数",
			"Integer"), CNT_ODU_ACCOUNT_SCARD_M3("CNT_ODU_ACCOUNT_SCARD_M3",
			"准贷记卡账户出现过M3+逾期次数", "Integer"), CNT_ODU_ACCOUNT_CARD_M2(
			"CNT_ODU_ACCOUNT_CARD_M2", "贷记卡账户出现过M2+逾期次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M2(
			"CNT_ODU_ACCOUNT_SCARD_M2", "准贷记卡账户出现过M2+逾期次数", "Integer"),

	CNT_ODU_ACCOUNT_SCARD_M2E_IN3M("CNT_ODU_ACCOUNT_SCARD_M2E_IN3M",
			"最近3个月准贷记卡账户逾期2期次数", "Integer"),

	CNT_ODU_ACCOUNT_SCARD_M1E_IN6M("CNT_ODU_ACCOUNT_SCARD_M1E_IN6M",
			"最近6个月准贷记卡账户逾期1期次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M2E_IN6M(
			"CNT_ODU_ACCOUNT_SCARD_M2E_IN6M", "最近6个月准贷记卡账户逾期2期次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M3E_IN6M(
			"CNT_ODU_ACCOUNT_SCARD_M3E_IN6M", "最近6个月准贷记卡账户逾期3期次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M4E_IN6M(
			"CNT_ODU_ACCOUNT_SCARD_M4E_IN6M", "最近6个月准贷记卡账户逾期4期次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M5E_IN6M(
			"CNT_ODU_ACCOUNT_SCARD_M5E_IN6M", "最近6个月准贷记卡账户逾期5期次数", "Integer"),

	CNT_ODU_ACCOUNT_SCARD_M3_IN6M("CNT_ODU_ACCOUNT_SCARD_M3_IN6M",
			"最近6个月准贷记卡账户逾期3期及以上次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M4_IN6M(
			"CNT_ODU_ACCOUNT_SCARD_M4_IN6M", "最近6个月准贷记卡账户逾期4期及以上次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M5_IN6M(
			"CNT_ODU_ACCOUNT_SCARD_M5_IN6M", "最近6个月准贷记卡账户逾期5期及以上次数", "Integer"),

	CNT_ODU_ACCOUNT_SCARD_M1E_IN12M("CNT_ODU_ACCOUNT_SCARD_M1E_IN12M",
			"最近12个月准贷记卡账户逾期1期次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M2E_IN12M(
			"CNT_ODU_ACCOUNT_SCARD_M2E_IN12M", "最近12个月准贷记卡账户逾期2期次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M3E_IN12M(
			"CNT_ODU_ACCOUNT_SCARD_M3E_IN12M", "最近12个月准贷记卡账户逾期3期次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M4E_IN12M(
			"CNT_ODU_ACCOUNT_SCARD_M4E_IN12M", "最近12个月准贷记卡账户逾期4期次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M5E_IN12M(
			"CNT_ODU_ACCOUNT_SCARD_M5E_IN12M", "最近12个月准贷记卡账户逾期5期次数", "Integer"),

	CNT_ODU_ACCOUNT_SCARD_M3_IN12M("CNT_ODU_ACCOUNT_SCARD_M3_IN12M",
			"最近12个月准贷记卡账户逾期3期及以上次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M4_IN12M(
			"CNT_ODU_ACCOUNT_SCARD_M4_IN12M", "最近12个月准贷记卡账户逾期4期及以上次数",
			"Integer"), CNT_ODU_ACCOUNT_SCARD_M5_IN12M(
			"CNT_ODU_ACCOUNT_SCARD_M5_IN12M", "最近12个月准贷记卡账户逾期5期及以上次数",
			"Integer"),

	CNT_ODU_ACCOUNT_SCARD_M3_IN24M("CNT_ODU_ACCOUNT_SCARD_M3_IN24M",
			"最近24个月准贷记卡账户逾期3期及以上次数", "Integer"),

	CNT_ODU_ACCOUNT_CARD_IN24M_MAX("CNT_ODU_ACCOUNT_CARD_IN24M_MAX",
			"最近24个月贷记卡账户最大逾期次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_IN24M_MAX(
			"CNT_ODU_ACCOUNT_SCARD_IN24M_MAX", "最近24个月准贷记卡账户最大逾期次数", "Integer"),

	CNT_ODU_ACCOUNT_CARD_M3_OUT24M("CNT_ODU_ACCOUNT_CARD_M3_OUT24M",
			"24个月以外贷记卡账户逾期3期及以上次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_M3_OUT24M(
			"CNT_ODU_ACCOUNT_SCARD_M3_OUT24M", "24个月以外准贷记卡账户逾期3期及以上次数",
			"Integer"), CNT_ODU_ACCOUNT_CARD_M1_IN24M(
			"CNT_ODU_ACCOUNT_CARD_M1_IN24M", "近24个月贷记卡账户逾期1期及以上的次数", "Integer"),

	MONTH_ODU_ACCOUNT_CARD_MAX("MONTH_ODU_ACCOUNT_CARD_MAX", "贷记卡账户最高逾期期数",
			"Integer"), MONTH_ODU_ACCOUNT_SCARD_MAX(
			"MONTH_ODU_ACCOUNT_SCARD_MAX", "准贷记卡账户最高逾期期数", "Integer"),

	// 额度使用率相关指标
	CNT_ACCOUNT_SCARD_LV80("CNT_ACCOUNT_SCARD_LV80", "额度使用率≥80%的准贷记卡账户数",
			"Integer"), CNT_ACCOUNT_CARD_LV80("CNT_ACCOUNT_CARD_LV80",
			"额度使用率≥80%的贷记卡账户数", "Integer"), LV_CREDLIMIT_NORMAL_CARD_TOTAL_LIMIT(
			"LV_CREDLIMIT_NORMAL_CRAD_TOTAL_LIMIT", "评分贷记卡未销户总计算额度", "Integer"), LV_CREDLIMIT_NORMAL_CARD_USED_LIMIT(
			"LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT", "评分卡贷记卡未销户总已使用额度", "Integer"), LV_CREDLIMIT_NORMAL_SCARD_TOTAL_LIMIT(
			"LV_CREDLIMIT_NORMAL_SCRAD_TOTAL_LIMIT", "评分准贷记卡未销户总计算额度",
			"Integer"), LV_CREDLIMIT_NORMAL_SCARD_USED_LIMIT(
			"LV_CREDLIMIT_NORMAL_SCRAD_USED_LIMIT", "评分准贷记卡销户总已使用额度", "Integer"),

	// 其他指标
	CNT_ODU_ACCOUNT_CARD_AMT100("CNT_ODU_ACCOUNT_CARD_AMT100",
			"贷记卡当前存在逾期且金额大于等于100元的次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_AMT100(
			"CNT_ODU_ACCOUNT_SCARD_AMT100", "准贷记卡当前存在逾期且金额大于等于100元的次数",
			"Integer"), CNT_ODU_ACCOUNT_CARD_AMT500(
			"CNT_ODU_ACCOUNT_CARD_AMT500", "贷记卡当前存在逾期且金额大于等于500元的次数", "Integer"), CNT_ODU_ACCOUNT_SCARD_AMT500(
			"CNT_ODU_ACCOUNT_SCARD_AMT500", "准贷记卡当前存在逾期且金额大于等于500元的次数",
			"Integer"), CNT_MAX_LOAN_ACCOUNT_CARD_IN6M(
			"CNT_MAX_LOAN_ACCOUNT_CARD_IN6M", "贷记卡单卡近6个月累计最高逾期次数", "Integer"), CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M(
			"CNT_MAX_LOAN_ACCOUNT_SCARD_IN6M", "准贷记卡单卡近6个月累计最高逾期次数", "Integer"), IF_CARD_REPORT_UPDATE_IN24MONTH(
			"IF_CARD_REPORT_UPDATE_IN24MONTH", "人行征信信息贷记卡24个月内是否有更新", "Integer"), IF_SCARD_REPORT_UPDATE_IN24MONTH(
			"IF_SCARD_REPORT_UPDATE_IN24MONTH", "人行征信信息准贷记卡24个月内是否有更新",
			"Integer"), CNT_ACCOUNT_CARD_ODU_NOW_MAXAMT(
			"CNT_ACCOUNT_CARD_ODU_NOW_MAXAMT", "贷记卡账户当前逾期金额的最大值", "Integer"),

	// 核准记录数
	CNT_CARD_APPROVE_IN6M("CNT_CARD_APPROVE_IN6M", "近6个月贷记卡核准记录数", "Integer"), CNT_SCARD_APPROVE_IN6M(
			"CNT_SCARD_APPROVE_IN6M", "近6个月准贷记卡核准记录数", "Integer"), CNT_CARD_APPROVE_IN3M(
			"CNT_CARD_APPROVE_IN3M", "近3个月贷记卡核准记录数", "Integer"), CNT_SCARD_APPROVE_IN3M(
			"CNT_SCARD_APPROVE_IN3M", "近3个月准贷记卡核准记录数", "Integer"),

	// 他行卡计算
	CNT_AMT_CARD_OBANK("CNT_AMT_CARD_OBANK", "有效他行卡数量", "Integer"), CNT_AMT_CARD_OBANK_HIGHEST(
			"CNT_AMT_CARD_OBANK_HIGHEST", "有效他行卡-最高额度", "Integer"), CNT_AMT_OBANK_SECOND(
			"CNT_AMT_OBANK_SECOND", "有效他行卡-次高额度", "Integer"), CNT_AMT_CARD_OBANK_LOWEST(
			"CNT_AMT_CARD_OBANK_LOWEST", "有效他行卡-最低额度", "Integer"), CRED_LIMIT_OBANK_ONE(
			"CRED_LIMIT_OBANK_ONE", "有效他行卡-单卡额度", "Integer"), CRED_LIMIT_OBANK_DOUBLE(
			"CRED_LIMIT_OBANK_DOUBLE", "有效他行卡-双卡额度", "Integer"), CRED_LIMIT_OBANK_MULTI_MODE(
			"CRED_LIMIT_OBANK_MULTI_MODE", "有效他行卡-多卡额度（众数）", "Integer"), CRED_LIMIT_OBANK_MULTI_MEDIAN(
			"CRED_LIMIT_OBANK_MULTI_MEDIAN", "有效他行卡-多卡额度（中位数）", "Integer"), CRED_LIMIT_OBANK_SUM(
			"CRED_LIMIT_OBANK_SUM", "他行卡-总授信额度", "Integer"),

	// 早期风险预警相关指标
	AMT_ACCOUNT_CARD_M1E("AMT_ACCOUNT_CARD_M1E", "贷记卡当前状态为逾期M1的逾期金额", "Integer"), AMT_ACCOUNT_CARD_M2E(
			"AMT_ACCOUNT_CARD_M2E", "贷记卡当前状态为逾期M2的逾期金额", "Integer"), AMT_ACCOUNT_CARD_M3E(
			"AMT_ACCOUNT_CARD_M3E", "贷记卡当前状态为逾期M3的逾期金额", "Integer"), AMT_ACCOUNT_CARD_M4E(
			"AMT_ACCOUNT_CARD_M4E", "贷记卡当前状态为逾期M4的逾期金额", "Integer"), AMT_ACCOUNT_CARD_M4(
			"AMT_ACCOUNT_CARD_M4", "贷记卡当前状态为逾期M4+的逾期金额", "Integer"), AMT_ACCOUNT_CARD_M5(
			"AMT_ACCOUNT_CARD_M5", "贷记卡当前状态为逾期M5+的逾期金额", "Integer"),

	AMT_ACCOUNT_SCARD_M1E("AMT_ACCOUNT_SCARD_M1E", "准贷记卡当前状态为逾期M1的逾期金额",
			"Integer"), AMT_ACCOUNT_SCARD_M2E("AMT_ACCOUNT_SCARD_M2E",
			"准贷记卡当前状态为逾期M2的逾期金额", "Integer"), AMT_ACCOUNT_SCARD_M3E(
			"AMT_ACCOUNT_SCARD_M3E", "准贷记卡当前状态为逾期M3逾期金额", "Integer"), AMT_ACCOUNT_SCARD_M4E(
			"AMT_ACCOUNT_SCARD_M4E", "准贷记卡当前状态为逾期M4逾期金额", "Integer"), AMT_ACCOUNT_SCARD_M4(
			"AMT_ACCOUNT_SCARD_M4", "准贷记卡当前状态为逾期M4+的逾期金额", "Integer"), AMT_ACCOUNT_SCARD_M5(
			"AMT_ACCOUNT_SCARD_M5", "准贷记卡当前状态为逾期M5+的逾期金额", "Integer"),

	CNT_ACCOUNT_CARD_ABNORMAL_ZF_ODU300("CNT_ACCOUNT_CARD_ABNORMAL_ZF_ODU300",
			"贷记卡当前状态为止付且逾期金额在300元及以上的账户数", "Integer"), CNT_ACCOUNT_CARD_ABNORMAL_DJ_ODU300(
			"CNT_ACCOUNT_CARD_ABNORMAL_DJ_ODU300",
			"贷记卡当前状态为冻结且逾期金额在300元及以上的账户数", "Integer"), CNT_ACCOUNT_CARD_ABNORMAL_DZ_ODU300(
			"CNT_ACCOUNT_CARD_ABNORMAL_DZ_ODU300",
			"贷记卡当前状态为呆账且逾期金额在300元及以上的账户数", "Integer"), CNT_ACCOUNT_CARD_ABNORMAL_DB(
			"CNT_ACCOUNT_CARD_ABNORMAL_DB", "贷记卡当前状态为担保人代偿以资抵债账户数", "Integer"),

	CNT_ACCOUNT_SCARD_ABNORMAL_ZF_ODU300(
			"CNT_ACCOUNT_SCARD_ABNORMAL_ZF_ODU300",
			"准贷记卡当前状态为止付且逾期金额在300元及以上的账户数", "Integer"), CNT_ACCOUNT_SCARD_ABNORMAL_DJ_ODU300(
			"CNT_ACCOUNT_SCARD_ABNORMAL_DJ_ODU300",
			"准贷记卡当前状态为冻结且逾期金额在300元及以上的账户数", "Integer"), CNT_ACCOUNT_SCARD_ABNORMAL_DZ_ODU300(
			"CNT_ACCOUNT_SCARD_ABNORMAL_DZ_ODU300",
			"准贷记卡当前状态为呆账且逾期金额在300元及以上的账户数", "Integer"), CNT_ACCOUNT_SCARD_ABNORMAL_DB(
			"CNT_ACCOUNT_SCARD_ABNORMAL_DB", "准贷记卡当前状态为担保人代偿以资抵债账户数", "Integer"),

	CNT_ACCOUNT_USEDLIMT_500K_AVG_IN6M("CNT_ACCOUNT_USEDLIMT_500K_AVG_IN6M",
			"未销户信用卡近6个月平均使用额度超过50万账户数", "Integer"), LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK(
			"LV_CREDLIMIT_NORMAL_CRAD_USED_LIMIT_NOBANK", "非本行名下所有贷记卡真实使用额度",
			"Integer"), CNT_PAYMENT_MIN("CNT_PAYMENT_MIN",
			"最低还款（本月实还款比本月应还款值±相差5%（含））账户数", "Integer"), CNT_ACCOUNT_TOTAL(
			"CNT_ACCOUNT_TOTAL", "实际已用账户数", "Integer"), CNT_ACCOUNT_CARD_LOW_LIMIT_DALIAN(
			"CNT_ACCOUNT_CARD_LOW_LIMIT_DALIAN", "小额卡用卡记录数", "Integer"), CNT_ACCOUNT_CARD_DALIAN(
			"CNT_ACCOUNT_CARD_DALIAN", "贷记卡使用张数", "Integer"),

	/**
	 * (9) 逾期(透支)信息汇总(overdueSum)
	 */
	AMT_MAXOVERDUE_MONTH("AMT_MAXOVERDUE_MONTH", "单月最高逾期总额", "Integer"),
	/**
	 * (15) 贷款信息(contratInfo)
	 */
	// 账户数计算
	CNT_ACCOUNT_LOAN_HO("CNT_ACCOUNT_LOAN_HO", "住房贷款账户数", "Integer"), CNT_ACCOUNT_NORMAL_LOAN_HO(
			"CNT_ACCOUNT_NORMAL_LOAN_HO", "未结清住房贷款账户数", "Integer"), CNT_ACCOUNT_NORMAL_LOAN_CR(
			"CNT_ACCOUNT_NORMAL_LOAN_CR", "状态正常的无抵押贷款账户数", "Integer"), CNT_ACCOUNT_NORMAL_LOAN_SL(
			"CNT_ACCOUNT_NORMAL_LOAN_SL", "状态正常的小额贷款公司贷款账户数", "Integer"), CNT_ACCOUNT_NORMAL_LOAN_CF(
			"CNT_ACCOUNT_NORMAL_LOAN_CF", "状态正常的消费金融公司贷款账户数", "Integer"), CNT_ACCOUNT_NORMAL_LOAN_CL(
			"CNT_ACCOUNT_NORMAL_LOAN_CL", "状态正常的个人消费贷款账户数", "Integer"), CNT_ACCOUNT_LOAN_CF(
			"CNT_ACCOUNT_LOAN_CF", "消费金融公司贷款账户数", "Integer"), CNT_ACCOUNT_LOAN_SL(
			"CNT_ACCOUNT_LOAN_SL", "小额贷款公司贷款账户数", "Integer"), CNT_ACCT_LOAN_M2E_IN6M_2TP(
			"CNT_ACCT_LOAN_M2E_IN6M_2TP", "近6个月存在逾期2期记录大于等于2次的贷款账户数", "Integer"), CNT_ACCT_LOAN_M2E_IN12M_3TP(
			"CNT_ACCT_LOAN_M2E_IN12M_3TP", "近12个月存在逾期2期记录大于等于3次的贷款账户数",
			"Integer"), CNT_ACCT_LOAN_M1E_IN12M_6TP(
			"CNT_ACCT_LOAN_M1E_IN12M_6TP", "近12个月存在逾期1期记录大于等于6次的贷款账户数",
			"Integer"), CNT_ACCT_LOAN_M3_IN24M("CNT_ACCT_LOAN_M3_IN24M",
			"近24个月逾期3期及以上的贷款账户数", "Integer"), CNT_ACCT_LOAN_M3_OUT24M(
			"CNT_ACCT_LOAN_M3_OUT24M", "24个月以外逾期3期及以上的贷款账户数", "Integer"),
	// 月数相关指标计算
	MONTH_ODU_ACCOUNT_LOAN("MONTH_ODU_ACCOUNT_LOAN", "距最近一次贷款账户逾期的月数",
			"Integer"),

	// 额度使用率指标计算
	CNT_ACCOUNT_LOAN_LV80("CNT_ACCOUNT_LOAN_LV80", "未偿金额占比≥80%贷款账户数", "Integer"), CNT_ACCOUNT_LOAN_LV80_CR(
			"CNT_ACCOUNT_LOAN_LV80_CR", "未偿金额占比≥80%无抵押贷款账户数", "Integer"),

	// 账龄相关指标计算
	MONTH_AGE_NORMAL_LOAN("MONTH_AGE_NORMAL_LOAN", "状态正常的贷款账户最长账龄（月）",
			"Integer"), CNT_ACCOUNT_NORMAL_LOAN_AGE24(
			"CNT_ACCOUNT_NORMAL_LOAN_AGE24", "账龄≥24个月且状态正常的贷款账户数", "Integer"), CNT_NODU_ACCOUNT_LOAN_AGE12(
			"CNT_NODU_ACCOUNT_LOAN_AGE12", "账龄≥12个月且从未逾期的贷款账户数", "Integer"), CNT_NODU_ACCOUNT_LOAN_AGE6(
			"CNT_NODU_ACCOUNT_LOAN_AGE6", "账龄≥6个月且从未逾期的贷款账户数", "Integer"), CNT_ACCOUNT_LOAN_AGE12_OP(
			"CNT_ACCOUNT_LOAN_AGE12_OP", "账龄≥12个月且状态正常的经营性贷款账户数", "Integer"), CNT_ACCOUNT_NORMAL_LOAN_AGE24_MO(
			"CNT_ACCOUNT_NORMAL_LOAN_AGE24_MO", "账龄≥24个月且状态正常的有抵押贷款账户数",
			"Boolean"), MONTH_AGE_LOAN("MONTH_AGE_LOAN", "贷款账户最长账龄（月）",
			"Integer"),

	// 还款状态
	CNT_ACCOUNT_LOAN_ABNORMAL_ZF_ODU300("CNT_ACCOUNT_LOAN_ABNORMAL_ZF_ODU300",
			"贷款当前状态为止付且逾期金额在300元及以上的账户数", "Integer"), CNT_ACCOUNT_LOAN_ABNORMAL_DJ_ODU300(
			"CNT_ACCOUNT_LOAN_ABNORMAL_DJ_ODU300",
			"贷款当前状态为冻结且逾期金额在300元及以上的账户数", "Integer"), CNT_ACCOUNT_LOAN_ABNORMAL_DZ_ODU300(
			"CNT_ACCOUNT_LOAN_ABNORMAL_DZ_ODU300",
			"贷款当前状态为呆账且逾期金额在300元及以上的账户数", "Integer"), CNT_ACCOUNT_LOAN_ABNORMAL_DB(
			"CNT_ACCOUNT_LOAN_ABNORMAL_DB", "贷款当前状态为担保人代偿以资抵债账户数", "Integer"),

	CNT_ODU_ACCOUNT_LOAN_G("CNT_ODU_ACCOUNT_LOAN_G", "人行报告中贷款还款状态为“G”出现的次数",
			"Integer"),

	// 逾期次数指标计算
	CNT_ODU_ACCOUNT_LOAN_IN3M("CNT_ODU_ACCOUNT_LOAN_IN3M", "最近3个月贷款逾期账户数",
			"Integer"), CNT_ODU_ACCOUNT_LOAN_CR_IN3M(
			"CNT_ODU_ACCOUNT_LOAN_CR_IN3M", "过去3个月无抵押贷款逾期账户数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M2_IN3M(
			"CNT_ODU_ACCOUNT_LOAN_M2_IN3M", "最近3个月贷款账户逾期2期次数", "Integer"), CNT_ACCT_LOAN_M2E_IN3M(
			"CNT_ACCT_LOAN_M2E_IN3M", "近3个月存在逾期2期的贷款账户数", "Integer"), CNT_ACCT_LOAN_M2E_IN6M(
			"CNT_ACCT_LOAN_M2E_IN6M", "近6个月存在逾期2期记录的贷款账户数", "Integer"),

	CNT_ODU_ACCOUNT_LOAN_IN6M("CNT_ODU_ACCOUNT_LOAN_IN6M", "最近6个月贷款逾期账户数",
			"Integer"), CNT_ODU_ACCOUNT_LOAN_IN12M(
			"CNT_ODU_ACCOUNT_LOAN_IN12M", "最近12个月贷款逾期账户数", "Integer"), CNT_ODU_ACCOUNT_LOAN_IN24M(
			"CNT_ODU_ACCOUNT_LOAN_IN24M", "最近24个月贷款逾期账户数", "Integer"), CNT_ACCT_LOAN_M2E_IN12M(
			"CNT_ACCT_LOAN_M2E_IN12M", "近12个月存在逾期2期记录的贷款账户数", "Integer"),

	CNT_ODU_ACCOUNT_LOAN_M1E_IN6M("CNT_ODU_ACCOUNT_LOAN_M1E_IN6M",
			"最近6个月贷款账户逾期1期次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M2E_IN6M(
			"CNT_ODU_ACCOUNT_LOAN_M2E_IN6M", "最近6个月贷款账户逾期2期次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M3E_IN6M(
			"CNT_ODU_ACCOUNT_LOAN_M3E_IN6M", "最近6个月贷款账户逾期3期次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M4_IN6M(
			"CNT_ODU_ACCOUNT_LOAN_M4_IN6M", "近6个月贷款账户逾期4期及以上的次数", "Integer"),

	CNT_ODU_ACCOUNT_LOAN_M1_IN6M("CNT_ODU_ACCOUNT_LOAN_M1_IN6M",
			"最近6个月贷款账户逾期1期及以上次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M2_IN6M(
			"CNT_ODU_ACCOUNT_LOAN_M2_IN6M", "最近6个月贷款账户逾期2期及以上次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M3_IN6M(
			"CNT_ODU_ACCOUNT_LOAN_M3_IN6M", "最近6个月贷款账户逾期3期及以上次数", "Integer"),

	CNT_ODU_ACCOUNT_LOAN_M1E_IN12M("CNT_ODU_ACCOUNT_LOAN_M1E_IN12M",
			"最近12个月贷款账户逾期1期次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M2E_IN12M(
			"CNT_ODU_ACCOUNT_LOAN_M2E_IN12M", "最近12个月贷款账户逾期2期次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M3E_IN12M(
			"CNT_ODU_ACCOUNT_LOAN_M3E_IN12M", "最近12个月贷款账户逾期3期次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M3_IN12M(
			"CNT_ODU_ACCOUNT_LOAN_M3_IN12M", "最近12个月贷款账户逾期3期及以上次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M4_IN12M(
			"CNT_ODU_ACCOUNT_LOAN_M4_IN12M", "最近12个月贷款账户逾期4期及以上次数", "Integer"),

	CNT_ODU_ACCOUNT_LOAN_IN24M_MAX("CNT_ODU_ACCOUNT_LOAN_IN24M_MAX",
			"最近24个月贷款账户最大逾期次数", "Integer"), CNT_ACCOUNT_ODU_LOAN_CF_IN24M(
			"CNT_ACCOUNT_ODU_LOAN_CF_IN24M", "最近24个月消费金融公司贷款逾期账户数", "Integer"), CNT_ACCOUNT_ODU_LOAN_SL_IN24M(
			"CNT_ACCOUNT_ODU_LOAN_SL_IN24M", "最近24个月小额贷款公司贷款逾期账户数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M3_IN24M(
			"CNT_ODU_ACCOUNT_LOAN_M3_IN24M", "最近24个月贷款账户逾期3期及以上次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M1_IN24M(
			"CNT_ODU_ACCOUNT_LOAN_M1_IN24M", "最近24个月贷款账户逾期1期及以上次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M2(
			"CNT_ODU_ACCOUNT_LOAN_M2", "贷款账户出现过M2+逾期次数", "Integer"), CNT_ODU_ACCOUNT_LOAN_M3(
			"CNT_ODU_ACCOUNT_LOAN_M3", "贷款账户出现过M3+逾期次数", "Integer"),

	CNT_ODU_ACCOUNT_LOAN_IN12M_CF("CNT_ODU_ACCOUNT_LOAN_IN12M_CF",
			"最近12个月消费金融贷款逾期账户数", "Integer"), CNT_ODU_ACCOUNT_LOAN_IN12M_SL(
			"CNT_ODU_ACCOUNT_LOAN_IN12M_SL", "最近12个月小额贷款逾期账户数", "Integer"), CNT_ODU_ACCOUNT_LOAN_IN24M_CF(
			"CNT_ODU_ACCOUNT_LOAN_IN24M_CF", "最近24个月消费金融贷款逾期账户数", "Integer"), CNT_ODU_ACCOUNT_LOAN_IN24M_SL(
			"CNT_ODU_ACCOUNT_LOAN_IN24M_SL", "最近24个月小额贷款逾期账户数", "Integer"),

	CNT_ODU_ACCOUNT_LOAN("CNT_ODU_ACCOUNT_LOAN", "贷款账户逾期记录次数", "Integer"), CNT_ACCOUNT_LOAN_ODU_NOW(
			"CNT_ACCOUNT_LOAN_ODU_NOW", "贷款当前逾期的账户数", "Integer"),

	CNT_ODU_ACCOUNT_LOAN_M3_OUT24M("CNT_ODU_ACCOUNT_LOAN_M3_OUT24M",
			"24个月以外贷款账户逾期3期及以上次数", "Integer"),

	MONTH_ODU_ACCOUNT_LOAN_MAX("MONTH_ODU_ACCOUNT_LOAN_MAX", "贷款账户最长逾期月数",
			"Integer"),

	CNT_ACCT_LOAN_M3("CNT_ACCT_LOAN_M3", "历史存在逾期3期及以上贷款账户数", "Integer"),

	// 五级分类指标
	CNT_ACCOUNT_LOAN_SEC("CNT_ACCOUNT_LOAN_SEC", "五级分类为次级的贷款账户数", "Integer"), CNT_ACCOUNT_LOAN_SUS(
			"CNT_ACCOUNT_LOAN_SUS", "五级分类为可疑的贷款账户数", "Integer"), CNT_ACCOUNT_LOAN_LOSS(
			"CNT_ACCOUNT_LOAN_LOSS", "五级分类为损失的贷款账户数", "Integer"), CNT_ACCOUNT_LOAN_ATTENTION(
			"CNT_ACCOUNT_LOAN_ATTENTION", "五级分类为关注的贷款账户数", "Integer"), CNT_ACCOUNT_LOAN_ABNORMAL(
			"CNT_ACCOUNT_LOAN_ABNORMAL", "高风险状态的贷款账户数（呆账、司法追偿）", "Integer"), CNT_ACCT_LOAN_ABNORMAL(
			"CNT_ACCT_LOAN_ABNORMAL", "高风险状态的贷款账户数（呆账、转出/银行止付、担保物不足、司法追偿）",
			"Integer"), CNT_ACCT_LOAN_ABNORMAL_MANDATORY(
			"CNT_ACCT_LOAN_ABNORMAL_MANDATORY", "强制平仓的贷款账户数", "Integer"),
	// 其他指标
	IF_LOAN_REPORT_UPDATE_IN24MONTH("IF_LOAN_REPORT_UPDATE_IN24MONTH",
			"人行征信贷款信息24个月内是否有更新", "Boolean"),

	// 贷款发放机构数
	CNT_ORG_LOAN_NORMAL_CF("CNT_ORG_LOAN_NORMAL_CF", "正常消费金融公司贷款发放机构数",
			"Integer"), CNT_ORG_LOAN_NORMAL_SM("CNT_ORG_LOAN_NORMAL_SM",
			"正常小额贷款公司贷款发放机构数", "Integer"),

	// 核准记录数
	CNT_LOAN_APPROVE_IN3M("CNT_LOAN_APPROVE_IN3M", "近3个月贷款核准记录数", "Integer"), CNT_LOAN_APPROVE_IN6M(
			"CNT_LOAN_APPROVE_IN6M", "近6个月贷款核准记录数", "Integer"), CNT_ORG_LOAN_APPROVE_IN6M(
			"CNT_ORG_LOAN_APPROVE_IN6M", "近6个月贷款核准机构数", "Integer"),

	// 金额相关指标
	CNT_ODU_ACCOUNT_LOAN_AMT500("CNT_ODU_ACCOUNT_LOAN_AMT500",
			"当前贷款存在逾期且逾期金额大于等于500元的次数", "Integer"), AMT_CREDLIMIT_NORMAL_LOAN_MO(
			"AMT_CREDLIMIT_NORMAL_LOAN_MO", "未结清有抵押贷款户均合同金额", "Integer"), CNT_ACCOUNT_LOAN_ODU_NOW_MAXAMT(
			"CNT_ACCOUNT_LOAN_ODU_NOW_MAXAMT", "贷款账户当前逾期金额的最大值", "Integer"), CNT_LOAN_BALANCE(
			"CNT_LOAN_BALANCE", "当前贷款余额", "Integer"), CNT_MORTGAGE_BALANCE(
			"CNT_MORTGAGE_BALANCE", "当前房贷余额", "Integer"), CNT_LOAN_BALANCE_OTHER(
			"CNT_LOAN_BALANCE_OTHER", "当前无抵质押类负债余额", "Integer"),

	CNT_LOAN_BALANCE_XF("CNT_LOAN_BALANCE_XF", "当前消费类贷款余额", "Integer"),

	CNT_MORTGAGE_AMT_NEW("CNT_MORTGAGE_AMT_NEW", "最近一次本行正常在续房贷的合同金额", "Integer"), CNT_MORTGAGE_PAY_NEW(
			"CNT_MORTGAGE_PAY_NEW", "最近一次本行正常在续房贷的月还款额", "Integer"), CNT_MORTGAGE_DURATION_NEW(
			"CNT_MORTGAGE_DURATION_NEW", "最近一次本行正常在续房贷的已发放月数", "Integer"), CNT_LOAN_AMT_NEW(
			"CNT_LOAN_AMT_NEW", "最近一次本行正常在续贷款的合同金额（经营性贷款、消费贷款和农户贷款）", "Integer"), CNT_LOAN_PAY_NEW(
			"CNT_LOAN_PAY_NEW", "最近一次本行正常在续贷款的月还款额（经营性贷款、消费贷款和农户贷款）", "Integer"), CNT_LOAN_DURATION_NEW(
			"CNT_LOAN_DURATION_NEW", "最近一次本行正常在续贷款的已还款月数（经营性贷款、消费贷款和农户贷款）",
			"Integer"),

	CRED_LIMIT_LARGE_INSTALMENT("CRED_LIMIT_LARGE_INSTALMENT", "大额专项分期额度（抵押类）",
			"Integer"), CRED_LIMIT_LARGE_INSTALMENT_USED(
			"CRED_LIMIT_LARGE_INSTALMENT_USED", "大额专项分期已用金额（抵押类）", "Integer"),

	AMT_MORTGAGE_CONTRACT("AMT_MORTGAGE_CONTRACT", "本行正常在续贷款的合同金额", "Integer"), AMT_MORTGAGE_CONTRACT_OBANK(
			"AMT_MORTGAGE_CONTRACT_OBANK", "他行正常在续贷款的合同金额", "Integer"), AMT_MORTGAGE_PAYMENT_MONTHLY(
			"AMT_MORTGAGE_PAYMENT_MONTHLY", "本行正常在续贷款的月还款额", "Integer"), AMT_MORTGAGE_PAYMENT_MONTHLY_OBANK(
			"AMT_MORTGAGE_PAYMENT_MONTHLY_OBANK", "他行正常在续贷款的月还款额", "Integer"),

	// 早期风险预警相关标签
	AMT_ACCOUNT_LOAN_M1E("AMT_ACCOUNT_LOAN_M1E", "贷款当前状态为逾期M1的逾期金额", "Integer"), AMT_ACCOUNT_LOAN_M2E(
			"AMT_ACCOUNT_LOAN_M2E", "贷款当前状态为逾期M2的逾期金额", "Integer"), AMT_ACCOUNT_LOAN_M3E(
			"AMT_ACCOUNT_LOAN_M3E", "贷款当前状态为逾期M3的逾期金额", "Integer"), AMT_ACCOUNT_LOAN_M4(
			"AMT_ACCOUNT_LOAN_M4", "贷款当前状态为逾期M4+的逾期金额", "Integer"),

	CNT_ACCOUNT_LOAN_5000("CNT_ACCOUNT_LOAN_5000", "未结清贷款的发放金额小于等于5000笔数",
			"Integer"), CNT_ACCOUNT_LOAN_NO_HOUSE_CAR(
			"CNT_ACCOUNT_LOAN_NO_HOUSE_CAR", "未结清非房贷、车贷的贷款笔数", "Integer"), CNT_LOAN_TRUST(
			"CNT_LOAN_TRUST", "未结清信托贷款账户数", "Integer"), AMT_LOAN_NON_COLLATERAL_BALANCE(
			"AMT_LOAN_NON_COLLATERAL_BALANCE", "非抵质押类负债余额（早期风险预警的担保方式与人行拒绝不同）",
			"Integer"), CNT_LOAN_NON_COLLATERAL_20P(
			"CNT_LOAN_NON_COLLATERAL_20P",
			"当前未结清无抵质押贷款合同金额超20万的贷款笔数（除1-抵押，2-质押外)", "Integer"), CNT_LOAN_COMMERCIAL_20P(
			"CNT_LOAN_COMMERCIAL_20P", "未结清贷款类型为经营性贷款且合同金额超过30万（含）的笔数",
			"Integer"), CNT_LOAN_NORMAL_GUARANTEE("CNT_LOAN_NORMAL_GUARANTEE",
			"当前正常的信用、保证类贷款笔数", "Integer"),
	// 授信策略
	AMT_LOAN_BALANCE_CREDIT("AMT_LOAN_BALANCE_CREDIT", "信用贷款余额（信用/免担保类）",
			"Integer"), AMT_LOAN_BALANCE_XF("AMT_LOAN_BALANCE_XF", "当前消费类贷款余额",
			"Integer"),

	/**
	 * (20) 住房公积金参加记录（accFund）
	 */
	CNT_ACCFUND_MONTH_NEW("CNT_ACCFUND_MONTH_NEW", "最近一次人行公积金的缴至月份", "Integer"), CNT_ACCFUND_PAY_NEW(
			"CNT_ACCFUND_PAY_NEW", "最近一次人行公积金的月缴存额", "Integer"), CNT_ACCFUND_OWNPERCENT_NEW(
			"CNT_ACCFUND_OWNPERCENT_NEW", "最近一次人行公积金的个人缴费比例", "double"), CNT_ACCFUND_STATE_NEW(
			"CNT_ACCFUND_STATE_NEW", "最近一次人行公积金的缴费状态", "String"), MONTH_ACCFUND_LASTEST(
			"MONTH_ACCFUND_LASTEST", "最近一次公积金缴纳距报告期的月份", "Integer"), CNT_ACCFUND(
			"CNT_ACCFUND", "公积金缴存记录数", "Integer"), CNT_ACCFUND_ERROR(
			"CNT_ACCFUND_ERROR", "公积金缴存异常记录数", "Integer"), MONTH_ACCFUND_REPORT_TIME(
			"MONTH_ACCFUND_REPORT_TIME", "公积金缴至时间距报告时间月份数", "Integer"), ITEM_ACCFUND_STATE(
			"ITEM_ACCFUND_STATE", "最近一次人行公积金的缴费状态", "Integer"),
	/**
	 * (25) 相关还款责任信息(repaymentDuty)
	 */
	CNT_LOAN_GUARANTEE_SEC("CNT_LOAN_GUARANTEE_SEC", "对外担保信息中五级分类为次级的数量",
			"Integer"), CNT_LOAN_GUARANTEE_SUS("CNT_LOAN_GUARANTEE_SUS",
			"对外担保信息中五级分类为可疑的数量", "Integer"), CNT_LOAN_GUARANTEE_LOSS(
			"CNT_LOAN_GUARANTEE_LOSS", "对外担保信息中五级分类为损失的数量", "Integer"), CNT_LOAN_GUARANTEE_ATTENTION(
			"CNT_LOAN_GUARANTEE_ATTENTION", "对外担保信息中五级分类为关注的贷款账户数", "Integer"), CNT_GUARENTEE_BALANCE(
			"CNT_GUARENTEE_BALANCE", "当前对外担保余额", "Integer"),

	/**
	 * (41) 行政处罚记录(adminPunishment)
	 */
	CNT_ADMINPUNISHMENT("CNT_ADMINPUNISHMENT", "行政处罚记录数", "Integer"),

	/**
	 * (44) 民事判决记录(civilJudgement)
	 */
	CNT_CIVILJUDGEMENT("CNT_CIVILJUDGEMENT", "低保救助记录数", "Integer"),

	/**
	 * (46) 欠税记录(taxArrear)
	 */
	AMT_TAX("AMT_TAX", "欠税总额", "Integer"),

	/**
	 * (48) 低保救助记录(salvation)
	 */
	CNT_SALVATION("CNT_SALVATION", "民事判决记录数", "Integer"),

	/**
	 * (2) 身份信息(identity)
	 */
	IF_PHONENO_CORRECT("IF_PHONENO_CORRECT", "手机号一致性判断", "Integer"),
	// (30)字段解读(numAnalysis)
	NUMBERANALYSIS_SCORE("NUMBERANALYSIS_SCORE", "数字解读分", "Integer");

	public String field;
	public String fieldDesc;
	public String fieldType;

	PbocLabelEnum(String field, String fieldDesc, String fieldType) {
		this.field = field;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
	}
}
