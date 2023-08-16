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

			<div class="module" id="change-invoice">
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
	
	
	<section class="new-invoice" id="invoice-popup">
		<h2>New Invoice</h2>
		
		
		<div class="select-customers">
			<span class="select-name">Customer Name : </span>
			<select class="select-customer" id="select-customer"></select>
		</div>
		
		<div class="select-products">
		
			<div class="add-items">
				<div class="select-product">Items : </div>
				<select class="select-items" id="select-items">
					<option value="saravana">Product</option>	
				</select>
			</div>
			
			<div class="add-quantity">
				<div class="select-product">Quantity : </div>
				<input class="select-quantity" type="text" placeholder="quantity" id="quantity" value="1">
			</div>
			
			<div class="invoice-add-items" id="add-to-invoice">Add</div>
		</div>
		
		
		<div>
			<div>
				<h3>invoice</h3>
				
				<table>
					<tr>
						<th class="items-head">ITEM DETAILS</th>
						<th class="quantity-head">QUANTITY</th>
						<th class="rate-head">RATE</th>
						<th class="amount-head">AMOUNT</th>
					</tr>
					
				</table>
				<table id="table">
					
				</table>
				<h3 id="total">Total : 0.00</h3>
			</div>
		</div>
		<div class="action-btns invoice-control">
			<div class="cancel-btn" id="invoice-cancel">Cancel</div>
			<div class="add-btn" id="product-add" onclick="createInvoice()">Send</div>
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
		
		
		<section class="invoice-module" id="invoice-module">
			<div class="top-bar">
				<h1 class="customer-name">Invoices</h1>
				<div class="new" id="invoice-new-btn" >+ New</div>
			</div>
			<div class="customers-list">
				<div class="headings">
					<div class="date">date</div>
					<div class="invoice">Invoice</div>
					<div class="invo-name">customer name</div>
					<div class="status">status</div>
					<div class="amount">amount</div>
					<div class="edit"></div>
					
				</div>
				<div class="list-cus" id="list-of-invoices"></div>
			</div>
		</section>
	</section>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<div class="delete-alert" id="delete-alert">
		<div class="sure"> Are you sure</div>
		<div class="confirm-delete"><div class="no" id="no" onclick="cancel('delete-alert')">No</div><div id="yes" onclick="confirmDelete(); deleteProduct(); deleteInvoice()" class="yes">Yes</div></div>
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
