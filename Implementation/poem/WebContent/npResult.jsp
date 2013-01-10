<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试结果</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep10"></div>
<div class="box">
<div class="cell">
<h1>你的分数是： <s:property value="%{result*100}" /></h1>
</div>

<table cellpadding="5" cellspacing="0" border="0">
	<tr>
		<th width="10%" align="right">编号</th>
		<th width="30%" align="left">错误诗句</th>
		<th width="30%" align="left">正确诗句</th>
	</tr>
	<s:iterator value="wrongItems" status="st">
		<s:if test="(#st.index)%2==0">
			<tr>
				<td width="10%" align="right"><s:property
					value="(#st.index+1)/2+1" /></td>
				<td width="30%" align="left"><s:property value="sentence" /></td>
		</s:if>
		<s:else>
			<td width="30%" align="left"><s:property value="sentence" /></td>
			<!-- Seems that </tr> can be omitted, or there will be a warning. -->
		</s:else>
	</s:iterator>
</table>
</div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>