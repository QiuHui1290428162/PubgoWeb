package com.pubgo.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.pubgo.bean.VIPNursingCard;
import com.pubgo.dao.VIPNursingCardDao;
import com.pubgo.service.VIPNursingCardService;

//vip护理卡表
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class VIPNursingCardServiceImpl implements VIPNursingCardService {

	@Resource
	private VIPNursingCardDao vipNursingCardDao;

	/**
	 * 	查询会员护理卡有效期
	 * @param vip   会员号
	 * @return    返回护理卡信息
	 */
	@Override
	public VIPNursingCard queryNursingCardOne(String vip) {
		QueryWrapper<VIPNursingCard> wrapper = new QueryWrapper<>();
		wrapper.eq("Vip", vip);
		
		return vipNursingCardDao.selectOne(wrapper);
	}

	/**
	 * 新增护理卡
	 * @param vipNursingCard
	 * @return 
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertNursingCard(VIPNursingCard vipNursingCard) throws SQLServerException{
		int row = vipNursingCardDao.insertNursingCard(vipNursingCard);
		return row;
	}

	

}
