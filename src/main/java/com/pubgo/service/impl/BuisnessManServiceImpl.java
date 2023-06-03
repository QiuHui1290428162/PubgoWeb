package com.pubgo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pubgo.bean.BuisnessMan;
import com.pubgo.dao.BuisnessManDao;
import com.pubgo.service.BuisnessManService;

@Service
//默认不不启动SQL事务控制
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class BuisnessManServiceImpl implements BuisnessManService{

	@Resource
	private BuisnessManDao buisnessManDao;
	
	//根据员工查询
	@Override
	public BuisnessMan queryBuisnessMan(String buisnessManID) {
		
		return buisnessManDao.selectBuisnessMan(buisnessManID);
	}

	
	

}
