<%@ page import="java.io.*" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<%
    int num = Integer.parseInt(request.getParameter("num"));
    boolean isPrime = true;

    if (num <= 1) {
        isPrime = false;
    } else {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
    }

    if (isPrime) {
%>
        <h3><%= num %> is a Prime Number</h3>
<%
    } else {
%>
        <h3><%= num %> is NOT a Prime Number</h3>
<%
    }
%>

<br>
<a href="index.html">Check another number</a>

</body>
</html>