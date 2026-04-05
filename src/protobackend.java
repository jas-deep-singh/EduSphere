import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class protobackend {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sic = request.getParameter("sic");
        String password = request.getParameter("password");

        String upper = "";
        String lower = "";

        if (password.equals("12345")) {
            upper = sic.toUpperCase();
            lower = sic.toLowerCase();
        } else {
            upper = "cant do bro";
            lower = "cant do bro";
        }

        out.println("<html><body>");

        out.println("<h2>Result</h2>");

        out.println("<input type='text' value='" + upper + "' readonly><br><br>");
        out.println("<input type='text' value='" + lower + "' readonly>");

        out.println("</body></html>");
    }
}
