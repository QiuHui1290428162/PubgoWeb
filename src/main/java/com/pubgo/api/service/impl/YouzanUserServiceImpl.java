package com.pubgo.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pubgo.api.bean.CustomerUser;
import com.pubgo.api.service.YouzanUserService;
import com.pubgo.exception.ImoocMallException;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;
import com.youzan.cloud.open.sdk.core.client.core.YouZanClient;
import com.youzan.cloud.open.sdk.gen.v1_0_0.api.YouzanUsersInfoQuery;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanUsersInfoQueryParams;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanUsersInfoQueryResult;

//有赞用户API接口业务层
@Service
public class YouzanUserServiceImpl implements YouzanUserService {

	
	@Autowired
	private YouZanClient yzClient;
	
	/**
	 * 	用户查询接口,使用API版本：1.0
	 * @param tel     手机号
	 * @param token   有赞鉴权凭证
	 * @return        有赞用户信息
	 * @throws SDKException
	 * @throws ImoocMallException
	 * @throws Exception
	 */
	@Override
	public CustomerUser infoQuery(String tel, Token token) throws SDKException, ImoocMallException, Exception {
		CustomerUser customerUser = new CustomerUser();
		
		YouzanUsersInfoQuery youzanUsersInfoQuery = new YouzanUsersInfoQuery();

		//创建参数对象,并设置参数
		YouzanUsersInfoQueryParams youzanUsersInfoQueryParams = new YouzanUsersInfoQueryParams();
		    youzanUsersInfoQueryParams.setMobile(tel);

		youzanUsersInfoQuery.setAPIParams(youzanUsersInfoQueryParams);
		YouzanUsersInfoQueryResult result = yzClient.invoke(youzanUsersInfoQuery, token, YouzanUsersInfoQueryResult.class);
		
		if ( result.getCode()==200 && result.getSuccess() ){
			if( result.getData().getLatestInfo() != null ) {
				customerUser.setAvatar(result.getData().getLatestInfo().getAvatar());
				customerUser.setNickName(result.getData().getLatestInfo().getNickName());
			}
			customerUser.setYzOpenId(result.getData().getUserList().get(0).getPrimitiveInfo().getYzOpenId());
			customerUser.setMobile(tel);
		}else {
			throw new ImoocMallException(result.getCode(), result.getMessage());
		}
		return customerUser;
	}

}
