package com.pubgo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pubgo.bean.VipCard;
import com.pubgo.dao.VipCardDao;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.service.VipCardService;

//会员卡业务层
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class VipCardServiceImpl implements VipCardService{

	@Resource
	private VipCardDao vipCardDao;
	
	/**
	 * 查询所有会员卡
	 */
	@Override
	public List<VipCard> selectAll() throws Exception {
		QueryWrapper<VipCard> wrapper = new QueryWrapper<>();
		wrapper.orderByAsc("VipCardSN");
		return vipCardDao.selectList(wrapper);
	}

	//根据会员名称查询对应的会员卡
	@Override
	public VipCard selectVipCardByName(String vipCardByName) throws ImoocMallException {
		QueryWrapper<VipCard> wrapper = new QueryWrapper<>();
		wrapper.eq("VipCardName", vipCardByName);
		wrapper.orderByAsc("VipCardSN");
		return vipCardDao.selectOne(wrapper);
	}

	//根据会员等级查询对应的会员卡
	@Override
	public List<VipCard> selectVipCardByGrade(int vipCardByGrade) throws ImoocMallException {
		QueryWrapper<VipCard> wrapper = new QueryWrapper<>();
		wrapper.eq("VipGrade", vipCardByGrade);
		wrapper.orderByAsc("VipCardSN");
		return vipCardDao.selectList(wrapper);
	}

	
}
