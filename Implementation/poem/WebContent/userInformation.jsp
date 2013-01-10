<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑个人信息</title>
<script src="maxheight.js" type="text/javascript"></script>
<script type="text/javascript">
	
	function checkSubmit(){
		if (document.getElementsByName("usercount.name")[0].value == "") {
			document.getElementsByName("usercount.name")[0].focus();
			alert("用户名不能为空！");
			return false;
		}
		if (document.getElementsByName("usercount.email")[0].value == "") {
			document.getElementsByName("usercount.email")[0].focus();
			alert("注册邮箱不能为空!");
			return false;
		}
		if (document.getElementsByName("usercount.password")[0].value == ""
			|| document.getElementsByName("password2")[0].value == "") {
		document.getElementsByName("usercount.password")[0].focus();
		alert("新密码不能为空！");
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
	href="userCountService!goMain">返回主页</a></div>
<h1><s:property value="usercount.name" />的个人信息</h1>
</div>
<div class="inner"><s:form action="userCountService!update"
	onsubmit="return checkSubmit();" theme="simple">
	<!-- 将原有的数据回显在页面上 -->
	<table cellpadding="5" cellspacing="0" border="0" width="100%">
		<!-- action的属性都是保存在valueStack中 -->
		<tr>
			<td width="120" align="right">用户编号</td>
			<td width="auto" align="left"><s:property
				value="usercount.userid" /></td>
			<s:hidden name="usercount.userid"></s:hidden>
		</tr>
		<tr>
			<td width="120" align="right">用户姓名</td>
			<td width="auto" align="left"><s:textfield cssClass="sl" name="usercount.name"theme="simple">
			</s:textfield>${userNameError}</td>

		</tr>
		<tr>
			<td width="120" align="right">电子邮件</td>
			<td width="auto" align="left"><s:textfield
				name="usercount.email" cssClass="sl">${userEmailError}
						   </s:textfield></td>
		</tr>
		<tr>
			<td width="120" align="right">密码</td>
			<td width="auto" align="left"><s:textfield
				name="usercount.password" cssClass="sl"></s:textfield></td>
		</tr>

		<tr>
			<td width="120" align="right"></td>
			<td width="auto" align="left"><s:submit cssClass="super normal button" value="更新"></s:submit></td>
		</tr>
	</table>
</s:form></div>
</div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>