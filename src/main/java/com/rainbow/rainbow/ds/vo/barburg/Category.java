package com.rainbow.rainbow.ds.vo.barburg;

import com.rainbow.rainbow.annotation.Column;

public class Category {

	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "e_Name")
	private String eName;

	@Column(name = "order_by")
	private Integer orderBy;

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

}
