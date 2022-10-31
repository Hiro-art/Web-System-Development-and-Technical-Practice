<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="MyFirstTag" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop Car</title>
</head>
<body>
	<h4>Session List:</h4>
	<hr>
	<br>
	<br>
<%--	<%=request.getParameterValues("now_color")[0]%><br>--%>
<%--	<%=request.getParameter("now_color")%>--%>
<%--	<c:forEach var="selected" items="${sessionList}">--%>
<%--${selected}<hr>--%>
	<%String[] all_str = request.getParameter("now_color").split(",");%>
<%--	<%=all_str[0] +"测试"%>--%>
<%--		<mytag:countColorTime select_color ='<%=(String)request.getParameter("now_color")%>'/>--%>
	<mytag:countColorTime select_color_history='<%=all_str%>'/>
	<%--	</c:forEach>--%>

<%--	<hr>--%>
</body>
</html>