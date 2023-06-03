package com.pubgo.service;

import com.pubgo.bean.Right;
//丽晶用户管理用户业务层
import com.pubgo.exception.ImoocMallException;

public interface RightService {

	public Right queryRightById(String id) throws ImoocMallException;
}
