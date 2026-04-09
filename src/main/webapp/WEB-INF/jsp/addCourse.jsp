<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Course</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Add New Course</h1>
<form action="/courses/add" method="post">
    Course Name: <input name="courseName" required><br>
    Description: <input name="description" required><br>
    Teacher Name: <input name="teacherName" required><br>
    <button type="submit">Save</button>
</form>
<br>
<a href="/courses">Back to List</a>
</body>
</html>