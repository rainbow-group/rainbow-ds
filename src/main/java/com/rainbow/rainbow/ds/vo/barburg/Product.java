package com.rainbow.rainbow.ds.vo.barburg;

import java.util.Date;

import com.rainbow.rainbow.annotation.Column;

public class Product {

	@Column(name = "id")
	Integer id;

	@Column(name = "category_id")
	Integer categoryId;

	@Column(name = "title")
	String title;

	@Column(name = "pic_url")
	String picUrl;

	@Column(name = "install_url")
	String installUrl;

	@Column(name = "order_by")
	Integer orderBy;

	@Column(name = "created_date")
	Date createdDate;

	@Column(name = "active_ind")
	String activeInd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getInstallUrl() {
		return installUrl;
	}

	public void setInstallUrl(String installUrl) {
		this.installUrl = installUrl;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
	}

}
