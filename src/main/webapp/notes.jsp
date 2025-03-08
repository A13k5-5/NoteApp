<%@ page import="org.example.Classes.Note" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notes</title>
    <%@include file="bootstrapConnect.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Note</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Note> notes = (List<Note>) request.getAttribute("notes");
            for (Note n : notes) { %>
        <tr>
            <td>
                <h5><%= n.getTitle() %></h5>
                <p><%= n.getContent() %></p>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>