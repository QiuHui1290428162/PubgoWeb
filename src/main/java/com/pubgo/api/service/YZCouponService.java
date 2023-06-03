package com.pubgo.api.service;


import com.pubgo.utils.ResponseUtil;
import com.youzan.cloud.open.sdk.common.exception.SDKException;

//有赞优惠券操作业务
public interface YZCouponService {

	//对优惠券/优惠码进行核销操作
	public ResponseUtil couponConsumeVerif(String tokenName,String code)throws SDKException;
	
	//根据核销码获取优惠券/优惠码
	public ResponseUtil getCouponConsume(String tokenName,String code)throws SDKException;
}
