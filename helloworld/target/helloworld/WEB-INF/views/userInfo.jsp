<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11655
  Date: 2017/4/17
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${! empty user}">
    <div>欢迎您，${user.name}${user.sex?'女士':'先生'}
    <a href="/lxf/test5/logout">注销</a></div>
</c:if>
<c:if test="${ empty user}">
   <div> 对不起，请先<a href="/lxf/test5/todl">登录</a></div>
</c:if>
</body>
</html>