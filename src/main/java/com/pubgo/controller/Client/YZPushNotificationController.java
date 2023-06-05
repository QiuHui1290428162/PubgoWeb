package com.pubgo.controller.Client;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubgo.api.bean.CustomerDetail;
import com.pubgo.api.bean.ScrmCustomerCardMsg;
import com.pubgo.api.service.YZAccessTokenService;
import com.pubgo.api.service.YouzanScrmCustomerService;
import com.pubgo.bean.BuisnessMan;
import com.pubgo.bean.SysLog;
import com.pubgo.bean.VIPNursingCard;
import com.pubgo.bean.Vip;
import com.pubgo.bean.VipCard;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.exception.ImoocMallExceptionEnum;
import com.pubgo.request.AddCustomerVipReq;
import com.pubgo.service.BuisnessManService;
import com.pubgo.service.CustomerVIPService;
import com.pubgo.service.SysLogService;
import com.pubgo.service.VIPNursingCardService;
import com.pubgo.service.VipCardService;
import com.pubgo.utils.ResponseUtil;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;

//有赞消息推送控制器
@RestController
@RequestMapping("/pushNotification")
public class YZPushNotificationController {
	
	@Resource
	private YouzanScrmCustomerService youzanScrmCustomerServiceImpl;
	
	@Resource
	private YZAccessTokenService yzAccessTokenServiceImpl;
	
	@Resource
	private BuisnessManService buisnessManServiceImpl;
	
	@Resource
	private CustomerVIPService customerVIPServiceImpl;
	
	@Resource
	private VIPNursingCardService vipNursingCardServiceImpl;
	
	@Resource
	private VipCardService vipCardServiceImpl;
	
	@Resource
	private SysLogService sysLogServiceImpl;
	
	
	private ObjectMapper  objectMapper  = new ObjectMapper (); 
	
	//接受有赞的推送信息
	@PostMapping("/post")
	public ResponseUtil doPostRequest(@RequestBody String json) {
		ResponseUtil resp = new ResponseUtil();

		try {
			//反序列化为
			Map<String, Object> message = objectMapper.readValue(json, Map.class);
            
            
    		for (Map.Entry<String, Object> entry : message.entrySet()) {
    		    String key = entry.getKey();
    		    Object value = entry.getValue();
    		    System.out.println("Key: " + key + ", Value: " + value);
    		}
			
    		//根据业务类型处理事务
            if (message.containsKey("type")) {
                String type = (String) message.get("type");
                String status = (String) message.get("status");
              
                switch (type) {
                case "SCRM_CUSTOMER_CARD":
                    handleCustomerCardMessage(status, message);
                    break;
                case "SCRM_CARD":
                    handleScrmCardMessage(status, message);
                    break;
                default:
                    return new ResponseUtil(ImoocMallExceptionEnum.YZ_ERROR_UNKNOWN_TEPY);
                }
            }else if (message.containsKey("trigger_behavior_dto")) {
            	resp = handleMemberChangeMessage(message);
            	
            	
            } else {
            	 return new ResponseUtil(ImoocMallExceptionEnum.YZ_ERROR_UNKNOWN_TEPY);
            }
			
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return new ResponseUtil(20000,e.getMessage());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseUtil(20000,e.getMessage());
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseUtil(20000,e.getMessage());
		}catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		} catch (SDKException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseUtil(20000,e.getMessage());
		}
		
