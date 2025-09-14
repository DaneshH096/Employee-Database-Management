package dao;
import util.DBConnection;
import model.Employee;
import java.sql.*;
import java.util.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public boolean addEmployee(Employee emp) throws Exception {
        String sql = "INSERT INTO emp (id, firstName, lastName, salary, designation) VALUES (?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getFirstName());
            ps.setString(3, emp.getLastName());
            ps.setDouble(4, emp.getSalary());
            ps.setString(5, emp.getDesignation());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateEmployee(Employee emp) throws Exception {
        String sql = "UPDATE emp SET firstName=?, lastName=?, salary=?, designation=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getDesignation());
            ps.setInt(5, emp.getId());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteEmployee(int id) throws Exception {
        String sql = "DELETE FROM emp WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Employee getEmployeeById(int id) throws Exception {
        String sql = "SELECT * FROM emp WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Employee e = new Employee();
                    e.setId(rs.getInt("id"));
                    e.setFirstName(rs.getString("firstName"));
                    e.setLastName(rs.getString("lastName"));
                    e.setSalary(rs.getDouble("salary"));
                    e.setDesignation(rs.getString("designation"));
                    return e;
                }
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() throws Exception {
        String sql = "SELECT * FROM emp";
        List<Employee> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setFirstName(rs.getString("firstName"));
                e.setLastName(rs.getString("lastName"));
                e.setSalary(rs.getDouble("salary"));
                e.setDesignation(rs.getString("designation"));
                list.add(e);
            }
        }
        return list;
    }
}