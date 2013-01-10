<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:wb="http://open.weibo.com/wb">
<%
	String getURL = request.getScheme()
			+ "://"
			+ request.getServerName()
			+ ":"
			+ request.getServerPort()
			+ request.getAttribute("javax.servlet.forward.request_uri")
					.toString() + "?" + request.getQueryString();
	;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏列表内容</title>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js?appkey="
	type="text/javascript" charset="utf-8"></script>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep10"></div>
<div class="box">
<div class="cell">
<div class="fr" style="margin: 16px 10px 0px 0px;"><a
	href="favoriteService!index">返回列表</a></div>
<span class="fr" style="margin: 12px 20px -20px 0px;"> <wb:share-button
	count="n" type="button" url="<%=getURL %>" size="middle"
	title="我的诗词收藏列表：<s:property value="favorite.name" />。"
	relateuid="1654287335"></wb:share-button> </span>
<h1><s:property value="favorite.name" /> 里的内容：</h1>
</div>
<s:iterator value="poemList">
	<div class="cell">
	<div class="content">
	<p><a href="poemService!show?poem.pid=<s:property value="pid" />"><s:property
		value="title" /></a> <span style="float: right; margin-right: 10px;">
	<a
		href="favoriteService!removePoem?favorite.fid=<s:property value="favorite.fid"/>&poem.pid=<s:property value="pid"/>">删除</a></span><br>
	<a
		href="authorService!show?author.aid=<s:property value="author.aid" />">
	<s:property value="author.name" /></a> <br>
	<s:property value="content" /></p>
	</div>
	</div>
</s:iterator></div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>