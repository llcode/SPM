<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
成功登陆<br>
<a
	href="userCountService!queryById?usercount.userid=${userInSession.userid}">${userInSession.name}</a>

<a href="userCountService!loginout">login out</a><br>

<s:iterator value="favoriteList">
	<s:property value="fid"/><br>
	<s:property value="name"/><br>
</s:iterator>
<a href="favoriteAdd.jsp">添加更多列表</a>
</body>
</html>