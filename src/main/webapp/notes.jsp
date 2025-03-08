<%@ page import="org.example.Classes.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notes</title>
    <%@include file="bootstrapConnect.jsp"%>
</head>
<body>
<form class="container mt-3" method="post" action="notes.html">
    <input class="form-control" name="content" value="<%
    Note note = (Note) request.getAttribute("note");
    if (note != null)
        out.print(note.getContent());
    %>">
    <input type="submit" class="btn btn-primary mt-3" value="Save">
</form>
</body>
</html>