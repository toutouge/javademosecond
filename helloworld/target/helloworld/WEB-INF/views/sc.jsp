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
</head>
<body>
选择文件： <input type="file" name="file" id="file"><br>
点击上传： <input type="button" name="sc" id="sc" value="Click Me" onclick="uploadWJ()"><br>
返回的url： <input type="text" id="url" name="url" placeholder="返回的url">
</body>
<script src="/js/jquery-1.8.3.min.js"></script>
<script src="/js/ajaxfileupload.js"></script>
<script>
    function uploadWJ() {
        var filename = $("#file").val();
        alert(filename);
        //执行上传文件操作的函数
        $.ajaxFileUpload({
            //处理文件上传操作的服务器端地址
            url: 'lxf/upload/file',
            enctype: "multipart/form-data",
            secureuri: false,                       //是否启用安全提交,默认为false
            fileElementId: 'file',                        //文件选择框的id属性
            dataType: "json",                       //服务器返回的格式,可以是json或xml等
            data: {
                filename: filename
            },
            success: function (data) {
                debugger
                if (data.success == 1) {
                    alert('文件上传成功，地址是' + data.url)
                    $("#url").val('' + data.url)
                }
                else
                    alert(data.message)
            },
            error: function (msg) {
                alert(msg.responseText);
            }
        });
    }
</script>
</html>