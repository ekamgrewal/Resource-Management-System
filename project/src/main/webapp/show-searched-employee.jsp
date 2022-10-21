<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Report</title>
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
		<h3 class="text-center">Employee Report</h3>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Hours Work</th>
					<th>Salary</th>
					<th>Projected Income</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${searched_employee.id}" /></td>
					<td><c:out value="${searched_employee.name}" /></td>
					<td><c:out value="${searched_employee.hourWorked}" /></td>
					<td><c:out value="${searched_employee.salary}" /></td>
					<td><c:out value="${searched_employee.projectedIncome}" /></td>
				</tr>
			</tbody>

		</table>
	</div>
	<br>
	<div class="container" align="center">
		<a href="employee.jsp"><button>Back</button></a>
	</div>
</body>
</html>
