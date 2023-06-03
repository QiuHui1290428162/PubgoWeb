package com.pubgo.api.bean;

//店铺用户信息
public class CustomerUser {

	private String mobile;      //手机号
	private String avatar;      //头像
	private String yzOpenId;    //有赞用户id，用户在有赞的唯一id
	private String nickName;    //昵称
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getYzOpenId() {
		return yzOpenId;
	}
	public void setYzOpenId(String yzOpenId) {
		this.yzOpenId = yzOpenId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "CustomerUser [mobile=" + mobile + ", avatar=" + avatar + ", yzOpenId=" + yzOpenId + ", nickName="
				+ nickName + "]";
	}
	
	
	
	
}
