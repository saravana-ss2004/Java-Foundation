let key;
let alertbox;
document.getElementById("customer-new-btn").onclick = function(){
    document.getElementById("customer-popup").style.display="flex";
}
document.getElementById("customer-cancel").onclick = function(){
    document.getElementById("customer-popup").style.display="none";
}

document.getElementById("product-new-btn").onclick = function(){
	 document.getElementById("product-popup").style.display="flex";
}

document.getElementById("product-cancel").onclick = function(){
    cancel("product-popup")
}

document.getElementById("change-customer").onclick = function(){
	document.getElementById("customer-module").style.display = "block";
	document.getElementById("product-module").style.display = "none";
	document.getElementById("invoice-module").style.display = "none";
	document.getElementById("change-product").style.backgroundColor="transparent";
	document.getElementById("change-customer").style.backgroundColor="#22b378";
	document.getElementById("change-invoice").style.backgroundColor = "transparent";
	getCustomers();
}

document.getElementById("change-product").onclick = function(){
	document.getElementById("customer-module").style.display = "none";
	document.getElementById("product-module").style.display = "block";
	document.getElementById("invoice-module").style.display = "none";
	document.getElementById("change-product").style.backgroundColor="#22b378";
	document.getElementById("change-customer").style.backgroundColor="transparent";
	document.getElementById("change-invoice").style.backgroundColor = "transparent";
	
	getProducts();
}

document.getElementById("change-invoice").onclick = function(){
	document.getElementById("customer-module").style.display = "none";
	document.getElementById("product-module").style.display = "none";
	document.getElementById("invoice-module").style.display = "block";
	document.getElementById("change-product").style.backgroundColor="transparent";
	document.getElementById("change-customer").style.backgroundColor="transparent";
	document.getElementById("change-invoice").style.backgroundColor = "#22b378";
	
	getInvoices();
}





function updateCustomerList(customers) {
    const customersList = document.getElementById("list-of-customers");
    customersList.innerHTML = ""; 

    customers.forEach((customer, index) => {
        const customerDiv = document.createElement("div");
        customerDiv.classList.add("customer");
        customerDiv.innerHTML = `
            <div class="s-num">${index + 1}</div>
            <div class="customers-name detail">${customer.name}</div>
            <div class="email">${customer.mail}</div>
            <div class="mobile">${customer.mobilenumber}</div>
            <div class="edit">
            	<span style="color:rgb(0,0,255,0.4); font-weight:300;" class="material-symbols-outlined delete-edit" onclick="customerEdit(this)" data-key="${customer.id}">edit</span>
            	<span onclick="deleteCustomer(this)" style="color:rgb(255,0,0); font-weight:100;"  class="material-symbols-outlined delete-edit"  data-key="${customer.id}">delete</span>
            </div>`;
        customersList.appendChild(customerDiv);
    });
}


function updateProductList(products){
	 const productsList = document.getElementById("list-of-products");
    productsList.innerHTML = ""; 

    products.forEach((product, index) => {
        const productDiv = document.createElement("div");
        productDiv.classList.add("customer");
        productDiv.innerHTML = `
            <div class="s-num">${index + 1}</div>
            <div class="customers-name">${product.name}</div>
            <div class="email">${product.unit}</div>
            <div class="mobile">${product.price}</div>
            <div class="edit">
            	<span style="color:rgb(0,0,255,0.4); font-weight:300;" class="material-symbols-outlined delete-edit" onclick="selectProduct(this)" data-key="${product.id}">edit</span>
            	<span onclick="deleteCustomer(this)" style="color:rgb(255,0,0); font-weight:100;"  class="material-symbols-outlined delete-edit"  data-key="${product.id}">delete</span>
            </div>`;
        productsList.appendChild(productDiv);
    });
}


function updateInvoiceList(invoices){
	 const invoiceList = document.getElementById("list-of-invoices");
    invoiceList.innerHTML = ""; 

    invoices.forEach((invoice, index) => {
        const invoiceDiv = document.createElement("div");
        invoiceDiv.classList.add("customer");
        invoiceDiv.innerHTML = `
            <div class="date">${invoice.date}</div>
            <div class="invoice">${invoice.invoice}</div>
            <div class="invo-name">${invoice.customerName}</div>
            <div class="status">${invoice.status}</div>
            <div class="amount">${invoice.amount}</div>
            <div class="edit">
            	<span style="color:rgb(0,0,255,0.4); font-weight:300;" class="material-symbols-outlined delete-edit" onclick="selectProduct(this)" data-key="${invoice.id}">edit</span>
            	<span onclick="deleteCustomer(this)" style="color:rgb(255,0,0); font-weight:100;"  class="material-symbols-outlined delete-edit"  data-key="${invoice.id}">delete</span>
            </div>`;
        invoiceList.appendChild(invoiceDiv);
    });
}

