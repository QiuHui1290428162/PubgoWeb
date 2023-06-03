package com.pubgo.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pubgo.bean.CheckActivity;
import com.pubgo.bean.CheckKanban;
import com.pubgo.dao.CheckDao;
import com.pubgo.service.CheckService;

//默认不不启动SQL事务控制
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
//店铺核销单业务层
@Service
public class CheckServiceImpl implements CheckService {

	@Resource
	public CheckDao checkdao;
	
	//查询店铺销售及活动
	@Override
	public List<CheckActivity> queryCheckSale() {
		
		return checkdao.selectCheckSale();
	}

	//根据单号修改stamp
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int editStampById(String checkID, int stamp) {
		return checkdao.updateStampById(checkID,stamp);
	}

	//销售看板：新增会员数，总销售金额，总销售金额，总销售金额客单价
	@Override
	public CheckKanban queryCheckKanban(List<String> customers, Date startDate, Date endDate) {
		
		return checkdao.selectCheckKanban(customers, new java.sql.Date(startDate.getTime()), new java.sql.Date(endDate.getTime()));
	}

}
