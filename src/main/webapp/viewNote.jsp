<%@ page import="org.example.Classes.StorageItems.Note" %>
<%@ page import="org.example.Classes.Contents.Text" %>
<%@ page import="org.example.Classes.Contents.Content" %>
<%@ page import="org.example.Classes.Contents.Image" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Note</title>
    <%@include file="bootstrapConnect.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<%
    Note curNote = (Note) request.getAttribute("note");
%>
<div class="container mt-3">
    <a href="notes.html" class="btn btn-primary mt-3">Back</a>
    <div class="card">
        <div class="card-header">
            <h1><%= curNote.getName() %></h1>
        </div>
        <div class="card-body">
        <%
        for (Content content : curNote.getContent()) {
            if (content.getType().equals("Text")) {
        %>
                <p class="card-text"><%= ((Text)content).getText() %></p>
        <% } else if(content.getType().equals("Image")) { %>
                <img src="/<%= ((Image)content).getPath() %>" alt="<%= ((Image)content).getDescription() %>" class="img-fluid rounded mb-3">
            <% } %>
        <% } %>
        </div>
    </div>
    <a href="editNote.html?id=<%= curNote.getId() %>" class="btn btn-primary mt-3">Edit</a>
</div>
</body>
</html>
