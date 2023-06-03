package com.pubgo.bean;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

//目录
@TableName("")
public class Category {

	@TableField("id")
	public int id;               //目录id
	@TableField("name")
	public String name;          //目录名称
	@TableField("level")
	public int level;            //层级
	@TableField("parentID")
	public int parentID;         //父目录id
	@TableField("orderNum")
	public int orderNum;         //统计目录排序
	@TableField("path")
	public String path;          //网页路径
	@TableField("image")
	public String image;         //图片路径  
	@TableField("platform")
	public int platform;         //平台     0-PC端，1—移动端
	@TableField("creteDate")
	public Date creteDate;       //创建时间
	@TableField("updateDate")
	public Date  updateDate;     //修改时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getPlatform() {
		return platform;
	}
	public void setPlatform(int platform) {
		this.platform = platform;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", level=" + level + ", parentID=" + parentID + ", orderNmae="
				+ orderNum + ", path=" + path + ", platform=" + platform + ", creteDate=" + creteDate + ", updateDate="
				+ updateDate + "]";
	}
}
