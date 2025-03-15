<%@ page import="org.example.Classes.StorageItems.Note" %>
<%@ page import="org.example.Classes.Contents.Text" %>
<%@ page import="org.example.Classes.Contents.Content" %>
<%@ page import="org.example.Classes.Contents.Image" %>
<%@ page import="java.util.Base64" %>
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
        <%
        for (Content content : curNote.getContent()) {
        %>
            <div class="card-body">
                <% if (content.getType().equals("Text")) {%>
                    <p class="card-text"><%= ((Text)content).getText() %></p>
                <% } else if (content.getType().equals("Image")) {%>
                    <% String base64Image = Base64.getEncoder().encodeToString(((Image)content).getImageData()); %>
                    <img src="data:image/jpeg;base64,<%= base64Image %>" class="img-fluid" alt="Image content">
                <% } %>

            </div>
        <% } %>
    </div>
    <a href="editNote.html?id=<%= curNote.getId() %>" class="btn btn-primary mt-3">Edit</a>
</div>
</body>
</html>
