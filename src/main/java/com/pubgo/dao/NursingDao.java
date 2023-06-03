package com.pubgo.dao;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pubgo.bean.Nursing;
import com.pubgo.vo.NursingVO;

public interface NursingDao extends BaseMapper<Nursing>{

	//多条件查询护理信息
	public IPage<NursingVO> selectNursings(@Param("value")String value, @Param("step")int step
		, @Param("startDate")Date startDate, @Param("endDate")Date endDate
		, @Param("status")int status, @Param("customerID")String customerID
		, @Param("rgUser")String rgUser, @Param("orderBy")int orderBy
		, @Param("sign")String sign, Page<NursingVO> page);
	
	//停用护理id标志
	public int deleteNursingID(String nursingID);
}
