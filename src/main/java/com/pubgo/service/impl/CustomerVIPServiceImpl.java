package com.pubgo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.pubgo.bean.Vip;
import com.pubgo.dao.CustomerVIPDao;
import com.pubgo.request.AddCustomerVipReq;
import com.pubgo.service.CustomerVIPService;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class CustomerVIPServiceImpl implements CustomerVIPService {

	@Resource
	private CustomerVIPDao customerVIPDao;
	
	/**
	 * 	查询会员名称
	 * @param vip   会员号
	 * @return   	会员信息
	 */
	@Override
	public Vip queryVipByID(String vip) {
		
		return customerVIPDao.selectById(vip);
	}

	//编辑会员
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void editVipByID(String vip) {
		
	}


	/**
	 *	 编辑会员积分
	 * @param vip    会员号
	 * @param integral  积分  
	 */
	//开启事务处理
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void editVipIntegralByID(String vip, int integral) {
		Vip entity = new Vip();
		entity.setVip(vip);
		entity.setHisIntegral(integral);
		
		customerVIPDao.updateById(entity);
	}
	
	//添加会员
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addVipByID(String vip) {
		// TODO Auto-generated method stub
		
	}

	//删除会员
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void removeVipByID(String vip) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 新增会员信息
	 * @param addCustomerVipReq   新增会员请求
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertCustomerVIP(AddCustomerVipReq addCustomerVipReq)throws SQLServerException {
		int row = customerVIPDao.insertCustomerVIP(addCustomerVipReq);
		return row; 
	}
}
