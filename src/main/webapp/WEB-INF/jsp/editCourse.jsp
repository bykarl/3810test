<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Course</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Edit Course</h1>
<% com.example.courseapp.models.Course c = (com.example.courseapp.models.Course) request.getAttribute("course"); %>
<form action="/courses/edit/<%= c.getId() %>" method="post">
    Course Name: <input name="courseName" value="<%= c.getCourseName() %>" required><br>
    Description: <input name="description" value="<%= c.getDescription() %>" required><br>
    Teacher Name: <input name="teacherName" value="<%= c.getTeacherName() %>" required><br>
    <button type="submit">Update</button>
</form>
<br>
<a href="/courses">Back to List</a>
</body>
</html>