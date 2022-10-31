<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>文件传输页面</title>
</head>
<body>
    <div>
        <h1>文件上传实例 - 菜鸟教程</h1>
        <form method="post" action="http://localhost:8080/ex2_1_war_exploded/UploadServlet" enctype="multipart/form-data">
            选择一个文件:
            <input type="file" name="uploadFile" />
            <br/><br/>
            <input type="submit" value="上传" />
        </form>
    </div>
</body>
</html>