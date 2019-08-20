<%--
  Created by IntelliJ IDEA.
  User: toutou
  Date: 2018/5/27
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<div>
    <form id="zc" action="/user/login" method="post">
        用户名：<input type="text" required id="name" name="name"><br>
        密码：<input type="password" required id="pw" name="pw"><br>
        <input type="submit" value="登录">
        <input type="button" value="注册" onclick="location.href='/user/register'">
    </form>
</div>
</body>
<script>

    //对应后台返回的提示
    if ('${status}' != '') {
        if ('${status}' == 0) {
            alert('登录成功,即将跳转至用户详情页！')
            location.href = '/user/userInfo'
        }else if ('${status}' == 1) {
            alert('该账户不存在！');
        }
        else if ('${status}' == 2) {
            alert('密码错误！')
        }
    }
</script>
</html>
