<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生诗词表</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<h1>生诗词列表</h1>
<s:iterator value="myNewPoems">
	<a href="poemService!show?poem.pid=<s:property value="poem.pid" />"><s:property
		value="poem.title" /></a>
	<br>
	<s:property value="%{poem.author.getName()}" />
	<br>
	<s:property value="poem.content" />
	<br>
	<a
		href="myNewPoemService!removePoem?myNewPoem.newpid=<s:property value="newpid"/>">从生诗词表删除</a>
	<br><hr>
</s:iterator>
开始测试吧
<a href="myNewPoemService!goTest?mode=easy">简单</a>
<a href="myNewPoemService!goTest?mode=normal">中等</a>
<a href="myNewPoemService!goTest?mode=hard">困难</a>
</body>
</html>