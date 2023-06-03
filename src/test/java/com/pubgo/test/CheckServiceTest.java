package com.pubgo.test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pubgo.utils.ResponseUtil;
import com.pubgo.api.service.ALSendSmsService;
import com.pubgo.api.service.YZAccessTokenService;
import com.pubgo.api.service.YZCouponService;
import com.pubgo.bean.CheckActivity;
import com.pubgo.bean.CheckKanban;
import com.pubgo.bean.SendSms;
import com.pubgo.property.InformationProperty;
import com.pubgo.service.BuisnessManService;
import com.pubgo.service.CheckActivityService;
import com.pubgo.service.CheckService;
import com.pubgo.service.RightService;
import com.pubgo.service.VipIntegralHisService;
import com.youzan.cloud.open.sdk.common.exception.SDKException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CheckServiceTest {

	@Resource
	public CheckService checkServiceImpl;
	
	@Resource
	public YZCouponService yzCouponServiceImpl;
	
	@Resource
	public YZAccessTokenService  yzAccessTokenServiceimpl;
	
	@Resource
	public ALSendSmsService alSendSmsServiceImpl;
	
	@Resource
	public VipIntegralHisService vipIntegralHisServiceImpl;
	
	@Resource
	public CheckActivityService checkActivityServiceImpl;
	
	@Resource
	public InformationProperty informationProperty;

	
	@Test
	public void test1() {
		System.out.println(informationProperty.getYzTokenName());
		System.out.println(informationProperty.getClientId());
		System.out.println(informationProperty.getClientSecret());
		System.out.println(informationProperty.getKtdId());
	}
	
	@Test
	public void test2() {
		List<CheckActivity> checkActivitys = checkServiceImpl.queryCheckSale();
		for ( CheckActivity checkActivity : checkActivitys ) {
			
//			//会员不为空，则发送短信
//			if ( !checkActivity.getVip().trim().equals("") && !checkActivity.getCode().equals("000000") ){
//				//查询会员积分
//				double integral = vipIntegralHisServiceImpl.queryIntegralHis(checkActivity.getVip()).getIntegralAmount(); 
//				
//				//获取积分短信参数
//				SendSms sms = alSendSmsServiceImpl.querySendSmsByName(informationProperty.getConsumptionIntegral());
//				//设置短信变量
//				sms.getTemplateParams().get(0).setValue(new SimpleDateFormat("yyyy-MM-dd")
//						.format(checkActivity.getInputDate()));
//				sms.getTemplateParams().get(1).setValue(checkActivity.getCustomerName());
//				sms.getTemplateParams().get(2).setValue(checkActivity.getDiscountPrice());
//				sms.getTemplateParams().get(3).setValue(checkActivity.getDiscountPrice());
//				sms.getTemplateParams().get(4).setValue(integral);
//				
//				//调取短信API 发送短信
//				if ( alSendSmsServiceImpl.send(checkActivity.getVip(), sms) ) {
//					checkActivity.setRemark("发送积分短信成功, ");
//					
//				}else {
//					checkActivity.setRemark("发送积分短信失败, ");
//					System.out.println("发送积分短信失败");
//				}
//				
//			}
			//核销优惠券,优惠券核销码以ZAN开头
			if ( checkActivity.getCode().length()>3 ) {
				if( checkActivity.getCode().substring(0, 3).equals("ZAN") ) {
					ResponseUtil resp = null;
					try {
						//核销优惠券
						resp = yzCouponServiceImpl.couponConsumeVerif(
								yzAccessTokenServiceimpl.getAccessToken(), checkActivity.getCode().trim());
						System.out.println("核销优惠券码   Code: "+resp.getCode()+"   message: "+resp.getMsg());
						//核销成功后，则查询核销码信息
						if ( resp.getCode().equals("200") ) {
							resp = yzCouponServiceImpl.getCouponConsume(
									yzAccessTokenServiceimpl.getAccessToken(), checkActivity.getCode().trim());
							checkActivity.setActivity((String) resp.getData().get("activity"));
							checkActivity.setPromocardID((Long)resp.getData().get("promocardID"));
							checkActivity.setRemark(checkActivity.getRemark()+"优惠券核销成功,");
							System.out.println("查询核销码信息   Code: "+resp.getCode()+"   message: "+resp.getMsg());
						}else {
							//核销发生错误备注
							checkActivity.setRemark(checkActivity.getRemark()+resp.getMsg()+",");
						}
						
					} catch (SDKException e) {
						System.out.println("核销优惠券发生错误，单号为: "+checkActivity.getCheckID());
						e.printStackTrace();
					}
				}else {
					//若都不是活动代码，则清空
					checkActivity.setCode("");
				}
			}
			
			//记录销售活动
			checkActivity.setId("AGU"+System.currentTimeMillis());
			checkActivityServiceImpl.addRecordOne(checkActivity);
			//标记已执行活动
			checkServiceImpl.editStampById(checkActivity.getCheckID(), 1);
			System.out.println(checkActivity.toString());
		}
	}
	
	@Test
	public void test3() throws ParseException {
		List<String> customers = new ArrayList<String>();
		customers.add("a08");
		
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
		Date startDate = new Date(format1.parse("2021-10-08").getTime());
		Date endDate = new Date(format1.parse("2021-12-08").getTime());
		
		
		CheckKanban check = checkServiceImpl.queryCheckKanban(customers, startDate, endDate);
		System.out.println(check.toString());
	}
	
	@Test
	public void test4() {
		int count = checkServiceImpl.editStampById("KGU0729990", 1);
		System.out.println(count);
	}
}

















































