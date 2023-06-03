package com.pubgo.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pubgo.bean.Category;

//目录导层
public interface CategoryDao extends BaseMapper<Category>{

	/**
	 * 	查询该父id的所有子目录
	 * @param parentId  父目录id
	 * @param platform  平台
	 * @return
	 */
	public List<Category> selectCategoriesByParentId(Integer parentId, Integer platform);
}
