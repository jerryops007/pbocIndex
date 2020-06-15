package com.jerry.pboclabel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.jerry.pbocLabel.enums.param.ReqParamEnum;
import com.jerry.pbocLabel.service.ContratInfoLabelImpl;
import com.jerry.pbocLabel.service.PbocLabelServiceImpl;

public class PbocLabelServiceImplTest {
	private static Logger log = LoggerFactory
			.getLogger(ContratInfoLabelImpl.class);

	private Map<String, Object> pbocMap;

	private StringBuffer sbf = new StringBuffer();
	private JSONObject pboc_INDEX;

	@Before
	public void before() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(
				// "D:\\query_platform\\平台文档\\CDA平台策略实施\\测试案例\\早期风险预警案例\\早期风险预警案例\\案例1——贷记卡当前状态为逾期M1的逾期金额-2000"),
						"C:\\Users\\yudaobo\\Desktop\\new 3.txt"), "utf-8"));
		String tempStr;
		while ((tempStr = reader.readLine()) != null) {
			sbf.append(tempStr);
		}
		reader.close();

		pbocMap = new HashMap<String, Object>();
		pbocMap.put(ReqParamEnum.BANKNAME.field, "秦农");
		pbocMap.put(ReqParamEnum.MO_PHONE.field, "13020155532");
		pbocMap.put(ReqParamEnum.BARCODE.field, "2012110102221");
		pbocMap.put(ReqParamEnum.CERTTYPE.field, "410922199902023816");

	}

	@Test
	public void PbocLabelServiceImpl() {
		PbocLabelServiceImpl impl = new PbocLabelServiceImpl();
		pboc_INDEX = impl.PBOC_INDEX(sbf.toString(), pbocMap);
	}

	@After
	public void after() {
		log.info("人行指标解析结果为：{}", JSONObject.toJSON(pboc_INDEX));
	}
}
