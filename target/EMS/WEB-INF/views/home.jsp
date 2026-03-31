<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>EMS Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>

<body>

<div class="container">

    <!-- HEADER -->
    <div class="header">
        <div>
            <h1>EMS</h1>
            <p>Employee Management Dashboard</p>
        </div>

        <div class="nav">
            <a href="<c:url value='/'/>">Dashboard</a>
            <a href="<c:url value='/add'/>">Add Employee</a>
        </div>
    </div>

    <h2>Dashboard Overview</h2>

    <!-- STATS CARDS -->
    <div class="cards">
        <div class="card">
            <h3>Total Employees</h3>
            <p>${totalEmployees}</p>
        </div>

        <div class="card">
            <h3>Departments</h3>
            <p>${deptCount}</p>
        </div>

        <div class="card">
            <h3>Roles</h3>
            <p>${roleCount}</p>
        </div>
    </div>

    <!-- 🔍 SEARCH BAR -->
    <div class="search-box">
        <form action="<c:url value='/search'/>" method="get">
            <input type="text" name="name" placeholder="Search by name..." required />
            <button type="submit">Search</button>
            <a href="<c:url value='/'/>" class="reset-btn">Reset</a>
        </form>
    </div>

    <!-- TABLE -->
    <div class="table-box">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>Department</th>
                    <th>Actions</th>
                </tr>
            </thead>

            <tbody>

                <!-- ✅ Empty State -->
                <c:if test="${empty employees}">
                    <tr>
                        <td colspan="6">No employees found</td>
                    </tr>
                </c:if>

                <!-- ✅ Data -->
                <c:forEach var="e" items="${employees}">
                    <tr>
                        <td>${e.id}</td>
                        <td>${e.name}</td>
                        <td>${e.email}</td>
                        <td>${e.role}</td>
                        <td>${e.department}</td>
                        <td>
                            <a href="<c:url value='/edit?id=${e.id}'/>" class="btn edit">Edit</a>
                            <a href="<c:url value='/delete?id=${e.id}'/>" class="btn delete"
                               onclick="return confirm('Are you sure to delete?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>

</div>

</body>
</html>