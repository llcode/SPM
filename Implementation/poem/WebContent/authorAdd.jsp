<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>诗人信息</title>
<script type="text/javascript">
	function checkSubmit() {
		if (document.getElementsByName("author.name")[0].value == "") {
			document.getElementsByName("author.name")[0].focus();
			alert("作者名字不能为空！");
			return false;
		}
	}
</script>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep10"></div>
<div class="box">
<div class="cell">
<div class="fr" style="margin: 16px 10px 0px 0px;"><a
	href="authorService!index">返回列表</a></div>
<h1>添加诗人信息</h1>
</div>
<div class="inner"><s:form action="authorService!add"
	onsubmit="return checkSubmit();" theme="simple">
	<table cellpadding="5" cellspacing="0" border="0" width="100%">
		<tr>
			<td width="120" align="right">诗人</td>
			<td width="auto" align="left"><s:textfield cssClass="sl" name="author.name"></s:textfield>
			<font color="red">${author}</font></td>
		</tr>
		<tr>
			<td width="120" align="right">简介</td>
			<td width="auto" align="left"><s:textarea cssClass="ml"
				name="author.description"></s:textarea></td>
		</tr>
		<tr>
			<td width="120" align="right"></td>
			<td width="auto" align="left"><s:submit cssClass="super normal button" value="添加"></s:submit></td>
		</tr>
	</table>
</s:form></div>
</div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>
