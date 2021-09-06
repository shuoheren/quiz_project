<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz Result Display</title>
</head>
<body>
	<table>
	  <thead>
	    <tr>
	      <th>content</th>
	      <th>opts1</th>
	      <th>opts2</th>
	      <%-- <th>Question One<br/></th>
	      <th>A</th>
	      <th>B</th>
	      <th>C</th>
	      <th>D</th>
	      <th>Question Two</th>
	      <th>A</th>
	      <th>B</th>
	      <th>C</th>
	      <th>D</th>--%>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${quizzes}" var="quiz" >
	  	 <tr>
	      <td>${quiz.content}</td>
	      <td>${quiz.opts1}</td>
	      <td>${quiz.opts2}</td>
	      <%--<td>${quiz.q1t}</td>
	      <td>${quiz.q1a}</td>
	      <td>${quiz.q1b}</td>
	      <td>${quiz.q1c}</td>
	      <td>${quiz.q1d}</td>
	      <td>${quiz.q2t}</td>
	      <td>${quiz.q2a}</td>
	      <td>${quiz.q2b}</td>
	      <td>${quiz.q2c}</td>
	      <td>${quiz.q2d}</td>--%>
	     </tr>
	  	</c:forEach>
	  </tbody>
	</table>
	<%out.println("type your answer in the box");%>
	<form method = "post">
		<input type="text" name="answer">
		<input type="submit" value="submit">
	</form>
		<%session.setAttribute("answer", "answer"); %>

</body>
</html>