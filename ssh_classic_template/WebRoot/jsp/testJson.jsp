<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
 %>
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
	<script type="text/javascript" src="<%=path %>/jquery/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="<%=path %>/js/user.js"></script>
  </head>
  
  <body>
  		<input id="getMessage" type="button" value="获取单个值"/>&nbsp;&nbsp;  
    	<input id="getUserInfo" type="button" value="获取UserInfo对象"/>&nbsp;&nbsp;  
    	<input id="getList" type="button" value="获取List对象"/>&nbsp;&nbsp;  
    	<input id="getMap" type="button" value="获取Map对象"/>&nbsp;&nbsp;
    	<br>  
    	<br>  
   		<br>
   		<!-- 要显示信息的层 -->  
	    <div id="message"></div>  
	    <form>  
			        用户ID：<input name="userInfo.id" type="text"/><br/>  
			        用户名：<input name="userInfo.name" type="text"/><br/>  
			        密&nbsp;&nbsp;&nbsp;码：<input name="userInfo.password" type="text"/><br>  
	       	   <input id="regRe" type="button" value="注册"/>  
	    </form>  
  </body>
</html>
