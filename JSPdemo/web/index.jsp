<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Welcome JSP
  <%!
    int a =10;
    int add(int a,int b){
      return a+b;
    }
  %>
  <%
    int b=10;
  %>
  <%=a%>
  <%=b%>
  </body>
</html>
