
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
  <title>存储文件到指定目录</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <!--
  <link rel="stylesheet" type="text/css" href="styles.css">
  -->

  <style type="text/css">
    #upload{
      margin-top: 300px;
      margin-left: 600px;
      position: relative;
    }
  </style>
</head>
<body>
<form action="http://localhost:8080/ex2_1_war_exploded/CodeReturn" method="post" enctype="multipart/form-data" id="upload">
  请选择上传的图片或文件:
  <br><br>
  <!-- 这个是item.isFormField()==false -->
  <input type="file" name="fileName"/>
  <br><br>
  <!-- 这个走的就是item.isFormField()==true -->
<%--  <input type="text" name="hello" >--%>
  <input type="submit" value="上传"/>
</form>
</body>
</html>