package com.pubgo.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pubgo.bean.NursingLog;

public interface NursingLogDao extends BaseMapper<NursingLog> {

	public List<NursingLog> selectByNursingID(String nursingID);
}
