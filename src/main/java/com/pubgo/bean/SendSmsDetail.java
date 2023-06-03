package com.pubgo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//阿里短信变量参数表
@TableName("SendSmsDetail")
public class SendSmsDetail {

	@TableId("TemplateID")
	public String templateID;      //短信变量ID
	@TableField("TemplateCode")
	public String templateCode;    //短信模板ID
	@TableField("Variable")
	public String variable;        //变量名称
	@TableField("VariableType")
	public String variableType;    //变量类型
	@TableField(exist = false)
	public String value;           //变量值
	public String getTemplateID() {
		return templateID;
	}
	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public String getVariableType() {
		return variableType;
	}
	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "SendSmsDetail [templateID=" + templateID + ", templateCode=" + templateCode + ", variable=" + variable
				+ ", variableType=" + variableType + ", value=" + value + "]";
	}
	
	
	
	
	
}
