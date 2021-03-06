<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep10"></div>
<div class="box">
<div class="cell">
搜索 
<s:form action="poemService!search"
	theme="simple" cssStyle="display:inline;">
	<s:select cssStyle="display:inline;" name="condition"
		list="{'标题','诗人','内容'}" headerKey="-1" headerValue="-- 请选择查询条件 --"
		required="true" theme="simple"></s:select>
	<s:textfield name="query" cssStyle="display:inline;" required="true"
		theme="simple"></s:textfield>
	<s:submit value="搜索"></s:submit>
</s:form> 
</div>
<s:if test="%{list == null}">
	<s:iterator value="authorList">
		<div class="cell">
		<div class="content">
		<p><a href="authorService!show?author.aid=<s:property value="aid" />">
		<s:property value="name" /></a>
		<br>
		<s:property value="description" /></p>
		</div>
		</div>
	</s:iterator>
</s:if> <s:else>
	<s:iterator value="list">
		<div class="cell">
		<div class="content">
		<p><a href="poemService!show?poem.pid=<s:property value="pid" />"><s:property
			value="title" /></a>
		<br>
		<a
			href="authorService!show?author.aid=<s:property value="author.aid" />">
		<s:property value="author.name" /></a>
		<br>
		<s:property value="content" /></p>
		</div>
		</div>
	</s:iterator>
</s:else>
</div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>