package com.jerry.pbocLabel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.dict.DictRecordDetail;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.RecordDetailEnum;
import com.jerry.pbocLabel.util.ArrayUtils;
import com.jerry.pbocLabel.util.DateUtils;
import com.jerry.pbocLabel.util.MapUtils;

public class RecordDetailLabelImpl {

	private static Logger log = LoggerFactory
			.getLogger(RecordDetailLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo,
			Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：信贷审批查询记录明细");
		Integer MONTH_APPLY_QUERY_CARD = 9999;
		Integer MONTH_APPLY_QUERY_LOAN = 9999;
		Integer CNT_APPLY_QUERY_CARD_IN3M = 0;
		Integer CNT_APPLY_QUERY_LOAN_IN3M = 0;
		Integer CNT_ORG_APPLY_QUERY_CARD_IN3M = 0;
		Integer CNT_ORG_APPLY_QUERY_LOAN_IN3M = 0;
		Integer CNT_ORG_APPLY_QUERY_IN3M = 0;
		Integer CNT_ORG_APPLY_QUERY_IN3M_1 = 0;

		Integer CNT_APPLY_QUERY_CARD_IN6M = 0;
		Integer CNT_APPLY_QUERY_LOAN_IN6M = 0;
		Integer CNT_ORG_APPLY_QUERY_CARD_IN6M = 0;
		Integer CNT_ORG_APPLY_QUERY_LOAN_IN6M = 0;
		Integer CNT_ORG_APPLY_QUERY_IN6M = 0;

		List<String> CNT_ORG_APPLY_QUERY_CARD_IN3M_querieList = new ArrayList<String>();
		List<String> CNT_ORG_APPLY_QUERY_LOAN_IN3M_querieList = new ArrayList<String>();
		List<String> CNT_ORG_APPLY_QUERY_CARD_IN6M_querieList = new ArrayList<String>();
		List<String> CNT_ORG_APPLY_QUERY_LOAN_IN6M_querieList = new ArrayList<String>();
		List<String> CNT_ORG_APPLY_QUERY_IN6M_querieList = new ArrayList<String>();
		List<String> CNT_ORG_APPLY_QUERY_IN3M_querieList = new ArrayList<String>();
		List<String> CNT_ORG_APPLY_QUERY_IN3M_1_querieList = new ArrayList<String>();

		Integer CNT_ORG_APPLY_QUERY_IN1M = 0;
		Integer CNT_ORG_APPLY_QUERY_IN12M = 0;
		Integer CNT_APPLY_QUERY_IN2M = 0;

		List<String> CNT_ORG_APPLY_QUERY_IN1M_querieList = new ArrayList<String>();
		List<String> CNT_ORG_APPLY_QUERY_IN12M_querieList = new ArrayList<String>();
		List<String> CNT_APPLY_QUERY_IN2M_querieList = new ArrayList<String>();
		ArrayList<String> CNT_ORG_QUERY_IN3M_querieList = new ArrayList<String>();
		ArrayList<String> CNT_ORG_QUERY_IN6M_querieList = new ArrayList<String>();

		Integer CNT_QUERY_IN6M = 0;
		Integer CNT_QUERY_IN3M = 0;
		Integer CNT_QUERY_IN6M_1 = 0;
		Integer CNT_ORG_QUERY_IN3M = 0;
		Integer CNT_ORG_QUERY_IN6M = 0;

		Integer MONTH_APPLY_QUERY_GUARANTEE = 9999;

		ArrayList<String> CNT_QUERY_IN6M_TEMP_ORGCODE = new ArrayList<String>();

		if (!pbocVo.getRecordDetail().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getRecordDetail()) {
				log.debug("信贷审批查询记录  展示:{}", map);
				String QUERYREASON = MapUtils.getStringFromMap(map,
						RecordDetailEnum.QUERYREASON.field);
				String QUERIER = MapUtils.getStringFromMap(map,
						RecordDetailEnum.QUERIER.field);
				Integer month = null;
				try {
					month = DateUtils.getdateDiffMonth(pbocBaseInfoPO
							.getReportCreateTime(), MapUtils.getStringFromMap(
							map, RecordDetailEnum.QUERYDATE.field),
							DateUtils.DATE_FORMAT_3, DateUtils.DATE_FORMAT_6);
					if (month < 0) {
						throw new RuntimeException();
					}
				} catch (Exception e) {
					log.error("日期计算发生错误，错误记录为{}", map);
					continue;
				}
				if (QUERYREASON.equals(DictRecordDetail.queryReason_02)
						| QUERYREASON.equals(DictRecordDetail.queryReason_03)
						| QUERYREASON.equals(DictRecordDetail.queryReason_08)) {
					if (month <= 6) {
						CNT_QUERY_IN6M++;
						CNT_QUERY_IN6M_TEMP_ORGCODE.add(QUERIER);
						// 近6个月人行查询次数（1个自然月内 同一机构相同原因的查询记录记作一次）
						CNT_ORG_QUERY_IN6M_querieList.add(QUERIER + month
								+ QUERYREASON);
					}
					if (month <= 3) {
						CNT_QUERY_IN3M++;
						CNT_ORG_QUERY_IN3M_querieList.add(QUERIER + month
								+ QUERYREASON);
					}
				}
				/**
				 * 他行查询
				 */
				if (MapUtils.getStringFromMap(map,
						RecordDetailEnum.QUERIER.field).length() == 2) {
					/**
					 * 信用卡审批
					 */
					if (QUERYREASON.equals(DictRecordDetail.queryReason_03)) {
						/**
						 * 最近一次他行信用卡查询时间
						 */
						MONTH_APPLY_QUERY_CARD = Math.min(
								MONTH_APPLY_QUERY_CARD, month);
						/**
						 * 最近三个月他行信用卡查询次数与机构数
						 */
						if (month <= 3) {
							CNT_APPLY_QUERY_CARD_IN3M++;
							CNT_ORG_APPLY_QUERY_CARD_IN3M_querieList
									.add(MapUtils.getStringFromMap(map,
											RecordDetailEnum.QUERIER.field));
						}
						/**
						 * 最近六个月他行信用卡查询次数与机构数
						 */
						if (month <= 6) {
							CNT_APPLY_QUERY_CARD_IN6M++;
							CNT_ORG_APPLY_QUERY_CARD_IN6M_querieList
									.add(MapUtils.getStringFromMap(map,
											RecordDetailEnum.QUERIER.field));
						}
					}
					/**
					 * 贷款审批
					 */
					if (QUERYREASON.equals(DictRecordDetail.queryReason_02)) {
						/**
						 * 最近一次他行贷款查询时间
						 */
						MONTH_APPLY_QUERY_LOAN = Math.min(
								MONTH_APPLY_QUERY_LOAN, month);
						/**
						 * 最近三个月他行贷款查询次数与机构数
						 */
						if (month <= 3) {
							CNT_APPLY_QUERY_LOAN_IN3M++;
							CNT_ORG_APPLY_QUERY_LOAN_IN3M_querieList
									.add(MapUtils.getStringFromMap(map,
											RecordDetailEnum.QUERIER.field));
						}
						/**
						 * 最近六个月他行贷款查询次数与机构数
						 */
						if (month <= 6) {
							CNT_APPLY_QUERY_LOAN_IN6M++;
							CNT_ORG_APPLY_QUERY_LOAN_IN6M_querieList
									.add(MapUtils.getStringFromMap(map,
											RecordDetailEnum.QUERIER.field));
						}
					}
					/**
					 * 担保资格审查
					 */
					if (QUERYREASON.equals(DictRecordDetail.queryReason_08)) {
						/**
						 * 最近一次他行担保资格审查查询距今月数
						 */
						MONTH_APPLY_QUERY_GUARANTEE = Math.min(
								MONTH_APPLY_QUERY_GUARANTEE, month);
					}
					/**
					 * 合并信息查询
					 */
					if (QUERYREASON.equals(DictRecordDetail.queryReason_02)
							| QUERYREASON
									.equals(DictRecordDetail.queryReason_03)) {
						/**
						 * 近3个月他行信贷审批查询总计机构数
						 */
						if (month <= 3) {
							CNT_ORG_APPLY_QUERY_IN3M_querieList.add(MapUtils
									.getStringFromMap(map,
											RecordDetailEnum.QUERIER.field));
						}
						/**
						 * 近6个月他行信贷审批查询总计机构数
						 */
						if (month <= 6) {
							CNT_ORG_APPLY_QUERY_IN6M_querieList.add(MapUtils
									.getStringFromMap(map,
											RecordDetailEnum.QUERIER.field));
						}
					}
					if (QUERYREASON.equals(DictRecordDetail.queryReason_02)
							| QUERYREASON
									.equals(DictRecordDetail.queryReason_03)
							| QUERYREASON
									.equals(DictRecordDetail.queryReason_08)) {
						/**
						 * 近3个月非本行信贷审批查询总计机构数（相比评分卡来说，查询原因多了“担保资格审查”）
						 */
						if (month <= 3) {
							CNT_ORG_APPLY_QUERY_IN3M_1_querieList.add(MapUtils
									.getStringFromMap(map,
											RecordDetailEnum.QUERIER.field));
						}
					}
					/**
					 * 早期风险预警：次数统计
					 */
					if (QUERYREASON.equals(DictRecordDetail.queryReason_02)
							| QUERYREASON
									.equals(DictRecordDetail.queryReason_03)
							| QUERYREASON
									.equals(DictRecordDetail.queryReason_08)) {
						/**
						 * 近1个月非本行信贷审批查询总计机构数
						 */
						if (month <= 1) {
							CNT_ORG_APPLY_QUERY_IN1M_querieList.add(MapUtils
									.getStringFromMap(map,
											RecordDetailEnum.QUERIER.field));
						}
						/**
						 * 近2个月(60天)非本行信用报告查询次数
						 */
						if (month <= 2) {
							CNT_APPLY_QUERY_IN2M_querieList.add(MapUtils
									.getStringFromMap(map,
											RecordDetailEnum.QUERIER.field));
						}
						/**
						 * 近12个月非本行信贷审批查询总计机构数
						 */
						if (month <= 12) {
							CNT_ORG_APPLY_QUERY_IN12M_querieList.add(MapUtils
									.getStringFromMap(map,
											RecordDetailEnum.QUERIER.field));
						}
					}
				}
			}

			CNT_ORG_APPLY_QUERY_CARD_IN3M = ArrayUtils.removeRepeat(
					CNT_ORG_APPLY_QUERY_CARD_IN3M_querieList).size();
			CNT_ORG_APPLY_QUERY_LOAN_IN3M = ArrayUtils.removeRepeat(
					CNT_ORG_APPLY_QUERY_LOAN_IN3M_querieList).size();
			CNT_ORG_APPLY_QUERY_CARD_IN6M = ArrayUtils.removeRepeat(
					CNT_ORG_APPLY_QUERY_CARD_IN6M_querieList).size();
			CNT_ORG_APPLY_QUERY_LOAN_IN6M = ArrayUtils.removeRepeat(
					CNT_ORG_APPLY_QUERY_LOAN_IN6M_querieList).size();
			CNT_ORG_APPLY_QUERY_IN3M = ArrayUtils.removeRepeat(
					CNT_ORG_APPLY_QUERY_IN3M_querieList).size();
			CNT_ORG_APPLY_QUERY_IN3M_1 = ArrayUtils.removeRepeat(
					CNT_ORG_APPLY_QUERY_IN3M_1_querieList).size();
			CNT_ORG_APPLY_QUERY_IN6M = ArrayUtils.removeRepeat(
					CNT_ORG_APPLY_QUERY_IN6M_querieList).size();
			CNT_QUERY_IN6M_1 = ArrayUtils.removeRepeat(
					CNT_QUERY_IN6M_TEMP_ORGCODE).size();

			CNT_ORG_APPLY_QUERY_IN1M = ArrayUtils.removeRepeat(
					CNT_ORG_APPLY_QUERY_IN1M_querieList).size();
			CNT_APPLY_QUERY_IN2M = ArrayUtils.removeRepeat(
					CNT_APPLY_QUERY_IN2M_querieList).size();
			CNT_ORG_APPLY_QUERY_IN12M = ArrayUtils.removeRepeat(
					CNT_ORG_APPLY_QUERY_IN12M_querieList).size();
			CNT_ORG_QUERY_IN3M = ArrayUtils.removeRepeat(
					CNT_ORG_QUERY_IN3M_querieList).size();
			CNT_ORG_QUERY_IN6M = ArrayUtils.removeRepeat(
					CNT_ORG_QUERY_IN6M_querieList).size();
		}
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_APPLY_QUERY_CARD.field,
				MONTH_APPLY_QUERY_CARD,
				PbocLabelEnum.MONTH_APPLY_QUERY_CARD.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_APPLY_QUERY_LOAN.field,
				MONTH_APPLY_QUERY_LOAN,
				PbocLabelEnum.MONTH_APPLY_QUERY_LOAN.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_APPLY_QUERY_CARD_IN3M.field,
				CNT_APPLY_QUERY_CARD_IN3M,
				PbocLabelEnum.CNT_APPLY_QUERY_CARD_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_APPLY_QUERY_LOAN_IN3M.field,
				CNT_APPLY_QUERY_LOAN_IN3M,
				PbocLabelEnum.CNT_APPLY_QUERY_LOAN_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_APPLY_QUERY_CARD_IN6M.field,
				CNT_APPLY_QUERY_CARD_IN6M,
				PbocLabelEnum.CNT_APPLY_QUERY_CARD_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_APPLY_QUERY_LOAN_IN6M.field,
				CNT_APPLY_QUERY_LOAN_IN6M,
				PbocLabelEnum.CNT_APPLY_QUERY_LOAN_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_APPLY_QUERY_CARD_IN3M.field,
				CNT_ORG_APPLY_QUERY_CARD_IN3M,
				PbocLabelEnum.CNT_ORG_APPLY_QUERY_CARD_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_APPLY_QUERY_LOAN_IN3M.field,
				CNT_ORG_APPLY_QUERY_LOAN_IN3M,
				PbocLabelEnum.CNT_ORG_APPLY_QUERY_LOAN_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_APPLY_QUERY_CARD_IN6M.field,
				CNT_ORG_APPLY_QUERY_CARD_IN6M,
				PbocLabelEnum.CNT_ORG_APPLY_QUERY_CARD_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_APPLY_QUERY_LOAN_IN6M.field,
				CNT_ORG_APPLY_QUERY_LOAN_IN6M,
				PbocLabelEnum.CNT_ORG_APPLY_QUERY_LOAN_IN6M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_APPLY_QUERY_IN3M.field,
				CNT_ORG_APPLY_QUERY_IN3M,
				PbocLabelEnum.CNT_ORG_APPLY_QUERY_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_APPLY_QUERY_IN3M_1.field,
				CNT_ORG_APPLY_QUERY_IN3M_1,
				PbocLabelEnum.CNT_ORG_APPLY_QUERY_IN3M_1.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_APPLY_QUERY_IN6M.field,
				CNT_ORG_APPLY_QUERY_IN6M,
				PbocLabelEnum.CNT_ORG_APPLY_QUERY_IN6M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.MONTH_APPLY_QUERY_GUARANTEE.field,
				MONTH_APPLY_QUERY_GUARANTEE,
				PbocLabelEnum.MONTH_APPLY_QUERY_GUARANTEE.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_QUERY_IN3M.field, CNT_QUERY_IN3M,
				PbocLabelEnum.CNT_QUERY_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_QUERY_IN3M.field,
				CNT_ORG_QUERY_IN3M, PbocLabelEnum.CNT_ORG_QUERY_IN3M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_QUERY_IN6M.field, CNT_QUERY_IN6M,
				PbocLabelEnum.CNT_QUERY_IN6M.fieldDesc);

		pbocRspPO.addIndex(PbocLabelEnum.CNT_QUERY_IN6M_1.field,
				CNT_QUERY_IN6M_1, PbocLabelEnum.CNT_QUERY_IN6M_1.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_QUERY_IN6M.field,
				CNT_ORG_QUERY_IN6M, PbocLabelEnum.CNT_ORG_QUERY_IN6M.fieldDesc);

		/**
		 * 早期风险预警
		 */
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_APPLY_QUERY_IN1M.field,
				CNT_ORG_APPLY_QUERY_IN1M,
				PbocLabelEnum.CNT_ORG_APPLY_QUERY_IN1M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_APPLY_QUERY_IN2M.field,
				CNT_APPLY_QUERY_IN2M,
				PbocLabelEnum.CNT_APPLY_QUERY_IN2M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ORG_APPLY_QUERY_IN12M.field,
				CNT_ORG_APPLY_QUERY_IN12M,
				PbocLabelEnum.CNT_ORG_APPLY_QUERY_IN12M.fieldDesc);
	}
}
