package com.pubgo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pubgo.utils.Constant;
import com.pubgo.utils.FileUtil;
import com.pubgo.utils.ResponseUtil;
import com.pubgo.utils.UserUtil;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.exception.ImoocMallExceptionEnum;
import com.pubgo.vo.NursingCenterVO;
import com.pubgo.vo.NursingDetailsVo;

import net.coobird.thumbnailator.Thumbnails;

import com.pubgo.bean.BuisnessMan;
import com.pubgo.bean.NursingCenter;
import com.pubgo.bean.NursingLog;
import com.pubgo.bean.Right;
import com.pubgo.bean.SysLog;
import com.pubgo.property.InformationProperty;
import com.pubgo.request.QueryNursingCenter;
import com.pubgo.service.BuisnessManService;
import com.pubgo.service.NursingCenterService;
import com.pubgo.service.NursingLogService;
import com.pubgo.service.RightService;
import com.pubgo.service.SysLogService;

@RestController
@RequestMapping("/register/nursingCentel/")
public class NursingCenterController {

	@Resource
	private NursingCenterService nursingCenterServiceImpl;
	
	@Resource
	private NursingLogService nursingLogServiceImpl;
	
	@Resource
	private BuisnessManService buisnessManServiceImpl;
	
	@Resource
	private InformationProperty informationProperty;
	
	@Resource
	private UserUtil userUtil;
	
