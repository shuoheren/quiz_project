<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
<body>
	<div id="register">
		<br/>
		<h2 style="text-align: center;"> Login your account for online quiz!</h2>
		<br/>
		<form action="loginServlet" method="POST" style="text-align: center">
			<div style="padding: 10px"> Username : <input type="text" name="username" style="border: 2px solid"/></div>			
			<div style="padding: 10px"> Password  :  <input type="text" name="password" style="border: 2px solid; margin-left:5px"/></div>
			<div style="padding: 5px"><input type="submit" value= "Login" style="margin-top:10px; margin-left:46px"/></div>	
		</form>
		<form action="registerServlet" style="text-align: center; margin-top:5px; margin-left:46px">
			<div><input type="submit"  value="Register"/></div>
		</form>
		<div>
			<c:if test="${not empty loginError}">
				<script>
					window.addEventListener("load", function(){
						alert("${loginError}");
					})
				</script>
			</c:if>
		</div>
		
	
	</div>
	
</body>
</html>