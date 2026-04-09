<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Voting History</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>My Voting History</h1>
<%
    java.util.List<com.example.courseapp.models.Vote> history = 
        (java.util.List<com.example.courseapp.models.Vote>) request.getAttribute("history");
    if (history != null && !history.isEmpty()) {
%>
<table border="1" cellpadding="8">
    <tr>
        <th>Course Name</th>
        <th>Voted Date</th>
    </tr>
    <% for (com.example.courseapp.models.Vote v : history) { %>
    <tr>
        <td><%= v.getCourseName() %></td>
        <td><%= new java.util.Date() %></td>
    </tr>
    <% } %>
</table>
<%
    } else {
%>
<p>You haven't voted for any courses yet.</p>
<%
    }
%>
<br>
<a href="/">Back to Home</a>
</body>
</html>