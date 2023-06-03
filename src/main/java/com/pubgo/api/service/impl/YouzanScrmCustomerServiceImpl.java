package com.pubgo.api.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pubgo.api.bean.CustomerCard;
import com.pubgo.api.bean.CustomerDetail;
import com.pubgo.api.service.YZAccessTokenService;
import com.pubgo.api.service.YouzanScrmCustomerService;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.property.InformationProperty;
import com.pubgo.request.AddCustomerVipReq;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;
import com.youzan.cloud.open.sdk.core.client.core.YouZanClient;
import com.youzan.cloud.open.sdk.gen.v1_0_0.api.YouzanScrmCardAddData;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanScrmCardAddDataParams;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanScrmCardAddDataResult;
import com.youzan.cloud.open.sdk.gen.v1_0_1.api.YouzanScrmCustomerDetailGet;
import com.youzan.cloud.open.sdk.gen.v1_0_1.model.YouzanScrmCustomerDetailGetParams;
import com.youzan.cloud.open.sdk.gen.v1_0_1.model.YouzanScrmCustomerDetailGetResult;
import com.youzan.cloud.open.sdk.gen.v3_0_0.api.YouzanScrmCustomerCreate;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCustomerCreateParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCustomerCreateResult;
import com.youzan.cloud.open.sdk.gen.v4_0_0.api.YouzanScrmCustomerCardGrant;
import com.youzan.cloud.open.sdk.gen.v4_0_0.api.YouzanScrmCustomerCardList;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanScrmCustomerCardGrantParams;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanScrmCustomerCardGrantResult;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanScrmCustomerCardListParams;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanScrmCustomerCardListResult;

//有赞会员API接口业务层
@Service
public class YouzanScrmCustomerServiceImpl implements YouzanScrmCustomerService {

	@Resource
	private InformationProperty informationProperty;
	
	@Autowired
	private YouZanClient yzClient;
	
	@Resource
	private YZAccessTokenService YZAccessTokenServiceImpl;
	
	/**
	 * 创建客户到店铺,使用API版本：3.0
	 * @param addCustomerVipReq  新增会员信息请求
	 * @return  返回YzOpenId
	 */
	@Override
	public String customerCreate(AddCustomerVipReq addCustomerVipReq,Token token)
			throws SDKException, ImoocMallException, Exception{
		
		
		SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		
		//创建参数对象
		YouzanScrmCustomerCreate youzanScrmCustomerCreate = new YouzanScrmCustomerCreate();
		YouzanScrmCustomerCreateParams youzanScrmCustomerCreateParams = new YouzanScrmCustomerCreateParams();
		YouzanScrmCustomerCreateParams.YouzanScrmCustomerCreateParamsCustomercreate  
			youzanScrmCustomerCreateCustomerCreateParams = 
			new YouzanScrmCustomerCreateParams.YouzanScrmCustomerCreateParamsCustomercreate();
		youzanScrmCustomerCreateCustomerCreateParams.setName(addCustomerVipReq.getName());
		//设置VIP会员参数
		if ( addCustomerVipReq.getSex() != null ) {
			if ( addCustomerVipReq.getSex().equals("男") )
			{
				youzanScrmCustomerCreateCustomerCreateParams.setGender((short) 1);
			}
			else 
			{
				youzanScrmCustomerCreateCustomerCreateParams.setGender((short)2);
			}
		}
		
		youzanScrmCustomerCreateCustomerCreateParams.setBirthday(sformat.format(addCustomerVipReq.getBirthDate()));    //数据类型转换Date转为String
		if ( addCustomerVipReq.getRemark() != null )
		{
			youzanScrmCustomerCreateCustomerCreateParams.setRemark(addCustomerVipReq.getRemark());
		}
		youzanScrmCustomerCreateCustomerCreateParams.setAscriptionKdtId( Long.parseLong(informationProperty.getKtdId()));
		youzanScrmCustomerCreateParams.setCustomerCreate(youzanScrmCustomerCreateCustomerCreateParams);
		youzanScrmCustomerCreateParams.setMobile(addCustomerVipReq.getVip());
		
		youzanScrmCustomerCreate.setAPIParams(youzanScrmCustomerCreateParams);
		//
		YouzanScrmCustomerCreateResult  result = yzClient.invoke(youzanScrmCustomerCreate
				, token, YouzanScrmCustomerCreateResult.class);
		
		//根据返回码判断是否开卡成功
		if ( result.getCode() == 200 )
		{
			return result.getData().getYzOpenId();
		}
		else if ( result.getCode() == 143001027 )
		{
			//该code代码表示已经成为商城会员，忽略错误
			return "";
		}
		else 
		{
			throw new ImoocMallException(result.getCode(), result.getMessage());
		}
		
	}

