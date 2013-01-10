<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>诗词信息</title>
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
<h1>诗词信息：</h1>
</div>
<div class="cell">
<div class="content">
<p><s:property value="poem.title" /> <br>
<a
	href="authorService!show?author.aid=<s:property value="poem.author.aid" />">
<s:property value="poem.author.name" /></a><br>
<s:property value="poem.content" /></p>
</div>
</div>

<div class="cell">
<div class="content">
<p>译文：<br>
<s:property value="poem.translation" /></p>
</div>
</div>

<div class="cell">
<div class="content">
<p>翻译：<br>
<s:property value="poem.explanation" /></p>
</div>
</div>

<div class="cell">
<div class="content">
<p>鉴赏：<br>
<s:property value="poem.appreciation" /></p>
</div>
</div>

<div class="cell"><a
	href="poemService!edit?poem.pid=<s:property value="poem.pid" />">更新</a>
&nbsp;&nbsp;&nbsp;&nbsp; <a
	href="poemService!delete?poem.pid=<s:property value="poem.pid" />">删除</a>

<span style="float: right;"> <a
	href="poemService!addToNewPoem?poem.pid=<s:property value="poem.pid" />">添加生诗词表</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a
	href="favoriteService!goAddPoem?poem.pid=<s:property value="poem.pid" />">添加到收藏列表</a></span></div>
</div>

<div class="sep20"></div>
<div class="box">
<div class="cell"><!-- UY BEGIN -->
<div id="uyan_frame"></div>
<script type="text/javascript" id="UYScript"
	src="http://v1.uyan.cc/js/iframe.js?UYUserId=1730412" async=""></script>
<!-- UY END --></div>
</div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>