<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Management System</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Course Management System</h1>
    <hr>

    <% 
        Object user = session.getAttribute("loginUser");
        if (user != null) { 
            com.example.courseapp.models.User loginUser = (com.example.courseapp.models.User) user;
    %>
        <h3>Welcome, <%= loginUser.getUsername() %>!</h3>

        <a href="/courses">Course List</a> | 
        <a href="/myCourses">My Enrolled Courses</a> | 
        <a href="/voteHistory">My Voting History</a> | 
        <a href="/commentHistory">My Comment History</a> | 
        <a href="/logout">Logout</a>

    <% } else { %>

        <a href="/login">Login</a> | 
        <a href="/register">Register</a>

    <% } %>
</body>
</html>