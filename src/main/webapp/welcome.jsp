<%@ page import="java.util.*" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    // Set session timeout to 1 minute (60 seconds)
    session.setMaxInactiveInterval(60);

    String name = request.getParameter("username");

    if (name != null) {
        // Store name in session
        session.setAttribute("username", name);
    }

    String user = (String) session.getAttribute("username");

    if (user != null) {
%>
        <h2>Hello, <%= user %>!</h2>
        <p>Session will expire in 1 minute of inactivity.</p>
        <p>Session ID: <%= session.getId() %></p>
        <p>Last Access Time: <%= new Date(session.getLastAccessedTime()) %></p>
<%
    } else {
%>
        <h2>Session expired or not set!</h2>
        <a href="index.jsp">Enter your name again</a>
<%
    }
%>

</body>
</html>