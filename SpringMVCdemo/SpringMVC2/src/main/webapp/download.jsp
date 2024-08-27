<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件下载</title>
</head>
<body>
<h3>文件下载</h3>
<%-- 遍历文件集合 --%>
<c:forEach items="${files}" var="file">
    <a href="/down?fileName=${file}">${file}</a><br/>
</c:forEach>

</body>
</html>
