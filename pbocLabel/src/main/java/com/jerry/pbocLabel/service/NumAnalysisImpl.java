package com.jerry.pbocLabel.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.NumAnalysisEnum;
import com.jerry.pbocLabel.util.MapUtils;

public class NumAnalysisImpl {
	private static Logger log = LoggerFactory
			.getLogger(ContratInfoLabelImpl.class);

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo,
			Map<String, Object> pbocParam, PbocBaseInfoPO pbocBaseInfoPO) {

		log.info("人行报文解析：开始字段解读指标解析");

		Integer NUMBERANALYSIS_SCORE = 0;

		if (!pbocVo.getNumAnalysis().isEmpty()) {
			log.debug("字段解读展示:{}", pbocVo.getNumAnalysis());

			Map<String, Object> map = pbocVo.getNumAnalysis();
			// 相对位置
			String RELATIVEPOSITION = MapUtils.getStringFromMap(map,
					NumAnalysisEnum.RELATIVEPOSITION.field);
			// 说明条数
			String COMENT = MapUtils.getStringFromMap(map,
					NumAnalysisEnum.COMENT.field);
			// 数字解读
			Integer NUMBERANALYSIS = MapUtils.getIntegerFromMap(map,
					NumAnalysisEnum.NUMBERANALYSIS.field);
			// 分数说明信息
			List<Map> SCOREEXPLAINS = MapUtils.getListFromMap(map,
					NumAnalysisEnum.SCOREEXPLAINS.field);

			/**
			 * 数字解读分
			 */
			NUMBERANALYSIS_SCORE = NUMBERANALYSIS;

		}

		pbocRspPO.addIndex(PbocLabelEnum.NUMBERANALYSIS_SCORE.field,
				NUMBERANALYSIS_SCORE,
				PbocLabelEnum.NUMBERANALYSIS_SCORE.fieldDesc);

	}
}
