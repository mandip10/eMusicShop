<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Cart</h1>
					
					<p>All the selected products in your shopping cart</p>
				</div>
			</div>
		</section>
		<section class="container" ng-app="cartApp">
		<div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
			<div>
				<a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
				<a href="<c:url value="/order/${cartId}" />" class="btn btn-success pull-right"><span class="glyphicon-shopping-cart glyphicon"></span>Check out</a>
			</div>
			
			<table class="table table-hover">
				<tr>
					<th>Product</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tr ng-repeat="item in cart.cartItems">
					<th>{{item.product.productName}}</th>
					<th>{{item.product.productPrice}}</th>
					<th>{{item.quantity}}</th>
					<th>{{item.totalPrice}}</th>
					<th><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
					<span class="glyphicon glyphicon-remove"></span>remove</a></th>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{calGrandTotal()}}</th>
					<th></th>
				</tr>
				
			</table>
			
			<a href="<c:url value="/product/productList"/>" class="btn btn-default">Continue Shopping</a>
			</div>
		</section>
	</div>
</div>
<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>