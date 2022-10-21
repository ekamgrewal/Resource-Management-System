<html>
<head>
<title>Search Product</title>
<style>
label {
  display: inline-block;
  width: 120px;
  text-align: left;
}​
</style>
</head>

<body>
	<h3 align="center">Search Product</h3>

	<div id="buttons" align="center">
		<form action = "search_product" method="post">
			<label>Search by ID:</label>
			<input type="text" onfocus="this.value=''" value="Enter product id here..." name="id" required="required">
			<input type="submit" value="Search">
		</form>
		
		<form action = "search_product" method="post">
			<label>Search by Name:</label>
			<input type="text" onfocus="this.value=''" value="Enter product name here..." name="name" required="required">
			<input type="submit" value="Search">
		</form>
		
		<a href = "customer.jsp"><button>Back</button></a>
	</div>
	
</body>
</html>