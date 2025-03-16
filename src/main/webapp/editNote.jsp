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
<form class="container mt-3" method="post" action="editNote.html" enctype="multipart/form-data">
    <% Note noteToEdit = (Note) request.getAttribute("noteToEdit"); %>
    <input class="form-control" name="title" value="<%= noteToEdit.getName() %>">
    <%
        for (Content content : noteToEdit.getContent()) {
            if (content.getType().equals("Text")) {
    %>
    <textarea class="form-control" name="content_<%= content.getId() %>"><%= ((Text)content).getText() %></textarea>
    <% } else if (content.getType().equals("Image")) { %>
    <div class="form-group mt-3">
        <label for="img_<%= content.getId() %>">Upload Image</label>
        <input class="form-control-file" type="file" name="img_<%= content.getId() %>" id="img_<%= content.getId() %>">
    </div>
    <% } %>
    <div class="mt-3">
        <a href="deleteContent?contentId=<%= content.getId() %>&noteId=<%= noteToEdit.getId() %>" class="btn btn-danger">Delete</a>
    </div>
    <% } %>
    <input type="hidden" name="noteId" value="<%= noteToEdit.getId() %>">
    <a href="addContent?id=<%= noteToEdit.getId() %>&type=text" class="btn btn-primary mt-3">Add Text</a>
    <a href="addContent?id=<%= noteToEdit.getId() %>&type=image" class="btn btn-primary mt-3">Add Image</a>
    <input type="submit" class="btn btn-primary mt-3" value="Save">
</form>
</body>
</html>