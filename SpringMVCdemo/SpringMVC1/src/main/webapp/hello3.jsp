<%--
  Created by IntelliJ IDEA.
  User: HX
  Date: 2023/12/06
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax异步请求</title>
    <script src="/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $("#btn").click(function (){
                var name = $("#name").val();
                var sex = $("#sex").val();
                var param = JSON.stringify({"name":name,
                                            "sex":sex})
                $.ajax({
                    url:"c8/addStudent2",
                    contentType:"application/json",
                    type:"post",
                    data:param,
                    success:function (data){
                        console.log(data);
                    }
                })
            });
        });
    </script>
</head>


<body>
    姓名：<input id="name"><br/>
    性别：<input id="sex"><br/>
    <input type="button" id="btn" value="提交">


</body>
</html>
