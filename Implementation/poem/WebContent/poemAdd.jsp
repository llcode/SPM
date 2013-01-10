<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加诗词</title>
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
<h1>请输入诗词信息：</h1>
</div>
<s:if test="flash != null">
<div class="yellow">
<s:property value="flash"/>
</div>
</s:if>
<div class="inner"><s:form action="poemService!add" theme="simple">
	<table cellpadding="5" cellspacing="0" border="0" width="100%">
		<tr>
			<td width="120" align="right">题目</td>
			<td width="auto" align="left"><s:textfield name="poem.title"
				cssClass="sl"></s:textfield></td>
		</tr>
		<tr>
			<td width="120" align="right">作者</td>
			<td width="auto" align="left"><s:textfield
				name="poem.author.name" cssClass="sl"></s:textfield></td>
		</tr>
		<tr>
			<td width="120" align="right">内容</td>
			<td width="auto" align="left"><s:textarea name="poem.content"
				cssClass="ml"></s:textarea></td>
		</tr>
		<tr>
			<td width="120" align="right">译文</td>
			<td width="auto" align="left"><s:textarea
				name="poem.translation" cssClass="ml"></s:textarea></td>
		</tr>
		<tr>
			<td width="120" align="right">解释</td>
			<td width="auto" align="left"><s:textarea
				name="poem.explanation" cssClass="ml"></s:textarea></td>
		</tr>
		<tr>
			<td width="120" align="right">赏析</td>
			<td width="auto" align="left"><s:textarea
				name="poem.appreciation" cssClass="ml"></s:textarea></td>
		</tr>
		<tr>
			<td width="120" align="right"></td>
			<td width="auto" align="left"><s:submit
				cssClass="super normal button" value="添加"></s:submit></td>
		</tr>
	</table>
</s:form></div>
</div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>