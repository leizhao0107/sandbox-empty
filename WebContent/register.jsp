<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.shopping.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("gb2312");
	String action = request.getParameter("action");
	if(action!=null && action.trim().equals("register")){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setAddr(addr);
		user.save();
		out.println("Congratulation!Registered OK");
		
	}
%>

<html>
	<head>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	 -->
	<title>ע�����û�</title>
	<script type="text/javascript" scr="script/regcheckdata.js">
	</script>
	</head>
	
	
<body>
	<form name = "form" action = "register.jsp" method = "post"  onSubmit = "return checkdata()">
	<input type="hidden" name="action" value="register"/>
	<table border = 2 align = "center" width="80%">
		<tr>
		<img src="images/table.jpg" width="1065" height="118" />		</tr>
		<tr>
			<th  colspan = 2 align = "center">�û�ע��</th>
		</tr>
		<tr>
			<td width="30%" height="31" >�û�����</td>
		  <td valign="bottom">
				<input name = "username" type="text" onblur = "checkUserName(this.value.toLowerCase())">
				<!--<div id = "usernameErr"></div>-->
				<span id = "usernameErr"></span>
	  </td>
		</tr>
		<tr>
			<td width="30%" height="39" >���룺 </td>
			<td>
				<input type="password" name = "password" >
				<span id = "pwdErr"></span>
		</td>
		</tr>
		<tr>
			<td width = "30%" height = "40" name = "password2">ȷ�����룺</td>
			<td>
				<input type = "password" name = "password2">
				<span id = "pwdErr2"></span>
			</td>
		<tr>
		<td>�绰��</td>
		<td>
		<input type="text" name="phone" size="20" />
	  	</td>
		</tr>
		<tr>
		<td>��ַ��</td>
		<td>
		  <textarea name = "addr" cols = 50 rows = 12></textarea>
		</td>
		</tr>
		<tr>
		<td>
		
		<input type="submit" value="�ύ">
		<input type = "reset" value="������д"/>
		</td>
		</tr>
	</table>
	</form>
</body>
</html>