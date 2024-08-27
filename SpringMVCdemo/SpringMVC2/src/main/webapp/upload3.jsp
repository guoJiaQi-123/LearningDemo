<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多文件上传</title>
</head>
<body>

<h3>多文件上传</h3>

<%--文件上传表达必须指明enctype="multipart/form-data"    method="post"--%>
<form action="/upload3" enctype="multipart/form-data" method="post">
    用户名：<input name="username">
    选择文件：<input type="file" name="files">
    选择文件：<input type="file" name="files">
    <input type="submit" name="upload" value="上传">
</form>


</body>
</html>
