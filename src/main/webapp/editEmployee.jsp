<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Employee"  %>
<html>
<head>
    <title>Edit Employee</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: linear-gradient(120deg, #89f7fe, #66a6ff);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .form-container {
            background: rgba(255, 255, 255, 0.15);
            padding: 30px;
            border-radius: 20px;
            backdrop-filter: blur(10px);
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
            width: 350px;
            color: #fff;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-radius: 8px;
            outline: none;
        }
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #1e7e34;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Edit Employee</h2>
    <form action="UpdateEmployeeServlet" method="post">
        <input type="hidden" name="id" value="${emp.id}">
        
        First Name:
        <input type="text" name="firstName" value="${emp.firstName}" required><br>
        
        Last Name:
        <input type="text" name="lastName" value="${emp.lastName}" required><br>
        
        Salary:
        <input type="number" name="salary" value="${emp.salary}" required><br>
        
        Designation:
        <input type="text" name="designation" value="${emp.designation}" required><br>
        
        <input type="submit" value="Update Employee">
    </form>
</div>


</body>
</html>
