<%--
  Created by IntelliJ IDEA.
  User: Xiaoning Jia
  Date: 2022/10/26
  Time: 下午 5:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--此处为使用的自定义标签--%>
<%@ taglib uri="MyFirstTag" prefix="mytag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Select a color for beer!</title>
</head>
<body>
<%@ include file="Header_ins.jsp"%>
<h1 align="center">Beer Selection Page</h1>
<!-- Commit to a Servlet Page -->
<!-- form method="POST" action="SelectBeer.do" -->
<!-- Commit to a JSP Page -->
<form method="POST" action="BeerList.jsp">
    This application has been visited
    <mytag:counter />
    times.
    <p>There are kinds of beer for choose.
    <p>
        <%--潜藏一个带name的select标签--%>
        <mytag:colorSelect />
    <center>
        <input type="SUBMIT" value="Submit">
    </center>

<%--    <% HttpSession httpSession = request.getSession();--%>
<%--        String colorSelected;--%>
<%--        colorSelected = request.getParameter("color");--%>
<%--        httpSession.setAttribute("color",colorSelected);%>--%>
</form>
</body>
</html>
</html>