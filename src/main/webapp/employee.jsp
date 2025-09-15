<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*,util.DBConnection" %><!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet"  href="<%= request.getContextPath() %>/css/style.css">
    <style>
	body {
	    margin: 0;
	    padding: 0;
	    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	    background: linear-gradient(120deg, #89f7fe, #66a6ff);
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    min-height: 100vh;
	    flex-direction: column;
	}
	
	h2 {
	    text-align: center;
	    color: #fff;
	    margin-bottom: 20px;
	}
	
	.table-container {
	    background: rgba(255, 255, 255, 0.15);
	    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
	    backdrop-filter: blur(10px);
	    -webkit-backdrop-filter: blur(10px);
	    border-radius: 20px;
	    padding: 30px;
	    width: 90%;
	    max-width: auto;
	    overflow-x: auto;
	}
	
	table {
	    width: 100%;
	    border-collapse: collapse;
	    border-radius: 10px;
	    overflow: hidden;
	}
	
	thead {
	    background-color: rgba(0, 0, 0, 0.6);
	    color: #fff;
	}
	
	th, td {
	    padding: 12px 15px;
	    text-align: left;
	    background-color: rgba(255, 255, 255, 0.6);
	    color: #000;
	}
	
	tr:nth-child(even) {
	    background-color: rgba(255, 255, 255, 0.4);
	}
	
	.edit-button, .delete-button {
	    padding: 6px 12px;
	    border: none;
	    border-radius: 5px;
	    cursor: pointer;
	    transition: background-color 0.3s ease, transform 0.2s ease;
	}
	
	.edit-button {
	    background-color: #4CAF50;
	    color: white;
	}
	
	.delete-button {
	    background-color: #f44336;
	    color: white;
	}
	
	.edit-button:hover {
	    background-color: #45a049;
	    transform: scale(1.05);
	}
	
	.delete-button:hover {
	    background-color: #e53935;
	    transform: scale(1.05);
	}
	
	.back-button {
    margin-top: 20px;
    padding: 10px 20px;
    background-color: #333;
    color: white;
    border: none;
    border-radius: 8px;
    font-size: 16px;
    text-decoration: none;
    transition: background-color 0.3s ease, transform 0.2s ease;
	}
	
	.back-button:hover {
	    background-color: #555;
	    transform: translateY(-2px);
	}

</style>

    
</head>
<body>

<h2>All Employees</h2>

<div class="table-container">
    <table border="1" width="100%" style="color:white; border-collapse: collapse;">
        <tr style="background-color: rgba(255,255,255,0.2);">
            <th>ID</th><th>First Name</th><th>Last Name</th><th>Salary</th><th>Designation</th><th>Action</th>
        </tr>

        <%
            try {
                Connection con = DBConnection.getConnection();   
                
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM emp");

                while(rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("firstName") %></td>
            <td><%= rs.getString("lastName") %></td>
            <td><%= rs.getDouble("salary") %></td>
            <td><%= rs.getString("designation") %></td>
            <td>           
			    <form action="EditEmployeeServlet" method="get" style="display:inline;">
			        <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
			        <input type="submit" value="Edit" class="edit-button">
			    </form>
			
			    <form action="DeleteEmployeeServlet" method="post" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this employee?');">
			        <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
			        <input type="submit" value="Delete" class="delete-button">
			    </form>
			</td>

        </tr>
        <%
                }
                con.close();
            } catch(Exception e) {
                out.println("<tr><td colspan='6'>Error: " + e.getMessage() + "</td></tr>");
            }
        %>
    </table>

	<a href="index.jsp" class="back-button">← Back to Admin Panel</a>
</div>

</body>
</html>
