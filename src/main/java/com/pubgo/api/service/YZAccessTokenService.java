package com.pubgo.api.service;

import com.pubgo.exception.ImoocMallException;

//有赞访问令牌业务层
public interface YZAccessTokenService {

	public  String getAccessToken()throws ImoocMallException;
}
