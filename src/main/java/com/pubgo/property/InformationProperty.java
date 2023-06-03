package com.pubgo.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//资源配置文件
@Component()
//查询配置文件的路径
@PropertySource("classpath:information.properties")
public class InformationProperty {
	//有赞SDK调用参数 
	//有赞名称
	@Value("${yz.tokenName}")
	private String yzTokenName;

	//有赞云颁发给开发者的应用ID
	@Value("${yz.clientId}")
	public String clientId;
	
	//有赞云颁发给开发者的应用secret
	@Value("${yz.clientSecret}")
	public String clientSecret;
	
	//授权店铺id
	@Value("${yz.ktdId}")
	public String ktdId;
	
	//管理员名称
	@Value("${yz.operatorName}")
	public String operatorName;
	
	//管理员手机号
	@Value("${yz.operatorMobile}")
	public String operatorMobile;
	
	//管理员openid
	@Value("${yz.operatorYzOpenId}")
	public String operatorYzOpenId;
	
	
	//阿里云SDK调用参数 
	@Value("${alibaba.accessKeyId}")
	public String accessKeyId;
	
	@Value("${alibaba.accessKeySecret}")
	public String accessKeySecret;
	
	//阿里短信名称
	@Value("${alibaba.templateName.consumptionIntegral}")
	public String consumptionIntegral;

	//文件静态目录
	@Value("${file.static.directory}")
	public String  fileStaticDirectory; 

	//Page分页行数
	@Value("${page.rows}")
	public int rows;
	
	public String getClientId() {
		return clientId;
	}

	public String getYzTokenName() {
		return yzTokenName;
	}

	public void setYzTokenName(String yzTokenName) {
		this.yzTokenName = yzTokenName;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getKtdId() {
		return ktdId;
	}

	public void setKtdId(String ktdId) {
		this.ktdId = ktdId;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	public String getConsumptionIntegral() {
		return consumptionIntegral;
	}

	public void setConsumptionIntegral(String consumptionIntegral) {
		this.consumptionIntegral = consumptionIntegral;
	}

	public String getFileStaticDirectory() {
		return fileStaticDirectory;
	}

	public void setFileStaticDirectory(String fileStaticDirectory) {
		this.fileStaticDirectory = fileStaticDirectory;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorMobile() {
		return operatorMobile;
	}

	public void setOperatorMobile(String operatorMobile) {
		this.operatorMobile = operatorMobile;
	}

	public String getOperatorYzOpenId() {
		return operatorYzOpenId;
	}

	public void setOperatorYzOpenId(String operatorYzOpenId) {
		this.operatorYzOpenId = operatorYzOpenId;
	}
	
}
