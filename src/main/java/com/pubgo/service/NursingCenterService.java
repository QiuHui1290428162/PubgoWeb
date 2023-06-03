package com.pubgo.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pubgo.bean.NursingCenter;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.vo.NursingCenterVO;
import com.pubgo.vo.NursingDetailsVo;

//护理中心登记表
public interface NursingCenterService {

	//新增护理信息
	public void addNursing( String customerID, int step
			, String remark, int number, String operator
			, String sign, String operate, List<String> imagePaths) throws SQLException, ImoocMallException;
	
	//根据id查询护理信息
	public NursingCenter queryNursingID(String nursingID);
	
	//标准查询护理信息
	public IPage<NursingCenterVO> queryNursings(String value, int step, Date startDate, Date endDate
			, List<String> customerIds, int orderBy, Integer page, Integer rows, String sign)  throws  ImoocMallException;
	
	//查询护理详情信息
	public NursingDetailsVo selectNursingDetails(String nursingID);
	
	//停用护理id
	public void deleteNursingID(String nursingID, String customerID, String operator, String operate);
	
	//修改护理信息
	public void editNursing(String nursingID, int step, String customerID, String remark, int number, String operator
			, String operate, List<String> imagePaths) throws SQLException, ImoocMallException;
	
	//修改员工备注信息
	public int updateNursingEmployeeRemake(String nursingID, String employeeRemake
			, String operator, String operate)throws SQLException, ImoocMallException;
	
	//推进员工进度
	public int advanceNursingStep(String nursingID, int step, int score, String appraise, String operator, String operate, String customerID
			, List<String> imagePaths )throws SQLException, ImoocMallException;
	
	//撤销员工进度
	public int revokeNursingStep(String nursingID, int step, int score, String appraise, String operator, String operate, String customerID)throws SQLException, ImoocMallException;
}
