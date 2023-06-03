package com.pubgo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pubgo.bean.Right;
import com.pubgo.dao.RightDao;
import com.pubgo.exception.ImoocMallException;
import com.pubgo.exception.ImoocMallExceptionEnum;
import com.pubgo.service.RightService;

//丽晶用户管理用户业务层
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class RightServiceImpl implements RightService {

	@Resource
	private RightDao dao;
	
	@Override
	public Right queryRightById(String id) throws ImoocMallException{
		Right right = dao.selectRightById(id);
		
		//判断用户权限是否包含 ”全部“
		if ( right != null ) {
			if ( right.getCustomers() == null ) {
				throw new ImoocMallException(ImoocMallExceptionEnum.ERROR_CUSTOMER_PERMISSION);
			}else {
				for (String customer : right.getCustomers()) {
					if ( customer.equals("全部") ) {
						List<String> customers = new ArrayList<>();
						customers.add("全部");
						right.setCustomerId(customers);
						break;
					}
				}
			}
		}
		return right;
	}

}
