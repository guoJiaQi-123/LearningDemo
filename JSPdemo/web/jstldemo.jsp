<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${1==1}">
        Hello,JSTL
    </c:if>
<br>
<c:forEach begin="0" end="9" step="2" varStatus="shuxin">
    forEach......${shuxin.count}  ${shuxin.first}  ${shuxin.last}  ${shuxin.index}<br/>
</c:forEach>
</body>
</html>
