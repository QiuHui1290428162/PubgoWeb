package com.pubgo.service;

import java.util.Date;
import java.util.List;

import com.pubgo.bean.CheckActivity;
import com.pubgo.bean.CheckKanban;

//店铺核销单业务层
public interface CheckService {

	//查询店铺销售及活动
	public List<CheckActivity> queryCheckSale();
	
	//根据单号修改stamp
	public int editStampById(String checkID, int stamp);
	
	/**
	 * 查看销售看板
	 * @param customers    店铺集合
	 * @param startDate    开始时间
	 * @param endDate      结束时间
	 * @return
	 */
	public CheckKanban queryCheckKanban(List<String> customers, Date startDate, Date endDate);
}
