<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aniam
  Date: 4/13/2020
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="grandparent-container">
    <div id="parent-container">
        <h1>Available resources are:</h1>
        <table id="table">
            <c:forEach items="${resources}" var="resources">
                <div style="margin-bottom: 5px">
                    <c:out value="${resources.name}"></c:out>
                    <a href="resourceDetail.jsp?content=${resources.content}">
                        <input type="submit"  value="Details"/></a>
                </div>
            </c:forEach>
        </table>

        <div style="margin-top: 20px">
            <button type="submit">Log Out</button>
        </div>
    </div>
</div>

</body>
</html>
