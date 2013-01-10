<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加到收藏列表</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep10"></div>
<div class="box">
<div class="cell">
<div class="fr" style="margin: 16px 10px 0px 0px;"><a
	href="poemService!index">返回列表</a></div>
<h1>添加诗歌到收藏</h1>
</div>
<div class="cell">添加 <a
	href="poemService!show?poem.pid=<s:property value="poem.pid" />"><s:property
	value="poem.title" /></a> 到列表：
</div>
<s:form action="favoriteService!addPoem">
	<s:hidden name="poem.pid"></s:hidden>
	<s:iterator value="list" status="st">
		<s:checkbox label="%{name}" name="chklist[%{#st.index}]"
			value="%{hasPoem(poem)}" fieldValue="%{fid}"></s:checkbox>
	</s:iterator>
	<s:submit cssClass="super normal button" value="添加"></s:submit>
</s:form></div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>