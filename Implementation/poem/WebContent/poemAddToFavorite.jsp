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
<div class="sep20"></div>
<div class="box">
<h4>添加诗歌到收藏</h4>
添加
<a href="poemService!show?poem.pid=<s:property value="poem.pid" />"><s:property
	value="poem.title" /></a>
到列表：
<s:form action="favoriteService!addPoem">
	<s:hidden name="poem.pid"></s:hidden>
	<s:iterator value="list" status="st">
		<s:checkbox label="%{name}" name="chklist[%{#st.index}]"
			value="%{hasPoem(poem)}" fieldValue="%{fid}"></s:checkbox>
	</s:iterator>
	<s:submit></s:submit>
</s:form>
</div>
</div>
</div>
</body>
</html>