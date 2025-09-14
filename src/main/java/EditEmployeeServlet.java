import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            EmployeeDAO dao = new EmployeeDAOImpl();
            Employee emp = dao.getEmployeeById(id);
            if (emp != null) {
                request.setAttribute("emp", emp);
                RequestDispatcher rd = request.getRequestDispatcher("editEmployee.jsp");
                rd.forward(request, response);
            } else {
                response.getWriter().println("Employee not found.");
            }
        } catch(Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}