	/**
	 * 给用户发放权益卡,使用API版本：4.0
	 * @param tel     手机号
	 * @param alias   有赞权益卡别名
	 * @return        返回卡号
	 */
	@Override
	public String customerCardGrant(String tel, String alias, Token token)
			throws ImoocMallException,SDKException,Exception {

		YouzanScrmCustomerCardGrant youzanScrmCustomerCardGrant = new YouzanScrmCustomerCardGrant();


		//创建参数对象,并设置参数
		YouzanScrmCustomerCardGrantParams youzanScrmCustomerCardGrantParams = new YouzanScrmCustomerCardGrantParams();

		    YouzanScrmCustomerCardGrantParams.YouzanScrmCustomerCardGrantParamsParams youzanScrmCustomerCardGrantParamsParams  = new YouzanScrmCustomerCardGrantParams.YouzanScrmCustomerCardGrantParamsParams();
		        youzanScrmCustomerCardGrantParams.setParams(youzanScrmCustomerCardGrantParamsParams);
		    youzanScrmCustomerCardGrantParamsParams.setAdminId(0L);
		    youzanScrmCustomerCardGrantParamsParams.setCardAlias(alias);

		    YouzanScrmCustomerCardGrantParams.YouzanScrmCustomerCardGrantParamsUser youzanScrmCustomerCardGrantParamsUser  = new YouzanScrmCustomerCardGrantParams.YouzanScrmCustomerCardGrantParamsUser();
		        youzanScrmCustomerCardGrantParamsParams.setUser(youzanScrmCustomerCardGrantParamsUser);
		    youzanScrmCustomerCardGrantParamsUser.setAccountType(2);
		    youzanScrmCustomerCardGrantParamsUser.setAccountId(tel);    

		    youzanScrmCustomerCardGrant.setAPIParams(youzanScrmCustomerCardGrantParams);
		    YouzanScrmCustomerCardGrantResult result = yzClient.invoke(youzanScrmCustomerCardGrant, token, YouzanScrmCustomerCardGrantResult.class);
		
		//判断是否开卡成功
		if ( result.getCode()==200 && result.getData().getIsSuccess() )
		{
			return result.getData().getCardNo();
		}else {
			throw new ImoocMallException(result.getCode(), result.getMessage());
		}

	}

	/**
	 *  获取客户账号下权益卡列表，使用API版本：4.0
	 * @param tel        手机号
	 * @param token
	 * @return           返回权益卡号
	 * @throws SDKException
	 * @throws ImoocMallException
	 * @throws Exception
	 */
	@Override
	public List<CustomerCard> customerCardList(String tel, Token token) throws SDKException, ImoocMallException, Exception {
		List<CustomerCard> customerCards = new ArrayList<CustomerCard>();
		
		YouzanScrmCustomerCardList youzanScrmCustomerCardList = new YouzanScrmCustomerCardList();

		//创建参数对象,并设置参数
		YouzanScrmCustomerCardListParams youzanScrmCustomerCardListParams = new YouzanScrmCustomerCardListParams();

		    YouzanScrmCustomerCardListParams.YouzanScrmCustomerCardListParamsParams youzanScrmCustomerCardListParamsParams  = new YouzanScrmCustomerCardListParams.YouzanScrmCustomerCardListParamsParams();
		        youzanScrmCustomerCardListParams.setParams(youzanScrmCustomerCardListParamsParams);
		        youzanScrmCustomerCardListParamsParams.setState(true);
		        

		    YouzanScrmCustomerCardListParams.YouzanScrmCustomerCardListParamsUser youzanScrmCustomerCardListParamsUser  = new YouzanScrmCustomerCardListParams.YouzanScrmCustomerCardListParamsUser();
		        youzanScrmCustomerCardListParamsParams.setUser(youzanScrmCustomerCardListParamsUser);
		    youzanScrmCustomerCardListParamsUser.setAccountType(2);
		    youzanScrmCustomerCardListParamsUser.setAccountId(tel);
		 

		    youzanScrmCustomerCardListParamsParams.setPageNo(1);


		youzanScrmCustomerCardList.setAPIParams(youzanScrmCustomerCardListParams);
		YouzanScrmCustomerCardListResult result = yzClient
				.invoke(youzanScrmCustomerCardList, token, YouzanScrmCustomerCardListResult.class);
		//判断是否开卡成功
		if ( result.getCode()==200 && result.getSuccess() )
		{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for ( int i=0; i<result.getData().getTotal(); i++) {
				CustomerCard customerCard = new CustomerCard();
				customerCard.setStartDate(simpleDateFormat.parse(result.getData().getItems().get(i).getCardStartTime()));
				customerCard.setEndDate(simpleDateFormat.parse(result.getData().getItems().get(i).getCardEndTime()));
				customerCard.setAlias(result.getData().getItems().get(i).getCardAlias());
				customerCard.setCardNo(result.getData().getItems().get(i).getCardNo());
				customerCards.add(customerCard);
			}
		}else {
			throw new ImoocMallException(result.getCode(), result.getMessage());
		}
		return customerCards;
	}

