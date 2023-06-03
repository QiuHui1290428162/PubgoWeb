package com.pubgo.controller;

import java.io.IOException;
import java.sql.Timestamp;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.pubgo.utils.Constant;
import com.pubgo.utils.ResponseUtil;
import com.pubgo.bean.SysLog;
import com.pubgo.exception.ImoocMallExceptionEnum;
import com.pubgo.vo.NursingVO;

import net.coobird.thumbnailator.Thumbnails;

import com.pubgo.bean.BuisnessMan;
import com.pubgo.bean.NursingDetail;
import com.pubgo.property.InformationProperty;
import com.pubgo.request.QueryNursing;
import com.pubgo.service.BuisnessManService;
import com.pubgo.service.NursingService;
import com.pubgo.service.SysLogService;

@RestController
@RequestMapping("/register/nursing")
public class NursingController {

	@Resource
	private NursingService nursingServiceImpl;
	
	@Resource
	private BuisnessManService buisnessManServiceImpl;
	
	@Resource
	private SysLogService sysLogServiceImpl;
	
	@Resource
	public InformationProperty informationProperty;
	/**
	 * -新增护理记录带图片
	 * @param tel          手机号
	 * @param name         用户名称
	 * @param customerID   店铺号
	 * @param input        录入方式
	 * @param payment      结算方式
	 * @param step         护理进度
	 * @param userRemake   客户备注
	 * @param employeeRemake    员工备注
	 * @param nursingDetails    护理项目
	 * @param file              上传文件
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("/insertFile")
	public ResponseUtil addFile(String tel, String name, String customerID, int step
			, int score, String appraise, int input, String payment, String userRemake
			, String employeeRemake, String operator, String nursingDetail
			, @RequestParam("file") CommonsMultipartFile file, HttpSession session) 
					throws IllegalStateException, IOException {
		
	    ResponseUtil resp = new ResponseUtil();
	    
		//设置存放路径.file.getOriginalFilename()返回图片名称+后缀名
	    String path = Constant.NURSINGSTATICPATHS
	    		+new Date().getTime()+file.getOriginalFilename();
	    //通过CommonsMultipartFile 的方法直接写文件
	    //file.transferTo(new File(path));
	    
	    //压缩图片大小
	    try {
			Thumbnails.of(file.getInputStream())
			.scale(0.25f)
			.toFile(path);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseUtil(ImoocMallExceptionEnum.NOT_IMAGE_COMPRESSION);
		}
	        
	    //反序列化为List，在缺省情况下Jackson不能获得完整对象的泛型信息，使用CollectionType类获取实体类消息
		ObjectMapper mapper = new ObjectMapper();
		CollectionType javaType = mapper.getTypeFactory()
				      .constructCollectionType(List.class,NursingDetail.class);
		List<NursingDetail> nursingDetails = mapper.readValue(nursingDetail, javaType);
		
		//获取员工信息
		BuisnessMan buisnessMan = buisnessManServiceImpl
					.queryBuisnessMan((String)session.getAttribute(Constant.ID));
			
		//信息存储数据库中
		nursingServiceImpl.addNursing(tel, name, buisnessMan.getCustomerID(), step, score, appraise
				, input, payment, userRemake, employeeRemake, buisnessMan.getBuisnessManID()
				, nursingDetails, "1", path);
		
		return resp;

	}
	
	//不带图片上传
	@PostMapping("/insertText")
	public ResponseUtil addText(String tel, String name, String customerID, int step
			, int score, String appraise, int input, String payment, String userRemake
			, String employeeRemake, String operator, String nursingDetail
			,  HttpSession session) throws IllegalStateException, IOException  {
		
	    ResponseUtil resp = new ResponseUtil();
		
		//反序列化为List，在缺省情况下Jackson不能获得完整对象的泛型信息，使用CollectionType类获取实体类消息
		ObjectMapper mapper = new ObjectMapper();
		CollectionType javaType = mapper.getTypeFactory()
				      .constructCollectionType(List.class,NursingDetail.class);
		List<NursingDetail> nursingDetails = mapper.readValue(nursingDetail, javaType);
			
		//获取员工信息
		BuisnessMan buisnessMan = buisnessManServiceImpl
			.queryBuisnessMan((String)session.getAttribute(Constant.ID));
		
	    //信息存储数据库中
		nursingServiceImpl.addNursing(tel, name, buisnessMan.getCustomerID(), step, score, appraise
				, input, payment, userRemake, employeeRemake, buisnessMan.getBuisnessManID()
				, nursingDetails, "1", "");

		
		return resp;

	}
	
	//查询启用的客户护理信息
	@PostMapping("/queryNursings")
	public ResponseUtil queryNursings(@Valid @RequestBody QueryNursing queryNursing 
			, HttpSession session) {
		
		ResponseUtil resp = new ResponseUtil();
		
		//检查日期类是否为null
		java.sql.Date startDate = null;
		if ( queryNursing.getStartDate() != null ) {
			startDate = new java.sql.Date(queryNursing.getStartDate().getTime());
		}
		java.sql.Date endDate = null;
		if ( queryNursing.getEndDate() != null ) {
			endDate = new java.sql.Date(queryNursing.getEndDate().getTime());
		}
		
		//获取员工信息
		BuisnessMan buisnessMan = buisnessManServiceImpl
			.queryBuisnessMan((String)session.getAttribute(Constant.ID));
		
		IPage<NursingVO> iPage = nursingServiceImpl.queryNursings(queryNursing.getValue(), queryNursing.getStep()
				, startDate, endDate
				, queryNursing.getStatus(), buisnessMan.getCustomerID(), queryNursing.getRgUser()
				, queryNursing.getOrderBy(), queryNursing.getPage(), informationProperty.getRows()
				, "1");
		return resp.put("iPage", iPage);
	}
	
	//删除客户护理信息
	@GetMapping("/delete")
	public ResponseUtil removeNursingID(String nursingID, HttpSession session) {
		
		ResponseUtil resp = new ResponseUtil();
		//执行删除
		nursingServiceImpl.deleteNursingID(nursingID);
		//记录日志
		SysLog log = new SysLog();
		log.setClientHost("PubgoWeb");
		log.setUserNo((String)session.getAttribute(Constant.NAME));
		log.setLogTime(new Timestamp(System.currentTimeMillis()));
		log.setModuleName("护理管理");
		log.setAction("删除");
		log.setRemark("删除单号："+nursingID);
		
		sysLogServiceImpl.insertLog(log);
		return resp;
	}
}




























