package com.pubgo.controller.Client;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.pubgo.utils.Constant;
import com.pubgo.utils.ResponseUtil;
import com.pubgo.bean.NursingDetail;
import com.pubgo.property.InformationProperty;
import com.pubgo.service.BuisnessManService;
import com.pubgo.service.NursingService;
import com.pubgo.service.SysLogService;

@RestController
@RequestMapping("/frontEnd/register/nursing")
public class NursingClientController {

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
			, @RequestParam("file") CommonsMultipartFile file) 
					throws IllegalStateException, IOException {
		
	    ResponseUtil resp = new ResponseUtil();
	    
		//设置存放路径.file.getOriginalFilename()返回图片名称+后缀名
	    String path = Constant.NURSINGSTATICPATHS
	    		+new Date().getTime()+file.getOriginalFilename();
	    //通过CommonsMultipartFile 的方法直接写文件
	    file.transferTo(new File(path));
	        
	    //反序列化为List，在缺省情况下Jackson不能获得完整对象的泛型信息，使用CollectionType类获取实体类消息
		ObjectMapper mapper = new ObjectMapper();
		CollectionType javaType = mapper.getTypeFactory()
				      .constructCollectionType(List.class,NursingDetail.class);
		List<NursingDetail> nursingDetails = mapper.readValue(nursingDetail, javaType);
		
			
		//信息存储数据库中
		nursingServiceImpl.addNursing(tel, name, customerID, step, score, appraise
				, input, payment, userRemake, employeeRemake, "", nursingDetails, "1", path);
		
		return resp;

	}
	
	//不带图片上传
	@PostMapping("/insertText")
	public ResponseUtil addText(String tel, String name, String customerID, int step
			, int score, String appraise, int input, String payment, String userRemake
			, String employeeRemake, String operator, String nursingDetail) 
			throws IllegalStateException, IOException {
		
	    ResponseUtil resp = new ResponseUtil();
		
		//反序列化为List，在缺省情况下Jackson不能获得完整对象的泛型信息，使用CollectionType类获取实体类消息
		ObjectMapper mapper = new ObjectMapper();
		CollectionType javaType = mapper.getTypeFactory()
				      .constructCollectionType(List.class,NursingDetail.class);
		List<NursingDetail> nursingDetails = mapper.readValue(nursingDetail, javaType);
			

		
	    //信息存储数据库中
		nursingServiceImpl.addNursing(tel, name, customerID, step, score, appraise
				, input, payment, userRemake, employeeRemake, "", nursingDetails, "1", "");

		
		return resp;

	}

}




























