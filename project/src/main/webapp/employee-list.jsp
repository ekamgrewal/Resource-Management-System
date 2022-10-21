<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>User Management Application</title>
<style>
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}

table.table {
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>

<body>
	<div class="container" align="center">
		<h3 class="text-center">List of Employees</h3>
		<a href="index.jsp"><button>Main Menu</button></a>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Hours Work</th>
					<th>Salary</th>
					<th>Projected Income</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${employeeList}">

					<tr>
						<td><c:out value="${employee.id}" /></td>
						<td><c:out value="${employee.name}" /></td>
						<td><c:out value="${employee.hourWorked}" /></td>
						<td><c:out value="${employee.salary}" /></td>
						<td><c:out value="${employee.projectedIncome}" /></td>
						<td><a
							href="edit_employee?id=<c:out value='${employee.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="delete_employee?id=<c:out value='${employee.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
				<!-- } -->
			</tbody>

		</table>
	</div>
	<br>
	<div class="container" align="center">
		<a href="<%=request.getContextPath()%>/new_employee"><button>Add New User</button></a>
		<a href="manager.jsp"><button>Back to Manager</button></a>
		<a href="admin.jsp"><button>Back to Admin</button></a>
	</div>
</body>

</html>