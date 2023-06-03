package com.pubgo.request;

import java.sql.Date;


//新增会员信息请求
public class AddCustomerVipReq {

	private String vip;              //vip卡号
	private String name;             //姓名
	private String sex;              //性别
	private Date birthDate;          //生日
	private String shoeSize;         //尺码
	private String jbUser;           //经办人
	private Date begainDate;         //发卡日期
	private Date expireDate;         //失效日期
	private String remark;           //备注
	private String encryptVIP;       //VIP卡密
	private String tel;              //会员等级标识
	private String useStatus;        //会员状态
	private String customerID;       //店铺号
	private String rgUser;           //员工号
	private String yzOpenID;         //有赞id，覆盖Email
	private String leiBie;           //会员年龄
	private String vipGrade;         //会员等级
	private String work;             //职业
	private String earning;          //收入水平
	private String height;           //身高 
	private String weight;           //体重
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
	public String getLeiBie() {
		return leiBie;
	}
	public void setLeiBie(String leiBie) {
		this.leiBie = leiBie;
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
		return "AddCustomerVipReq [vip=" + vip + ", name=" + name + ", sex=" + sex + ", birthDate=" + birthDate
				+ ", shoeSize=" + shoeSize + ", jbUser=" + jbUser + ", begainDate=" + begainDate + ", expireDate="
				+ expireDate + ", remark=" + remark + ", encryptVIP=" + encryptVIP + ", tel=" + tel + ", useStatus="
				+ useStatus + ", customerID=" + customerID + ", rgUser=" + rgUser + ", yzOpenID=" + yzOpenID
				+ ", leiBie=" + leiBie + ", vipGrade=" + vipGrade + ", work=" + work + ", earning=" + earning
				+ ", height=" + height + ", weight=" + weight + ", address=" + address + "]";
	}
	
	
}
