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
		<h3 class="text-center">Product</h3>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${searched_product.id}" /></td>
					<td><c:out value="${searched_product.name}" /></td>
					<td><c:out value="${searched_product.price}" /></td>
				</tr>
			</tbody>

		</table>
	</div>
	<br>
	<div class="container" align="center">
		<a href="search-product.jsp"><button>Back</button></a>
	</div>
</body>
</html>
