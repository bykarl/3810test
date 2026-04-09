<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comments</title>
    <meta charset="UTF-8">
</head>
<body>
<%
    com.example.courseapp.models.Course course = (com.example.courseapp.models.Course) request.getAttribute("course");
    if (course == null) {
%>
    <h1>Course not found</h1>
    <a href="/courses">Back to Courses</a>
<%
        return;
    }
%>
<h1>Comments for <%= course.getCourseName() %></h1>

<form action="/comments/add" method="post">
    <input type="hidden" name="courseId" value="<%= course.getId() %>">
    <textarea name="content" placeholder="Write a comment..." rows="4" cols="50" required></textarea><br>
    <button type="submit">Post Comment</button>
</form>

<hr>
<h3>All Comments</h3>
<%
    java.util.List<com.example.courseapp.models.Comment> comments = 
        (java.util.List<com.example.courseapp.models.Comment>) request.getAttribute("comments");
    if (comments != null && !comments.isEmpty()) {
        for (com.example.courseapp.models.Comment c : comments) {
%>
<div style="border:1px solid #ccc; padding:8px; margin:8px 0;">
    <strong><%= c.getUsername() %>:</strong> <%= c.getContent() %>
</div>
<%
        }
    } else {
%>
<p>No comments yet.</p>
<%
    }
%>

<br>
<a href="/courses">Back to Course List</a>
</body>
</html>