package com.pubgo.service;

import java.sql.SQLException;

import com.pubgo.bean.SysLog;

//员工信息业务层
public interface SysLogService {
 
	public int insertLog(SysLog log );
}
