<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		Question1: How to Overwrite exception message?
			1) Build a new ActionClassName.properties file in the Action class,
		       ActionClassName includes the name of input string Action class
			2) Add Key-Value pair in the attribute file:
		       invalid.filedvalue.fieldName=xxx
		
		Question2: Will the exception message be shown when the theme is simple?
		     	   If not, what should we do?
			1) From debug tag, we can find the "fieldError" attribute, 
			and it is in the Action(implements ValidationAware interface)
			that is on the top of valueStack.
			Such attribute's type is Map<String, List<String>> Key: String(attribute name), Value: Exception Message List
			So we can use LE or OGNL to show Exception Message: ${fieldErrors.age[0]}
			
			2) Or use s:fielderror.  Can use attribute "fieldName" to show a specific error String.
	
		Question3: In simple theme, <s:fielderror fieldName="age"></s:fielderror> will show
				   Exception Messages in ul, li, span. How to get rid of ul, li, span?
				   In template.simple, "fielderror.ftl" defines "s:fielderror" format in simple theme.
				   So modify this configure file.
				   Create a "template.simple" package in "src", and "fielderror.ftl" file, copy
				   the original "fielderror.ftl" in the new one, and delete ul, li, span 
				
				
		Question 4: How to define a conversion?
			1) Why need to define it?
			   Because Struts cannot achieve the conversion from "String" to "Reference" type.		
			   
			2) How to define a conversion:
			I. Developing type conversion class: Expand "StrutsTypeConverter" class
			II. Configure converter:
				a. Base on String to configure:
					> In String's Model(maybe is Action, or JavaBean) package,
					  create a ModelClassName-conversion.property
					> In the file: fieldName= typeConverter's full class name
					> It will create a converter instance at the first time.
					> typeConverter is singleton!
				
				b. Base type to configure:
					> In src, create xwork-conversion.properties
					> Key: converted type=typeConverter's full class name
					> It will be create an instance when the current Struts2 application is loaded
					> 
	 -->
	<s:debug></s:debug>

	<s:form action="testConversion" theme="simple">
		<s:textfield name="age" label="Age"></s:textfield>
		${fieldErrors.age[0] }
		<s:fielderror fieldName="age"></s:fielderror>
		<br><br>
		<s:textfield name="birth" label="Birth"></s:textfield>
		<s:fielderror fieldName="birth"></s:fielderror>
		<br><br>
		<s:submit></s:submit>
	
	</s:form>

</body>
</html>