	/**
	 * 	付费权益卡续费，使用API版本：1.0
	 * @param cardNo       卡号
	 * @param yzOpenId     有赞用户id，用户在有赞的唯一id。
	 * @param extensionDateNum   延期天数
	 * @return             
	 * @throws SDKException
	 * @throws ImoocMallException
	 * @throws Exception
	 */
	@Override
	public boolean CardAddData(String cardNo, String yzOpenId, int extensionDateNum, Token token)
			throws SDKException, ImoocMallException, Exception {
		YouzanScrmCardAddData youzanScrmCardAddData = new YouzanScrmCardAddData();


		//创建参数对象,并设置参数
		YouzanScrmCardAddDataParams youzanScrmCardAddDataParams = new YouzanScrmCardAddDataParams();
		    youzanScrmCardAddDataParams.setCardNo(cardNo);
		    youzanScrmCardAddDataParams.setYzOpenId(yzOpenId);
		    youzanScrmCardAddDataParams.setCheckCustomer(false);
		    youzanScrmCardAddDataParams.setOperatorYzOpenId(informationProperty.getOperatorYzOpenId());
		    youzanScrmCardAddDataParams.setExtensionDateNum(extensionDateNum);

		youzanScrmCardAddData.setAPIParams(youzanScrmCardAddDataParams);
		YouzanScrmCardAddDataResult result = yzClient.invoke(youzanScrmCardAddData, token, YouzanScrmCardAddDataResult.class);
		
		if ( result.getCode() != 200 ){
			throw new ImoocMallException(result.getCode(), result.getMessage());
		}
		return true;
	}

	/**
	 * 获取会员详细信息，使用API版本：1.1
	 * @param yzOpenId    有赞openid
	 * @param token
	 * @return
	 * @throws SDKException
	 * @throws ImoocMallException
	 * @throws Exception
	 */
	@Override
	public CustomerDetail GetDetail(String yzOpenId, Token token) throws SDKException, ImoocMallException, Exception {
		
		YouzanScrmCustomerDetailGet youzanScrmCustomerDetailGet = new YouzanScrmCustomerDetailGet();


		//创建参数对象,并设置参数
		YouzanScrmCustomerDetailGetParams youzanScrmCustomerDetailGetParams = new YouzanScrmCustomerDetailGetParams();
		    youzanScrmCustomerDetailGetParams.setIsDoExtPoint(true);
		    youzanScrmCustomerDetailGetParams.setYzOpenId(yzOpenId);
		    youzanScrmCustomerDetailGetParams.setFields("user_base,tags,benefit_cards,benefit_level,benefit_rights,credit,behavior,giftcard,prepaid,coupon,level,auth_info");

		youzanScrmCustomerDetailGet.setAPIParams(youzanScrmCustomerDetailGetParams);
		YouzanScrmCustomerDetailGetResult result = yzClient.invoke(youzanScrmCustomerDetailGet, token, YouzanScrmCustomerDetailGetResult.class);
		
		if ( result.getCode() != 200 ){
			throw new ImoocMallException(result.getCode(), result.getMessage());
		}
		
		//赋值
		CustomerDetail customerDetail = new CustomerDetail();
		if ( result.getData().getCustomerAttrinfos().size() != 0 )
		{
			customerDetail.setAttrInfos01(result.getData().getCustomerAttrinfos().get(0).getValue());
		}
		customerDetail.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(result.getData().getBirthday()));
		customerDetail.setGender(result.getData().getGender());
		customerDetail.setLatestAvatar(result.getData().getLatestAvatar());
		customerDetail.setLatestNickname(result.getData().getLatestNickname());
		customerDetail.setMobile(result.getData().getMobile());
		customerDetail.setYzOpenId(yzOpenId);
		return customerDetail;
	}

	
}



































