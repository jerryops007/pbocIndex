package com.jerry.pbocLabel.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.param.ReqParamEnum;

public class PbocLabelServiceImpl implements PbocLabelService {

	private static Logger log = LoggerFactory
			.getLogger(PbocLabelServiceImpl.class);
	private PbocVo pbocVo;
	private Map<String, Object> PbocParam;
	private PbocRspPO pbocRspPO;
	private PbocBaseInfoPO pbocBaseInfoPO;

	public PbocLabelServiceImpl() {
		super();
		pbocRspPO = new PbocRspPO();
		pbocBaseInfoPO = new PbocBaseInfoPO();
	}

	public JSONObject PBOC_INDEX(String pboc, Map<String, Object> params) {
		log.info("人行报告人行变量指标解析开始");
		log.debug("人行报文指标解析处理开始,额外数据参数为{}", params.toString());
		PbocParam = params;
		long startTime = System.currentTimeMillis();
		try {
			Map<String, Object> pbocMap = JSONObject.parseObject(pboc);
			pbocVo = new PbocVo(pbocMap);
			/**
			 * 基础信息提取
			 */
			BaseInfoImpl.run(pbocRspPO, pbocVo, PbocParam, pbocBaseInfoPO);
			/**
			 * 开始人行报文指标解析
			 */
			TelPaymentLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			ForceExecutionLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			RecordDetailLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			CreditSummaryCueLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			FellbackSumLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			DetailQueryReasonLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			ShareAndDebtSumLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			OverdueSumLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			AccFundLabelImpl.run(pbocRspPO, pbocVo, PbocParam, pbocBaseInfoPO);
			ContratInfoLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			AwardCreditInfoLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			RepaymentDutyLabelImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			AdminPunishmentImpl.run(pbocRspPO, pbocVo, PbocParam,
					pbocBaseInfoPO);
			SalvationLabelImpl
					.run(pbocRspPO, pbocVo, PbocParam, pbocBaseInfoPO);
			TaxArrearLabelImpl
					.run(pbocRspPO, pbocVo, PbocParam, pbocBaseInfoPO);
			IdentityLabelImpl.run(pbocRspPO, pbocVo, PbocParam, pbocBaseInfoPO);
			QueryReqLabelImpl.run(pbocRspPO, pbocVo, PbocParam, pbocBaseInfoPO);
			NumAnalysisImpl.run(pbocRspPO, pbocVo, PbocParam, pbocBaseInfoPO);

			log.info("人行报文解析完成,解析耗时{}ms", System.currentTimeMillis()
					- startTime);
			pbocRspPO.setStatus("true");
			pbocRspPO.setExecption_message("解析完成");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("人行报文解析异常，申请件编码为{}", PbocParam.get(ReqParamEnum.BARCODE));
			pbocRspPO.setStatus("false");
			pbocRspPO.setExecption_message("解析失败,原因为:" + e.getMessage());
		}
		pbocRspPO.setCost_time(System.currentTimeMillis() - startTime);

		return (JSONObject) JSONObject.toJSON(pbocRspPO);
	}
}
