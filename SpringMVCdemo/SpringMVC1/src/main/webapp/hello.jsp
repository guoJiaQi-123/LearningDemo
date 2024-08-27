<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DELETE/PUT</title>
</head>
<body>

        <%-- 提交DELETE、PUT请求，表单必须提交方式为post --%>
        <%-- 表单中有一个隐藏域，name值为_method，value值为提交方式 --%>
        <form action="/c7/delete" method="post">
            <input type="hidden" name="_method" value="DELETE">
            <input value="删除" type="submit">
        </form>

        <form action="/c7/put" method="post">
            <input type="hidden" name="_method" value="PUT">
            <input value="修改" type="submit">
        </form>
</body>
</html>
