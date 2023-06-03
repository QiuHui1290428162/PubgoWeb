package com.pubgo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pubgo.bean.NursingLog;
import com.pubgo.dao.NursingLogDao;
import com.pubgo.service.NursingLogService;

//护理日志表
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class NursingLogServiceImpl implements NursingLogService {

	@Resource
	private NursingLogDao nursingLogDao; 
	
	/**
	 *  查询护理日志
	 * @param NursingID   护理id
	 * @return
	 */
	@Override
	public List<NursingLog> selectByNursingID(String nursingID) {
		
		return nursingLogDao.selectByNursingID(nursingID);
	}

}
