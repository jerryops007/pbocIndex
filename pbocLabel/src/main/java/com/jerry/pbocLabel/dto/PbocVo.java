package com.jerry.pbocLabel.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jerry.pbocLabel.enums.pboc.PbocCons;
import com.jerry.pbocLabel.util.MapUtils;

/**
 * 人行报告返回字段
 * 
 * @author xxfan
 */
public class PbocVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> messageHeader;
	private Map<String, Object> identity;
	private List<Map<String, Object>> spouse;
	private List<Map<String, Object>> residence;
	private List<Map<String, Object>> professional;
	private Map<String, Object> creditSummaryCue;
	private List<Map<String, Object>> fellbackSum;
	private List<Map<String, Object>> overdueSum;
	private List<Map<String, Object>> shareAndDebtSum;
	private List<Map<String, Object>> contratInfo;
	private Map<String, Object> contratInfo_currAccountInfo;
	private Map<String, Object> contratInfo_currOverdue;
	private List<Map<String, Object>> awardCreditInfo;// 授信情况
	private Map<String, Object> awardCreditInfo_repayInfo;// 使用/还款情况
	private Map<String, Object> contratInfo_state;
	private Map<String, Object> awardCreditInfo_state;
	private List<Map<String, Object>> accFund;
	private List<Map<String, Object>> endowmentInsuramceDeposit;
	private List<Map<String, Object>> recordDetail;
	private Map<String, Object> numAnalysis;
	private Map<String, Object> queryReq;
	private Map<String, Object> calculateSegment;
	private List<Map<String, Object>> awardCreditInfo_overdueRecordlist;
	private List<Map<String, Object>> contratInfo_cOverdueRecordlist;
	private List<Map<String, Object>> awardCreditInfo_specialTradelist;
	private List<Map<String, Object>> contratInfo_specialTradelist;
	private Map<String, Object> guaranteeSum;
	private List<Map<String, Object>> detailQueryReason;
	private List<Map<String, Object>> adminPunishment;
	private List<Map<String, Object>> assetDisposition;
	private List<Map<String, Object>> assurerRepay;
	private List<Map<String, Object>> civilJudgement;// (29) 民事判决记录
	private List<Map<String, Object>> forceExecution;// (30) 强制执行记录
	private List<Map<String, Object>> taxArrear;// (31) 欠税记录
	private List<Map<String, Object>> endowmentInsuranceDeliver;// (32)//
																// 养老保险金发放记录
	private List<Map<String, Object>> salvation;// (33) 低保救助记录
	private List<Map<String, Object>> competence;// (34) 执业资格记录
	private List<Map<String, Object>> adminAward;// (35) 行政奖励记录
	private List<Map<String, Object>> vehicle;// (36) 车辆交易和抵押记录
	private List<Map<String, Object>> assureLoanInfo;// (37) 对外贷款担保信息
	private List<Map<String, Object>> creditCardAssureInfo;// (38) 对外信用卡担保信息
	private List<Map<String, Object>> awardCreditInfo_dissentInfolist;// (39)
																		// 异议标注
																		// //
																		// 异议标注
	private List<Map<String, Object>> contratInfo_dissentInfolist;// (39) 异议标注
	private List<Map<String, Object>> telPayment;// (40) 电信缴费记录
	private List<Map<String, Object>> repaymentDuty;// (25)
													// 相关还款责任信息(repaymentDuty)

	public List<Map<String, Object>> getRepaymentDuty() {
		return repaymentDuty;
	}

	public void setRepaymentDuty(List<Map<String, Object>> repaymentDuty) {
		this.repaymentDuty = repaymentDuty;
	}

	public Map<String, Object> getMessageHeader() {
		return messageHeader;
	}

	public void setMessageHeader(Map<String, Object> messageHeader) {
		this.messageHeader = messageHeader;
	}

	public Map<String, Object> getIdentity() {
		return identity;
	}

	public void setIdentity(Map<String, Object> identity) {
		this.identity = identity;
	}

	public List<Map<String, Object>> getSpouse() {
		return spouse;
	}

	public void setSpouse(List<Map<String, Object>> spouse) {
		this.spouse = spouse;
	}

	public List<Map<String, Object>> getResidence() {
		return residence;
	}

	public void setResidence(List<Map<String, Object>> residence) {
		this.residence = residence;
	}

	public List<Map<String, Object>> getProfessional() {
		return professional;
	}

	public void setProfessional(List<Map<String, Object>> professional) {
		this.professional = professional;
	}

	public Map<String, Object> getCreditSummaryCue() {
		return creditSummaryCue;
	}

	public void setCreditSummaryCue(Map<String, Object> creditSummaryCue) {
		this.creditSummaryCue = creditSummaryCue;
	}

	public List<Map<String, Object>> getFellbackSum() {
		return fellbackSum;
	}

	public void setFellbackSum(List<Map<String, Object>> fellbackSum) {
		this.fellbackSum = fellbackSum;
	}

	public List<Map<String, Object>> getOverdueSum() {
		return overdueSum;
	}

	public void setOverdueSum(List<Map<String, Object>> overdueSum) {
		this.overdueSum = overdueSum;
	}

	public List<Map<String, Object>> getShareAndDebtSum() {
		return shareAndDebtSum;
	}

	public void setShareAndDebtSum(List<Map<String, Object>> shareAndDebtSum) {
		this.shareAndDebtSum = shareAndDebtSum;
	}

	public List<Map<String, Object>> getContratInfo() {
		return contratInfo;
	}

	public void setContratInfo(List<Map<String, Object>> contratInfo) {
		this.contratInfo = contratInfo;
	}

	public Map<String, Object> getContratInfo_currAccountInfo() {
		return contratInfo_currAccountInfo;
	}

	public void setContratInfo_currAccountInfo(Map<String, Object> contratInfo_currAccountInfo) {
		this.contratInfo_currAccountInfo = contratInfo_currAccountInfo;
	}

	public Map<String, Object> getContratInfo_currOverdue() {
		return contratInfo_currOverdue;
	}

	public void setContratInfo_currOverdue(Map<String, Object> contratInfo_currOverdue) {
		this.contratInfo_currOverdue = contratInfo_currOverdue;
	}

	public List<Map<String, Object>> getAwardCreditInfo() {
		return awardCreditInfo;
	}

	public void setAwardCreditInfo(List<Map<String, Object>> awardCreditInfo) {
		this.awardCreditInfo = awardCreditInfo;
	}

	public Map<String, Object> getAwardCreditInfo_repayInfo() {
		return awardCreditInfo_repayInfo;
	}

	public void setAwardCreditInfo_repayInfo(Map<String, Object> awardCreditInfo_repayInfo) {
		this.awardCreditInfo_repayInfo = awardCreditInfo_repayInfo;
	}

	public Map<String, Object> getContratInfo_state() {
		return contratInfo_state;
	}

	public void setContratInfo_state(Map<String, Object> contratInfo_state) {
		this.contratInfo_state = contratInfo_state;
	}

	public Map<String, Object> getAwardCreditInfo_state() {
		return awardCreditInfo_state;
	}

	public void setAwardCreditInfo_state(Map<String, Object> awardCreditInfo_state) {
		this.awardCreditInfo_state = awardCreditInfo_state;
	}

	public List<Map<String, Object>> getAccFund() {
		return accFund;
	}

	public void setAccFund(List<Map<String, Object>> accFund) {
		this.accFund = accFund;
	}

	public List<Map<String, Object>> getEndowmentInsuramceDeposit() {
		return endowmentInsuramceDeposit;
	}

	public void setEndowmentInsuramceDeposit(List<Map<String, Object>> endowmentInsuramceDeposit) {
		this.endowmentInsuramceDeposit = endowmentInsuramceDeposit;
	}

	public List<Map<String, Object>> getRecordDetail() {
		return recordDetail;
	}

	public void setRecordDetail(List<Map<String, Object>> recordDetail) {
		this.recordDetail = recordDetail;
	}

	public Map<String, Object> getNumAnalysis() {
		return numAnalysis;
	}

	public void setNumAnalysis(Map<String, Object> numAnalysis) {
		this.numAnalysis = numAnalysis;
	}

	public Map<String, Object> getQueryReq() {
		return queryReq;
	}

	public void setQueryReq(Map<String, Object> queryReq) {
		this.queryReq = queryReq;
	}

	public Map<String, Object> getCalculateSegment() {
		return calculateSegment;
	}

	public void setCalculateSegment(Map<String, Object> calculateSegment) {
		this.calculateSegment = calculateSegment;
	}

	public List<Map<String, Object>> getAwardCreditInfo_overdueRecordlist() {
		return awardCreditInfo_overdueRecordlist;
	}

	public void setAwardCreditInfo_overdueRecordlist(List<Map<String, Object>> awardCreditInfo_overdueRecordlist) {
		this.awardCreditInfo_overdueRecordlist = awardCreditInfo_overdueRecordlist;
	}

	public List<Map<String, Object>> getContratInfo_cOverdueRecordlist() {
		return contratInfo_cOverdueRecordlist;
	}

	public void setContratInfo_cOverdueRecordlist(List<Map<String, Object>> contratInfo_cOverdueRecordlist) {
		this.contratInfo_cOverdueRecordlist = contratInfo_cOverdueRecordlist;
	}

	public List<Map<String, Object>> getAwardCreditInfo_specialTradelist() {
		return awardCreditInfo_specialTradelist;
	}

	public void setAwardCreditInfo_specialTradelist(List<Map<String, Object>> awardCreditInfo_specialTradelist) {
		this.awardCreditInfo_specialTradelist = awardCreditInfo_specialTradelist;
	}

	public List<Map<String, Object>> getContratInfo_specialTradelist() {
		return contratInfo_specialTradelist;
	}

	public void setContratInfo_specialTradelist(List<Map<String, Object>> contratInfo_specialTradelist) {
		this.contratInfo_specialTradelist = contratInfo_specialTradelist;
	}

	public Map<String, Object> getGuaranteeSum() {
		return guaranteeSum;
	}

	public void setGuaranteeSum(Map<String, Object> guaranteeSum) {
		this.guaranteeSum = guaranteeSum;
	}

	public List<Map<String, Object>> getDetailQueryReason() {
		return detailQueryReason;
	}

	public void setDetailQueryReason(List<Map<String, Object>> detailQueryReason) {
		this.detailQueryReason = detailQueryReason;
	}

	public List<Map<String, Object>> getAdminPunishment() {
		return adminPunishment;
	}

	public void setAdminPunishment(List<Map<String, Object>> adminPunishment) {
		this.adminPunishment = adminPunishment;
	}

	public List<Map<String, Object>> getAssetDisposition() {
		return assetDisposition;
	}

	public void setAssetDisposition(List<Map<String, Object>> assetDisposition) {
		this.assetDisposition = assetDisposition;
	}

	public List<Map<String, Object>> getAssurerRepay() {
		return assurerRepay;
	}

	public void setAssurerRepay(List<Map<String, Object>> assurerRepay) {
		this.assurerRepay = assurerRepay;
	}

	public List<Map<String, Object>> getCivilJudgement() {
		return civilJudgement;
	}

	public void setCivilJudgement(List<Map<String, Object>> civilJudgement) {
		this.civilJudgement = civilJudgement;
	}

	public List<Map<String, Object>> getForceExecution() {
		return forceExecution;
	}

	public void setForceExecution(List<Map<String, Object>> forceExecution) {
		this.forceExecution = forceExecution;
	}

	public List<Map<String, Object>> getTaxArrear() {
		return taxArrear;
	}

	public void setTaxArrear(List<Map<String, Object>> taxArrear) {
		this.taxArrear = taxArrear;
	}

	public List<Map<String, Object>> getEndowmentInsuranceDeliver() {
		return endowmentInsuranceDeliver;
	}

	public void setEndowmentInsuranceDeliver(List<Map<String, Object>> endowmentInsuranceDeliver) {
		this.endowmentInsuranceDeliver = endowmentInsuranceDeliver;
	}

	public List<Map<String, Object>> getSalvation() {
		return salvation;
	}

	public void setSalvation(List<Map<String, Object>> salvation) {
		this.salvation = salvation;
	}

	public List<Map<String, Object>> getCompetence() {
		return competence;
	}

	public void setCompetence(List<Map<String, Object>> competence) {
		this.competence = competence;
	}

	public List<Map<String, Object>> getAdminAward() {
		return adminAward;
	}

	public void setAdminAward(List<Map<String, Object>> adminAward) {
		this.adminAward = adminAward;
	}

	public List<Map<String, Object>> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Map<String, Object>> vehicle) {
		this.vehicle = vehicle;
	}

	public List<Map<String, Object>> getAssureLoanInfo() {
		return assureLoanInfo;
	}

	public void setAssureLoanInfo(List<Map<String, Object>> assureLoanInfo) {
		this.assureLoanInfo = assureLoanInfo;
	}

	public List<Map<String, Object>> getCreditCardAssureInfo() {
		return creditCardAssureInfo;
	}

	public void setCreditCardAssureInfo(List<Map<String, Object>> creditCardAssureInfo) {
		this.creditCardAssureInfo = creditCardAssureInfo;
	}

	public List<Map<String, Object>> getAwardCreditInfo_dissentInfolist() {
		return awardCreditInfo_dissentInfolist;
	}

	public void setAwardCreditInfo_dissentInfolist(List<Map<String, Object>> awardCreditInfo_dissentInfolist) {
		this.awardCreditInfo_dissentInfolist = awardCreditInfo_dissentInfolist;
	}

	public List<Map<String, Object>> getContratInfo_dissentInfolist() {
		return contratInfo_dissentInfolist;
	}

	public void setContratInfo_dissentInfolist(List<Map<String, Object>> contratInfo_dissentInfolist) {
		this.contratInfo_dissentInfolist = contratInfo_dissentInfolist;
	}

	public List<Map<String, Object>> getTelPayment() {
		return telPayment;
	}

	public void setTelPayment(List<Map<String, Object>> telPayment) {
		this.telPayment = telPayment;
	}

	@SuppressWarnings("unchecked")
	public PbocVo(Map<String, Object> pboc) {
		super();
		this.messageHeader = MapUtils.getMapFromMap(pboc, PbocCons.messageHeader);
		this.identity = MapUtils.getMapFromMap(pboc, PbocCons.identity);
		this.spouse = MapUtils.getListFromMap(pboc, PbocCons.spouse);
		this.residence = MapUtils.getListFromMap(pboc, PbocCons.residence);
		this.professional = MapUtils.getListFromMap(pboc, PbocCons.professional);
		this.creditSummaryCue = MapUtils.getMapFromMap(pboc, PbocCons.creditSummaryCue);
		this.fellbackSum = MapUtils.getListFromMap(pboc, PbocCons.fellbackSum);
		this.overdueSum = MapUtils.getListFromMap(pboc, PbocCons.overdueSum);
		this.shareAndDebtSum = MapUtils.getListFromMap(pboc, PbocCons.shareAndDebtSum);
		this.contratInfo = MapUtils.getListFromMap(pboc, PbocCons.contratInfo);

		// this.contratInfo_currAccountInfo = MapUtils.getListFromMap(pboc,
		// PbocCons.spouse);
		// this.contratInfo_currOverdue = MapUtils.getListFromMap(pboc,
		// PbocCons.spouse)
		//
		this.awardCreditInfo = MapUtils.getListFromMap(pboc, PbocCons.awardCreditInfo);

		// this.awardCreditInfo_repayInfo =MapUtils.getListFromMap(pboc,
		// PbocCons.spouse);
		// this.contratInfo_state =MapUtils.getListFromMap(pboc,
		// PbocCons.spouse);
		// this.awardCreditInfo_state =MapUtils.getListFromMap(pboc,
		// PbocCons.spouse);
		this.accFund = MapUtils.getListFromMap(pboc, PbocCons.accFund);
		this.endowmentInsuramceDeposit = MapUtils.getListFromMap(pboc, PbocCons.endowmentInsuramceDeposit);
		this.recordDetail = MapUtils.getListFromMap(pboc, PbocCons.recordDetail);
		this.numAnalysis = MapUtils.getMapFromMap(pboc, PbocCons.numAnalysis);
		this.queryReq = MapUtils.getMapFromMap(pboc, PbocCons.queryReq);
		this.calculateSegment = MapUtils.getMapFromMap(pboc, PbocCons.calculateSegment);

		// this.awardCreditInfo_overdueRecordlist =MapUtils.getListFromMap(pboc,
		// PbocCons.spouse);
		// this.contratInfo_cOverdueRecordlist = MapUtils.getListFromMap(pboc,
		// PbocCons.spouse);
		// this.awardCreditInfo_specialTradelist =MapUtils.getListFromMap(pboc,
		// PbocCons.spouse);
		// this.contratInfo_specialTradelist =MapUtils.getListFromMap(pboc,
		// PbocCons.spouse);
		//
		this.guaranteeSum = MapUtils.getMapFromMap(pboc, PbocCons.guaranteeSum);
		this.detailQueryReason = MapUtils.getListFromMap(pboc, PbocCons.detailQueryReason);
		this.adminPunishment = MapUtils.getListFromMap(pboc, PbocCons.adminPunishment);
		this.assetDisposition = MapUtils.getListFromMap(pboc, PbocCons.assetDisposition);
		this.assurerRepay = MapUtils.getListFromMap(pboc, PbocCons.assurerRepay);
		this.civilJudgement = MapUtils.getListFromMap(pboc, PbocCons.civilJudgement);
		this.forceExecution = MapUtils.getListFromMap(pboc, PbocCons.forceExecution);
		this.taxArrear = MapUtils.getListFromMap(pboc, PbocCons.taxArrear);
		this.endowmentInsuranceDeliver = MapUtils.getListFromMap(pboc, PbocCons.endowmentInsuranceDeliver);
		this.salvation = MapUtils.getListFromMap(pboc, PbocCons.salvation);
		this.competence = MapUtils.getListFromMap(pboc, PbocCons.competence);
		this.adminAward = MapUtils.getListFromMap(pboc, PbocCons.adminAward);
		this.vehicle = MapUtils.getListFromMap(pboc, PbocCons.vehicle);
		this.assureLoanInfo = MapUtils.getListFromMap(pboc, PbocCons.assureLoanInfo);
		this.creditCardAssureInfo = MapUtils.getListFromMap(pboc, PbocCons.creditCardAssureInfo);
		this.awardCreditInfo_dissentInfolist = MapUtils.getListFromMap(pboc, PbocCons.awardCreditInfo_dissentInfolist);
		this.contratInfo_dissentInfolist = MapUtils.getListFromMap(pboc, PbocCons.contratInfo_dissentInfolist);
		this.telPayment = MapUtils.getListFromMap(pboc, PbocCons.telPayment);
		this.repaymentDuty = MapUtils.getListFromMap(pboc, PbocCons.repaymentDuty);
	}
}
