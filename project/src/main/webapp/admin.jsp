<html>
<head>
<title>Admin</title>
</head>
<body>
<h3 align="center">Select an Option: </h3>

<div id="buttons" align="center">
    <a href="insert-edit-employee.jsp"><button>Add an Employee</button></a>
    <a href="insert-edit-product.jsp"><button>Add a Product</button></a>
    <a href="<%=request.getContextPath()%>/list_employee"><button>List all Employees</button></a>
    <a href="<%=request.getContextPath()%>/list_product_admin"><button>List all Products</button></a>
    <a href="index.jsp"><button>Back</button></a>
</div>
</body>
</html>