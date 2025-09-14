<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #FFDEE9, #B5FFFC);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background: rgba(255,255,255,0.1);
            padding: 30px;
            border-radius: 15px;
            backdrop-filter: blur(10px);
            box-shadow: 0 8px 32px rgba(0,0,0,0.25);
            color: #000;
        }

        h2 {
            text-align: center;
        }

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 8px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background: #28a745;
            color: #fff;
            border: none;
            border-radius: 8px;
            font-weight: bold;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Edit Employee</h2>
    <form action="UpdateEmployeeServlet" method="post">
        <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">

        <label>First Name:</label>
        <input type="text" name="firstName" value="<%= request.getAttribute("firstName") %>" required>

        <label>Last Name:</label>
        <input type="text" name="lastName" value="<%= request.getAttribute("lastName") %>" required>

        <label>Salary:</label>
        <input type="number" name="salary" value="<%= request.getAttribute("salary") %>" required>

        <label>Designation:</label>
        <input type="text" name="designation" value="<%= request.getAttribute("designation") %>" required>

        <input type="submit" value="Update Employee">
    </form>
</div>

</body>
</html>
