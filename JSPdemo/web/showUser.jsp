<%--
  Created by IntelliJ IDEA.
  User: HX
  Date: 2023/11/04
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" align="center">
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="users">
            <tr>
                <td>${users.userid}</td>
                <td>${users.username}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
