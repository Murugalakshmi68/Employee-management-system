<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Employee | EMS</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>

<body>

<div class="container">

    <div class="header">
        <h1>EMS</h1>
        <p>Add Employee</p>
    </div>

    <div class="form-container">

        <form action="${emp.id == 0 ? 'save' : 'update'}" method="post">

            <input type="hidden" name="id" value="${emp.id}" />

            <input type="text" name="name" value="${emp.name}" placeholder="Enter Name" required />

            <input type="email" name="email" value="${emp.email}" placeholder="Enter Email" required />

            <select name="department" required>
                <option value="">Select Department</option>
                <option value="IT">IT</option>
                <option value="HR">HR</option>
                <option value="Finance">Finance</option>
                <option value="Sales">Sales</option>
            </select>

            <select name="role" required>
                <option value="">Select Role</option>
                <option value="Developer">Developer</option>
                <option value="Manager">Manager</option>
                <option value="Tester">Tester</option>
                <option value="Intern">Intern</option>
            </select>

            <button type="submit">Save Employee</button>

        </form>

    </div>

    <a href="<c:url value='/'/>" class="back-btn">← Back to Dashboard</a>

</div>

</body>
</html>