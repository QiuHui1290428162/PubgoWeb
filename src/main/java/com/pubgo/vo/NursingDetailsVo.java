package com.pubgo.vo;

import java.util.List;


public class NursingDetailsVo {

	private String nursingID;      //单号
	private String remark;         //店铺备注
	private String quantity;       //数量
	private int currentStep;       //当前进度
	private String appraise;           //评价
	private List<NursingProgressVo> nursingProgress;   //护理进度
	
	public String getNursingID() {
		return nursingID;
	}
	public void setNursingID(String nursingID) {
		this.nursingID = nursingID;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public List<NursingProgressVo> getNursingProgress() {
		return nursingProgress;
	}
	public void setNursingProgress(List<NursingProgressVo> nursingProgress) {
		this.nursingProgress = nursingProgress;
	}
	public int getCurrentStep() {
		return currentStep;
	}
	public void setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
	}
	
	public String getAppraise() {
		return appraise;
	}
	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}
	@Override
	public String toString() {
		return "NursingDetailsVo [nursingID=" + nursingID + ", remark=" + remark + ", quantity=" + quantity
				+ ", currentStep=" + currentStep + ", nursingProgress=" + nursingProgress + "]";
	}


	


	
	
}
