<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring4 MVC Project</title>
<script type="text/javascript">
function checkForValue(){
	var x = 1+3;
	var value = document.getElementById("sal").value;
	if(value == ""){
		alert();
		return false;
	}else{
		return true;
	}
}
</script>
<style type="text/css">

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
<br/>
<%
 String name ="Test Demo";
 out.println("My Name is ::"+ name);
 out.println();
 String mycontext = config.getInitParameter("contextConfigLocation");
 out.print("contextConfigLocation is ::"+ mycontext);
%>
The time is now <%=new Date() %>
<br/>
<%=name %>
<br/>
<%="Sum of two numbers ::"+sum(val, val)%>
<%=m %>

<form action="showData.do" method="get" onsubmit="return checkForValue()">
<input type="text" name ="salary" id ="sal"> </br>
<input type="submit" value="Submit"></br>

</form>

</body>
</html>