package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.CreditSummaryCueEnum;
import com.jerry.pbocLabel.util.DateUtils;
import com.jerry.pbocLabel.util.MapUtils;

public class CreditSummaryCueLabelImpl {

	private static Logger log = LoggerFactory.getLogger(CreditSummaryCueLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：信用信息提示");
		Integer MONTH_CREDIT_HISTORY_LENGTH = -1;
		Boolean IF_NO_PBOC_RECORD = true;
		Integer CNT_LOAN_SUM = 0;
		if (!pbocVo.getCreditSummaryCue().isEmpty()) {
			log.debug("信用信息提示展示：{}", pbocVo.getCreditSummaryCue().toString());
			String FIRSTLOANOPENMONTH = MapUtils.getStringFromMap(pbocVo.getCreditSummaryCue(), CreditSummaryCueEnum.FIRSTLOANOPENMONTH.field);
			String FIRSTLOANCARDOPENMONTH = MapUtils
					.getStringFromMap(pbocVo.getCreditSummaryCue(), CreditSummaryCueEnum.FIRSTLOANCARDOPENMONTH.field);
			String FIRSTSTANDARDLOANCARDOPENMONTH = MapUtils.getStringFromMap(pbocVo.getCreditSummaryCue(),
					CreditSummaryCueEnum.FIRSTSTANDARDLOANCARDOPENMONTH.field);
			String FIRSTCOMHOUSELOANOPENMONTH = MapUtils.getStringFromMap(pbocVo.getCreditSummaryCue(),
					CreditSummaryCueEnum.FIRSTCOMHOUSELOANOPENMONTH.field);
			String FIRSTOTHERLOANCOUNTOPENMONTH = MapUtils.getStringFromMap(pbocVo.getCreditSummaryCue(),
					CreditSummaryCueEnum.FIRSTOTHERLOANCOUNTOPENMONTH.field);
			String OTHERTYPEOPENMONTH = MapUtils.getStringFromMap(pbocVo.getCreditSummaryCue(), CreditSummaryCueEnum.OTHERTYPEOPENMONTH.field);

			Integer HOUSELOANCOUNT = MapUtils.getIntegerFromMap(pbocVo.getCreditSummaryCue(), CreditSummaryCueEnum.HOUSELOANCOUNT.field);
			Integer COMHOUSELOANCOUNT = MapUtils.getIntegerFromMap(pbocVo.getCreditSummaryCue(), CreditSummaryCueEnum.COMHOUSELOANCOUNT.field);
			Integer OTHERLOANCOUNT = MapUtils.getIntegerFromMap(pbocVo.getCreditSummaryCue(), CreditSummaryCueEnum.OTHERLOANCOUNT.field);
			/*
			 * 人行信用历史长度计算
			 */
			Integer temp1 = -1;
			Integer temp2 = -1;
			Integer temp3 = -1;
			Integer temp4 = -1;
			Integer temp5 = -1;
			Integer temp6 = -1;
			if (!pbocBaseInfoPO.getReportCreateTime().isEmpty() && !FIRSTLOANOPENMONTH.isEmpty() && !FIRSTLOANOPENMONTH.equals("..")
					&& !FIRSTLOANOPENMONTH.equals("--")) {
				temp1 = DateUtils.getdateDiffMonth(pbocBaseInfoPO.getReportCreateTime(), FIRSTLOANOPENMONTH, DateUtils.DATE_FORMAT_3,
						DateUtils.DATE_FORMAT_5);
			}
			if (!pbocBaseInfoPO.getReportCreateTime().isEmpty() && !FIRSTLOANCARDOPENMONTH.isEmpty() && !FIRSTLOANCARDOPENMONTH.equals("..")
					&& !FIRSTLOANCARDOPENMONTH.equals("--")) {
				temp2 = DateUtils.getdateDiffMonth(pbocBaseInfoPO.getReportCreateTime(), FIRSTLOANCARDOPENMONTH, DateUtils.DATE_FORMAT_3,
						DateUtils.DATE_FORMAT_5);
			}
			if (!pbocBaseInfoPO.getReportCreateTime().isEmpty() && !FIRSTSTANDARDLOANCARDOPENMONTH.isEmpty()
					&& !FIRSTSTANDARDLOANCARDOPENMONTH.equals("..") && !FIRSTSTANDARDLOANCARDOPENMONTH.equals("--")) {
				temp3 = DateUtils.getdateDiffMonth(pbocBaseInfoPO.getReportCreateTime(), FIRSTSTANDARDLOANCARDOPENMONTH, DateUtils.DATE_FORMAT_3,
						DateUtils.DATE_FORMAT_5);
			}
			if (!pbocBaseInfoPO.getReportCreateTime().isEmpty() && !FIRSTCOMHOUSELOANOPENMONTH.isEmpty() && !FIRSTCOMHOUSELOANOPENMONTH.equals("..")
					&& !FIRSTCOMHOUSELOANOPENMONTH.equals("--")) {
				temp4 = DateUtils.getdateDiffMonth(pbocBaseInfoPO.getReportCreateTime(), FIRSTCOMHOUSELOANOPENMONTH, DateUtils.DATE_FORMAT_3,
						DateUtils.DATE_FORMAT_5);
			}
			if (!pbocBaseInfoPO.getReportCreateTime().isEmpty() && !FIRSTOTHERLOANCOUNTOPENMONTH.isEmpty()
					&& !FIRSTOTHERLOANCOUNTOPENMONTH.equals("..") && !FIRSTOTHERLOANCOUNTOPENMONTH.equals("--")) {
				temp5 = DateUtils.getdateDiffMonth(pbocBaseInfoPO.getReportCreateTime(), FIRSTOTHERLOANCOUNTOPENMONTH, DateUtils.DATE_FORMAT_3,
						DateUtils.DATE_FORMAT_5);
			}
			if (!pbocBaseInfoPO.getReportCreateTime().isEmpty() && !OTHERTYPEOPENMONTH.isEmpty() && !OTHERTYPEOPENMONTH.equals("..")
					&& !OTHERTYPEOPENMONTH.equals("--")) {
				temp6 = DateUtils.getdateDiffMonth(pbocBaseInfoPO.getReportCreateTime(), OTHERTYPEOPENMONTH, DateUtils.DATE_FORMAT_3,
						DateUtils.DATE_FORMAT_5);
			}
			MONTH_CREDIT_HISTORY_LENGTH = Math.max(Math.max(temp1, temp2), Math.max(Math.max(temp3, temp4), Math.max(temp5, temp6)));
			/*
			 * 是否为 无人行征信报告、无信贷记录
			 */
			if (MONTH_CREDIT_HISTORY_LENGTH > 0) {
				IF_NO_PBOC_RECORD = false;
			} else {
				IF_NO_PBOC_RECORD = true;
			}
			/**
			 * 当前贷款笔数
			 */
			CNT_LOAN_SUM = HOUSELOANCOUNT + COMHOUSELOANCOUNT + OTHERLOANCOUNT;
		}
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_CREDIT_HISTORY_LENGTH.field, MONTH_CREDIT_HISTORY_LENGTH,
				PbocLabelEnum.MONTH_CREDIT_HISTORY_LENGTH.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.IF_NO_PBOC_RECORD.field, IF_NO_PBOC_RECORD, PbocLabelEnum.IF_NO_PBOC_RECORD.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_LOAN_SUM.field, CNT_LOAN_SUM, PbocLabelEnum.CNT_LOAN_SUM.fieldDesc);
	}
}
