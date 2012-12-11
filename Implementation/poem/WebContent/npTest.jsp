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
<s:include value="top.jsp"></s:include>
<h1>测试开始啦</h1>
<s:form action="myNewPoemService!goResult" theme="simple">
	<s:iterator value="myNewPoems" status="npoemid">
		<s:property value="#npoemid.index+1" />
		<s:property value="poem.title" />
		<br>
		<s:property value="poem.author.name" />
		<br>
		<s:subset source="allItems">
			<s:iterator status="itemid">
				<s:if test="poemid == poem.pid">
					<s:if test="exist == false">
						<!--  the %{} must stay together, I mean no whitespace between them!  -->
						<s:hidden name="testItems[%{#itemid.index}].poemid" value="%{poemid}" ></s:hidden>
						<s:hidden name="testItems[%{#itemid.index}].sentenceid"
							value="%{sentenceid}"></s:hidden>
						<s:textfield cssStyle="display:inline;"
							name="testItems[%{#itemid.index}].sentence" theme="simple"></s:textfield>
						<s:property value="punc" />
					</s:if>
					<s:else>
						<s:property value="sentence" />
						<s:property value="punc" />
					</s:else>
				</s:if>
			</s:iterator>
		</s:subset>
		<br>
	</s:iterator>
	<s:submit></s:submit>
</s:form>
</body>
</html>