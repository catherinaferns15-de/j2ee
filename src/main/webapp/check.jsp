<%@ page import="java.util.*" %>
<html>
<head>
    <title>Session Check</title>
</head>
<body>

<%
    String user = (String) session.getAttribute("username");

    if (user != null) {
%>
        <h2>Hello again, <%= user %>!</h2>
        <p>Session is still active.</p>
        <p>Session ID: <%= session.getId() %></p>
        <p>Last Access Time: <%= new Date(session.getLastAccessedTime()) %></p>

        <p><a href="check.jsp">Refresh to continue session</a></p>
<%
    } else {
%>
        <h2>Session has expired!</h2>
        <p>Please enter your details again.</p>
        <a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>