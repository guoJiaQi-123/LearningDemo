
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有学生</title>
</head>
<body>
    <table align="center" width="500px" border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <th>id</th>
            <th>名字</th>
            <th>性别</th>
            <th>地址</th>
        </tr>
        <c:forEach items="${allStudent}" var="student">

            <tr>
               <td>${student.id}</td>
               <td>${student.name}</td>
               <td>${student.sex}</td>
               <td>${student.address}</td>
           </tr>

       </c:forEach>



    </table>

</body>
</html>
