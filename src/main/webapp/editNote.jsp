<%@ page import="org.example.Classes.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Note</title>
    <%@include file="bootstrapConnect.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<form class="container mt-3" method="post" action="editNote.html">
    <% Note noteToEdit = (Note) request.getAttribute("noteToEdit"); %>
    <input class="form-control" name="title" value="<%= noteToEdit.getTitle() %>">
    <input class="form-control" name="content" value="<%= noteToEdit.getContent() %>">
    <input type="hidden" name="id" value="<%= noteToEdit.getId()%>">
    <input type="submit" class="btn btn-primary mt-3" value="Save">
</form>
</body>
</html>
