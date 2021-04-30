package com.rainbow.rainbow.ds.vo.barburg;

import com.rainbow.rainbow.annotation.Column;

public class ProdInfoItem {

	@Column(name = "id")
	Integer id;

	@Column(name = "prod_id")
	Integer prodId;

	@Column(name = "content")
	String content;

	@Column(name = "order_by")
	Integer orderBy;

	@Column(name = "active_ind")
	String activeInd;

	@Column(name = "img_tag")
	String imgTag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public String getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
	}

	public String getImgTag() {
		return imgTag;
	}

	public void setImgTag(String imgTag) {
		this.imgTag = imgTag;
	}

}
