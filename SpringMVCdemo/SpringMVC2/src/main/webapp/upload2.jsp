<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<h3>文件上传</h3>

<%--文件上传表达必须指明enctype="multipart/form-data"    method="post"--%>
<form action="/upload2" enctype="multipart/form-data" method="post">
    选择文件：<input type="file" name="file">
    <input type="submit" name="upload" value="上传">
</form>


</body>
</html>
