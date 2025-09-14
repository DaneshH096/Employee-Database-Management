import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class AddEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String designation = request.getParameter("designation");

            Employee emp = new Employee(id, firstName, lastName, salary, designation);
            EmployeeDAO dao = new EmployeeDAOImpl();

            boolean ok = dao.addEmployee(emp);
            if (ok) {
                response.sendRedirect("employee.jsp");
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('Failed to add employee.');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }
        } catch (Exception e) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Error: " + e.getMessage().replace("\"","'") +  "');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }
}