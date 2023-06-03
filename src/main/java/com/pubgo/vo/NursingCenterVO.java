package com.pubgo.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.annotation.TableField;
import com.pubgo.property.InformationProperty;
import com.pubgo.utils.Constant;

//护理管理页面展示
public class NursingCenterVO {

	private String nursingID;          //单号
	private String customerNa;         //店铺名称
	private String operator;           //操作人
	private int quantity;              //数量
	private int step;                  //护理步骤
	private String stepName;           //护理步骤名称
	private int score;                 //评分
	private String appraise;           //评价
	private String remark;             //员工备注
	private String employeeRemake;     //员工备注
	private String imagePath = "/PubgoWeb/static/image/logo.jpg";          //图片路径
	private Timestamp createTime;      //创建时间,因java.sql.date为日期格式，若要显示时分秒，则需转换为Timestamp类型
	private String createTimeToString; //创建时间

	
	
	public String getNursingID() {
		return nursingID;
	}
	public void setNursingID(String nursingID) {
		this.nursingID = nursingID;
	}
	public String getCustomerNa() {
		return customerNa;
	}
	public void setCustomerNa(String customerNa) {
		this.customerNa = customerNa;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
		switch (step) {
		case 1:
			this.stepName = "待确认";
			break;
		case 2:
			this.stepName = "待发货";
			break;
		case 3:
			this.stepName = "待收货";
			break;
		case 4:
			this.stepName = "已完成";
			break;
		default:
			this.stepName = "已删除";
			break;
		}
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStepName() {
		return stepName;
	}
	public String getEmployeeRemake() {
		return employeeRemake;
	}
	public void setEmployeeRemake(String employeeRemake) {
		this.employeeRemake = employeeRemake;
	}
	
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		if ( imagePath.equals("") )
		{
			imagePath = "/PubgoWeb/static/image/logo.jpg";
		}else {
			//转换图片路径
			imagePath = imagePath.replace("\\", "/");
			imagePath = imagePath.replace(Constant.NURSINGSTATICPATH, "/PubgoWeb/images/");
		}
		this.imagePath = imagePath;
	}
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
		//转换时间格式
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.createTimeToString = formatter.format(createTime.getTime());
	}
	
	public String getCreateTimeToString() {
		return createTimeToString;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getAppraise() {
		return appraise;
	}
	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}
	@Override
	public String toString() {
		return "NursingCenterVO [nursingID=" + nursingID + ", customerNa=" + customerNa + ", operator=" + operator
				+ ", quantity=" + quantity + ", step=" + step + ", stepName=" + stepName + ", score=" + score
				+ ", appraise=" + appraise + ", remark=" + remark + ", employeeRemake=" + employeeRemake
				+ ", imagePath=" + imagePath + ", createTime=" + createTime + ", createTimeToString="
				+ createTimeToString + "]";
	}

	
	
	
}