function getCustomers(){
	fetch("http://localhost:8080/Invoice/customers")
	    .then(response => response.json())
	    .then(data => {
	        updateCustomerList(data.Message);
	});
}


function getProducts(){
	fetch("http://localhost:8080/Invoice/products")
    .then(response => response.json())
    .then(data => {
        updateProductList(data.Message);
});
}


function addCustomer() {
    let customerName = document.getElementById("customer_name");
    let customerMail = document.getElementById("customer_mail");
    let customerMobile = document.getElementById("customer_mobile");
    let validatedNumber;
    
    if (customerMobile.value.length === 10 && customerMail.value.length >= 12 && customerMobile.value.length >= 1) {
        validatedNumber = customerMobile.value;
        
        fetch("http://localhost:8080/Invoice/addcustomer", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: `customer_name=${customerName.value}&customer_mail=${customerMail.value}&customer_mobile=${validatedNumber}`
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Request failed with status " + response.status);
                alert("customer exists")
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            if(data == 0){
				alert("customer already exists");
			}
			else{
				cancel("customer-popup")
				 fetch("http://localhost:8080/Invoice/customers")
    			.then(response => response.json())
    			.then(data => {
        		updateCustomerList(data.Message);
        		});
			}
   
        })
        .catch(error => {
            console.error("Error:", error);
        });
    } else {
        alert("Input not valid");
    }
}



function deleteCustomer(ele){
	key = ele.getAttribute("data-key");
	alertBox= document.getElementById("delete-alert");
	alertBox.style.display="flex";
	
	console.log(key)
}

function confirmDelete(){
	fetch("http://localhost:8080/Invoice/deletecustomer", {
        	method: "POST",
        	headers: {
            	"Content-Type": "application/x-www-form-urlencoded",
        	},
        	body: `customer_id=${key}`
    	})
    	.then(response => {
			alertBox.style.display="none";
        	if (response.ok) {
            	return fetch("http://localhost:8080/Invoice/customers");
        	} else {
            	console.error("Failed to delete customer.");
        	}
    	})
    	.then(response=>response.json())
		.then(data=>{
			updateCustomerList(data.Message)
		});
}
function cancel(element){
	key="";
	document.getElementById(element).style.display="none";
}

function customerEdit(ele){

	editCustomer = document.getElementById("edit_customer-popup");
	editCustomer.style.display="flex";	
	
	key = ele.getAttribute("data-key")
	
	fetch("http://localhost:8080/Invoice/customer", {
        	method: "POST",
        	headers: {
            	"Content-Type": "application/x-www-form-urlencoded",
        	},
        	body: `customer_id=${key}`
    	})
    	.then(response => response.json())
    	.then(data => {
        	document.getElementById("edit_customer_name").value=data.Message[0].name;
        	document.getElementById("edit_customer_mail").value=data.Message[0].mail;
        	document.getElementById("edit_customer_mobile").value=data.Message[0].mobilenumber;
   		});
}

