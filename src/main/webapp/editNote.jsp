<%@ page import="org.example.Classes.StorageItems.Note" %>
<%@ page import="org.example.Classes.Contents.Text" %>
<%@ page import="org.example.Classes.Contents.Content" %>
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
    <input class="form-control" name="title" value="<%= noteToEdit.getName() %>">
    <%
    for (Content content : noteToEdit.getContent()) {
    %>
        <textarea class="form-control" name="content_<%= content.getId() %>"><%= content.getType().equals("Text") ? ((Text)content).getText() : "Image" %></textarea>
    <% } %>
    <input type="hidden" name="noteId" value="<%= noteToEdit.getId() %>">
    <a href="addContent?id=<%= noteToEdit.getId() %>&type=text" class="btn btn-primary mt-3">Add Text</a>
    <input type="submit" class="btn btn-primary mt-3" value="Save">
</form>
</body>
</html>
