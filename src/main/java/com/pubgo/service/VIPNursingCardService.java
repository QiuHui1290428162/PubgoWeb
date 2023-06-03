package com.pubgo.service;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.pubgo.bean.VIPNursingCard;

//vip护理卡表
public interface VIPNursingCardService {

	public VIPNursingCard queryNursingCardOne(String vip);
	
	/**
	 * 新增护理卡
	 * @param vipNursingCard
	 * @return 
	 */
	public int insertNursingCard(VIPNursingCard vipNursingCard)  throws SQLServerException; 
	

	

}
