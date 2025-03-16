<%@ page import="org.example.Classes.StorageItems.Directory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit directory</title>
    <%@include file="bootstrapConnect.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<% Directory curDir = (Directory)(request.getAttribute("dirToEdit")); %>
<form class="container mt-3" method="post" action="editDir">
    <input class="form-control" name="name" value="<%= curDir.getName() %>" placeholder="Enter directory name">
    <input type="hidden" name="dirId" value="<%= curDir.getId() %>">
    <input type="submit" class="btn btn-primary mt-3" value="Save">
</form>
</body>
</html>
