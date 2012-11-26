<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeImage() {
		var img = document.getElementById("valiCode");
		img.src = "image.jsp?" + Math.random();
	}

	function register() {
		window.location.href = "userCountService!goRegister";

	}
</script>
<link href="css/bootstrap-classic.css" rel="stylesheet" />
</head>
<body>
	<center>
		<h4>请输入登录信息</h4>
		<form action="userCountService!login" method="post">
			<table>
				<tr>
					<td>
						<!-- 等效于type为text的input标签--> <!-- 如果action中的属性是一个封装类型，属性的赋值是按照对象导航的方式来寻找的 -->

						账号:<input type="text" name="user.username" style="width: 250px" />

					</td>
				</tr>
				<tr>
					<td>密码:<input type="password" name="user.pwd"
						style="width: 250px" />

					</td>
				</tr>
				<!-- <tr>
				<td>验证码:<input type="text" style="width: 100px" name="code" /> <img
					id="valiCode"  src="image.jsp"> <a
					href="javascript:changeImage()">看不清，换一张</a>
				</td>
			</tr> -->
				<tr>
					<td><input type="submit" value="登录">
					<td><input type="button" onclick="register()" value="注册" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>