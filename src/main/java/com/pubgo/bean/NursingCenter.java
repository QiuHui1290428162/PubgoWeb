package com.pubgo.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//护理中心登记表
@TableName("NursingCenter")
public class NursingCenter {

	@TableId("NursingID")
	private String nursingID;        //id
	@TableField("Customer_ID")
	private String customerID;       //店铺号
	@TableField("Operator")
	private String operator;         //创操作人
	@TableField("Quantity")
	private int quantity;            //数量
	@TableField("Score")
	private int score;               //评分
	@TableField("Appraise")
	private String appraise;         //评价
	@TableField("Step")
    private int step;                //护理步骤
	@TableField("Remark")
	private String remark;           //用户备注
	@TableField("EmployeeRemake")
	private String employeeRemake;   //员工备注
	@TableField("CreateTime")
	private Date createTime;         //创建时间
	@TableField("UpdateTime")
    private Date updateTime;         //修改时间
	@TableField("Sign")
    private String sign;             //停用标志  0-停用   1-启用
	@TableField("ImagePath")
    private String imagePath;        //图片路径
	public String getNursingID() {
		return nursingID;
	}
	public void setNursingID(String nursingID) {
		this.nursingID = nursingID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	public String getEmployeeRemake() {
		return employeeRemake;
	}
	public void setEmployeeRemake(String employeeRemake) {
		this.employeeRemake = employeeRemake;
	}
	@Override
	public String toString() {
		return "NursingCenter [nursingID=" + nursingID + ", customerID=" + customerID + ", operator=" + operator
				+ ", quantity=" + quantity + ", score=" + score + ", appraise=" + appraise + ", step=" + step
				+ ", remark=" + remark + ", employeeRemake=" + employeeRemake + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", sign=" + sign + ", imagePath=" + imagePath + "]";
	}


	
	
	
}