	/**
	 * -新增护理记录带图片
	 * @param step      护理进度
	 * @param remark    备注
	 * @param number    数量
	 * @param file      上传文件
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("insertFile")
	public ResponseUtil addFile(int step, String remark, int number
	        , @RequestParam("files") List<CommonsMultipartFile> files, HttpSession session){
		
	    ResponseUtil resp = new ResponseUtil();
	    
	    //存储文件，并返回路径
	    List<String> imagePaths = FileUtil.saveFile(files);
		
		//获取员工信息
		BuisnessMan buisnessMan = buisnessManServiceImpl
					.queryBuisnessMan((String)session.getAttribute(Constant.ID));
			
		//信息存储数据库中
		try {
			nursingCenterServiceImpl.addNursing( buisnessMan.getCustomerID(), step, remark, number
					, buisnessMan.getName(), "1", "登记数量"+number, imagePaths);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		return resp;

	}
	
	//不带图片上传
	@PostMapping("insertText")
	public ResponseUtil addText(int step, String remark, int number, HttpSession session) {
		
	    ResponseUtil resp = new ResponseUtil();
			
		//获取员工信息
		BuisnessMan buisnessMan = buisnessManServiceImpl
			.queryBuisnessMan((String)session.getAttribute(Constant.ID));
		
	    //信息存储数据库中
		try {
			nursingCenterServiceImpl.addNursing(buisnessMan.getCustomerID(), step, remark, number
					, buisnessMan.getName(), "1", "未上传图片, 登记数量"+number, null);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}

		
		return resp;

	}
	
	//查询启用的客户护理信息
	@PostMapping("queryNursings")
	public ResponseUtil queryNursings(@Valid @RequestBody QueryNursingCenter queryNursingCenter 
			, HttpSession session) {
		
		//检查日期类是否为null
		java.sql.Date startDate = null;
		if ( queryNursingCenter.getStartDate() != null ) {
			startDate = new java.sql.Date(queryNursingCenter.getStartDate().getTime());
		}
		java.sql.Date endDate = null;
		if ( queryNursingCenter.getEndDate() != null ) {
			endDate = new java.sql.Date(queryNursingCenter.getEndDate().getTime());
		}
		
		//获取账号店铺权限
		List<String> customerIds = userUtil.getCustomersID((String)session.getAttribute(Constant.ID)
				, (String)session.getAttribute(Constant.TYPE));
		
		IPage<NursingCenterVO> iPage = null;
		try {
			iPage = nursingCenterServiceImpl.queryNursings(queryNursingCenter.getValue(), queryNursingCenter.getStep()
					, startDate, endDate, customerIds, queryNursingCenter.getOrderBy(), queryNursingCenter.getPage(), informationProperty.getRows()
					, "1");
		} catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		
		
		return new ResponseUtil().put("iPage", iPage);
	}
	
	//查询护理订单详情
	@GetMapping("queryNursingDetails")
	public ResponseUtil queryNursingDetails(String nursingID, HttpSession session) {
		
		//判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    
	    NursingDetailsVo nursingDetailsVo = nursingCenterServiceImpl.selectNursingDetails(nursingID);
	    List<NursingLog> nursingLogs = nursingLogServiceImpl.selectByNursingID(nursingID);
	    if ( nursingDetailsVo==null || nursingLogs==null) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.NOT_ID);
	    }
	    
		return new ResponseUtil().put("nursingDetailsVo", nursingDetailsVo).put("nursingLogs", nursingLogs);
	}
	
	//删除客户护理信息
	@PostMapping("staff/delete")
	public ResponseUtil removeNursingID(String nursingID, HttpSession session) {
		
		ResponseUtil resp = new ResponseUtil();
		
		//判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    if ( nursingCenter.getStep() != 1 ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ORDER_CONFIRMED);
	    }
		
		//获取员工信息
		BuisnessMan buisnessMan = buisnessManServiceImpl
			.queryBuisnessMan((String)session.getAttribute(Constant.ID));
		
		//执行删除
		nursingCenterServiceImpl.deleteNursingID(nursingID,buisnessMan.getCustomerID(),buisnessMan.getName(),"删除护理信息");
	
		return resp;
	}	
	
	/**
	 * -修改护理记录带图片
	 * @param step      护理进度
	 * @param remark    备注
	 * @param number    数量
	 * @param file      上传文件
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("staff/updateNusingFile")
	public ResponseUtil updateNusingFile(String nursingID, int step, String remark, int number
	        , @RequestParam("files") List<CommonsMultipartFile> files, HttpSession session){
		
	    ResponseUtil resp = new ResponseUtil();
	    
	    //判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    if ( nursingCenter.getStep() != 1 ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ORDER_CONFIRMED);
	    }
	    
	    //存储文件，并返回路径
	    List<String> imagePaths = FileUtil.saveFile(files);

		
		//获取员工信息
		BuisnessMan buisnessMan = buisnessManServiceImpl
					.queryBuisnessMan((String)session.getAttribute(Constant.ID));
			
		//修改数据
		try {
			nursingCenterServiceImpl.editNursing(nursingID, step, buisnessMan.getCustomerID()
					, remark, number, buisnessMan.getName(), "替换图片, 修改数量"+number, imagePaths);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		
		//返回修改后的数据
		return resp;

	}
	
	//修改护理记录不带图片
	@PostMapping("staff/updateNusingText")
	public ResponseUtil updateNusingText(String nursingID, int step, String remark, int number
	        , HttpSession session){
		
	    ResponseUtil resp = new ResponseUtil();
			
	    //判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    if ( nursingCenter.getStep() != 1 ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ORDER_CONFIRMED);
	    }
	    
		//获取员工信息
		BuisnessMan buisnessMan = buisnessManServiceImpl
			.queryBuisnessMan((String)session.getAttribute(Constant.ID));
		
		//修改数据
		try {
			nursingCenterServiceImpl.editNursing(nursingID, step, buisnessMan.getCustomerID()
					, remark, number, buisnessMan.getName(), "修改数量"+number, null);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		
		
		return resp;

	}
	
	//修改员工备注信息
	@PostMapping("update/updateNursingEmployeeRemake")
	public ResponseUtil updateNursingEmployeeRemake(String nursingID, String employeeRemake, HttpSession session){
		ResponseUtil resp = new ResponseUtil();
		
		 //判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    
	    //修改员工备注
	    try {
			nursingCenterServiceImpl.updateNursingEmployeeRemake(nursingID, employeeRemake,(String)session.getAttribute(Constant.NAME)
					, "备注信息 ("+employeeRemake+" ) ");
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		
		return resp.put("employeeRemake", employeeRemake);
	}
	
	/**
	 * 推进员工进度带图片
	 * @param nursingID   id
	 * @param step        护理进度
	 * @param files       图片文件
	 * @param session
	 * @return
	 */
	@PostMapping("update/advanceNursingStepFile")
	public ResponseUtil advanceNursingStepFile(String nursingID, int step, @RequestParam("files") List<CommonsMultipartFile> files, HttpSession session){
		
	    ResponseUtil resp = new ResponseUtil();
	    
	    //判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    if ( nursingCenter.getStep()+1 != step ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_STEP_CHANGED);
	    }
	    
