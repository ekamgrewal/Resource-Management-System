<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>

<style>
label {
  display: inline-block;
  width: 100px;
  text-align: left;
}​
</style>
</head>

<body>
	<div align="center">
		<c:if test="${employee != null}">
			<form action="update_employee" method="post">
		</c:if>
		<c:if test="${employee == null}">
			<form action="insert_employee" method="post">
		</c:if>

		<h2>
			<c:if test="${employee != null}">Edit Employee</c:if>
			<c:if test="${employee == null}">Add New Employee</c:if>
		</h2>

		<c:if test="${employee != null}">
			<input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
		</c:if>

		<fieldset class="form-group">
			<label>Name</label>
			<input type="text" value="<c:out value='${employee.name}'/>" name="name" required="required">
		</fieldset>

		<fieldset class="form-group">
			<label>ID</label>
			<input type="text" value="<c:out value='${employee.id}'/>" name="id" required="required">
		</fieldset>
		
		<fieldset class="form-group">
			<label>Hours Worked</label>
			<input type="text" value="<c:out value='${employee.hourWorked}'/>" name="hoursWorked">
		</fieldset>

		<fieldset class="form-group">
			<label>Salary</label>
			<input type="text" value="<c:out value='${employee.salary}'/>" name="salary" required="required">
		</fieldset>
		<fieldset>
			<input type='submit' value="Submit">
		</fieldset>
		</form>
	</div>
	<br>
	<div align = "center">
		<a href="manager.jsp"><button>Back to Manager</button></a>
	</div>
</body>

</html>