package com.pubgo.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

//护理管理页面展示
public class NursingVO {

	private String nursingID;          //单号
	private String tel;                //手机号
	private String userName;           //姓名
	private String customerNa;         //店铺名称
	private String operator;           //营业员
	private int quantity;              //数量
	private int step;                  //护理步骤
	private String stepName;           //护理步骤
	private int score;                 //评分
	private String payment;            //录入方式
	private String userRemake;         //客户备注
	private String employeeRemake;     //员工备注
	private String imagePath;          //图片路径
	private Timestamp createTime;      //创建时间,因java.sql.date为日期格式，若要显示时分秒，则需转换为Timestamp类型
	private String createTimeToString; //创建时间
	public String getNursingID() {
		return nursingID;
	}
	public void setNursingID(String nursingID) {
		this.nursingID = nursingID;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
		if ( step == 1 ) {
			this.stepName = "待护理";
		}else if ( step == 2 ) {
			this.stepName = "待领取";
		}else {
			this.stepName = "已完成";
		}
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getUserRemake() {
		return userRemake;
	}
	public void setUserRemake(String userRemake) {
		this.userRemake = userRemake;
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
		if ( imagePath.equals("") || imagePath==null)
		{
			imagePath = "/PubgoWeb/static/image/logo.jpg";
		}else {
			//转换图片路径
			imagePath = imagePath.replace("\\", "/");
			imagePath = imagePath.replace("//192.168.0.5/Image/", "/PubgoWeb/images/");
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
	public String getStepName() {
		return stepName;
	}
	public String getCreateTimeToString() {
		return createTimeToString;
	}
	@Override
	public String toString() {
		return "NursingVO [nursingID=" + nursingID + ", tel=" + tel + ", name=" + userName + ", customerNa=" + customerNa
				+ ", operator=" + operator + ", quantity=" + quantity + ", step=" + step + ", stepName=" + stepName
				+ ", score=" + score + ", payment=" + payment + ", userRemake=" + userRemake + ", employeeRemake="
				+ employeeRemake + ", imagePath=" + imagePath + ", createTime=" + createTime + ", createTimeToString="
				+ createTimeToString + "]";
	}
}
