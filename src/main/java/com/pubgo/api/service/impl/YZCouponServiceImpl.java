package com.pubgo.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pubgo.api.service.YZCouponService;
import com.pubgo.utils.ResponseUtil;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;
import com.youzan.cloud.open.sdk.core.client.core.DefaultYZClient;
import com.youzan.cloud.open.sdk.core.client.core.YouZanClient;
import com.youzan.cloud.open.sdk.gen.v3_0_0.api.YouzanUmpCouponConsumeGet;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanUmpCouponConsumeGetParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanUmpCouponConsumeGetResult;
import com.youzan.cloud.open.sdk.gen.v3_0_1.api.YouzanUmpCouponConsumeVerify;
import com.youzan.cloud.open.sdk.gen.v3_0_1.model.YouzanUmpCouponConsumeVerifyParams;
import com.youzan.cloud.open.sdk.gen.v3_0_1.model.YouzanUmpCouponConsumeVerifyResult;
//有赞优惠券操作业务
@Service
public class YZCouponServiceImpl implements YZCouponService {


	
	/**
	 * 对优惠券/优惠码进行核销操作
	 * @param tokenName  有赞token参数
	 * @param code       优惠券核销码
	 * @return 
	 */
	@Override
	public ResponseUtil couponConsumeVerif(String tokenName, String code) throws SDKException{
		YouZanClient yzClient = new DefaultYZClient();
		Token token = new Token(tokenName);

		YouzanUmpCouponConsumeVerify youzanUmpCouponConsumeVerify = new YouzanUmpCouponConsumeVerify();


		//创建参数对象,并设置参数
		YouzanUmpCouponConsumeVerifyParams youzanUmpCouponConsumeVerifyParams = new YouzanUmpCouponConsumeVerifyParams();
		    youzanUmpCouponConsumeVerifyParams.setCode(code);

		youzanUmpCouponConsumeVerify.setAPIParams(youzanUmpCouponConsumeVerifyParams);
		YouzanUmpCouponConsumeVerifyResult result = yzClient.invoke(
				youzanUmpCouponConsumeVerify, token, YouzanUmpCouponConsumeVerifyResult.class);

		ResponseUtil resp = null;
		if ( result.getSuccess() == true ) {
			resp = new ResponseUtil();
		}else {
//			resp = new ResponseUtil(result.getCode()+"", result.getMessage());
		}
		
		return resp;
		
	}

	/**
	 * 根据核销码获取优惠券/优惠码
	 * @param tokenName  有赞token参数
	 * @param code       优惠券核销码
	 * @return
	 */
	@Override
	public ResponseUtil getCouponConsume(String tokenName,String code)throws SDKException {


		//YouZanClient 建议全局唯一,使用 spring 容器管理
		YouZanClient yzClient = new DefaultYZClient();
		Token token = new Token(tokenName);

		YouzanUmpCouponConsumeGet youzanUmpCouponConsumeGet = new YouzanUmpCouponConsumeGet();


		//创建参数对象,并设置参数
		YouzanUmpCouponConsumeGetParams youzanUmpCouponConsumeGetParams = new YouzanUmpCouponConsumeGetParams();
		    youzanUmpCouponConsumeGetParams.setCode(code);

		youzanUmpCouponConsumeGet.setAPIParams(youzanUmpCouponConsumeGetParams);
		YouzanUmpCouponConsumeGetResult result = yzClient.invoke(youzanUmpCouponConsumeGet, token, YouzanUmpCouponConsumeGetResult.class);
		
		ResponseUtil resp = null;
		if ( result.getSuccess() == true ) {
			resp = new ResponseUtil().put("activity", result.getData().getCoupon().getTitle())
					.put("promocardID", result.getData().getPromocardId());
		}else {
//			resp = new ResponseUtil(result.getCode()+"", result.getMessage());
		}
		return resp;
	}

}
