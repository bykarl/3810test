<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Course List</h1>
<a href="/courses/add">Add New Course</a>
<br><br>
<table border="1">
    <tr>
        <th>Course Name</th>
        <th>Description</th>
        <th>Teacher</th>
        <th>Votes</th>
        <th>Action</th>
    </tr>
    <% for (com.example.courseapp.models.Course c : (java.util.List<com.example.courseapp.models.Course>) request.getAttribute("courses")) { %>
    <tr>
        <td><%= c.getCourseName() %></td>
        <td><%= c.getDescription() %></td>
        <td><%= c.getTeacherName() %></td>
        <td><%= c.getVoteCount() %></td>
        <td>
            <a href="/courses/edit/<%= c.getId() %>">Edit</a>
            &nbsp;
            <a href="/courses/delete/<%= c.getId() %>" onclick="return confirm('Delete?')">Delete</a>
            &nbsp;
            <a href="/enroll/<%= c.getId() %>">Enroll</a>
            &nbsp;
            <a href="/vote/<%= c.getId() %>">Vote 👍</a>
            &nbsp;
            <!-- 新增：评论入口 -->
            <a href="/courses/<%= c.getId() %>/comments">Comments</a>
        </td>
    </tr>
    <% } %>
</table>
<br>
<a href="/">Back to Home</a>
</body>
</html>