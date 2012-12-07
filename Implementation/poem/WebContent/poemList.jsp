<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>诗词列表</title>
</head>
<body>
<h1>诗词列表</h1>

<s:iterator value="list">
	<a href="poemService!show?poem.pid=<s:property value="pid" />"><s:property
		value="title" /></a>
	<br>
	<s:property value="%{author.getName()}" />
	<br>
	<s:property value="content" />
	<br>
	<hr>
</s:iterator>
<a href="poemAdd.jsp">添加新诗词</a>
</body>
</html>