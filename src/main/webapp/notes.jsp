<%@ page import="org.example.Classes.StorageItems.Note" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.Classes.StorageItems.Directory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notes</title>
    <%@include file="bootstrapConnect.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<form class="container mt-3" action="search">
    <div class="form-row align-items-center">
        <div class="col-auto">
            <input class="form-control mb-2" type="text" name="keywords" placeholder="Search">
        </div>
        <div class="col-auto">
            <input type="submit" class="btn btn-primary mb-2" value="Search">
        </div>
    </div>
</form>
<form class="container mt-3" action="sort" method="get">
    <div class="form-row align-items-center">
        <div class="col-auto">
            <select class="form-control mb-2" name="sortOrder">
                <option value="a-z">A-Z</option>
                <option value="z-a">Z-A</option>
                <option value="oldest-to-newest">Oldest to Newest</option>
                <option value="newest-to-oldest">Newest to Oldest</option>
            </select>
        </div>
        <div class="col-auto">
            <input type="submit" class="btn btn-primary mb-2" value="Sort">
        </div>
    </div>
</form>
<div class="container mt-3">
    <%if (!curDir.isRoot()) {%>
        <a href="goBack.html" class="btn btn-primary mt-3">Go Back</a>
    <% } %>
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
                <a href="delete?id=<%= d.getId() %>&type=dir" class="btn btn-danger mt-3">Delete</a>
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
                <a href="viewNote.html?id=<%= n.getId() %>" class="btn btn-primary mt-3">View</a>
                <a href="editNote.html?id=<%= n.getId() %>" class="btn btn-primary mt-3">Edit</a>
                <a href="delete?id=<%= n.getId() %>&type=note" class="btn btn-danger mt-3">Delete</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>