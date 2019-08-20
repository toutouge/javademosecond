<%--
  Created by IntelliJ IDEA.
  User: toutou
  Date: 2018/2/17
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .table-b td {
        border: 1px solid black
    }
</style>
<body>
<table class="table-b">
    <tr>
        <td>序号</td>
        <td>ID</td>
        <td>姓名</td>
        <td>性别</td>
        <td>生成时间</td>
    </tr>
    <c:choose>
        <c:when test="${empty list}">
            没有数据！
        </c:when>
        <c:otherwise>
            <c:forEach items="${list}" var="one" varStatus="num" >
                <tr>
                    <td>${num.count}</td>
                    <td>${one.id}</td>
                    <td>${one.name}</td>
                    <td>
                            ${one.sex eq 0 ?'男':'女'}

                            <%--<c:if test="${one.sex eq 0}" >--%>
                            <%--男--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${one.sex eq 1}">--%>
                            <%--女--%>
                            <%--</c:if>--%>


                            <%--<c:choose>--%>
                            <%--<c:when test="${one.sex eq 0}">--%>
                            <%--男--%>
                            <%--</c:when>--%>
                            <%--<c:when test="${one.sex eq 1}">--%>
                            <%--女--%>
                            <%--</c:when>--%>
                            <%--<c:otherwise>--%>
                            <%--不知道性别--%>
                            <%--</c:otherwise>--%>
                            <%--</c:choose>--%>

                    </td>
                    <td><fmt:formatDate value='${one.createtime}' type="both"/></td>
                </tr>

            </c:forEach>
        </c:otherwise>
    </c:choose>


</table>
</body>
</html>
