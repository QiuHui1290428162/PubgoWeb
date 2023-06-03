package com.pubgo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//会员卡明细
@TableName("VipCard")
public class VipCard {

	@TableField("VipCardSN")
	private int vipCardSN;        //序号
	@TableField("VipGrade")
	private int vipGrade;         //会员卡等级
	@TableField("VipCardName")
	private String vipCardName;   //会员卡名称
	@TableField("VipCardAlias")
	private String vipCardAlias;  //有赞会员卡id
	@TableField("CorrelationId")
	private int correlationId;    //关联等级id
	public int getVipCardSN() {
		return vipCardSN;
	}
	public void setVipCardSN(int vipCardSN) {
		this.vipCardSN = vipCardSN;
	}
	public int getVipGrade() {
		return vipGrade;
	}
	public void setVipGrade(int vipGrade) {
		this.vipGrade = vipGrade;
	}
	public String getVipCardName() {
		return vipCardName;
	}
	public void setVipCardName(String vipCardName) {
		this.vipCardName = vipCardName;
	}
	public String getVipCardAlias() {
		return vipCardAlias;
	}
	public void setVipCardAlias(String vipCardAlias) {
		this.vipCardAlias = vipCardAlias;
	}
	
	public int getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(int correlationId) {
		this.correlationId = correlationId;
	}
	@Override
	public String toString() {
		return "VipCard [vipCardSN=" + vipCardSN + ", vipGrade=" + vipGrade + ", vipCardName=" + vipCardName
				+ ", vipCardAlias=" + vipCardAlias + ", correlationId=" + correlationId + "]";
	}
	

	
	
	
}
