package com.pubgo.api.bean;

import java.util.Date;

//会员详细信息
public class CustomerDetail {
	
	private Date birthday;           //生日
	private String mobile;           //手机号
	private String latestNickname;   //昵称
	private String latestAvatar;     //头像url
	private String yzOpenId;         //有咱openid
	private short gender;            //性别， 1:男，2:女
	private String attrInfos01;      //自定义信息：员工号
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLatestNickname() {
		return latestNickname;
	}
	public void setLatestNickname(String latestNickname) {
		this.latestNickname = latestNickname;
	}
	public String getLatestAvatar() {
		return latestAvatar;
	}
	public void setLatestAvatar(String latestAvatar) {
		this.latestAvatar = latestAvatar;
	}
	public String getYzOpenId() {
		return yzOpenId;
	}
	public void setYzOpenId(String yzOpenId) {
		this.yzOpenId = yzOpenId;
	}
	public short getGender() {
		return gender;
	}
	public void setGender(short gender) {
		this.gender = gender;
	}
	public String getAttrInfos01() {
		return attrInfos01;
	}
	public void setAttrInfos01(String attrInfos01) {
		this.attrInfos01 = attrInfos01;
	}
	
	
	
}
