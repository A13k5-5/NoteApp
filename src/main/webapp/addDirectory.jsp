<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add directory</title>
    <%@include file="bootstrapConnect.jsp"%>
</head>
<body>
<form class="container mt-3" method="post" action="addNote.html?dir=true">
    <input class="form-control" name="name" placeholder="Title">
    <input type="submit" class="btn btn-primary mt-3" value="Save">
</form>
</body>
</html>
