<%@ page import="java.util.List" %>
<%@ page import="org.example.Classes.StorageItems.Note" %>
<%@ page import="org.example.Classes.StorageItems.Directory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search result page</title>
    <%@include file="bootstrapConnect.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<% Directory searchResult = (Directory) request.getAttribute("searchResult"); %>
<%
for (Note n : searchResult.getNotes()) {
%>
    <h1><%= n.getName() %></h1>
<% } %>
</body>
</html>
