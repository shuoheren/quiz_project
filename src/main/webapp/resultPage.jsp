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
	<div>
		<h1 style="margin-left:20px; width:15%; background-color:red;">Result</h1>
		<div class ="container">
			<table id = "infoTable1">
				<tr><th>ID: </th><td>${userObj.userID} </td></tr>
				<tr><th>Username: </th><td>${userObj.userName} </td></tr>
				<tr><th>Full Name: </th><td>${userObj.firstName} ${userObj.lastName}</td></tr>
				<tr><th><input type="button" onclick="javascript:window.location.href:'homeServlet?oper=newQuiz'"/></th></tr>
			</table>
			
			<c:forEach var="result" items="${resultMap.values()}">
				<table id = "infoTable2" style="width:600px;">
				<tr>
					<th>Quiz: </th><td><c:out value="${result.quizID }"/></td>
				</tr>
				<tr>
					<th style="width:20%; margin-left:10px;">Result: </th>
					<c:choose>
						<c:when test="${result.result == 'P' }">
							<td style="width:20%">Pass</td>
						</c:when>
						<c:otherwise>
							<td>Failed</td>
						</c:otherwise>
					</c:choose>
					<th style="width:20%">Score:</th>
					<td style="width:20%"><c:out value="${result.getCorrectNum()*10}" /></td>
				</tr>
				<tr>
					<th>Start time:</th>
					<td id="tdTime"><c:out value="${quizMap[result.quizID].getStartTime() }" /></td>
					<th>End time:</th>
					<td id="tdTime"><c:out value="${quizMap[result.quizID].getEndTime() }"/></td>
				</tr>
			</table>
			</c:forEach>		
		</div>
	</div>
</body>
</html>