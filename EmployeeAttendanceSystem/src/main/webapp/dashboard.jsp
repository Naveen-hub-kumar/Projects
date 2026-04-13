<%@ page session="true" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<%
    String user = (String) session.getAttribute("user");
    if(user == null){
        response.sendRedirect("login.jsp");
    }
%>

<div class="container">
    <h2>Welcome <%= user %></h2>

    <form action="AttendanceServlet" method="post">
        <input type="submit" class="dashboard-btn" name="status" value="Present">
        <input type="submit" class="dashboard-btn" name="status" value="Absent">
    </form>
</div>

</body>
</html>