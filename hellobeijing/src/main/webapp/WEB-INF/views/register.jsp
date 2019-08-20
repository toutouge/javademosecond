<%--
  Created by IntelliJ IDEA.
  User: toutou
  Date: 2018/5/27
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<div>
    <form id="register" action="/user/register" method="post">
        用户名：<input type="text" required id="name" name="name"><br>
        密码：<input type="password" required id="pw" name="pw"><br>
        性别： <input type="radio" required value="0" name="sex">男 <input type="radio" value="1" required name="sex">女<br>
        <input type="submit" value="注册">
        <input type="reset" value="重置"/>
    </form>
</div>
</body>
<script>
    //根据后台返回状态给予提示
    if ('${status}' != '') {
        if ('${status}' == 0) {
            alert('注册成功，点击确定跳转到登录页面！')
            location.href = '/user/login'
        }
        if ('${status}' == 1) {
            alert('exception，注册失败！')
        }
        if ('${status}' == 2) {
            alert('账号信息已存在！')
        }
    }
</script>
</html>
