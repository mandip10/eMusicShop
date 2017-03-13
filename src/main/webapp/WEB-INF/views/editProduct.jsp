
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Edit Product</h1>
			<p class="lead">Please update the product information here.</p>
		</div>

		<form:form
			action="${pageContext.request.contextPath}/admin/productInventory/editProduct?${_csrf.parameterName}=${_csrf.token}"
			method="post" commandName="product" enctype="multipart/form-data">
			<form:hidden path="productId" value="${product.productId}"/>
			
			<div class="form-group">
				<label for="name">Name</label>
				<form:input path="productName" id="name" class="form-control" value="${product.productName}"/>
			</div>

			<div class="form-group">
				<label for="category">Category</label> <label
					class="checkbox-inline"><form:radiobutton
						path="productCategory" id="category" value="Instrument" />Instrument
				</label> <label class="checkbox-inline"><form:radiobutton
						path="productCategory" id="category" value="Record" /> Record </label> <label
					class="checkbox-inline"><form:radiobutton
						path="productCategory" id="category" value="Accessory" />
					Accessory</label>
			</div>

			<div class="form-group">
				<label for="description">Description</label>
				<form:textarea path="productDescription" id="description" class="form-control" 
				value="${product.productDescription}"/>
			</div>

			<div class="form-group">
				<label for="price">Price</label>
				<form:input path="productPrice" id="price" class="form-control" value="${product.productPrice}" />
			</div>

			<div class="form-group">
				<label for="condition">Condition</label> <label
					class="checkbox-inline"><form:radiobutton
						path="productCondition" id="condition" value="New" /> New </label> <label
					class="checkbox-inline"><form:radiobutton
						path="productCondition" id="condition" value="Used" /> Used </label>
			</div>

			<div class="form-group">
				<label for="status">Status</label>
				<label class="checkbox-inline"><form:radiobutton
						path="productStatus" id="status" value="inStock" /> In Stock </label> 
				<label class="checkbox-inline"><form:radiobutton
						path="productStatus" id="status" value="outOfStock" /> Out Of Stock </label>
			</div>

			<div class="form-group">
				<label for="unitInStock">Unit In stock</label>
				<form:input path="unitInStock" id="unitInStock" class="form-control" value="${product.unitInStock}"/>
			</div>

			<div class="form-group">
				<label for="manufacturer">Manufacturer</label>
				<form:input path="productManufacturer" id="manufacturer"
					class="form-control" value="${product.productManufacturer}" />
			</div>

			<div class="form-group">
				<label class="control-label" for="productImage">Upload
					Picture</label>
				<form:input path="productImage" id="productImage" type="file"
					class="form:input-large" />
			</div>

			<br>
			<br>
			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/admin/productInventroy"/>" class="btn btn-default">Cancel</a>
		</form:form>
		<%@include file="/WEB-INF/views/template/footer.jsp"%>