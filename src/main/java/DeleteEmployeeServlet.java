import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DeleteEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee", "root", "root123");

            PreparedStatement ps = con.prepareStatement("DELETE FROM emp WHERE id=?");
            ps.setInt(1, id);
            int status = ps.executeUpdate();
            con.close();

            if (status > 0) {
                response.sendRedirect("employee.jsp");
            } else {
                response.getWriter().println("Failed to delete employee.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}