package com.pubgo.service;

import java.util.List;
import com.pubgo.vo.CategoryVo;

//目录列表
public interface CategoryService {

	/**
	 * 	查询目录列表
	 * @param platform   平台     0-PC端，1—移动端
	 * @return
	 */
	public List<CategoryVo> listCategory(Integer platform);
}
