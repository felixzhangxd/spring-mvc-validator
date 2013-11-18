<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.error{
	color:red;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<form:form action="/declare/submit" commandName="user">
		<form:label path="username">username:</form:label><form:input path="username"/><form:errors path="username" cssClass="error"/><br/>
		<form:label path="password">password:</form:label><form:password path="password"/><form:errors path="password" cssClass="error"/><br/>
		<form:label path="repassword">repassword:</form:label><form:password path="repassword"/><form:errors path="repassword" cssClass="error"/><br/>
		<form:button>注册</form:button>
	</form:form>
</body>
</html>