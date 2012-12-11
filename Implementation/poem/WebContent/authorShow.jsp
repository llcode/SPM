<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>诗人信息</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<h1>${author.name }的信息</h1>
姓名:
<s:property value="author.name" />
<br>
简介
<br>
<s:property value="author.description" />
<br>
<a
	href="authorService!edit?author.aid=<s:property value="author.aid" />">更新</a>
<a
	href="authorService!delete?author.aid=<s:property value="author.aid" />">删除</a>
<br>
诗集
<br>
<s:iterator value="poems">
	<a href="poemService!show?poem.pid=<s:property value="pid" />"><s:property
		value="title" /></a>
	<br>
	<s:property value="content"></s:property>
	<br>
</s:iterator>

</body>
</html>