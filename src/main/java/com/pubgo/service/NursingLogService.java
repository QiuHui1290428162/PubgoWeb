package com.pubgo.service;

import java.util.List;

import com.pubgo.bean.NursingLog;

public interface NursingLogService {

	//查询护理日志
	public List<NursingLog> selectByNursingID(String nursingID);
}
