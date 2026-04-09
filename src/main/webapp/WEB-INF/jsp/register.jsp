<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Register</h1>

    <form action="/register" method="post">
        <div>
            <label>Username:</label>
            <input name="username" required>
        </div>
        <div>
            <label>Password:</label>
            <input name="password" type="password" required>
        </div>
        <div>
            <label>Full Name:</label>
            <input name="fullName" required>
        </div>
        <div>
            <label>Email:</label>
            <input name="email" required>
        </div>
        <button type="submit">Register</button>
    </form>

    <br>
    <a href="/login">Back to Login</a>
</body>
</html>