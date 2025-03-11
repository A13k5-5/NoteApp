<%@ page import="org.example.Classes.Note" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.Classes.Directory" %>
<%@ page import="org.example.Classes.StorageItem" %>
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
for(Directory d : curDir.getDirectories()) {
%>
    <p><%= d.getName() %></p>
<% } %>
<div class="container mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Note</th>
        </tr>
        </thead>
        <tbody>
        <% for (Note n : curDir.getNotes()) { %>
        <tr>
            <td>
                <h5><%= n.getName() %></h5>
                <p><%= n.getContent() %></p>
                <a href="editNote.html?id=<%= n.getId() %>" class="btn btn-primary mt-3">Edit</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>