<%@ page import="org.example.Classes.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Note</title>
    <%@include file="bootstrapConnect.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<form class="container mt-3" method="post" action="addNote.html">
    <input class="form-control" name="name" placeholder="Title">
    <input class="form-control" name="content" placeholder="Add Note Content">
    <input type="submit" class="btn btn-primary mt-3" value="Save">
</form>
</body>
</html>
