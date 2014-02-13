<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript">
	function add(){
		var row = tb.insertRow();
		var cell = row.insertCell();
		cell.innerHTML="<input type='text' name='name'/>";
		
		cell = row.insertCell();
		cell.innerHTML="<input type='text' name='password'/>";
		
	}
</script>
  </head>
  
  <body>
  	<h2>欢迎登录</h2>
  	<a href="<s:url value='demoAction!query.action' />">显示所有用户</a><br>
  	<form action="<s:url value='demoAction!query.action' />" name="form2" method="post">
  		请输入要查询的用户名包含的内容<input type="text" name="name">
  		<input type="submit" value="提交">
  	</form>
  	<form action="<s:url value='demoAction!save.action' />" method="post">
  		<table border="1" width="30%" id="tb">
  			<tr bgcolor="#FFDDAA">
  				<td align="center">用户名</td>
  				<td align="center">密码</td>
  			</tr>
  		</table>
  		<br>
  		<s:token />
  		<input type="button" onclick="add();" value="增加">
  		<input type="submit" value="保存">
  	</form><br>
  	<a href="<s:url value='exportAction!query.action' />">进入导入导出</a><br>
  	<s:debug></s:debug>
  </body>
</html>
