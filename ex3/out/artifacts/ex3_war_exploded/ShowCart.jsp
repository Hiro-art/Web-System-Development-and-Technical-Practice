<%--
  Created by IntelliJ IDEA.
  User: Xiaoning Jia
  Date: 2022/10/30
  Time: 上午 11:25
  To change this template use File | Settings | File Templates.
--%>
<%--将ShoppingCart中的页面显示部分勇jsp和标签技术实现--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>item list</title>
</head>
<body>
    <h4>Session List:</h4><hr><br><br>

    <%-- 从session中根据名字提取出指定的session，并且将其分割为字符数组--%>
    <% Integer all = (Integer) request.getSession().getAttribute("itemCount");%>
    <% String all_item = "";
        for(int i=1;i<=all;i++){
            all_item += request.getSession().getAttribute("item" + i) + ",";
        }
        String[] str = all_item.split(",");
    %>
    <%-- 使用C标签和EL表达式输出想要购买的商品列表  --%>
    <c:forEach var="select_name" items="<%=str%>" varStatus="status">
        <c:out value="item${status.count}: ${select_name}"></c:out><hr>
    </c:forEach>
    <%--  用C标签输出总共想要购买商品的总数  --%>
    <c:out value="itemCount:"></c:out>
    <c:out value='<%=all%>'></c:out><br>

    <%--    <c:forEach var="item_selected" items='<%=request.getParameterValues("item")%>' varStatus="status">--%>
    <%--        <c:out value="Item${status.count}: ${item_selected}"></c:out><hr>--%>
    <%--    </c:forEach>--%>
</body>
</html>
