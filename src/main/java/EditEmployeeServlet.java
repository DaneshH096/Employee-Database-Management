import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root123");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM emp WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // set employee data as request attributes
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("firstName", rs.getString("firstName"));
                request.setAttribute("lastName", rs.getString("lastName"));
                request.setAttribute("salary", rs.getDouble("salary"));
                request.setAttribute("designation", rs.getString("designation"));

                // forward to editEmployee.jsp
                RequestDispatcher rd = request.getRequestDispatcher("editEmployee.jsp");
                rd.forward(request, response);
            } else {
                response.getWriter().println("Employee not found.");
            }

            con.close();
        } catch(Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
