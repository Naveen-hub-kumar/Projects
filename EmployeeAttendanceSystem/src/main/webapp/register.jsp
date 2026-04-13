<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>Register</h2>

    <form action="RegisterServlet" method="post">
        <input type="text" name="username" placeholder="Enter Username" required><br>
        <input type="password" name="password" placeholder="Enter Password" required><br>
        <input type="submit" value="Register">
    </form>

    <br>
    <a href="login.jsp">Already have account? Login</a>
</div>

</body>
</html>