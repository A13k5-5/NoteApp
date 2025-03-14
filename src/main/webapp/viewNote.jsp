<%@ page import="org.example.Classes.Note" %>
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
            <p class="card-text"><%= curNote.getContent() %></p>
        </div>
    </div>
    <a href="editNote.html?id=<%= curNote.getId() %>" class="btn btn-primary mt-3">Edit</a>
</div>
</body>
</html>
