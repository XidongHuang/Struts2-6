package com.tony.struts2.model;


/**
 * 1. Department is a model, which is the Department class.
 * deptName can be written to the "name" of "s:textfield". How abut mgr attribute?
 * 
 * the "name" attribute of Struts2 form tag can be specified to attribute's attribute
 * like: name=mgr.name, name=mgr.birth  
 * 
 * 
 * 2. mgr has a type "Date", can Struts2 transform it automatically?
 *
 * Global type conversation works fine!
 * 
 * @author tony
 *
 */

public class Department {

	private Integer id;
	private String deptName;

	private Manager mgr;

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", mgr=" + mgr + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Manager getMgr() {
		return mgr;
	}

	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}
}
