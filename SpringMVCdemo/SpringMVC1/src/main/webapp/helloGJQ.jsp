<%--
  Created by IntelliJ IDEA.
  User: HX
  Date: 2023/12/06
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>你好郭家旗</title>
</head>
<body>

        <h1>你好,${requestScope.name}</h1>
        <h1>地址：${sessionScope.address}</h1>
        <h1>年龄：${applicationScope.age}</h1>
</body>
</html>
