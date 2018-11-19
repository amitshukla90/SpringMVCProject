<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring4 MVC Project</title>
<script type="text/javascript">
function checkForValue(){
	var x = 1+3;
	var value = document.getElementById("empId").value;
	if(value == ""){
		alert();
		return false;
	}else{
		return true;
	}
}

function submitForSearch(){
	var value = document.getElementById("empIdSearch").value;
	if(value == ""){
		alert("Please enter value in Employee ID");
		return false;
	}else{
		document.getElementById("searchEmployeeForm").action = "seachEmployee.do";
		document.getElementById("searchEmployeeForm").submit();
	}
}
</script>
<style type="text/css">
.formError{
    color : red;
    font-weight: bold;
}
</style>
</head>
<body>
	<%-- 1- Changed to servlet (Java class same as SPring Contrller having various get post put delete methods) 
	 2 - home_jsp.java
	 3- home_jsp.class
	 4- Instance of home_jsp will be created
	 5- Init
	 6- service()
	 7- destroy

--%>
	<%! int val = 800; %>
	<%!
static int m = 90;
static{
 m = 100;	
}
    static int sum(int a, int b){
	System.out.println("Hello sum method");
	return a +b;
}
%>
	Hello!! this is my first web Application
	<br />
	<%
 String name ="Test Demo";
 out.println("My Name is ::"+ name);
 out.println();
 String mycontext = config.getInitParameter("contextConfigLocation");
 out.print("contextConfigLocation is ::"+ mycontext);
%>
	The time is now
	<%=new Date() %>
	<br />
	<%=name %>
	<br />
	<%="Sum of two numbers ::"+sum(val, val)%>
	<%=m %>

<!-- 	<form action="insertEmp.do" method="post" onsubmit="return checkForValue()"> -->
<!-- 		Enter FirstName :: <input type="text" name="firstName" id="firstName"> <br/>  -->
<!-- 		Enter LastName :: <input type="tt" name="lastName" id="lastName"> <br/>   -->
<!-- 		Enter Employee Id ::<input type="text" name="empId" id="empId"> <br/>  -->
<!-- 		Enter Employee Age :: <input type="text" name="empAge" id="empAge"> <br/>  -->
<!-- 		Enter Employee Role :: <input type="text" name=role id="role"> <br/>  -->
		
<!-- 		<input type="submit" value="Submit"><br/>  -->

<!-- 	</form> -->
	
	<springForm:form action="insertEmp.do" method="post" commandName="employee">
	    Enter FirstName :: <springForm:input path="firstName"/> <springForm:errors path="firstName" cssClass="formError"/> <br/> 
		Enter LastName :: <springForm:input path="lastName"/> <br/> 
		Enter Employee Id ::<springForm:input path="empid"/> <springForm:errors path="empid" cssClass="formError"/> <br/> 
		Enter Employee Age :: <springForm:input path="age"/> <springForm:errors path="age" cssClass="formError"/> <br/> 
		Enter Employee Role :: <springForm:input path="role"/><br/> 
	    <input type="submit" value="Submit"><br/> 
	</springForm:form>
	
	<form action="" method="get"
		id="searchEmployeeForm">
		Enter the EmpId to search:: <input type="text" name ="empIdSearch" id ="empIdSearch">
		<input type="button" value="Submit" onclick="submitForSearch()">

	</form>
	

</body>
</html>