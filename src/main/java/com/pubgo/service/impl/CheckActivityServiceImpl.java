package com.pubgo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pubgo.bean.CheckActivity;
import com.pubgo.dao.CheckActivityDao;
import com.pubgo.service.CheckActivityService;
//销售活动记录表
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class CheckActivityServiceImpl implements CheckActivityService {

	@Resource
	public CheckActivityDao checkActivityDao;
	/**
	 * 
	 * @param checkActivity
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addRecordOne(CheckActivity checkActivity) {
		checkActivityDao.insert(checkActivity);

	}

}
