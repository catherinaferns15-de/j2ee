package basic;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        try {
            int sub1 = Integer.parseInt(request.getParameter("sub1"));
            int sub2 = Integer.parseInt(request.getParameter("sub2"));
            int sub3 = Integer.parseInt(request.getParameter("sub3"));
            int sub4 = Integer.parseInt(request.getParameter("sub4"));
            int sub5 = Integer.parseInt(request.getParameter("sub5"));

            // Server-side validation
            if (rollno.isEmpty() || name.isEmpty() ||
                sub1 < 0 || sub1 > 100 ||
                sub2 < 0 || sub2 > 100 ||
                sub3 < 0 || sub3 > 100 ||
                sub4 < 0 || sub4 > 100 ||
                sub5 < 0 || sub5 > 100) {

                request.setAttribute("error", "Invalid input!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }

            // Calculate average
            double average = (sub1 + sub2 + sub3 + sub4 + sub5) / 5.0;

            // Check pass condition
            boolean pass = (sub1 >= 40 && sub2 >= 40 && sub3 >= 40 && sub4 >= 40 && sub5 >= 40);

            String result = pass ? "Pass" : "Fail";

            // Set attributes
            request.setAttribute("rollno", rollno);
            request.setAttribute("name", name);
            request.setAttribute("sub1", sub1);
            request.setAttribute("sub2", sub2);
            request.setAttribute("sub3", sub3);
            request.setAttribute("sub4", sub4);
            request.setAttribute("sub5", sub5);
            request.setAttribute("average", average);
            request.setAttribute("result", result);

            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Marks must be numeric!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}