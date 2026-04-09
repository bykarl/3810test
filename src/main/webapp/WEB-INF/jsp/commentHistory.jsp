<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Comment History</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>My Comment History</h1>
<%
    java.util.List<com.example.courseapp.models.Comment> comments = 
        (java.util.List<com.example.courseapp.models.Comment>) request.getAttribute("comments");
    if (comments != null && !comments.isEmpty()) {
%>
<table border="1" cellpadding="8">
    <tr>
        <th>Course</th>
        <th>Comment</th>
    </tr>
    <% for (com.example.courseapp.models.Comment c : comments) { %>
    <tr>
        <td><%= c.getCourseName() %></td>
        <td><%= c.getContent() %></td>
    </tr>
    <% } %>
</table>
<%
    } else {
%>
<p>You haven't posted any comments yet.</p>
<%
    }
%>
<br>
<a href="/">Back to Home</a>
</body>
</html>