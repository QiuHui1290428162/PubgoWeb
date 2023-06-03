package com.pubgo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.pubgo.bean.SysLog;
import com.pubgo.dao.SysLogDao;
import com.pubgo.service.SysLogService;

@Service
//默认不不启动SQL事务控制
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class SysLogServiceImpl implements SysLogService{

	@Resource
	private SysLogDao sysLogDao;
	
	//新增事务
	@Override
	public int insertLog(SysLog log ) {
		
		return sysLogDao.insertLog(log);
	}

	
	

}
