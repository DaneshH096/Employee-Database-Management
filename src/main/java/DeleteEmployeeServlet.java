import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class DeleteEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            EmployeeDAO dao = new EmployeeDAOImpl();
            boolean status = dao.deleteEmployee(id);
            if (status) {
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