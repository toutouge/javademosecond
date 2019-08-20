<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11655
  Date: 2017/4/17
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="zc" action="/lxf/test5/zc" method="post">
    <label for="name">用户名：</label> <input type="text" required id="name" name="name"><br>
    <label for="pw">密码：</label> <input type="password" required id="pw" name="pw"><br>
    性别： <input type="radio" required value="0" name="sex">男 <input type="radio" value="1" required name="sex">女<br>
    <input type="submit" value="注册">
    <input type="reset" value="重置"/>
</form>
</body>
<script>
    //对应后台返回的提示
    if ('${result}' != '') {
        if ('${result}' == 1) {
            alert('注册成功，将跳转到登录页面！')
            location.href = '/lxf/test5/todl'
        }
        if ('${result}' == 0) {
            alert('未知错误，注册失败！')
        }
        if ('${result}' == 2) {
            alert('该账号已有人注册！')
        }

    }


</script>
</html>