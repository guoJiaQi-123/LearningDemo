<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int flag = new Random().nextInt(100);
        if(flag<=20){
    %>
    中奖了<%=flag%>
    <%}else {%>
    没中奖<%=flag%>
    <%}%>
</body>
</html>
