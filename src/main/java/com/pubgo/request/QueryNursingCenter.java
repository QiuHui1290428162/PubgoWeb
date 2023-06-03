package com.pubgo.request;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

//查询护理信息
public class QueryNursingCenter {

	@Size(min=0, max=30, message="搜索关键词不能大于30个字符")
	private String value;          //搜索关键词
	@Max(value=3, message="护理步骤不能大于3")
	@Min(value=0, message="护理步骤不能于于0")
	private Integer step;          //护理步骤
	private Date startDate;        //开始时间
    private Date endDate;          //结束时间
	private Integer orderBy;       //时间排序 0：降序，1：升序
	private Integer page;          //页数   
	private Integer rows;          //每页行数
	private String sign;           //停用标志  0-停用   1-启用
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

	
}
