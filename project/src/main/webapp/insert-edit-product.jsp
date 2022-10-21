<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<style>
label {
	display: inline-block;
	width: 80px;
	text-align: left;
}
​
</style>
</head>

<body>
	<div align="center">
		<c:if test="${product != null}">
			<form action="update_product" method="post">
		</c:if>
		<c:if test="${product == null}">
			<form action="insert_product" method="post">
		</c:if>

		<h2>
			<c:if test="${product != null}">Edit Product</c:if>
			<c:if test="${product == null}">Add New Product</c:if>
		</h2>

		<c:if test="${product != null}">
			<input type="hidden" name="id"
				value="<c:out value='${product.id}' />" />
		</c:if>

		<fieldset>
			<label>ID</label> <input type="text"
				value="<c:out value='${product.id}'/>" name="id">
		</fieldset>

		<fieldset>
			<label>Name</label> <input type="text"
				value="<c:out value='${product.name}'/>" name="name"
				required="required">
		</fieldset>

		<fieldset>
			<label>Price</label> <input type="text"
				value="<c:out value='${product.price}'/>" name="price">
		</fieldset>
		<fieldset>
			<input type='submit' value="Submit">
		</fieldset>
		</form>
	</div>
	<br>
	<div align="center">
		<a href="index.jsp"><button>Back to Main</button></a>
	</div>

</body>

</html>