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
<div id="Wrapper">
<div id="Main">
<div class="sep10"></div>
<div class="box">
<div class="cell">
<h1>${author.name }的信息</h1>
</div>
<div class="cell">
<div class="content">
<p><s:property value="author.description" /></p>
</div>
</div>
<div class="cell"><a
	href="authorService!edit?author.aid=<s:property value="author.aid" />">更新</a>
<a
	href="authorService!delete?author.aid=<s:property value="author.aid" />">删除</a>
<br>
</div>
</div>
<div class="sep20"></div>
<div class="box">
<div class="cell">
<h1>${author.name }的诗集</h1>
</div>
<s:iterator value="poems">
	<div class="cell">
	<div class="content">
	<p><a href="poemService!show?poem.pid=<s:property value="pid" />"><s:property
		value="title" /></a></p>
	<p><s:property value="content"></s:property></p>
	</div>
	</div>
</s:iterator></div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>