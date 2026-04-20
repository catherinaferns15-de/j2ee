package basic;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitServlet1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        int count = 1;
        boolean returningUser = false;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("user")) {
                    name = c.getValue();
                    returningUser = true;
                }

                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        // Create cookies
        Cookie nameCookie = new Cookie("user", name);
        Cookie countCookie = new Cookie("count", String.valueOf(count));

        // Set expiry time (1 minute for demo)
        nameCookie.setMaxAge(60);
        countCookie.setMaxAge(60);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // Output response
        out.println("<html><body>");

        if (returningUser) {
            out.println("<h2>Welcome back " + name + "!</h2>");
        } else {
            out.println("<h2>Welcome " + name + "!</h2>");
        }

        out.println("<p>You have visited this page " + count + " times.</p>");

        // Display cookies and their set values
        out.println("<h3>Cookies List (Name & Values):</h3>");
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("Cookie Name: " + c.getName() +
                            " | Value: " + c.getValue() + "<br>");
            }
        }

        out.println("<br><b>Note:</b> Cookies will expire in 60 seconds.");
        out.println("<br>After expiry, visit count resets.");

        out.println("</body></html>");
    }
}