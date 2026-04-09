<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Login</h1>
    <%-- 👇 表单action必须和Security的loginProcessingUrl一致 --%>
    <form action="/doLogin" method="post">
    <input type="text" name="username" required>
    <input type="password" name="password" required>
    <button type="submit">Login</button>
</form>
    <br>
    <a href="/register">Create a new account</a>
</body>
</html>