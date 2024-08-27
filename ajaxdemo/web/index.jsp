<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script>
        $(function() {
            //初始化用户数据
            getData();
            //添加按钮绑定点击事件
            $("#add").click(function(){
                addOrUpdateUser("addUser");
            });
            //更新按钮绑定点击事件
            $("#update").click(function(){
                addOrUpdateUser("updateUser");
            });
        });

        // 获取页面初始化数据
        function getData(){
            $.getJSON("user.do",{flag:"getData"},function (result) {
                listUser(result);
            });
        }
        // 遍历数据生成数据
        function listUser(obj){
            var str ="";
            $.each(obj,function(){
                str+= "<tr align='center' bgcolor=\"#FFFFFF\">" +
                    "<td id='"+this.id+"'>"+this.id +"</td>"+
                    "<td>"+this.username+"</td>" +
                    "<td>"+this.password+"</td>" +
                    "<td>"+this.salary+"</td>" +
                    "<td>"+this.birthday+"</td>" +
                    "<td><a href='#' onclick='preUpdateUser("+this.id+")'>更新</a>&nbsp;&nbsp;<a href='#' onclick='deleteUser("+this.id+")'>删除 </a></td></tr>"
            });
            $("#tBody").prepend(str);
        }

        // 更新之前的数据选择
        function preUpdateUser(userid){
            var arr = new Array();
            $("#"+userid).closest("tr").children().each(function(index,ele){
                if(index <=4){
                    arr[index]= ele.innerText
                }
            });
            $("#id").val(arr[0]);
            $("#id").attr("readonly",true);
            $("#username").val(arr[1]);
            $("#password").val(arr[2]);
            $("#salary").val(arr[3]);
            $("#birthday").val(arr[4]);
        }

        // 用户添加或者用户更新
        function addOrUpdateUser(flag){
            // 从页面中获取数据
            var userid = $("#id").val();
            var username = $("#username").val();
            var password = $("#password").val();
            var salary = $("#salary").val();
            var birthday = $("#birthday").val();
            var data = {
                userid:userid,
                username:username,
                password:password,
                salary:salary,
                birthday:birthday,
                flag:flag
            }
            $.get("user.do",data,function(result){
               alert(result);
               location.reload();
            });
        }

        // 删除用户
        function deleteUser(userid){
            $("#"+userid).closest("tr").remove();
            $.post("user.do",{userid:userid,flag:"delete"},function(result){
                alert(result)
            })
        }
    </script>
    <style>
        div{
            padding:10px 10px 0 10px;
        }
    </style>
</head>
<body>
    <div>
        <table align="center" width="60%" border="0" cellspacing="1" bgcolor="#000000">
            <tr bgcolor="#FFFFFF">
                <td>ID：</td>
                <td><input type="text" name="id" id="id"/></td>
                <td>姓名：</td>
                <td><input type="text" name="username" id="username"/></td>
                <td>密码：</td>
                <td><input type="text" name="password" id="password"/></td>
            </tr>
            <tr bgcolor="#FFFFFF">
                <td>收入：</td>
                <td><input type="text" name="salary" id="salary"/></td>
                <td>出生日期：</td>
                <td><input type="text" name="birthday" id="birthday"/></td>
                <td colspan="2"></td>
            </tr>
            <tr align="center" bgcolor="#FFFFFF">
                <td colspan="6">
                    <input type="button" value="添加用户" id="add" />
                    <input type="button" value="更新用户" id="update"/>
                </td>
            </tr>
        </table> <hr/>
        <table align="center" width="60%" bgcolor="#000000" border="0" id="myTable" cellpadding="0" cellspacing="1">
            <thead>
            <tr align="center" bgcolor="#FFFFFF">
                <td>ID</td>
                <td>姓名</td>
                <td>密码</td>
                <td>收入</td>
                <td>生日</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody id="tBody"></tbody>
        </table>

    </div>

</body>
</html>