	    //存储文件，并返回路径
	    List<String> imagePaths = FileUtil.saveFile(files);
			
	    //
	    String operate = "";
	    if ( step == 2 ) {
	    	operate = "确认订单";
	    }else if ( step == 3 ) {
	    	operate = "订单发货";
	    }
	    
		//修改数据
		try {
			nursingCenterServiceImpl.advanceNursingStep(nursingID, step, 0, "", (String)session.getAttribute(Constant.NAME)
					, operate, null, imagePaths);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		
		NursingCenterVO nursingCenterVO = nursingCenterServiceImpl.queryNursings(nursingID, 0, null, null, null, 0, 1, 10, "1").getRecords().get(0);
		//返回修改后的数据
		return resp.put("nursingCenterVO", nursingCenterVO);

	}
	
	/**
	 * 推进员工进度不带图片
	 * @param nursingID   id
	 * @param step        护理进度
	 * @param session
	 * @return
	 */
	@PostMapping("update/advanceNursingStepText")
	public ResponseUtil advanceNursingStepText(String nursingID, int step, HttpSession session){
		
	    ResponseUtil resp = new ResponseUtil();
	    
	    //判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    if ( nursingCenter.getStep()+1 != step ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_STEP_CHANGED);
	    }
			
	    //
	    String operate = "";
	    if ( step == 2 ) {
	    	operate = "确认订单,未上传图片";
	    }else if ( step == 3 ) {
	    	operate = "订单发货,未上传图片";
	    }
	    
		//修改数据
		try {
			nursingCenterServiceImpl.advanceNursingStep(nursingID, step, 0, "", (String)session.getAttribute(Constant.NAME)
					, operate, null, null);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		
		NursingCenterVO nursingCenterVO = nursingCenterServiceImpl.queryNursings(nursingID, 0, null, null, null, 0, 1, 10, "1").getRecords().get(0);
		//返回修改后的数据
		return resp.put("nursingCenterVO", nursingCenterVO);

	}
	
	/**
	 * 撤销员工进度
	 * @param nursingID   id
	 * @param step        护理进度
	 * @param session
	 * @return
	 */
	@PostMapping("update/revokeNursingStep")
	public ResponseUtil revokeNursingStep(String nursingID, int step,  HttpSession session){
		
	    ResponseUtil resp = new ResponseUtil();
	    
	    //判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    if ( nursingCenter.getStep()-1 != step ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_STEP_CHANGED);
	    }

	    //
	    String operate = "";
	    if ( step == 1 ) {
	    	operate = "取消确认";
	    }else if ( step == 2 ) {
	    	operate = "取消发货";
	    }
	    
		//修改数据
		try {
			nursingCenterServiceImpl.revokeNursingStep(nursingID, step, 0, "", (String)session.getAttribute(Constant.NAME)
					, operate, null);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		
		NursingCenterVO nursingCenterVO = nursingCenterServiceImpl.queryNursings(nursingID, 0, null, null, null, 0, 1, 10, "1").getRecords().get(0);
		//返回修改后的数据
		return resp.put("nursingCenterVO", nursingCenterVO);

	}
	
	/**
	 * 推进员工进度带图片
	 * @param nursingID   id
	 * @param step        护理进度
	 * @param files       图片文件
	 * @param score       评分
	 * @param appraise    评价
	 * @param session
	 * @return
	 */
	@PostMapping("staff/advanceNursingStepFile")
	public ResponseUtil advanceNursingStepFile(String nursingID, int step, int score, String appraise, @RequestParam("files") List<CommonsMultipartFile> files, HttpSession session){
		
	    ResponseUtil resp = new ResponseUtil();
	    
	    //判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    if ( nursingCenter.getStep()+1 != step ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_STEP_CHANGED);
	    }
	    
	    //存储文件，并返回路径
	    List<String> imagePaths = FileUtil.saveFile(files);
			
	    //
	    String operate = "";
	    if ( step == 4 ) {
	    	operate = "确认收货，评分"+score+"星";
	    }
	    
