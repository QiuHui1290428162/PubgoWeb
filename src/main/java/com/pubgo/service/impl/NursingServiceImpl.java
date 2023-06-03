package com.pubgo.service.impl;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pubgo.bean.CStock;
import com.pubgo.bean.Nursing;
import com.pubgo.bean.NursingDetail;
import com.pubgo.bean.NursingProgress;
import com.pubgo.dao.NursingDao;
import com.pubgo.dao.NursingDetailDao;
import com.pubgo.dao.NursingProgressDao;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.exception.ImoocMallExceptionEnum;
import com.pubgo.service.NursingService;
import com.pubgo.utils.OrderCodeFactory;
import com.pubgo.vo.NursingVO;

//护理登记表
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class NursingServiceImpl implements NursingService {

	@Resource
	private NursingDao nursingDao;
	@Resource
	private NursingDetailDao nursingDetailDao;
	@Resource
	private NursingProgressDao nursingProgressDao;
	
	private String nursingID;
	
	/**
	 * 	新增护理信息
	 * @param tel           手机号     
	 * @param name          用户姓名
	 * @param customerID    店铺号
	 * @param step          护理进度
	 * @param score         评分
	 * @param appraise      评价
	 * @param input         录入方式
	 * @param payment       结算方式
	 * @param userRemake    用户备注
	 * @param employeeRemake  员工备注
	 * @param operator      营业员号
	 * @param nursingDetails  护理明细
	 * @param nursingDetails  停用标志
	 * @param imagePath     图片路径
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addNursing( String tel, String name, String customerID, int step
			, int score, String appraise, int input, String payment, String userRemake
			, String employeeRemake, String operator, List<NursingDetail> nursingDetails
			, String sign, String imagePath) {
		//生成护理单号
		nursingID = OrderCodeFactory.getOrderCode("HL");
		//新增护理鞋信息
		Nursing nursing = new Nursing();
		nursing.setNursingID(nursingID);
		nursing.setTel(tel);
		nursing.setUserName(name);
		nursing.setCustomerID(customerID);
		nursing.setStep(step);
		nursing.setScore(score);
		nursing.setAppraise(appraise);
		nursing.setInput(input);
		nursing.setPayment(payment);
		nursing.setUserRemake(userRemake);
		nursing.setEmployeeRemake(employeeRemake);
		nursing.setSign(sign);
		nursingDao.insert(nursing);
		
		//护理鞋总数
		int quantity = 0;
		//新增护理项目明细
		NursingDetail nursingDetail = new NursingDetail();
		for ( int i=0; i<nursingDetails.size(); i++ ) {
			nursingDetail.setNursingDetailID(nursingID
					+new DecimalFormat("00").format(i+1));
			nursingDetail.setNursingID(nursingID);
			nursingDetail.setItem(nursingDetails.get(i).getItem());
			nursingDetail.setRenge(nursingDetails.get(i).getRenge());
			nursingDetail.setNumber(nursingDetails.get(i).getNumber());
			nursingDetailDao.insert(nursingDetail);
			quantity += nursingDetails.get(i).getNumber();
		}
		
		//修改护理鞋总数,Nursing其它int类型也要修改，否则会默认为0
		Nursing nursingTemp = new Nursing();
		nursingTemp.setNursingID(nursingID);
		nursingTemp.setQuantity(quantity);
		nursingTemp.setStep(step);
		nursingTemp.setScore(score);
		nursingTemp.setInput(input);
		nursingDao.updateById(nursingTemp);
		
		//新增护理鞋进度
		NursingProgress nursingProgress = new NursingProgress();
		nursingProgress.setNursingProgressID(nursingID
				+new DecimalFormat("0").format(step));
		nursingProgress.setNursingID(nursingID);
		nursingProgress.setStep(step);
		nursingProgress.setOperator(operator);
		nursingProgress.setImagePath(imagePath);
		nursingProgressDao.insert(nursingProgress);
		
	}

	/**
	* 	根据手机号查询护理信息
	* @param tel  手机号
	* @return  护理信息
	*/
	@Override
	public List<Nursing> queryNursings(String tel) {
		QueryWrapper<Nursing> wrapper = new QueryWrapper<>();
		wrapper.eq("Tel", tel);
		
		return nursingDao.selectList(wrapper);
	}
		

	/**
	* 	根据手机号查询护理次数
	* @param tel
	* @return   护理次数
	*/
	@Override
	public int queryNursingNum(String tel) {
		QueryWrapper<Nursing> wrapper = new QueryWrapper<>();
		wrapper.eq("Tel", tel);
		
		return nursingDao.selectList(wrapper).size();
	}

	/**
	 * 
	 * @param value      搜索关键词    
	 * @param step       护理步骤
	 * @param startDate  开始时间
	 * @param endDate    结束时间
	 * @param status     用户身份，0:全部,1:会员,2:用户
	 * @param customerID 店铺号
	 * @param rgUser     员工号
	 * @param orderBy    时间排序 0：降序，1：升序
	 * @param page       页数   
	 * @param rows       每页行数
	 * @param sign       停用标志  0-停用   1-启用
	 * @return   返回分页销售信息
	 */
	@Override
	public IPage<NursingVO> queryNursings(String value, int step, Date startDate, Date endDate
			, int status, String customerID, String rgUser, int orderBy, Integer page
			, Integer rows, String sign){

		//配置分页Page
		Page<NursingVO> p = new Page<>(page, rows);
		//设置排序方式
		if ( orderBy == 0 ) {
			p.addOrder(OrderItem.desc("Nursing.CreateTime"));
		}
		
		//将查询的结果导入到IPage
		IPage<NursingVO>  iPage = nursingDao.selectNursings(value, step, startDate, endDate, status
				, customerID, rgUser, orderBy, sign, p);
		return iPage;
	}
	
	/**
	 * 	停用护理id
	 * @param nursingID      护理id  
	 * @return   
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteNursingID(String nursingID) {
		
		int row = nursingDao.deleteNursingID(nursingID);
		//判断是否删除成功
		if ( row == 0 ) {
			throw new ImoocMallException(ImoocMallExceptionEnum.NOT_DELETE);
		}
		
	}
	
	public String getNursingID() {
		return nursingID;
	}


	public void setNursingID(String nursingID) {
		this.nursingID = nursingID;
	}

	
	
	
	
}


































































