package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.dict.DictAccFundInfo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.AccFundEnum;
import com.jerry.pbocLabel.util.DateUtils;
import com.jerry.pbocLabel.util.MapUtils;

public class AccFundLabelImpl {

	private static Logger log = LoggerFactory.getLogger(AccFundLabelImpl.class);

	@SuppressWarnings("unused")
	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo,
			Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：住房公积金参缴记录");
		Integer MONTH_ACCFUND_LASTEST = -1;

		String CNT_ACCFUND_MONTH_NEW = new String();
		String CNT_ACCFUND_STATE_NEW = new String();
		Integer CNT_ACCFUND_PAY_NEW = -1;
		Integer CNT_ACCFUND_OWNPERCENT_NEW = -1;
		Integer CNT_ACCFUND_MONTH_NEW_TEMP = 9999;
		Integer CNT_ACCFUND = 0;
		Integer CNT_ACCFUND_ERROR = 0;
		Integer MONTH_ACCFUND_REPORT_TIME = 0;
		Integer RATE_ACCFUND_FIRMPERCENT_NEW = 0;
		String ITEM_ACCFUND_STATE = new String();

		if (!pbocVo.getAccFund().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getAccFund()) {
				try {
					log.debug("住房公积金参缴记录 展示：{}", map);
					Integer getdateDiffMonth = DateUtils.getdateDiffMonth(
							pbocBaseInfoPO.getReportCreateTime(), MapUtils
									.getStringFromMap(map,
											AccFundEnum.GETTIME.field),
							DateUtils.DATE_FORMAT_3, DateUtils.DATE_FORMAT_6);
					Integer getdateDiffMonth_TOMONTH;
					try {
						getdateDiffMonth_TOMONTH = DateUtils.getdateDiffMonth(
								pbocBaseInfoPO.getReportCreateTime(), MapUtils
										.getStringFromMap(map,
												AccFundEnum.TOMONTH.field),
								DateUtils.DATE_FORMAT_3,
								DateUtils.DATE_FORMAT_5);
					} catch (Exception e) {
						log.error("日期记录发生错误,记录信息为{}", map);
						continue;
					}
					String TOMONTH = MapUtils.getStringFromMap(map,
							AccFundEnum.TOMONTH.field);
					Integer PAY = MapUtils.getIntegerFromMap(map,
							AccFundEnum.PAY.field);
					Integer OWNPERCENT = MapUtils.getIntegerFromMap(map,
							AccFundEnum.OWNPERCENT.field);
					String STATE = MapUtils.getStringFromMap(map,
							AccFundEnum.STATE.field);
					Integer COMPERCENT = MapUtils.getIntegerFromMap(map,
							AccFundEnum.COMPERCENT.field);
					/**
					 * 公积金缴存记录数
					 */
					CNT_ACCFUND++;
					/**
					 * 公积金缴存异常记录数
					 */
					if (!STATE.equals(DictAccFundInfo.STATE_JJ)
							| (STATE.equals(DictAccFundInfo.STATE_JJ) && getdateDiffMonth_TOMONTH <= 3)) {
						CNT_ACCFUND_ERROR++;
					}
					/**
					 * 人行公积金
					 */
					if (getdateDiffMonth_TOMONTH < CNT_ACCFUND_MONTH_NEW_TEMP) {
						/**
						 * 最近一次人行公积金的缴至月份
						 */
						CNT_ACCFUND_MONTH_NEW = TOMONTH;
						/**
						 * 最近一次人行公积金的月缴存额
						 */
						CNT_ACCFUND_PAY_NEW = PAY;
						/**
						 * 最近一次人行公积金的个人缴费比例
						 */
						CNT_ACCFUND_OWNPERCENT_NEW = OWNPERCENT;
						/**
						 * 最近一次人行公积金的缴费状态
						 */
						CNT_ACCFUND_STATE_NEW = STATE;
						/**
						 * 公积金缴至时间距报告时间月份数
						 */
						MONTH_ACCFUND_REPORT_TIME = getdateDiffMonth_TOMONTH;
						/**
						 * 最近一次人行公积金的缴费状态
						 */
						ITEM_ACCFUND_STATE = STATE;
						/**
						 * 最近一次人行公积金的单位缴费比例
						 */
						RATE_ACCFUND_FIRMPERCENT_NEW = COMPERCENT;
						/**
						 * 将TOMONTH距今月数替换为较小值
						 */
						CNT_ACCFUND_MONTH_NEW_TEMP = getdateDiffMonth_TOMONTH;
					}
					log.debug("缴纳记录距离报告期之间的月份：{},当前lastest_month：{}",
							getdateDiffMonth, MONTH_ACCFUND_LASTEST);
					if (MONTH_ACCFUND_LASTEST < 0) {
						MONTH_ACCFUND_LASTEST = getdateDiffMonth;
					}
					if (MONTH_ACCFUND_LASTEST > getdateDiffMonth) {
						MONTH_ACCFUND_LASTEST = getdateDiffMonth;
					}
				} catch (Exception e) {
					log.error("人行指标处理发生异常，异常信息为{}", e.getMessage());
					continue;
				}
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_ACCFUND_LASTEST.field,
				MONTH_ACCFUND_LASTEST,
				PbocLabelEnum.MONTH_ACCFUND_LASTEST.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCFUND_MONTH_NEW.field,
				CNT_ACCFUND_MONTH_NEW,
				PbocLabelEnum.CNT_ACCFUND_MONTH_NEW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCFUND_PAY_NEW.field,
				CNT_ACCFUND_PAY_NEW,
				PbocLabelEnum.CNT_ACCFUND_PAY_NEW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCFUND_OWNPERCENT_NEW.field,
				CNT_ACCFUND_OWNPERCENT_NEW,
				PbocLabelEnum.CNT_ACCFUND_OWNPERCENT_NEW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCFUND_STATE_NEW.field,
				CNT_ACCFUND_STATE_NEW,
				PbocLabelEnum.CNT_ACCFUND_STATE_NEW.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCFUND.field, CNT_ACCFUND,
				PbocLabelEnum.CNT_ACCFUND.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_ACCFUND_ERROR.field,
				CNT_ACCFUND_ERROR, PbocLabelEnum.CNT_ACCFUND_ERROR.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.MONTH_ACCFUND_REPORT_TIME.field,
				MONTH_ACCFUND_REPORT_TIME,
				PbocLabelEnum.MONTH_ACCFUND_REPORT_TIME.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.ITEM_ACCFUND_STATE.field,
				ITEM_ACCFUND_STATE, PbocLabelEnum.ITEM_ACCFUND_STATE.fieldDesc);

	}
}
