package com.pubgo.api.service;

import com.pubgo.api.bean.CustomerUser;
import com.pubgo.exception.ImoocMallException;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;

//有赞用户API接口业务层
public interface YouzanUserService {

	/**
	 * 	用户查询接口,使用API版本：1.0
	 * @param tel     手机号
	 * @param token   有赞鉴权凭证
	 * @return        有赞用户信息
	 * @throws SDKException
	 * @throws ImoocMallException
	 * @throws Exception
	 */
	public CustomerUser infoQuery(String tel, Token token) 
			throws SDKException, ImoocMallException, Exception;
}
