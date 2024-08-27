<%--
  Created by IntelliJ IDEA.
  User: HX
  Date: 2023/12/05
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数获取</title>
</head>
<body>
        <form action="c1/param3" method="post">
            id:<input name="id">
            姓名:<input name="name">
            性别:<input name="sex">
            地址:<input name="address.info">
            邮编:<input name="address.postcode">
            <input type="submit">
        </form>


</body>
</html>
