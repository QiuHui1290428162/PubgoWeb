package com.pubgo.dao;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pubgo.bean.NursingProgress;

public interface NursingProgressDao extends BaseMapper<NursingProgress>{

	public int updateNursing(@Param("nursingID")String nursingID, @Param("step")int step
			, @Param("operator")String operator, @Param("imagePath")String imagePath);
}
