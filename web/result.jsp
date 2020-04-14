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
    <title>Result</title>
    <link rel="stylesheet" href="result.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/result" method="post">
    <div id="grandparent-container">
        <div id="parent-container">
            <h1 style="color: darkblue">Available resources are:</h1>
            <table id="table">
                <c:forEach items="${resources}" var="resources">
                    <div style="margin-bottom: 10px">
                        <c:out value="${resources.name}"></c:out>
                        <button style="margin-left: 40px" type="submit" name="details" value="${resources.content}"
                                formaction="${pageContext.request.contextPath}/resourceDetail" formmethod="get">Details
                        </button>
                    </div>
                </c:forEach>
            </table>

            <div style="margin-top: 20px">
                <button type="submit" formaction="${pageContext.request.contextPath}/logout" formmethod="post">Log Out
                </button>
                <button type="submit" formaction="${pageContext.request.contextPath}/login" formmethod="get">Go Back
                </button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