		return resp;
	}
	
	
    private void handleCustomerCardMessage(String status, Map<String, Object> message) throws UnsupportedEncodingException, JsonMappingException, JsonProcessingException {
    	ScrmCustomerCardMsg scrmCustomerCardMsg = null;
    	
    	//忽略未知的JSON字段,用于控制反序列化过程中如何处理 JSON 中存在而 Java 对象中不存在的属性。
    	objectMapper.configure(
    			DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	//经过UrlEncode(UTF-8)编码，则使用UrlEncode(UTF-8)解码
    	String msg = URLDecoder.decode((String) message.get("msg"), "UTF-8");
    	scrmCustomerCardMsg = objectMapper.readValue(msg, ScrmCustomerCardMsg.class);
    	
    	System.out.println(scrmCustomerCardMsg.toString());
    	
    }

    private void handleScrmCardMessage(String status, Map<String, Object> message) {
        // 根据 status 处理不同的商家端会员卡事件消息
    }

    // 根据 status 处理不同的会员状态变更消息
    private ResponseUtil handleMemberChangeMessage(Map<String, Object> message) throws ImoocMallException, SDKException, Exception {
    	
    	//根据openid查询会员详细信息
    	Token token = new Token(yzAccessTokenServiceImpl.getAccessToken());
    	CustomerDetail customerDetail =  youzanScrmCustomerServiceImpl.GetDetail((String)message.get("yz_open_id"), token);
    	
    	//判断会员是否存在
    	Vip vip = customerVIPServiceImpl.queryVipByID(customerDetail.getMobile());
    	if ( vip != null ) {
    		return new ResponseUtil().put("massage", "会员已注册："+vip.getVip());
    	}
    	
    	//设置新增会员请求
    	AddCustomerVipReq addCustomerVipReq = new AddCustomerVipReq();
    	addCustomerVipReq.setVip(customerDetail.getMobile());
    	addCustomerVipReq.setEncryptVIP(customerDetail.getMobile());
    	addCustomerVipReq.setName(customerDetail.getLatestNickname());
    	if( customerDetail.getGender() == 1 ) {
    		addCustomerVipReq.setSex("男");
    	}else {
    		addCustomerVipReq.setSex("女");
    	}
    	addCustomerVipReq.setBirthDate(new Date(customerDetail.getBirthday().getTime()));
    	addCustomerVipReq.setRgUser("RH"+customerDetail.getAttrInfos01());
    	
    	//获取员工号和店铺信息
    	BuisnessMan buisnessMan = buisnessManServiceImpl.queryBuisnessMan(addCustomerVipReq.getRgUser());
    	if ( buisnessMan != null ) {
    		addCustomerVipReq.setJbUser(buisnessMan.getName());
        	addCustomerVipReq.setCustomerID(buisnessMan.getCustomerID());
    	}
    	addCustomerVipReq.setBegainDate(new Date(System.currentTimeMillis()));
    	addCustomerVipReq.setExpireDate(new Date(System.currentTimeMillis()+3153600000000l));
    	addCustomerVipReq.setAddress("护理卡有效日期至"
				+ new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date(System.currentTimeMillis()+31536000000l)));
    	addCustomerVipReq.setUseStatus("正常");
    	addCustomerVipReq.setYzOpenID(customerDetail.getYzOpenId());
    	addCustomerVipReq.setVipGrade("1");
    	addCustomerVipReq.setTel("1");
    	
    	//给会员发放会员卡，护理卡
    	VIPNursingCard vipNursingCard = new VIPNursingCard();
		List<VipCard> cards = vipCardServiceImpl.selectVipCardByGrade(
				Integer.parseInt(addCustomerVipReq.getVipGrade()));
		for ( int i=0; i<cards.size(); i++ ) {
			//获取卡号
			vipNursingCard.setCardID(youzanScrmCustomerServiceImpl.customerCardGrant(addCustomerVipReq.getVip()
					, cards.get(i).getVipCardAlias(), token));
		}
		System.out.println("3.发放权益卡成功");
		
		//创建丽晶会员
		if( customerVIPServiceImpl.insertCustomerVIP(addCustomerVipReq)==0 ) {
			throw new ImoocMallException(ImoocMallExceptionEnum.FAILED_ADD_VIP);
		}
		System.out.println("4.丽晶添加会员成功");
		vipNursingCard.setVip(addCustomerVipReq.getVip());
		vipNursingCard.setBegainDate(addCustomerVipReq.getBegainDate());
		vipNursingCard.setExpireDate(new Date(addCustomerVipReq.getBegainDate().getTime()+31536000000l));
		if( vipNursingCardServiceImpl.insertNursingCard(vipNursingCard)==0 ) {
			throw new ImoocMallException(ImoocMallExceptionEnum.FAILED_ADD_VIP);
		}
		System.out.println("5.丽晶添加护理卡成功");

		//记录日志
		SysLog log = new SysLog();
		log.setClientHost("LJServer");
		log.setUserNo(addCustomerVipReq.getJbUser());
		log.setLogTime(new Timestamp(System.currentTimeMillis()));
		log.setModuleName("会员");
		log.setAction("新增");
		log.setRemark(addCustomerVipReq.getVip());
		sysLogServiceImpl.insertLog(log);
		
		return new ResponseUtil().put("massage", "会员注册成功："+customerDetail.getMobile());
    }
	


}
