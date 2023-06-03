package com.pubgo.bean;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//阿里短信变量参数表
@TableName("SendSms")
public class SendSms {

	@TableId("TemplateCode")
	public String templateCode;      //短信模板ID
	@TableField("SignName")
	public String signName;          //短信签名名称
	@TableField("Region")
	public String region;            //地域
	@TableField("SysDomain")
	public String sysDomain;         //服务地域
	@TableField("TemplateText")
	public String templateText;      //短信模板文本
	@TableField("TemplateName")
	public String templateName;      //短信模板标题
	@TableField(exist=false)
	private List<JsonParam> templateParams;  //短信模板变量
	
	
	public String getTemplateCode() {
		return templateCode;
	}


	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}


	public String getSignName() {
		return signName;
	}


	public void setSignName(String signName) {
		this.signName = signName;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getSysDomain() {
		return sysDomain;
	}


	public void setSysDomain(String sysDomain) {
		this.sysDomain = sysDomain;
	}


	public String getTemplateText() {
		return templateText;
	}


	public void setTemplateText(String templateText) {
		this.templateText = templateText;
	}


	public String getTemplateName() {
		return templateName;
	}


	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}


	public List<JsonParam> getTemplateParams() {
		return templateParams;
	}


	public void setTemplateParams(List<JsonParam> templateParams) {
		this.templateParams = templateParams;
	}


	@Override
	public String toString() {
		return "SendSms [templateCode=" + templateCode + ", signName=" + signName + ", region=" + region
				+ ", sysDomain=" + sysDomain + ", templateText=" + templateText + ", templateName=" + templateName
				+ ", templateParams=" + templateParams + "]";
	}
	
	
	
}
