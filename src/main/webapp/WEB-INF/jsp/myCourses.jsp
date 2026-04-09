<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Courses</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>My Enrolled Courses</h1>

<table border="1">
    <tr>
        <th>Course Name</th>
        <th>Description</th>
        <th>Teacher</th>
    </tr>
    <% for (com.example.courseapp.models.Course c : (java.util.List<com.example.courseapp.models.Course>) request.getAttribute("myCourses")) { %>
    <tr>
        <td><%= c.getCourseName() %></td>
        <td><%= c.getDescription() %></td>
        <td><%= c.getTeacherName() %></td>
    </tr>
    <% } %>
</table>

<br>
<a href="/courses">Browse More Courses</a><br>
<a href="/">Back to Home</a>
</body>
</html>