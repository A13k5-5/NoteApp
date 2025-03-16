<%@ page import="org.example.Classes.StorageItems.Note" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.Classes.StorageItems.Directory" %>
<%@ page import="org.example.Classes.StorageItems.StorageItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notes</title>
    <%@include file="bootstrapConnect.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>

<%
Directory curDir = (Directory) request.getAttribute("contents");
%>
<div class="container mt-3">
    <a href="goBack.html" class="btn btn-primary mt-3">Back</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Directories</th>
        </tr>
        </thead>
        <tbody>
        <% for(Directory d : curDir.getDirectories()) { %>
        <tr>
            <td>
                <h5><%= d.getName() %></h5>
                <a href="changeCurDir.html?newDirId=<%= d.getId() %>" class="btn btn-primary mt-3">Open</a>
                <a href="editDir?dirId=<%= d.getId() %>" class="btn btn-primary mt-3">Edit</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<div class="container mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Notes</th>
        </tr>
        </thead>
        <tbody>
        <% for (Note n : curDir.getNotes()) { %>
        <tr>
            <td>
                <h5><%= n.getName() %></h5>
<%--                <p><%= n.getContent() %></p>--%>
                <a href="viewNote.html?id=<%= n.getId() %>" class="btn btn-primary mt-3">View</a>
                <a href="editNote.html?id=<%= n.getId() %>" class="btn btn-primary mt-3">Edit</a>
                <a href="deleteNote.html?id=<%= n.getId() %>" class="btn btn-danger mt-3">Delete</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>