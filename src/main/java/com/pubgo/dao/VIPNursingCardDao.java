package com.pubgo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.pubgo.bean.VIPNursingCard;

//vip护理卡表
public interface VIPNursingCardDao extends BaseMapper<VIPNursingCard> {

	public int insertNursingCard(VIPNursingCard vipNursingCard);
}
