package com.pubgo.api.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.pubgo.api.service.YZAccessTokenService;
import com.pubgo.bean.AutoToken;
import com.pubgo.dao.AutoTokenDao;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.property.InformationProperty;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;
import com.youzan.cloud.open.sdk.core.client.core.DefaultYZClient;
import com.youzan.cloud.open.sdk.core.client.core.YouZanClient;
import com.youzan.cloud.open.sdk.core.oauth.model.OAuthToken;
import com.youzan.cloud.open.sdk.core.oauth.token.TokenParameter;
import com.youzan.cloud.open.sdk.gen.v3_0_0.api.YouzanScrmCardList;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCardListParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCardListResult;

//有赞访问令牌业务层
@Service
public class YZAccessTokenServiceImpl implements YZAccessTokenService{

	@Resource
	public InformationProperty informationProperty;
	
	@Resource
	public AutoTokenDao autoTokenDao;
	
	@Autowired
	private YouZanClient yzClient;
	
	//获取有赞 access_token
	@Override
	public  String getAccessToken() throws ImoocMallException{
		//调取数据库中的有赞token
		QueryWrapper<AutoToken> queryWrapper = new QueryWrapper<AutoToken>();
		queryWrapper.eq("Token_name", informationProperty.getYzTokenName());
		
		AutoToken autoToken = autoTokenDao.selectOne(queryWrapper);
		
		try {
			//判断token是否有效
			YouzanScrmCardList youzanScrmCardList = new YouzanScrmCardList();
			YouzanScrmCardListParams youzanScrmCardListParams = new YouzanScrmCardListParams();
			//设置参数
			Token token = new Token(autoToken.getToken());
			youzanScrmCardListParams.setPage(1);
			youzanScrmCardList.setAPIParams(youzanScrmCardListParams);
			yzClient.invoke(youzanScrmCardList, token, YouzanScrmCardListResult.class);
		} catch (SDKException e) {
			System.out.println("有赞Token已过期");
			//若token过期，则重新获取并更新到数据库中
			OAuthToken oAuthToken = new OAuthToken();
			TokenParameter tokenParameter;
			try {
				tokenParameter = TokenParameter.self()
				      .clientId(informationProperty.getClientId())
				      .clientSecret(informationProperty.getClientSecret())
				      .grantId(informationProperty.getKtdId())
				      .refresh(true)
				      .build();
				oAuthToken = yzClient.getOAuthToken(tokenParameter);
			} catch (SDKException exception) {
				exception.printStackTrace();
				throw new ImoocMallException(exception.getCode(), "获取ToKen失败，"+exception.getMessage());
			}
			autoToken.setToken(oAuthToken.getAccessToken());
			//token更新到数据库中
			UpdateWrapper<AutoToken> updateWrapper = new UpdateWrapper<AutoToken>();
			updateWrapper.eq("Token_name", informationProperty.getYzTokenName());
			autoTokenDao.update(autoToken, updateWrapper);
			System.out.println("有赞token更新成功");
		}
		
		return autoToken.getToken();
	}
}
