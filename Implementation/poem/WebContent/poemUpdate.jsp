<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新诗歌</title>
<script type="text/javascript">
	var goBack = function() {
		//window.history.go(-1);
		window.location.href = "poemService!index";
	};
</script>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep20"></div>
<div class="box">
<div class="cell">
<div class="fr" style="margin: 16px 10px 0px 0px;"><a
	href="poemService!index">返回列表</a></div>
<h1>更新信息</h1>
</div>
<div class="inner">
<s:form action="poemService!update" theme="simple">
	<!-- 将原有的数据回显在页面上 -->
	<table cellpadding="5" cellspacing="0" border="0" width="100%">
	<tr>
	<s:hidden name="poem.pid"></s:hidden>
	</tr>
	<tr>
		<td width="120" align="right">题目</td>
		<td width="auto" align="left"><s:textfield name="poem.title" readonly="true" theme="simple" cssClass="sl"/></td>
	</tr>
	<tr>
		<td width="120" align="right">作者</td>
		<td width="auto" align="left"><s:textfield name="poem.author.name" readonly="true" theme="simple" cssClass="sl"/></td>
	</tr>
	<tr>
		<td width="120" align="right">内容</td>
		<td width="auto" align="left"><s:textarea name="poem.content" theme="simple" cssClass="ml"/></td>
	</tr>
	<tr>
		<td width="120" align="right">译文</td>
		<td width="auto" align="left"><s:textarea name="poem.translation" theme="simple" cssClass="ml"/></td>
	</tr>
	<tr>
		<td width="120" align="right">解释</td>
		<td width="auto" align="left"><s:textarea name="poem.explanation" theme="simple" cssClass="ml"/></td>
	</tr>
	<tr>
		<td width="120" align="right">赏析</td>
		<td width="auto" align="left"><s:textarea name="poem.appreciation" theme="simple" cssClass="ml"/></td>
	</tr>
	<tr>
		<td width="120" align="right"><s:submit value="更新" theme="simple" cssClass="super normal button"></s:submit></td>
		<td width="auto" align="left"><s:reset value="重置" theme="simple" cssClass="super normal button"></s:reset></td>
	</tr>
	</table>
</s:form>
</div>
</div>
</div>
</div>
</body>
</html>