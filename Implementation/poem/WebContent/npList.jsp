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
<div id="Wrapper">
<div id="Main">
<div class="sep10"></div>
<div class="box">
<div class="cell">
<h1>生诗词列表</h1>
</div>
<s:iterator value="myNewPoems">
	<div class="cell">
	<div class="content">
	<p><a
		href="poemService!show?poem.pid=<s:property value="poem.pid" />"><s:property
		value="poem.title" /></a> <span style="float: right; margin-right: 10px;">
	<a
		href="myNewPoemService!removePoem?myNewPoem.newpid=<s:property value="newpid"/>">删除</a></span>
	<br>
	<a
		href="authorService!show?author.aid=<s:property value="poem.author.aid" />">
	<s:property value="%{poem.author.getName()}" /> </a> <br>
	<s:property value="poem.content" /></p>
	</div>
	</div>
</s:iterator>
<div class="cell">开始测试吧&nbsp;&nbsp;&nbsp; <a
	href="myNewPoemService!goTest?mode=easy">简单</a> <a
	href="myNewPoemService!goTest?mode=normal">中等</a> <a
	href="myNewPoemService!goTest?mode=hard">困难</a></div>
</div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>