<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!!!！</h2>
<a href="/test/href1">测试页面一</a>
<a href="/test/href2">测试页面二</a>
<input type="text" id="data" name="data" onchange="changeUrl(this)"><br/>
<a id="test3" href="test/href3/data=">测试页面三</a>
<br/><br/><br/>

<p>GET实现输出两个数之间的一个随机数</p>
<form id="form1" action="/test/href4" method="get">
    Begin:<input type="text" name="t1"><br>
    End:<input type="text" name="t2"><br>
    <input type="submit" value="点击提交">
</form>
<p>POST实现输出两个数之间的一个随机数</p>
<form id="form2" action="/test/href5" method="post">
    Begin:<input type="text" name="t11"><br>
    End:<input type="text" name="t22"><br>
    <input type="submit" value="点击提交">
</form>

</body>
<script>
    function changeUrl(obj){
        document.getElementById("test3").href="test/href3/data="+obj.value;
    }
</script>
</html>
