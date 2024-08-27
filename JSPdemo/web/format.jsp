<%--
  Created by IntelliJ IDEA.
  User: HX
  Date: 2023/11/04
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  ${requestScope.date}
  <hr/>
  <fmt:formatDate value="${requestScope.date}" pattern="yyyy-MM-dd" />
  <hr/>
  <fmt:formatNumber value="${requestScope.number}" type="currency"/>

</body>
</html>
