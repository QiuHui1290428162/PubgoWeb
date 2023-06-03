package com.pubgo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

//访问token表
@TableName("AutoToken")
public class AutoToken {

	@TableField("Token_name")
	public String tokenName;  //Token运营商
	@TableField("Token")
	public String token;      //Token码
	public String getTokenName() {
		return tokenName;
	}
	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