function saveEditedCustomer(){
	
	let customerName = document.getElementById("edit_customer_name");
	let customerMail = document.getElementById("edit_customer_mail");
	let customerMobile = document.getElementById("edit_customer_mobile");
	
	if(customerName.value.length >= 1 && customerMail.value.length >= 12 && customerMobile.value.length == 10){
		fetch("http://localhost:8080/Invoice/editcustomer", {
        	method: "POST",
        	headers: {
            	"Content-Type": "application/x-www-form-urlencoded",
        	},
        	body: `customer_name=${customerName.value}&customer_mail=${customerMail.value}&customer_mobile=${customerMobile.value}&customer_id=${key}`
    	})
    	.then(response => {
            if (!response.ok) {
                throw new Error("Request failed with status " + response.status);
                alert("customer exists")
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            if(data == 0){
				alert("customer already exists");
			}
			else{
				cancel("edit_customer-popup")
				 fetch("http://localhost:8080/Invoice/customers")
    			.then(response => response.json())
    			.then(data => {
        		updateCustomerList(data.Message);
        		});
			}
   
        })
        .catch(error => {
            console.error("Error:", error);
        });
    } else {
        alert("Input not valid");
    }

}




function addProduct() {
    let productName = document.getElementById("product_name");
    let productUnit = document.getElementById("unit");
    let productPrice = document.getElementById("price");
    
    if (productName.value.length >= 1 && productUnit.value.length >= 1 && productPrice.value.length >= 1) {
        
        
        fetch("http://localhost:8080/Invoice/addproduct", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: `product_name=${productName.value}&unit=${productUnit.value}&price=${productPrice.value}`
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Request failed with status " + response.status);
                
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            if(data == 0){
				alert("product already exists");
			}
			else{
				cancel("product-popup")
				 fetch("http://localhost:8080/Invoice/products")
    			.then(response => response.json())
    			.then(data => {
        		updateProductList(data.Message);
        		});
			}
   
        })
        .catch(error => {
            console.error("Error:", error);
        });
    } else {
        alert("Input not valid");
    }
}

function deleteProduct(){
	fetch("http://localhost:8080/Invoice/deleteproduct", {
        	method: "POST",
        	headers: {
            	"Content-Type": "application/x-www-form-urlencoded",
        	},
        	body: `product_id=${key}`
    	})
    	.then(response => {
			console.log(response)
			alertBox.style.display="none";
        	if (response.ok) {
            	return fetch("http://localhost:8080/Invoice/products");
        	} else {
            	console.error("Failed to delete product.");
        	}
    	})
    	.then(response=>response.json())
		.then(data=>{
			updateProductList(data.Message)
		});

}


function selectProduct(ele){
	editCustomer = document.getElementById("edit_product-popup");
	editCustomer.style.display="flex";	
	
	key = ele.getAttribute("data-key")
	
	fetch("http://localhost:8080/Invoice/product", {
        	method: "POST",
        	headers: {
            	"Content-Type": "application/x-www-form-urlencoded",
        	},
        	body: `product_id=${key}`
    	})
    	.then(response => response.json())
    	.then(data => {
        	document.getElementById("edit_product_name").value=data.Message[0].name;
        	document.getElementById("edit_product_unit").value=data.Message[0].unit;
        	document.getElementById("edit_product_price").value=data.Message[0].price;
   		});
}


function saveEditedProduct(){
	 let productName = document.getElementById("edit_product_name");
    let productUnit = document.getElementById("edit_product_unit");
    let productPrice = document.getElementById("edit_product_price");
    
    if (productName.value.length >= 1 && productUnit.value.length >= 1 && productPrice.value.length >= 1) {
        
        
        fetch("http://localhost:8080/Invoice/editproduct", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: `product_name=${productName.value}&unit=${productUnit.value}&price=${productPrice.value}&product_id=${key}`
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Request failed with status " + response.status);
                
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            if(data == 0){
				alert("product already exists");
			}
			else{
				cancel("edit_product-popup")
				 fetch("http://localhost:8080/Invoice/products")
    			.then(response => response.json())
    			.then(data => {
        		updateProductList(data.Message);
        		});
			}
   
        })
        .catch(error => {
            console.error("Error:", error);
        });
    } else {
        alert("Input not valid");
    }

}


function cliker(){
	const invoiceNumber = '23';
	const detail = '{"milk":{"quantity":2,"price":64},"biscuit":{"quantity":4,"price":20}}';
	const sum = '84';
	const status = 'paid';
	const date = '14-08-2023';
	const customer = '349076';

	const encodedDetail = encodeURIComponent(detail);

	const baseUrl = 'http://localhost:8080/Invoice/addinvoice';
	const queryParams = `invoice_number=${invoiceNumber}&detail=${encodedDetail}&sum=${sum}&status=${status}&date=${date}&customer=${customer}`;
	const finalUrl = `${baseUrl}?${queryParams}`;

	console.log('Final URL: ', finalUrl);
}


function getInvoices(){
	fetch("http://localhost:8080/Invoice/invoices")
	    .then(response => response.json())
	    .then(data => {
	        updateInvoiceList(data.Message);
	});
}


getCustomers();