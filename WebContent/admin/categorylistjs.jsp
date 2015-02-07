<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import = "com.shopping.service.*" %>
<%@ page import = "com.shopping.model.*" %>
<%@ page import = "java.util.*" %>
<%@ include file="_session.jsp"%>
<%
List<Category> categories = Category.getCategories();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Categorylistjs</title>
<script language="javascript" src="script/TV20.js"></script>
<script type="text/javascript">
	function t (key, parentkey){
		document.forms["form"].pid.value = key;
	}
	
		</script>

</head>
<body>
	
		<!-- <tr><td id = "show"></td></tr> -->
<table align="center" border="1">
		
	<tr><td id="show"></td></tr>
	<tr><td>
	<form name="form" action="categoryadd.jsp" method = "post">
		
		<input type = "hidden" name = "action" value = "add">
	
		
	
			<label>添加节点</label><input type = "text" name ="pid" value="" readonly><br>
			
				
				
			<label>Name:</label><input type = "text" name = "name"><br>
		
				
			<label>Descr:</label><input type = "text" name = "descr"><br>
		
		
			<input type = "submit" value ="提交"/>
	
		</form>	

			</td></tr>
	</table>			
	
	<script language="javascript"> 	
	<!-- 
	addNode(-1,0,"所有类别","images/top.gif");
 <%
 	for(Iterator<Category> it = categories.iterator();it.hasNext();){
 		Category c = it.next();
 		System.out.println(c.getName());
 		%>
 		addNode(<%=c.getPid()%>,<%=c.getId()%>,"<%=c.getName()%>","images/top.gif");
 		<%
 	}
%>
showTV();
addListener("click","t");
--> 
</script>
	


</body>
</html>