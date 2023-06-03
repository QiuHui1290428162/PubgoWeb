package com.pubgo.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.pubgo.service.BuisnessManService;
import com.pubgo.service.RightService;

//用户账号工具类
@Component
public class UserUtil {

	@Resource
	private RightService rightServiceImpl;
	
	@Resource
	private BuisnessManService buisnessManServiceImpl;
	/**
	 *  获取店铺权限
	 * @param id    账号id
	 * @param type  账号类型
	 * @return
	 */
	public List<String> getCustomersID(String id,String type){
		List<String> customersIds = new ArrayList<String>();
		//判断用户类型
		if ( type.equals(Constant.STAFF) ) {
			//员工号获取店铺ID
			customersIds.add(buisnessManServiceImpl
					.queryBuisnessMan(id).getCustomerID());
			
		}else {
			//丽晶账号获取店铺ID
			customersIds = rightServiceImpl.queryRightById(id).getCustomers();
		}
		return customersIds;
	}
}






































