package com.pubgo.service;

import java.sql.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pubgo.bean.Nursing;
import com.pubgo.bean.NursingDetail;
import com.pubgo.vo.NursingVO;

//护理登记表
public interface NursingService {

	//新增护理信息
	public void addNursing( String tel, String name, String customerID, int step
			, int score, String appraise, int input, String payment, String userRemake
			, String employeeRemake, String operator, List<NursingDetail> nursingDetails
			, String sign, String imagePath);
	
	//根据手机号查询护理信息
	public List<Nursing> queryNursings(String tel);
	
	//多条件查询护理信息
	public IPage<NursingVO> queryNursings(String value, int step, Date startDate, Date endDate
			,int status, String customerID, String rgUser, int orderBy, Integer page
			,Integer rows, String sign);
	
	//根据手机号查询护理次数
	public int queryNursingNum(String tel);
	
	public void deleteNursingID( String nursingID );
	
	public String getNursingID();
	
	public void setNursingID(String nursingID);
}
