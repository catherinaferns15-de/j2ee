<%@ page import="java.util.*" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<%
    String name = request.getParameter("username");
    String expiryStr = request.getParameter("expiry");

    if (name != null && expiryStr != null) {
        int expiry = Integer.parseInt(expiryStr) * 60; // convert minutes to seconds

        // Set session timeout
        session.setMaxInactiveInterval(expiry);

        // Store values in session
        session.setAttribute("username", name);
        session.setAttribute("expiryTime", expiryStr);
    }

    String user = (String) session.getAttribute("username");
%>

<% if (user != null) { %>
    <h2>Hello, <%= user %>!</h2>
    <p>Session expiry time: <%= session.getAttribute("expiryTime") %> minute(s)</p>

    <p>
        <a href="check.jsp">Click here to check session status</a>
    </p>

    <p>Try clicking the link within the session time OR wait to see session expiry.</p>
<% } else { %>
    <h2>Session not available!</h2>
    <a href="index.jsp">Go Back</a>
<% } %>

</body>
</html>