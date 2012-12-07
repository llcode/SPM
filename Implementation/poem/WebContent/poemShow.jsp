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
<h1>诗词信息：</h1>
<s:property value="poem.title" />
<br>
<s:property value="poem.author.name" />
<br>
<s:property value="poem.content" />
<br>
<s:property value="poem.translation" />
<br>
<s:property value="poem.explanation" />
<br>
<s:property value="poem.appreciation" />
<br>
<s:checkboxlist name="favorites" list="favoriteList"/>
<br>
<a href="poemService!edit?poem.pid=<s:property value="poem.pid" />">更新</a>
<a href="poemService!delete?poem.pid=<s:property value="poem.pid" />">删除</a><br>
<a href="poemService!index">返回列表</a>
</body>
</html>