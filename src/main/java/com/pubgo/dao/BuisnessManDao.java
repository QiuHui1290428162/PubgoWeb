package com.pubgo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pubgo.bean.BuisnessMan;

//员工信息表
public interface BuisnessManDao extends BaseMapper<BuisnessMan> {

	public BuisnessMan selectBuisnessMan(String buisnessManID);
}
