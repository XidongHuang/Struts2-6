package com.tony.struts2.app;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tony.struts2.model.Customer;

public class ConversionAction extends ActionSupport implements ModelDriven<Customer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	
	private Date birth;
	
	
	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String execute(){
	
		System.out.println("Model: " + model);
		
		return "success";
	}

	private Customer model;
	
	@Override
	public Customer getModel() {
		
		model = new Customer();
		
		return model;
		
		
	}
	
	
}
