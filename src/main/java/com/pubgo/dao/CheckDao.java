package com.pubgo.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pubgo.bean.Check;
import com.pubgo.bean.CheckActivity;
import com.pubgo.bean.CheckKanban;

//店铺核销单
public interface CheckDao extends BaseMapper<Check> {

	public List<CheckActivity> selectCheckSale();
	public int updateStampById(String checkID, int stamp);
	public CheckKanban selectCheckKanban(@Param(value="customers")List<String> customers, Date startDate, Date endDate);
}
