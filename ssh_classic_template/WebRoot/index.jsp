<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body style="text-align: center;">
	<form action="<s:url value='/demoAction.action' />" name="form1"
		method="post">
		<table border="0">
			<tr>
				<td colspan="2" bgcolor="#FDDDE" align="center">用户登录</td>
			</tr>
			<tr>
				<td align="right"><s:text name="users.name" />：</td>
				<td><input type="text" name="name" style="width: 100px;">
				</td>
			</tr>
			<tr>
				<td align="right"><s:text name="users.password" />：</td>
				<td><input type="password" name="password" style="width: 100px;">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="%{getText('users.submit')}">
				</td>
			</tr>
		</table>
	</form>
	<s:debug></s:debug>
</body>
</html>
