import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class AddEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        float salary = Float.parseFloat(request.getParameter("salary"));
        String designation = request.getParameter("designation");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("<script>alert('JDBC Driver loaded successfully');</script>");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root123");
            out.println("<script>alert('Connected to the database');</script>");
            PreparedStatement ps = con.prepareStatement("Insert into emp values (?, ?, ?, ?, ?);");
            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setFloat(4, salary);
            ps.setString(5, designation);

            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Employee added successfully!');");
                out.println("location='index.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('Failed to add employee.');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Error: " + e.getMessage() +  "');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }
}
