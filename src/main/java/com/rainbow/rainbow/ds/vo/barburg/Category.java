package com.rainbow.rainbow.ds.vo.barburg;

import com.rainbow.rainbow.annotation.Column;

public class Category {

	@Column(name = "id")
	Integer id;

	@Column(name = "name")
	String name;

	@Column(name = "e_Name")
	String eName;

	@Column(name = "order_by")
	Integer orderBy;

	@Column(name = "active_ind")
	String activeInd;

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

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
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

}
