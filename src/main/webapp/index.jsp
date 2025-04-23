<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel</title>
    <link rel="icon" type="image/x-icon" href="logo.avif">
    <link rel="stylesheet/text"  href="css/style.css">
    <style>
    body {
    font-family: 'Segoe UI', sans-serif;
    margin: 0;
    background: linear-gradient(135deg, #667eea, #764ba2);
    height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

h2 {
    color: #fff;
    margin-bottom: 20px;
}

.form-container {
    backdrop-filter: blur(16px) saturate(180%);
    -webkit-backdrop-filter: blur(16px) saturate(180%);
    background-color: rgba(255, 255, 255, 0.15);
    border-radius: 20px;
    padding: 30px 40px;
    width: 100%;
    max-width: 450px;
    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.3);
    color: #fff;
    border: 1px solid rgba(255, 255, 255, 0.18);
}

form input[type="text"],
form input[type="number"] {
    width: 100%;
    padding: 10px;
    margin-top: 6px;
    margin-bottom: 10px;
    border: 2px solid #ddd;
    border-radius: 8px;
    outline: none;
    transition: 0.3s;
}

input.input-error {
    border-color: red;
}

.error-message {
    color: red;
    font-size: 12px;
    height: 16px;
    margin-bottom: 8px;
}

form input[type="submit"] {
    width: 100%;
    padding: 12px;
    background-color: #999;
    border: none;
    border-radius: 10px;
    color: #fff;
    font-size: 16px;
    cursor: not-allowed;
    transition: background-color 0.3s;
}

form input[type="submit"].active {
    background-color: #28a745;
    cursor: pointer;
}

form input[type="submit"].active:hover {
    background-color: #218838;
}
    .nav-button {
    display: inline-block;
    margin-top: 15px;
    padding: 10px 20px;
    background: #007bff;
    color: white;
    border: none;
    text-align: center;
    text-decoration: none;
    border-radius: 10px;
    font-size: 14px;
    transition: 0.3s;
}

.nav-button:hover {
    background-color: #0056b3;
}
    
    </style>
</head>
<body>

<h2>Admin Panel - Add New Employee</h2>

<div class="form-container">
    <form id="employeeForm" action="AddEmployeeServlet" method="post">
        <label for="id">Employee ID:</label>
        <input type="number" id="id" name="id" required>
        <small class="error-message" id="idError"></small>

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required>
        <small class="error-message" id="firstNameError"></small>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required>
        <small class="error-message" id="lastNameError"></small>

        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" required>
        <small class="error-message" id="salaryError"></small>

        <label for="designation">Designation:</label>
        <input type="text" id="designation" name="designation" required>
        <small class="error-message" id="designationError"></small>

        <input type="submit" value="Add Employee" disabled>
    </form>
    <div>
	    <a href="employee.jsp" class="nav-button">View Employee List</a>
    </div>
</div>

<script>
    const form = document.getElementById('employeeForm');
    const inputs = form.querySelectorAll('input[type="text"], input[type="number"]');
    const submitBtn = form.querySelector('input[type="submit"]');

    function validateForm() {
        let valid = true;

        inputs.forEach(input => {
            const id = input.id;
            const errorEl = document.getElementById(id + "Error");
            input.classList.remove("input-error");
            errorEl.textContent = "";

            if (input.value.trim() === "") {
                input.classList.add("input-error");
                errorEl.textContent = `${id} is required`;
                valid = false;
            } else {
                if ((id === "firstName" || id === "lastName") && !/^[a-zA-Z]+$/.test(input.value)) {
                    input.classList.add("input-error");
                    errorEl.textContent = `${id} must contain only letters`;
                    valid = false;
                }

                if ((id === "id" || id === "salary") && isNaN(input.value)) {
                    input.classList.add("input-error");
                    errorEl.textContent = `${id} must be a valid number`;
                    valid = false;
                }
            }
        });

        submitBtn.disabled = !valid;
        submitBtn.classList.toggle("active", valid);
    }

    inputs.forEach(input => input.addEventListener("input", validateForm));
</script>

</body>
</html>
