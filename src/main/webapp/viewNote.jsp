<%@ page import="org.example.Classes.StorageItems.Note" %>
<%@ page import="org.example.Classes.Contents.Text" %>
<%@ page import="org.example.Classes.Contents.Content" %>
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
        %>
            <p class="card-text"><%= content.getType().equals("Text") ? ((Text)content).getText() : "Image" %></p>
        <% } %>
        </div>
    </div>
    <a href="editNote.html?id=<%= curNote.getId() %>" class="btn btn-primary mt-3">Edit</a>
</div>
</body>
</html>
