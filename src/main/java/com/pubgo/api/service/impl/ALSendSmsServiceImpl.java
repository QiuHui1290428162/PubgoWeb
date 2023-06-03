package com.pubgo.api.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.pubgo.api.service.ALSendSmsService;
import com.pubgo.bean.SendSms;
import com.pubgo.dao.SendSmsDao;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.exception.ImoocMallExceptionEnum;
import com.pubgo.property.InformationProperty;
import com.pubgo.utils.JavaToJSONUtil;

//阿里短信API业务层
@Service
public class ALSendSmsServiceImpl implements ALSendSmsService{

	@Resource
	public SendSmsDao sendSmsDao;
	
	@Resource
	public InformationProperty informationProperty;
	
	
	/**
	 *  根据短信模板名称查询短信模板表
	 * @param templateName   短信模板名称
	 * @return   
	 */
	@Override
	public SendSms querySendSmsByName(String templateName) {
		return sendSmsDao.selectSmsByName(templateName);
	}
	
	/**
	 *  调用阿里云短信服务API，发送短信
	 * @param tel        手机号
	 * @param sendSms    短信模板类
	 * @return      发送是否成功
	 */
	@Override
	public String send(String tel, SendSms sendSms) {
		//获取秘钥
		DefaultProfile profile = DefaultProfile.getProfile(sendSms.getRegion()
        		,informationProperty.getAccessKeyId()
        		,informationProperty.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);
        CommonResponse response = null;
        
        //构建请求参数
        CommonRequest request = new CommonRequest();
        //固定参数，不可动
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(sendSms.getSysDomain());
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        //自定义参数
        request.putQueryParameter("PhoneNumbers", tel);
        request.putQueryParameter("SignName", sendSms.getSignName());
        request.putQueryParameter("TemplateCode", sendSms.getTemplateCode());
        //将集合序列化JSON，需要使用阿里云JSON工具包
    	request.putQueryParameter("TemplateParam",JavaToJSONUtil.toJSONString(sendSms.getTemplateParams()));
        try {
        	
            response = client.getCommonResponse(request);
//          return response.getHttpResponse().isSuccess();
            if ( response.getHttpResponse().isSuccess() ) {
            	return "200";
            }
        } catch (ServerException e) {
			////阿里短信SDK异常捕获
            e.printStackTrace();
            return "错误代码10100，" + e.getMessage();
        } catch (ClientException e) {
            e.printStackTrace();
            return "错误代码10100，" + e.getMessage();
        }
        return "错误代码10100，发送失败";
        
	}


	

}
