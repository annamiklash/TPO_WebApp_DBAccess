<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aniam
  Date: 4/13/2020
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <link rel="stylesheet" href="resourceDetail.css">
</head>
<body>
<div id="grandparent-container">
    <div id="parent-container">

        <form  id='detailsForm' action="${pageContext.request.contextPath}/resourceDetail" method="get">
            <h1 style="color: darkblue">Details:</h1>

            <div style="margin-top: 20px">
                <% String details = request.getParameter("details"); %>
                <p>
                    <%out.print(details); %>
                </p>
                <%
                    out.println("<a href =" + details + "  target=\"_blank\">Click To Go To Website</a>");
                %>
                <div style="margin-top: 20px">
                    <button type="submit" formaction="${pageContext.request.contextPath}/logout" formmethod="post">Log
                        Out
                    </button>
                    <button type="submit" formaction="${pageContext.request.contextPath}/result" formmethod="get">Go
                        Back
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
