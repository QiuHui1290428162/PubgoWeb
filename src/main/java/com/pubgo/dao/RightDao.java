package com.pubgo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pubgo.bean.Right;

//用户管理表
public interface RightDao extends BaseMapper<Right>{

	
	public Right selectRightById(String id);
}
