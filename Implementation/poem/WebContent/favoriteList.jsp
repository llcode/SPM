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
<div class="sep10"></div>
<div class="box">
<div class="cell">
<div class="fr" style="margin: 16px 10px 0px 0px;"><a
	href="favoriteAdd.jsp">添加列表</a></div>
<h1>我的收藏列表</h1>
</div>
<s:iterator value="list">
	<div class="cell"><a
		href="favoriteService!show?favorite.fid=<s:property value="fid" />">
	<s:property value="name" /></a>（共<s:property value="%{poemLists.size()}" />首）
	<span style="float: right; margin-right: 10px;"> <a
		href="favoriteService!edit?favorite.fid=<s:property value="fid" />">
	编辑</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
		href="favoriteService!delete?favorite.fid=<s:property value="fid" />">
	删除</a></span></div>
</s:iterator></div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>