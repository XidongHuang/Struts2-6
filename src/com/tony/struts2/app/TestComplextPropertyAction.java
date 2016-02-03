package com.tony.struts2.app;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tony.struts2.model.Department;

public class TestComplextPropertyAction extends ActionSupport implements ModelDriven<Department> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Department department;

	@Override
	public Department getModel() {

		department = new Department();

		return department;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(department);
		return SUCCESS;

	}

}
