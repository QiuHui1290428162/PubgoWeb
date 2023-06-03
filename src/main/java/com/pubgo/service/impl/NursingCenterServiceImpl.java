package com.pubgo.service.impl;


import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pubgo.bean.NursingCenter;
import com.pubgo.bean.NursingLog;
import com.pubgo.bean.NursingProgress;
import com.pubgo.dao.NursingCenterDao;
import com.pubgo.dao.NursingLogDao;
import com.pubgo.dao.NursingProgressDao;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.exception.ImoocMallExceptionEnum;
import com.pubgo.service.NursingCenterService;
import com.pubgo.utils.OrderCodeFactory;
import com.pubgo.vo.NursingCenterVO;
import com.pubgo.vo.NursingDetailsVo;

//护理登记表
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class NursingCenterServiceImpl implements NursingCenterService {

	@Resource
	private NursingCenterDao nursingCenterDao;
	@Resource
	private NursingCenterDao NursingProgressDao;
	@Resource
	private NursingLogDao nursingLogDao;
	@Resource
	private NursingProgressDao nursingProgressDao;
	
	private String nursingID;

	/**
	 * 新增护理信息
	 * @param customerID     店铺号
	 * @param step           护理进度
	 * @param remark         备注
	 * @param number         数量
	 * @param operato        营业员号
	 * @param sign           停用标志 
	 * @param imagePath      图片路径
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addNursing(String customerID, int step, String remark, int number, String operator, String sign
			,String operate, List<String> imagePaths) throws SQLException, ImoocMallException {
		
		//生成护理单号
		nursingID = OrderCodeFactory.getOrderCode("H");
		
		//新增洗鞋信息
		NursingCenter nursingCenter = new NursingCenter();
		nursingCenter.setNursingID(nursingID);
		nursingCenter.setCustomerID(customerID);
		nursingCenter.setOperator(operator);
		nursingCenter.setQuantity(number);
		nursingCenter.setStep(step);
		nursingCenter.setRemark(remark);
		nursingCenter.setSign(sign);
		if ( imagePaths != null ) {
			nursingCenter.setImagePath(imagePaths.get(0));
		}
		nursingCenterDao.insert(nursingCenter);
		
		//新增护理鞋进度
		NursingProgress nursingProgress = new NursingProgress();
		nursingProgress.setNursingProgressID(nursingID
				+new DecimalFormat("0").format(step));
		nursingProgress.setNursingID(nursingID);
		nursingProgress.setStep(step);
		nursingProgress.setOperator(operator);
		if ( imagePaths != null ) {
			for (String imagePath : imagePaths) {
				if ( nursingProgress.getImagePath() == null ) {
					nursingProgress.setImagePath(imagePath);
				}else {
					String psths =  imagePath + "," + nursingProgress.getImagePath();
					nursingProgress.setImagePath(psths);
				}
			}
		}
		nursingProgressDao.insert(nursingProgress);
		
		
		//登记日志
		NursingLog nursingLog =  new NursingLog();
		nursingLog.setLogId(OrderCodeFactory.getOrderCode("log"));
		nursingLog.setNursingId(nursingID);
		nursingLog.setCustomerID(customerID);
		nursingLog.setOperator(operator);
		nursingLog.setOperate(operate);
		nursingLogDao.insert(nursingLog);
	}
	
	/**
	* 	根据id查询护理信息
	* @param nursingID  id
	* @return  护理信息
	*/
	@Override
	public NursingCenter queryNursingID(String nursingID) {
		
		return nursingCenterDao.selectById(nursingID);
	}
	
	/**
	 * 标准查询护理信息
	 * @param value      搜索关键词    
	 * @param step       护理步骤
	 * @param startDate  开始时间
	 * @param endDate    结束时间
	 * @param customerIds  门店权限
	 * @param orderBy    时间排序 0：降序，1：升序
	 * @param page       页数   
	 * @param rows       每页行数
	 * @param sign       停用标志  0-停用   1-启用
	 * @return   返回分页销售信息
	 */
	@Override
	public IPage<NursingCenterVO> queryNursings(String value, int step, Date startDate, Date endDate
			, List<String> customerIds, int orderBy, Integer page, Integer rows, String sign) throws ImoocMallException{
		
		
		//配置分页Page
		Page<NursingCenterVO> p = new Page<>(page, rows);
		//设置排序方式
		if ( orderBy == 0 ) {
			p.addOrder(OrderItem.desc("NursingCenter.CreateTime"));
		}
		
		//将查询的结果导入到IPage
		IPage<NursingCenterVO>  iPage = nursingCenterDao.selectNursings(value, step, startDate, endDate, customerIds
				, orderBy, sign, p);
		return iPage;
	}
	
	//查询护理详情信息
	@Override
	public NursingDetailsVo selectNursingDetails(String nursingID) {
		return nursingCenterDao.selectNursingDetails(nursingID);
	}
	
	/**
	 * 	停用护理id
	 * @param nursingID      护理id  
	 * @return   
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteNursingID(String nursingID, String customerID, String operator, String operate) {
		
		int row = nursingCenterDao.deleteNursingID(nursingID);
		//判断是否删除成功
		if ( row == 0 ) {
			throw new ImoocMallException(ImoocMallExceptionEnum.NOT_DELETE);
		}
		//登记日志
		NursingLog nursingLog =  new NursingLog();
		nursingLog.setLogId(OrderCodeFactory.getOrderCode("log"));
		nursingLog.setNursingId(nursingID);
		nursingLog.setCustomerID(customerID);
		nursingLog.setOperator(operator);
		nursingLog.setOperate(operate);
		nursingLogDao.insert(nursingLog);
	}

	/**
	 * 修改护理信息
	 * @param customerID  店铺编号
	 * @param remark      备注
	 * @param number      数量
	 * @param operator    操作人
	 * @param imagePaths  图片路径
	 * @throws SQLException
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editNursing(String nursingID, int step, String customerID, String remark, int number, String operator
			, String operate, List<String> imagePaths)throws SQLException, ImoocMallException{
		//判断图片是否为空
		String imagePath01 = null;
		if ( imagePaths != null ) {
			imagePath01 = imagePaths.get(0);
		}
		
		//更新信息
		int rows = nursingCenterDao.updateNursing(nursingID, customerID, remark, number, operator, operate, imagePath01);
		if ( rows == 0 ) {
			throw new ImoocMallException(ImoocMallExceptionEnum.NOT_UPDATE);
		}
		
		String imagePath02 = null;
		if ( imagePaths != null ) {
			for (String tempPath : imagePaths) {
				if ( imagePath02 == null ) {
					imagePath02 = tempPath;
				}else {
					imagePath02 =  imagePath02 + "," + tempPath;
				}
			}
		}
		rows = nursingProgressDao.updateNursing(nursingID, step, operator, imagePath02);
		if ( rows == 0 ) {
			throw new ImoocMallException(ImoocMallExceptionEnum.NOT_UPDATE);
		}
		
		//登记日志
		NursingLog nursingLog =  new NursingLog();
		nursingLog.setLogId(OrderCodeFactory.getOrderCode("log"));
	    nursingLog.setNursingId(nursingID);
		nursingLog.setCustomerID(customerID);
		nursingLog.setOperator(operator);
		nursingLog.setOperate(operate);
		nursingLogDao.insert(nursingLog);
	}

	/**
	 * 修改员工备注信息
	 * @param nursingID
	 * @param employeeRemake  员工备注
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateNursingEmployeeRemake(String nursingID, String employeeRemake
			, String operator, String operate) throws SQLException, ImoocMallException{
		int rows = nursingCenterDao.updateNursingEmployeeRemake(nursingID, employeeRemake);
		if ( rows == 0 ) {
			throw new ImoocMallException(ImoocMallExceptionEnum.NOT_UPDATE);
		}
		
		//登记日志
		NursingLog nursingLog =  new NursingLog();
		nursingLog.setLogId(OrderCodeFactory.getOrderCode("log"));
		nursingLog.setNursingId(nursingID);
		nursingLog.setOperator(operator);
		nursingLog.setOperate(operate);
		nursingLogDao.insert(nursingLog);
		return rows;
	}

	/**
	 * 推进员工进度
	 * @param nursingID         id
	 * @param step              护理进度
	 * @param customerID        店铺号
	 * @param operator          操作人
	 * @param operate           操作
	 * @param imagePaths        图片路径
	 * @return
	 * @throws SQLException
	 * @throws ImoocMallException
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int advanceNursingStep(String nursingID, int step, int score, String appraise, String operator, String operate
			, String customerID , List<String> imagePaths )throws SQLException, ImoocMallException {
		//更新护理进度
		int rows = nursingCenterDao.updateNursingStep(nursingID, step, score, appraise);
		if ( rows == 0 ) {
			throw new ImoocMallException(ImoocMallExceptionEnum.NOT_UPDATE);
		}
		
		//新增护理鞋进度
		NursingProgress nursingProgress = new NursingProgress();
		nursingProgress.setNursingProgressID(nursingID
				+new DecimalFormat("0").format(step));
		nursingProgress.setNursingID(nursingID);
		nursingProgress.setStep(step);
		nursingProgress.setOperator(operator);
		if ( imagePaths != null ) {
			for (String imagePath : imagePaths) {
				if ( nursingProgress.getImagePath() == null ) {
					nursingProgress.setImagePath(imagePath);
				}else {
					String psths =  imagePath + "," + nursingProgress.getImagePath();
					nursingProgress.setImagePath(psths);
				}
			}
		}
		nursingProgressDao.insert(nursingProgress);
		
		//登记日志
		NursingLog nursingLog =  new NursingLog();
		nursingLog.setLogId(OrderCodeFactory.getOrderCode("log"));
		nursingLog.setNursingId(nursingID);
		nursingLog.setOperator(operator);
		nursingLog.setOperate(operate);
		nursingLog.setCustomerID(customerID);
		nursingLogDao.insert(nursingLog);
		return rows;
	}

	/**
	 * 撤销员工进度
	 * @param nursingID         id
	 * @param step              护理进度
	 * @param operator          操作人
	 * @param operate           操作
	 * @return
	 * @throws SQLException
	 * @throws ImoocMallException
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int revokeNursingStep(String nursingID, int step, int score, String appraise, String operator, String operate, String customerID) throws SQLException, ImoocMallException {
		//更新护理进度
		int rows = nursingCenterDao.updateNursingStep(nursingID, step, score, appraise);
		if ( rows == 0 ) {
			throw new ImoocMallException(ImoocMallExceptionEnum.NOT_UPDATE);
		}
		
		//删除护理鞋进度
		QueryWrapper<NursingProgress> wrapper = new QueryWrapper<NursingProgress>();
		wrapper.eq("NursingID", nursingID);
		wrapper.eq("Step", step+1);
		nursingProgressDao.delete(wrapper);
		
		//登记日志
		NursingLog nursingLog =  new NursingLog();
		nursingLog.setLogId(OrderCodeFactory.getOrderCode("log"));
		nursingLog.setNursingId(nursingID);
		nursingLog.setOperator(operator);
		nursingLog.setOperate(operate);
		nursingLog.setCustomerID(customerID);
		nursingLogDao.insert(nursingLog);
		return rows;
	}
	
	
	
}


    













































