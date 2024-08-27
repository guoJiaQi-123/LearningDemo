<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步文件上传</title>
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/jquery.form.js"></script>
</head>
<body>

<h3>多文件上传</h3>

<%--文件上传表达必须指明enctype="multipart/form-data"    method="post"--%>
<form enctype="multipart/form-data" id="ajaxForm">
    选择文件：<input type="file" name="file">
    <input type="button" id="btn" value="上传头像">
</form>
<img src="/" width="100px" id="img">
<script>
    $(function () {
        $("#btn").click(function () {
            // 异步提交表单
            $("#ajaxForm").ajaxSubmit({
                url: "/upload5",
                method: "post",
                success: function (data) {
                    $("#img").attr("src", data);
                }
            })
        })
    })
</script>


</body>
</html>
