package com.pubgo.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pubgo.bean.NursingCenter;
import com.pubgo.vo.NursingCenterVO;
import com.pubgo.vo.NursingDetailsVo;

public interface NursingCenterDao extends BaseMapper<NursingCenter>{

	//标准条件查询护理信息
	public IPage<NursingCenterVO> selectNursings(@Param("value")String value, @Param("step")int step
		, @Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("customerIds")List<String> customerIds
		, @Param("orderBy")int orderBy, @Param("sign")String sign, Page<NursingCenterVO> page);
	
	//查询护理详情信息
	public NursingDetailsVo selectNursingDetails(@Param("nursingID")String nursingID);
	
	//停用护理id标志
	public int deleteNursingID(String nursingID);
	
	//更新护理信息
	public int updateNursing(@Param("nursingID")String nursingID, @Param("customerID")String customerID
			, @Param("remark")String remark, @Param("number")int number, @Param("operator")String operator
			, @Param("operate")String operate, @Param("imagePath")String imagePath);
	
	//修改员工备注信息
	public int updateNursingEmployeeRemake( @Param("nursingID")String nursingID, @Param("employeeRemake")String employeeRemake );
	
	//修改员工进度
	public int updateNursingStep( @Param("nursingID")String nursingID, @Param("step")int step, @Param("score")int score, @Param("appraise")String appraise );
	
	
}
