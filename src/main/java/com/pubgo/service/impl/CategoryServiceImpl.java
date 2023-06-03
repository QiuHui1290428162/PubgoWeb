package com.pubgo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.pubgo.bean.Category;
import com.pubgo.dao.CategoryDao;
import com.pubgo.service.CategoryService;
import com.pubgo.vo.CategoryVo;

/**
 *  	目录分类Service实现类
 * @author Administrator
 *
 */

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class CategoryServiceImpl implements CategoryService{

	@Resource
	public CategoryDao categoryDao;
	
	//查询目录列表
	@Override
	public List<CategoryVo> listCategory(Integer platform) {
		ArrayList<CategoryVo> categoryVoList = new ArrayList<>();
		//递归查询所有子目录
		recursivelyFindCategories(categoryVoList, platform, 0);
		return categoryVoList;
	}

	private void recursivelyFindCategories ( List<CategoryVo> categoryVoList
			, Integer platform, Integer parentId ) {
		//查询该父类id的所有子目录
		List<Category> categoryList = categoryDao
				.selectCategoriesByParentId(parentId, platform);
		//判断List集合是否为空
		if ( !CollectionUtils.isEmpty(categoryList) ) {
			//不为空，递归查询
			for ( int i=0; i<categoryList.size(); i++ ) {
				Category category = categoryList.get(i);
				CategoryVo categoryVo = new CategoryVo();
				//复制类的属性到目标类中
				BeanUtils.copyProperties(category, categoryVo);
				categoryVoList.add(categoryVo);
				recursivelyFindCategories(categoryVo.getCategorys(), platform, categoryVo.getId());
			}
		}
	}
}
























