package com.jerry.pboclabel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.jerry.pbocLabel.enums.param.ReqParamEnum;
import com.jerry.pbocLabel.service.ContratInfoLabelImpl;
import com.jerry.pbocLabel.service.PbocLabelServiceImpl;

public class PbocLabelServiceImplTestBatch {
	private static Logger log = LoggerFactory
			.getLogger(ContratInfoLabelImpl.class);

	private Map<String, Object> pbocMap;

	private StringBuffer sbf;
	private JSONObject pboc_INDEX;
	private PbocLabelServiceImpl impl;

	@SuppressWarnings("resource")
	@Test
	public void before() throws Exception {
		// File file = new
		// File("C:\\Users\\lpwang\\Desktop\\20200106response\\20200106\\");
		File file = new File("C:\\Users\\yudaobo\\Desktop\\指标测试案例\\");
		pbocMap = new HashMap<String, Object>();
		pbocMap.put(ReqParamEnum.BANKNAME.field, "秦农");
		pbocMap.put(ReqParamEnum.MO_PHONE.field, "13020155532");
		pbocMap.put(ReqParamEnum.BARCODE.field, "2012110102221");
		// FileWriter fw = new
		// FileWriter("C:\\Users\\lpwang\\Desktop\\result.csv");
		FileWriter fw = new FileWriter(
				"C:\\Users\\yudaobo\\Desktop\\指标测试结果\\指标批量测试结果.txt");
		for (File file_temp : file.listFiles()) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file_temp), "utf-8"));
			String name = file_temp.getName();
			String tempStr;
			sbf = new StringBuffer();
			while ((tempStr = reader.readLine()) != null) {
				sbf.append(tempStr);
			}
			reader.close();
			impl = new PbocLabelServiceImpl();
			pboc_INDEX = impl.PBOC_INDEX(sbf.toString(), pbocMap);
			JSONObject json = (JSONObject) JSONObject.toJSON(pboc_INDEX);
			json.put("filename", name);
			log.info("人行指标解析结果为：{}", JSONObject.toJSON(pboc_INDEX));
			fw.write(json.toJSONString() + "\n");
		}
		fw.flush();

	}
}
