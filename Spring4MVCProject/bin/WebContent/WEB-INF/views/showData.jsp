<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Data</title>
<link rel="stylesheet" href="<c:url value='/css/showData.css'/>">
<script ></script>
<script>
function sayHello(){
	alert("Hello");
}

function validate(){
	var input = document.getElementById("salary").value;
	if(input == ""){
		alert("Please fill a value into the text box");
	}else {
		alert("Values is ::"+ input);
		document.getElementById("salary").value ="";
	}
}
</script>
</head>
<body onload="sayHello()">

<%
String val = "Hello this is show data";
//String salVal = request.getParameter("salary");
//response.sendRedirect("https://www.google.com");

out.print(val);
%>
<br/>
<h1>My show data View Page</h1>
<h2>My show data View Page</h2>
<h3 class="setCss">My show data View Page</h3>
<h4>My show data View Page</h4>
<b>My salary Value is :: </b> ${mySalVal}</br>

<input type="text" name ="salary" id ="salary"></br>

<button type="button" onclick="validate()"> Validate</button>
</body>

</html>