<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>诗人列表</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<h1>所有诗人</h1>
<s:iterator value="authors">
	<a href="authorService!show?author.aid=<s:property value="aid" />"> <s:property
		value="name" /></a>
	<br>
	<s:property value="description" />
	<br>
</s:iterator>
<a href="authorAdd.jsp">添加诗人</a>
</body>
</html>