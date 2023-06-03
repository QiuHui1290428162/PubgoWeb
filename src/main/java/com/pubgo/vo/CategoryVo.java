package com.pubgo.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//递归目录   
//实现redis缓存，需要实体类继承Serializable接口
public class CategoryVo {

	private Integer id;        

    private String name;        

    private Integer level;      

    private Integer parentID;   

    private Integer orderNum;  
    
    private String path;

	public String image;       
	
    private Date creteDate;    

    private Date updateDate;    

    private List<CategoryVo> Categorys = new ArrayList<CategoryVo>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getCreteDate() {
		return creteDate;
	}

	public void setCreteDate(Date creteDate) {
		this.creteDate = creteDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<CategoryVo> getCategorys() {
		return Categorys;
	}

	public void setCategorys(List<CategoryVo> categorys) {
		Categorys = categorys;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public String toString() {
		return "CategoryVo [id=" + id + ", name=" + name + ", level=" + level + ", parentID=" + parentID + ", orderNum="
				+ orderNum + ", path=" + path + ", creteDate=" + creteDate + ", updateDate=" + updateDate
				+ ", Categorys=" + Categorys + "]";
	};
    
    
	
	
}
