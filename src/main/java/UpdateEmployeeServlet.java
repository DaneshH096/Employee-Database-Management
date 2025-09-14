import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String designation = request.getParameter("designation");

            Employee emp = new Employee(id, firstName, lastName, salary, designation);
            EmployeeDAO dao = new EmployeeDAOImpl();
            dao.updateEmployee(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("employee.jsp");
    }
}