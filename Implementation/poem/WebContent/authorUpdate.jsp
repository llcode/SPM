<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑诗人</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<h1>编辑诗人信息</h1>
<s:form action="authorService!update">
	<s:hidden name="author.aid"></s:hidden>
	<s:textfield name="author.name"></s:textfield>
	<s:textarea name="author.description"></s:textarea>
	<s:submit></s:submit>
</s:form>
</body>
</html>