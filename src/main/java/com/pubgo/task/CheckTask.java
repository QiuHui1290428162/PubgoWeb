//package com.pubgo.task;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import com.pubgo.utils.OrderCodeFactory;
//import com.pubgo.api.service.ALSendSmsService;
//import com.pubgo.api.service.YZAccessTokenService;
//import com.pubgo.api.service.YZCouponService;
//import com.pubgo.bean.CheckActivity;
//import com.pubgo.bean.SendSms;
//import com.pubgo.bean.VipIntegralHis;
//import com.pubgo.property.InformationProperty;
//import com.pubgo.service.CheckActivityService;
//import com.pubgo.service.CheckService;
//import com.pubgo.service.VipIntegralHisService;
//
//@Component
//@CrossOrigin   //跨域支持 
//public class CheckTask {
//	@Resource
//	public CheckService checkServiceImpl;
//	
//	
//	@Resource
//	public YZCouponService yzCouponServiceImpl;
//	
//	@Resource
//	public YZAccessTokenService  yzAccessTokenServiceimpl;
//	
//	@Resource
//	public ALSendSmsService alSendSmsServiceImpl;
//	
//	@Resource
//	public VipIntegralHisService vipIntegralHisServiceImpl;
//	
//	@Resource
//	public CheckActivityService checkActivityServiceImpl;
//
//	@Resource
//	public InformationProperty informationProperty;
//	
//	@Scheduled(cron = "0 0/5 0-23 * * ?")
//	public void scanCheck() {
//		
//		
//		List<CheckActivity> checkActivitys = checkServiceImpl.queryCheckSale();
//		for ( CheckActivity checkActivity : checkActivitys ) {
//			
//			//会员不为空，则发送短信
//			if ( !checkActivity.getVip().trim().equals("")){
//				//查询会员积分,若积分没有更新，则取销售额积分
//				VipIntegralHis vipIntegralHis = vipIntegralHisServiceImpl.queryIntegralHis(checkActivity.getVip());
//				double integral = checkActivity.getDiscountPrice();
//				if ( vipIntegralHis != null ) {
//					integral = vipIntegralHis.getIntegralAmount(); 
//				}
//				
//				//标记已执行活动
//				int count = checkServiceImpl.editStampById(checkActivity.getCheckID(), 1);
//				//若标记成功，则执行短信发送
//				if ( count > 0 ) {
//					//获取积分短信参数
//					SendSms sms = alSendSmsServiceImpl.querySendSmsByName(informationProperty.getConsumptionIntegral());
//					//设置短信变量
//					sms.getTemplateParams().get(0).setValue(new SimpleDateFormat("yyyy-MM-dd")
//							.format(checkActivity.getInputDate()));
//					sms.getTemplateParams().get(1).setValue(checkActivity.getCustomerName());
//					sms.getTemplateParams().get(2).setValue(checkActivity.getDiscountPrice());
//					sms.getTemplateParams().get(3).setValue(checkActivity.getDiscountPrice());
//					sms.getTemplateParams().get(4).setValue(integral);
//					
//					//调取短信API 发送短信
//					String code = alSendSmsServiceImpl.send(checkActivity.getVip(), sms);
//					if ( code.equals("200") ) {
//						checkActivity.setRemark("发送积分短信成功, ");
//						System.out.println("发送积分短信成功");
//					}else {
//						checkActivity.setRemark("发送积分短信失败, ");
//						System.out.println(code);
//					}
//					//记录销售活动
//					checkActivity.setId(OrderCodeFactory.getOrderCode("AGU"));
//					checkActivityServiceImpl.addRecordOne(checkActivity);
//					System.out.println(checkActivity.toString());
//				}
//			}	
//		}
//	}
//}
