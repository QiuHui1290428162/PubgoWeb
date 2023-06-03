package com.pubgo.api.service;

import java.util.List;

import com.pubgo.api.bean.CustomerCard;
import com.pubgo.api.bean.CustomerDetail;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.request.AddCustomerVipReq;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;

//有赞会员API
public interface YouzanScrmCustomerService {

	/**
	 * 创建客户到店铺
	 * @param addCustomerVipReq  新增会员信息请求
	 * @return  返回YzOpenId
	 */
	public String customerCreate(AddCustomerVipReq addCustomerVipReq,Token token) 
			throws SDKException, ImoocMallException, Exception;
	
	
	/**
	 * 给用户发放权益卡
	 * @param tel     手机号
	 * @param alias   有赞权益卡别名
	 * @return        返回权益卡号
	 */
	public String customerCardGrant(String tel, String alias,Token token) 
			throws SDKException, ImoocMallException, Exception;
	
	/**
	 *  获取客户账号下权益卡列表
	 * @param tel        手机号
	 * @return           返回权益卡号
	 * @throws SDKException
	 * @throws ImoocMallException
	 * @throws Exception
	 */
	public List<CustomerCard> customerCardList(String tel ,Token token) 
			throws SDKException, ImoocMallException, Exception;
	
	/**
	 * 	付费权益卡续费
	 * @param cardNo       卡号
	 * @param yzOpenId     有赞用户id，用户在有赞的唯一id。
	 * @param extensionDateNum   延期天数
	 * @return             
	 * @throws SDKException
	 * @throws ImoocMallException
	 * @throws Exception
	 */
	public boolean CardAddData(String cardNo, String yzOpenId, int extensionDateNum, Token token)
			throws SDKException, ImoocMallException, Exception;
	
	/**
	 * 获取会员详细信息
	 * @param yzOpenId    有赞openid
	 * @param token
	 * @return
	 * @throws SDKException
	 * @throws ImoocMallException
	 * @throws Exception
	 */
	public CustomerDetail  GetDetail( String yzOpenId, Token token )throws SDKException, ImoocMallException, Exception;
}
