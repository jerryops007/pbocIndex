package com.jerry.pbocLabel.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jerry.pbocLabel.dto.PbocBaseInfoPO;
import com.jerry.pbocLabel.dto.PbocRspPO;
import com.jerry.pbocLabel.dto.PbocVo;
import com.jerry.pbocLabel.enums.label.PbocLabelEnum;
import com.jerry.pbocLabel.enums.pboc.IdentityEnum;
import com.jerry.pbocLabel.enums.pboc.PbocParamEnum;
import com.jerry.pbocLabel.util.MapUtils;

public class IdentityLabelImpl {

	private static Logger log = LoggerFactory.getLogger(IdentityLabelImpl.class);

	@SuppressWarnings("unchecked")
	public static void run(PbocRspPO pbocRspPO, PbocVo pbocVo, Map<String, Object> PbocParam, PbocBaseInfoPO pbocBaseInfoPO) {
		log.info("人行报文解析：身份信息");
		Integer IF_PHONENO_CORRECT = -1;
		if (!pbocVo.getIdentity().isEmpty()) {
			Map<String, Object> identity = pbocVo.getIdentity();
			List<Map<String, Object>> PHONENUMBERLIST = MapUtils.getListFromMap(identity, IdentityEnum.PHONENUMBERLIST.field);
			String input_mobile = MapUtils.getStringFromMap(PbocParam, PbocParamEnum.mo_phone.field);
			if (!PHONENUMBERLIST.isEmpty() && !input_mobile.isEmpty()) {
				for (Map<String, Object> map : PHONENUMBERLIST) {
					log.debug("身份信息  展示:{}", map);
					String phoneNumber = MapUtils.getStringFromMap(map, IdentityEnum.PHONENUMBERLIST_PHONENUMBER.field);
					if (!phoneNumber.isEmpty() && !input_mobile.isEmpty() && phoneNumber.equals(input_mobile)) {
						IF_PHONENO_CORRECT = 1;
					}
				}
				if (IF_PHONENO_CORRECT != 1) {
					IF_PHONENO_CORRECT = 0;
				}
			} else {
				IF_PHONENO_CORRECT = -1;
			}
		}
		pbocRspPO.addIndex(PbocLabelEnum.IF_PHONENO_CORRECT.field, IF_PHONENO_CORRECT, PbocLabelEnum.IF_PHONENO_CORRECT.fieldDesc);
	}
}
