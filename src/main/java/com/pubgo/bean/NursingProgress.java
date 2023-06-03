package com.pubgo.bean;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//护理进度
@TableName("NursingProgress")
public class NursingProgress {
    @TableId("NursingProgressID")     
	private String nursingProgressID;  //护理进度id
	@TableField("NursingID")
    private String nursingID;          //id
	@TableField("Step")
    private int step;                  //护理步骤
	@TableField("InputDate")
    private Date inputDate;            //录入时间
	@TableField("Operator")
    private String operator;           //操作人
	@TableField("ImagePath")
    private String imagePath;          //图片路径
	public String getNursingProgressID() {
		return nursingProgressID;
	}
	public void setNursingProgressID(String nursingProgressID) {
		this.nursingProgressID = nursingProgressID;
	}
	public String getNursingID() {
		return nursingID;
	}
	public void setNursingID(String nursingID) {
		this.nursingID = nursingID;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
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

	
}
