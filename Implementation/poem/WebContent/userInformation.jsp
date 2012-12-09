<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="maxheight.js" type="text/javascript"></script>
<script type="text/javascript">
	function goMain() {
		window.location.href = "userCountService!goMain";
	}
	
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

<s:form action="userCountService!update"
	onsubmit="return checkSubmit();">
	<!-- 将原有的数据回显在页面上 -->
	<s:include value="top.jsp"></s:include>
	<table border="0">
		<tbody>
			<!-- action的属性都是保存在valueStack中 -->
			<tr>
				<td>USERID</td>
				<td><s:property value="usercount.userid" /></td>
				<s:hidden name="usercount.userid"></s:hidden>
			</tr>
			<tr>
				<td>USERNAME</td>
				<td><s:textfield name="usercount.name" theme="simple">
				</s:textfield></td>
				<td>${userNameError}</td>

			</tr>
			<tr>
				<td>EMAIL</td>
				<td><s:textfield name="usercount.email" theme="simple">${userEmailError}
						   </s:textfield></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><s:textfield name="usercount.password" theme="simple"></s:textfield></td>
			</tr>

			<tr>
				<td colspan="2"><s:submit value="更新" theme="simple"></s:submit>
				<input type="button" value="返回" onclick="goMain()"></td>
			</tr>
		</tbody>
	</table>
</s:form>
</body>
</html>