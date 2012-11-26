<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h4>输入诗词编号，我将把它添加到生诗词表</h4>
	<s:form action="myNewPoemService!addMyNewPoem">
		<s:textfield label="诗词编号" name="poem.pid"></s:textfield>
		<s:submit></s:submit>
	</s:form>
</center>
</body>
</html>