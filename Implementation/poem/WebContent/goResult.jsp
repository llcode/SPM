<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Your score is
<s:property value="%{result*100}" />
<br>

<table>
	<tr>
		<th>No</th>
		<th>Yours wrong answer</th>
		<th>The right answer</th>

	</tr>
	<s:iterator value="wrongItems" status="st">
		<s:if test="(#st.index)%2==0">
			<tr>
				<td><s:property value="(#st.index+1)/2+1" /></td>
				<td><s:property value="sentence" /></td>
		</s:if>
		<s:else>
			<td><s:property value="sentence" /></td>
			</tr>
		</s:else>
	</s:iterator>
</table>
</body>
</html>