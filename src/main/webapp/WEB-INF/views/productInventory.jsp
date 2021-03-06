<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Inventory</h1>
			<p class="lead">This is the product inventory page!</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Photo</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Condition</th>
					<th>Price</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tr>
					<td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" 
					style="width: 100%"/></td>
					<td>${product.productName}</td>
					<td>${product.productCategory}</td>
					<td>${product.productCondition}</td>
					<td>${product.productPrice} USD</td>
					<td><a href="<spring:url value="/product/viewProduct/${product.productId}" />"
					class="btn btn-primary"><!-- <span class="glyphicon glyphicon-info-sign"></span> -->Detail</a></td>
										
					<td><a href="<spring:url value="/admin/product/editProduct/${product.productId}" />"
					class="btn btn-primary"><!-- <span class="glyphicon glyphicon-info-pencil"></span> -->Edit</a></td>
					
					<td><a href="<spring:url value="/admin/product/deleteProduct/${product.productId}" />"
					class="btn btn-danger" ><!-- <span class="glyphicon glyphicon-info-remove"></span> -->Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="<c:url value="/admin/product/addProduct" />" class="btn btn-primary">Add Product</a>
<%@include file="/WEB-INF/views/template/footer.jsp"%>