	  //获取员工信息
	  	BuisnessMan buisnessMan = buisnessManServiceImpl
	  		.queryBuisnessMan((String)session.getAttribute(Constant.ID));
	    
		//修改数据
		try {
			nursingCenterServiceImpl.advanceNursingStep(nursingID, step, score, appraise, (String)session.getAttribute(Constant.NAME)
					, operate, buisnessMan.getCustomerID(), imagePaths);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		
		NursingCenterVO nursingCenterVO = nursingCenterServiceImpl.queryNursings(nursingID, 0, null, null, null, 0, 1, 10, "1").getRecords().get(0);
		//返回修改后的数据
		return resp.put("nursingCenterVO", nursingCenterVO);

	}
	
	/**
	 * 推进员工进度不带图片
	 * @param nursingID   id
	 * @param step        护理进度
	 * @param score       评分
	 * @param appraise    评价
	 * @param session
	 * @return
	 */
	@PostMapping("staff/advanceNursingStepText")
	public ResponseUtil advanceNursingStepText(String nursingID, int step, int score, String appraise, HttpSession session){
		
	    ResponseUtil resp = new ResponseUtil();
	    
	    //判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    if ( nursingCenter.getStep()+1 != step ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_STEP_CHANGED);
	    }
			
	    //
	    String operate = "";
	    if ( step == 4 ) {
	    	operate = "确认收货，评分"+score+"星，未上传图片";
	    }
	  
	  //获取员工信息
	  	BuisnessMan buisnessMan = buisnessManServiceImpl
	  		.queryBuisnessMan((String)session.getAttribute(Constant.ID));
	    
		//修改数据
		try {
			nursingCenterServiceImpl.advanceNursingStep(nursingID, step, score, appraise, (String)session.getAttribute(Constant.NAME)
					, operate, buisnessMan.getCustomerID(), null);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		
		NursingCenterVO nursingCenterVO = nursingCenterServiceImpl.queryNursings(nursingID, 0, null, null, null, 0, 1, 10, "1").getRecords().get(0);
		//返回修改后的数据
		return resp.put("nursingCenterVO", nursingCenterVO);

	}
	
	/**
	 * 撤销员工进度
	 * @param nursingID   id
	 * @param step        护理进度
	 * @param score       评分
	 * @param appraise    评价
	 * @param session
	 * @return
	 */
	@PostMapping("staff/revokeNursingStep")
	public ResponseUtil revokeNursingStep(String nursingID, int step, int score, String appraise,  HttpSession session){
		
	    ResponseUtil resp = new ResponseUtil();
	    
	    //判断护理信息是否已停用
	    NursingCenter nursingCenter = nursingCenterServiceImpl.queryNursingID(nursingID);
	    if ( nursingCenter.getSign().equals("0") ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_DATE_HAS_BEEN_DELETED);
	    }
	    if ( nursingCenter.getStep()-1 != step ) {
	    	return new ResponseUtil(ImoocMallExceptionEnum.ERROR_STEP_CHANGED);
	    }

	    //
	    String operate = "";
	    if ( step == 1 ) {
	    	operate = "取消确认";
	    }else if ( step == 2 ) {
	    	operate = "取消发货";
	    }else if ( step == 3 ) {
	    	operate = "取消收货";
	    }else if ( step == 3 ) {
	    	operate = "取消收货";
	    }
	    
	  //获取员工信息
	  	BuisnessMan buisnessMan = buisnessManServiceImpl
	  		.queryBuisnessMan((String)session.getAttribute(Constant.ID));
	    
	    
		//修改数据
		try {
			nursingCenterServiceImpl.revokeNursingStep(nursingID, step, score, appraise, (String)session.getAttribute(Constant.NAME)
					, operate, buisnessMan.getCustomerID());
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getErrorCode(),e.getMessage());
		}  catch (ImoocMallException e) {
			e.printStackTrace();
			return new ResponseUtil(e.getCode(),e.getMsg());
		}
		
		NursingCenterVO nursingCenterVO = nursingCenterServiceImpl.queryNursings(nursingID, 0, null, null, null, 0, 1, 10, "1").getRecords().get(0);
		//返回修改后的数据
		return resp.put("nursingCenterVO", nursingCenterVO);

	}
}




























