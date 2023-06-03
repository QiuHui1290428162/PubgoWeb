package com.pubgo.service.impl;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.pubgo.bean.VIPIntegralExchange;
import com.pubgo.bean.Vip;
import com.pubgo.bean.VipIntegralHis;
import com.pubgo.dao.CustomerVIPDao;
import com.pubgo.dao.VIPIntegralExchangeDao;
import com.pubgo.dao.VipIntegralHisDao;
import com.pubgo.service.VipIntegralHisService;

//会员积分表
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class VipIntegralHisServiceImpl implements VipIntegralHisService {

	@Resource
	VipIntegralHisDao vipIntegralHisDao;
	
	@Resource
	private VIPIntegralExchangeDao vipIntegralExchangeDao;
	
	@Resource
	private CustomerVIPDao customerVIPDao;
	
	/**
	 * 修改会员积分
	 * @param vip        会员号
	 * @param integral   积分
	 * @param integralChange   修改积分
	 * @param exchangeDate     更改时间
	 * @param operator         操作人
	 * @param postUser         店铺号
	 * @param remark           备注
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void editIntegralHis(String vip, int integral, int integralChange
			, String operator, String postUser, String remark) {
		//修改积分
		UpdateWrapper<VipIntegralHis> wrapper = new UpdateWrapper<>();
		wrapper.eq("VIP", vip);
		
		VipIntegralHis vipIntegralHis = new VipIntegralHis();
		vipIntegralHis.setSaveDate(new Date(System.currentTimeMillis()));   //更新时间
		vipIntegralHis.setIntegralAmount(integral);
		/**
	     * 	根据 whereEntity 条件，更新记录
	     *
	     * @param entity        实体对象 (set 条件值,可以为 null)
	     * @param updateWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
	     */
		vipIntegralHisDao.update(vipIntegralHis, wrapper);
		
		//新增积分操作
		VIPIntegralExchange integralExchange = new VIPIntegralExchange();  
		integralExchange.setVip(vip);
		integralExchange.setExchangeDate(new Date(System.currentTimeMillis()));
		integralExchange.setInputDate(new Date(System.currentTimeMillis()));
		integralExchange.setPostedDate(new Date(System.currentTimeMillis()));
		integralExchange.setOperator(operator);
		integralExchange.setAmount(integralChange);
		integralExchange.setPostUser(postUser);
		integralExchange.setRemark(remark);
		
		vipIntegralExchangeDao.insertOne(integralExchange);
		
		//修改会员积分
		Vip entity = new Vip();
		entity.setVip(vip);
		entity.setHisIntegral(integral);
		
		customerVIPDao.updateById(entity);
	}

	/**
	 * 	查询会员积分
	 * @param vip  会员号
	 * return 
	 */
	@Override
	public VipIntegralHis queryIntegralHis(String vip) {
		QueryWrapper<VipIntegralHis>  wrapper = new QueryWrapper<>();
		wrapper.eq("VIP", vip);
		
		return vipIntegralHisDao.selectOne(wrapper);
	}
	
	/**
	 * 	创建会员积分
	 * @param vip   会员号
	 * @param integral   积分
	 * @return
	 */
	@Override
	public int addIntegralHis(String vip, int integral) {
		VipIntegralHis vipIntegralHis = new VipIntegralHis();
		vipIntegralHis.setVip(vip);
		vipIntegralHis.setSaveDate(new Date(System.currentTimeMillis())); 
		vipIntegralHis.setIntegralAmount(integral);
		
		int row = vipIntegralHisDao.insert(vipIntegralHis);
		return row;
	}
	
	

}
