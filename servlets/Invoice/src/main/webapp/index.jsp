<html>
<head>
<title>Invoice</title>
<link rel="stylesheet" href="style.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,300,1,0" />
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<section class="side-bar">
		<div class="heading">Invoice</div>
		<div class="modules">
			<div class="module" id="change-customer">
				<span class="material-symbols-outlined">person</span> <span
					class="module-btn">Customers</span>
			</div>

			<div class="module" id="change-product">
				<span class="material-symbols-outlined"> shopping_cart </span> <span
					class="module-btn">Items</span>
			</div>

			<div class="module">
				<span class="material-symbols-outlined"> description </span> <span
					class="module-btn">Invoices</span>
			</div>

		</div>
	</section>

	<section class="new-customer" id="customer-popup">
		<h2>New customer</h2>
		<span class="side-head-new-customer">Customer name:</span><input id="customer_name" type="text" class="user-input" required> 
		<span class="side-head-new-customer">Email:</span><input id="customer_mail" type="text" class="user-input" required> 
		<span class="side-head-new-customer">Mobile number:</span><input id="customer_mobile" type="text" class="user-input" required>

		<div class="action-btns">
			<div class="cancel-btn" id="customer-cancel">Cancel</div>
			<div class="add-btn" id="customer-add" onclick="addCustomer()">Add</div>
		</div>
	</section>
	
	<section class="new-customer" id="product-popup">
		<h2>New Product</h2>
		<span class="side-head-new-customer">Product name:</span><input id="product_name" type="text" class="user-input" required> 
		<span class="side-head-new-customer">Unit:</span><input id="unit" type="text" class="user-input" required> 
		<span class="side-head-new-customer">Price:</span><input id="price" type="text" class="user-input" required>

		<div class="action-btns">
			<div class="cancel-btn" id="product-cancel">Cancel</div>
			<div class="add-btn" id="product-add" onclick="addProduct()">Add</div>
		</div>
	</section>

	<section class="dynamic-modules">
		<div class="header"></div>
		<section class="customer-module" id="customer-module">
			<div class="top-bar">
				<h1 class="customer-name">Active Customers</h1>
				<div class="new" id="customer-new-btn">+ New</div>
			</div>
			<div class="customers-list">
				<div class="headings">
					<div class="s-num">s.no</div>
					<div class="customers-name">Customer Name</div>
					<div class="email">E mail</div>
					<div class="mobile">Mobile Number</div>
					<div class="edit"></div>
					
				</div>
				<div class="list-cus" id="list-of-customers"></div>
			</div>
		</section>
		
		<section class="product-module" id="product-module">
			<div class="top-bar">
				<h1 class="customer-name">Products</h1>
				<div class="new" id="product-new-btn">+ New</div>
			</div>
			<div class="customers-list">
				<div class="headings">
					<div class="s-num">s.no</div>
					<div class="customers-name">Product</div>
					<div class="email">Unit</div>
					<div class="mobile">Price</div>
					<div class="edit"></div>
					
				</div>
				<div class="list-cus" id="list-of-products"></div>
			</div>
		</section>
	</section>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<div class="delete-alert" id="delete-alert">
		<div class="sure"> Are you sure</div>
		<div class="confirm-delete"><div class="no" id="no" onclick="cancel('delete-alert')">No</div><div id="yes" onclick="confirmDelete(); deleteProduct()" class="yes">Yes</div></div>
	</div>
	
	<section class="new-customer" id="edit_customer-popup">
		<h2>Edit Customer</h2>
		<span class="side-head-new-customer">Customer name:</span><input id="edit_customer_name" type="text" class="user-input" required> 
		<span class="side-head-new-customer">Email:</span><input id="edit_customer_mail" type="text" class="user-input" required> 
		<span class="side-head-new-customer">Mobile number:</span><input id="edit_customer_mobile" type="text" class="user-input" required>

		<div class="action-btns">
			<div class="cancel-btn" id="customer-cancel" onclick="cancel('edit_customer-popup')">Cancel</div>
			<div class="add-btn" id="customer-add" onclick="saveEditedCustomer()">Save</div>
		</div>
	</section>
	
	<section class="new-customer" id="edit_product-popup">
		<h2>Edit Product</h2>
		<span class="side-head-new-customer">Product name:</span><input id="edit_product_name" type="text" class="user-input" required> 
		<span class="side-head-new-customer">Unit:</span><input id="edit_product_unit" type="text" class="user-input" required> 
		<span class="side-head-new-customer">Price:</span><input id="edit_product_price" type="text" class="user-input" required>

		<div class="action-btns">
			<div class="cancel-btn" id="customer-cancel" onclick="cancel('edit_product-popup')">Cancel</div>
			<div class="add-btn" id="customer-add" onclick="saveEditedProduct()">Save</div>
		</div>
	</section>
	<script type="text/javascript" src="script.js"></script>
</body>

</html>
