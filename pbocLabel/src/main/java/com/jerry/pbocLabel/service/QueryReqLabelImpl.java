package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.param.ReqParamEnum;
import com.jerry.pbocLabel.enums.pboc.QueryReqEnum;
import com.jerry.pbocLabel.util.MapUtils;

public class QueryReqLabelImpl {
	private static Logger log = LoggerFactory
			.getLogger(FellbackSumLabelImpl.class);

	@SuppressWarnings("unused")
	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo,
			Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：查询信息汇总");

		Boolean IF_CERTNO_CORRECT = false;

		if (!pbocVo.getQueryReq().isEmpty()) {
			Map<String, Object> map = pbocVo.getQueryReq();
			log.debug("授信情况 展示:{}", map);

			String CERTNO = MapUtils.getStringFromMap(map,
					QueryReqEnum.CERTNO.field);

			if (CERTNO.equals(PbocParam.get(ReqParamEnum.CERTTYPE))) {
				// 证件号一致性判断
				IF_CERTNO_CORRECT = true;
			}
		}
	}
}
