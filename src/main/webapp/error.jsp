<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%@include file="header.jsp"%>
    <div class="container mt-4">
        <div class="alert alert-info">
            <p><%= request.getAttribute("message") %></p>
        </div>
    </div>
</body>
</html>
