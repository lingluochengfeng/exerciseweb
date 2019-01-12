<%--
  Created by IntelliJ IDEA.
  User: gaojie
  Date: 2019/1/7
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/static/css/application.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/application.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.js"></script>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="myTag" tagdir="/WEB-INF/tags" %>

<table width="70%" align="center">

    <tr>
        <td colspan=4><a href="${pageContext.request.contextPath}/toCart">查看购物车</a></td>
    </tr>
    <%--设置一个变量--%>
    <c:set var="num" value="0"></c:set>
    <c:forEach var="m" items="${page.result}">
        <c:if test="${num==0}">
            <tr>
        </c:if>
        <td>
            <a href="${pageContext.request.contextPath}/toGoodsDesc/${m.uuid}">
                <table>
                    <tr>
                        <td><img alt="" src="${pageContext.request.contextPath}/static/images/logo.jpg"/></td>
                        <td>${m.description }</td>
                    </tr>
                    <tr>
                        <td>${m.name }</td>
                    </tr>
                </table>
            </a>
        </td>
        <c:set var="num" value="${num+1}"></c:set>
        <c:if test="${num==3}">
            <c:set var="num" value="0"></c:set>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
