<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏列表</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep20"></div>
<div class="box">
<h1>我的收藏列表</h1>
<a href="favoriteAdd.jsp">添加列表</a>
<br>
<s:iterator value="list">
	<a href="favoriteService!show?favorite.fid=<s:property value="fid" />">
	<s:property value="name" /></a>（共<s:property value="%{poemLists.size()}"/>首）
	<a href="favoriteService!edit?favorite.fid=<s:property value="fid" />">
	编辑</a>
	<a
		href="favoriteService!delete?favorite.fid=<s:property value="fid" />">
	删除</a>
	<br>
</s:iterator>
</div>
</div>
</div>
</body>
</html>