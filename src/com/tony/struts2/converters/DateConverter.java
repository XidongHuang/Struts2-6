package com.tony.struts2.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {

	private DateFormat dateFormat;
	
	public DateConverter() {
		System.out.println("DateConverter's constructor...");
		
		
	
	}
	
	
	public DateFormat getDateFormat(){
		
		
		if(dateFormat == null){
			//Gain the current WEB application's initial parameters "pattern"
			ServletContext servletContext = ServletActionContext.getServletContext();
			String pattern = servletContext.getInitParameter("pattern");
			
			dateFormat = new SimpleDateFormat(pattern);
			
		} 
		
		return dateFormat;
	}
	
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		
		System.out.println("ConverFromString...");
		
		if(arg2 == Date.class){
			
			if(arg1 != null && arg1.length > 0){
				String value = arg1[0];
				try {
					return getDateFormat().parseObject(value);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		//If conversation is not successful
		return arg1;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		
		System.out.println("ConverToString...");
		if(arg1 instanceof Date){
			
			Date date = (Date)arg1;
			return getDateFormat().format(date);
			
		}
		
		//If conversation is not successful
		return null;
	}

}
