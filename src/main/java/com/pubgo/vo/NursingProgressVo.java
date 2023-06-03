package com.pubgo.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.pubgo.utils.Constant;

//护理进度视图
public class NursingProgressVo {    
	private String nursingProgressID;  //护理进度id
    private String nursingID;          //id
    private int step;                  //护理步骤
    private String stepName;              //护理步骤名称
    private Timestamp inputDate;       //录入时间
	private String inputDateToString;  //录入时间字符串
    private String operator;           //操作人
    private String imagePath;          //图片路径
	private List<String> imagePaths;   //图片路径
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
		switch (step) {
		case 1:
			this.stepName = "登记";
			break;
		case 2:
			this.stepName = "确认";
			break;
		case 3:
			this.stepName = "发货";
			break;
		case 4:
			this.stepName = "收货";
			break;
		default:
			this.stepName = "已删除";
			break;
		}
	}
	public Timestamp getInputDate() {
		return inputDate;
	}
	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
		//转换时间格式
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.inputDateToString = formatter.format(inputDate.getTime());
	}
	public String getInputDateToString() {
		return inputDateToString;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	//原图片路径不保存
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
		//分隔图片路径
		List<String> imagePaths = new ArrayList<String>();
		if ( imagePath!=null ) {
			String[] parts = imagePath.split(",");
			for (String part : parts) {
				//转换图片路径
				part = part.replace("\\", "/");
				part = part.replace(Constant.NURSINGSTATICPATH, "/PubgoWeb/images/");
		    	imagePaths.add(part);
		    }
			setImagePaths(imagePaths);
		}
	}
	public List<String> getImagePaths() {
		return imagePaths;
	}
	public void setImagePaths(List<String> imagePaths) {
		this.imagePaths = imagePaths;
	}
	public void setInputDateToString(String inputDateToString) {
		this.inputDateToString = inputDateToString;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	@Override
	public String toString() {
		return "NursingProgress [nursingProgressID=" + nursingProgressID + ", nursingID=" + nursingID + ", step=" + step
				+ ", inputDate=" + inputDate + ", operator=" + operator + ", imagePath=" + imagePath + ", imagePaths="
				+ imagePaths + "]";
	}
	
}
