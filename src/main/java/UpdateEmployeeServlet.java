import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String designation = request.getParameter("designation");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root123");

            PreparedStatement ps = con.prepareStatement(
                "UPDATE emp SET firstName=?, lastName=?, salary=?, designation=? WHERE id=?");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setDouble(3, salary);
            ps.setString(4, designation);
            ps.setInt(5, id);

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("employee.jsp");
    }
}

