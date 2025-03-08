<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form class="container mt-3" method="post" action="data.html">
    <input class="form-control" name="data" value="<%
    List<String> data = (List<String>) request.getAttribute("data");
    StringBuilder concatenatedData = new StringBuilder();
    for (String dat : data) {
        concatenatedData.append(dat).append(" ");
    }
    out.print(concatenatedData.toString().trim());
%>">
    <input type="submit" class="btn btn-primary mt-3" value="Save">
</form>
</body>
</html>