package com.pubgo.bean;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


//会员信息类
//注解输入数据表名称
@TableName("CustomerVip")
public class Vip {

	@TableId("Vip")
	private String vip;              //vip卡号
	@TableField("Name")
	private String name;             //姓名
	@TableField("Sex")
	private String sex;              //性别
	@TableField("BirthDate")
	private Date birthDate;          //生日
	@TableField("HisIntegral")
	private double hisIntegral;      //积分
	@TableField("ShoeSize")
	private String shoeSize;         //尺码
	@TableField("JBUser")
	private String jbUser;           //经办人
	@TableField("BegainDate")
	private Date begainDate;         //发卡日期
	@TableField("ExpireDate")
	private Date expireDate;         //失效日期
	@TableField("Remark")
	private String remark;           //备注
	@TableField("EncryptVIP")
	private String encryptVIP;       //VIP卡密
	@TableField("Tel")
	private String tel;              //会员等级标识
	@TableField("UseStatus")
	private String useStatus;        //会员状态
	@TableField("Customer_ID")
	private String customerID;       //店铺号
	@TableField("RGUser")
	private String rgUser;           //员工号
	@TableField("Email")
	private String yzOpenID;         //有赞id
	@TableField("VipGrade")
	private String vipGrade;        //会员等级
	@TableField("Work")
	private String work;             //职业
	@TableField("Earning")
	private String earning;          //收入水平
	@TableField("Height")
	private String height;           //身高 
	@TableField("Weight")
	private String weight;           //体重
	@TableField("Address")
	private String address;          //地址
	
	
	
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public double getHisIntegral() {
		return hisIntegral;
	}
	public void setHisIntegral(double hisIntegral) {
		this.hisIntegral = hisIntegral;
	}
	public String getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(String shoeSize) {
		this.shoeSize = shoeSize;
	}
	public String getJbUser() {
		return jbUser;
	}
	public void setJbUser(String jbUser) {
		this.jbUser = jbUser;
	}
	public Date getBegainDate() {
		return begainDate;
	}
	public void setBegainDate(Date begainDate) {
		this.begainDate = begainDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEncryptVIP() {
		return encryptVIP;
	}
	public void setEncryptVIP(String encryptVIP) {
		this.encryptVIP = encryptVIP;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getRgUser() {
		return rgUser;
	}
	public void setRgUser(String rgUser) {
		this.rgUser = rgUser;
	}
	public String getYzOpenID() {
		return yzOpenID;
	}
	public void setYzOpenID(String yzOpenID) {
		this.yzOpenID = yzOpenID;
	}
	public String getVipGrade() {
		return vipGrade;
	}
	public void setVipGrade(String vipGrade) {
		this.vipGrade = vipGrade;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getEarning() {
		return earning;
	}
	public void setEarning(String earning) {
		this.earning = earning;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Vip [vip=" + vip + ", name=" + name + ", sex=" + sex + ", birthDate=" + birthDate + ", hisIntegral="
				+ hisIntegral + ", shoeSize=" + shoeSize + ", jbUser=" + jbUser + ", begainDate=" + begainDate
				+ ", expireDate=" + expireDate + ", remark=" + remark + ", encryptVIP=" + encryptVIP + ", tel=" + tel + ", useStatus=" + useStatus + ", customerID=" + customerID + ", rgUser="
				+ rgUser + ", yzOpenID=" + yzOpenID + ", vipGrade=" + vipGrade + ", work=" + work + ", earning="
				+ earning + ", height=" + height + ", weight=" + weight + ", address=" + address + "]";
	}

	
}
