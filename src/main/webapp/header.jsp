<%@ page import="org.example.Classes.StorageItems.Directory" %>
<%@include file="bootstrapConnect.jsp"%>
<%
    Directory curDir = (Directory) request.getAttribute("curDir");
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">NoteApp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">Show Notes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="addNote.html">Add Note</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="addDirectory.html">Add Dir</a>
                </li>
            </ul>
            <% if (curDir != null) {%>
                <div class="nav-link ml-auto">Current directory: <%= curDir.getName() %></div>
            <% } %>
        </div>
    </div>
</nav>