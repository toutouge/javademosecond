<%--
  Created by IntelliJ IDEA.
  User: toutou
  Date: 2018/2/16
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<label for="form2">表单传值，user对象传到后台，注意，< input > 的 name 对应后台user的属性</label>
<form id="form2" action="" method="post">
    Name:<input type="text" name="name"><br/>
    Sex:<input type="text" name="sex"><br/>
    <input type="submit" value="点击提交">
</form>
<p>反馈信息:${result}</p>
</body>
</html>
