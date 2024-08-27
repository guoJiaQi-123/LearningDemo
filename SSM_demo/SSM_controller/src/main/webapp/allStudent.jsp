<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有学生</title>
</head>
<body>
<%--获取学生表单--%>
<form action="/student/add" method="post">
    姓名：<input name="name">
    性别：<input name="sex">
    地址：<input name="address">
    <input type="submit" value="提交">
</form>
<%--删除学生表单--%>
<br/>
<form action="/student/delete" method="post">
    学生id:<input name="id" value="">
    <input type="submit" value="删除">
</form>
<%-- 展示学生表格 --%>
<table width="500px" cellspacing="0" cellpadding="0" border="1" align="center">
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>性别</th>
        <th>地址</th>
    </tr>
    <c:forEach items="${Students}" var="student">
        <tr>
            <th>${student.id}</th>
            <th>${student.name}</th>
            <th>${student.sex}</th>
            <th>${student.address}</th>
        </tr>
    </c:forEach>
</table>


</body>
</html>
