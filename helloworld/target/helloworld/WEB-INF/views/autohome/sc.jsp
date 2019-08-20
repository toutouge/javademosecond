<%--
  Created by IntelliJ IDEA.
  User: 11655
  Date: 2017/4/24
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.8.3.min.js"></script>
    <script src="/js/ajaxfileupload.js"></script>
</head>
<body>
<h2>JQuery ajaxfileupload文件上传</h2>
<div id="loading" style="display: none;">正在上传.....</div>
用户信息：
<br /> 姓名：
<input id="name" name="name" type="text">
<br /> 附件：
<input id="fileToUpload" name="file" type="file" class="input">
<br />
<input type="button" onclick="ajaxFileUpload()" value="上传">
<br />

<script type="text/javascript">
    function ajaxFileUpload() {
        $('#loading').show();
        $.ajaxFileUpload({
            url : '/lxf/upload/mvc/upload',
            secureuri : false,
            fileElementId : 'fileToUpload',
            dataType : 'json',//此时指定的是后台需要返回json字符串,前端自己解析,可以注释掉.后台直接返回map
            data : {
                name : $('#name').val()
            },
            success : function(data, status) {
                alert("success");
                console.log(data);
                $('#loading').hide();
            },
            error : function(data, status, e) {
                $('#loading').hide();
                //这里处理的是网络异常，返回参数解析异常，DOM操作异常
                alert("上传发生异常");
            }
        })
    }
</script>
</body>
</html>