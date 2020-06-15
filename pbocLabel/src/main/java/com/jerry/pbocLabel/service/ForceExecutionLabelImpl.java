package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.ForceExecutionEnum;
import com.jerry.pbocLabel.util.DateUtils;
import com.jerry.pbocLabel.util.MapUtils;
import com.jerry.pbocLabel.util.StringUtil;

public class ForceExecutionLabelImpl {

	private static Logger log = LoggerFactory
			.getLogger(ForceExecutionLabelImpl.class);

	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo,
			Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：强制执行记录指标计算");

		Integer CNT_EXECUTE_IN24M = 0;
		Integer CNT_EXECUTE_IN12M = 0;

		Integer CNT_EXECUTE_SX = 0;
		if (!pbocVo.getForceExecution().isEmpty()) {
			for (Map<String, Object> map : pbocVo.getForceExecution()) {
				log.debug("强制执行记录 展示:{}", map);
				// 判断立案时间是否为空
				if (!StringUtil.isEmpty(MapUtils.getStringFromMap(map,
						ForceExecutionEnum.REGISTERDATE.field))) {
					// 报告时间-立案时间
					Integer getdateDiffMonth;
					try {
						getdateDiffMonth = DateUtils.getdateDiffMonth(
								pbocBaseInfoPO.getReportCreateTime(),
								MapUtils.getStringFromMap(map,
										ForceExecutionEnum.REGISTERDATE.field),
								DateUtils.DATE_FORMAT_3,
								DateUtils.DATE_FORMAT_6);
						if (getdateDiffMonth < 0) {
							throw new RuntimeException();
						}
						if (getdateDiffMonth <= 24) {
							// 最近24个月存在强制执行记录
							CNT_EXECUTE_IN24M++;
						}
						if (getdateDiffMonth <= 12) {
							// 近12个月强制执行记录数
							CNT_EXECUTE_IN12M++;
						}
					} catch (Exception e) {
						log.error("日期计算发生错误,错误记录为{}", map);
					}
				} else {
					CNT_EXECUTE_IN24M++;
					CNT_EXECUTE_IN12M++;
				}
				if (MapUtils.getStringFromMap(map,
						ForceExecutionEnum.CASESTATE.field).contains("失信")) {
					// 失信被执行人记录数
					CNT_EXECUTE_SX++;
				}
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.CNT_EXECUTE_IN24M.field,
				CNT_EXECUTE_IN24M, PbocLabelEnum.CNT_EXECUTE_IN24M.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_EXECUTE_SX.field, CNT_EXECUTE_SX,
				PbocLabelEnum.CNT_EXECUTE_SX.fieldDesc);
		pbocRspPO.addIndex(PbocLabelEnum.CNT_EXECUTE_IN12M.field,
				CNT_EXECUTE_IN12M, PbocLabelEnum.CNT_EXECUTE_IN12M.fieldDesc);
	}
}
