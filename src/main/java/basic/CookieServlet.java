package basic;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        int visitCount = 1;
        boolean foundUser = false;

        Cookie cookies[] = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    name = c.getValue();
                    foundUser = true;
                }
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        // Create/update cookies
        Cookie userCookie = new Cookie("username", name);
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry (60 seconds for demo)
        userCookie.setMaxAge(60);
        visitCookie.setMaxAge(60);

        response.addCookie(userCookie);
        response.addCookie(visitCookie);

        // Output
        out.println("<html><body>");

        if (foundUser) {
            out.println("<h2>Welcome back " + name + "!</h2>");
        } else {
            out.println("<h2>Welcome " + name + "!</h2>");
        }

        out.println("<p>You have visited this page " + visitCount + " times.</p>");

        // Display all cookies
        out.println("<h3>List of Cookies:</h3>");
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("Name: " + c.getName() + " Value: " + c.getValue() + "<br>");
            }
        }

        out.println("<br><p><b>Note:</b> Cookies will expire in 60 seconds.</p>");

        out.println("</body></html>");
    }
}