<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pison_p
  Date: 3/7/2025
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
<%
    List<String> data = (List<String>) request.getAttribute("data");
    for (String dat : data) {
%>
    <li><%=dat%></li>
<%
    }
%>
</ul>

</body>
</html>
