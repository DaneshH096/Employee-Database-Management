package dao;
import java.util.List;
import model.Employee;

public interface EmployeeDAO {
    boolean addEmployee(Employee emp) throws Exception;
    boolean updateEmployee(Employee emp) throws Exception;
    boolean deleteEmployee(int id) throws Exception;
    Employee getEmployeeById(int id) throws Exception;
    List<Employee> getAllEmployees() throws Exception;
}