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

document.getElementById("invoice-new-btn").onclick = function(){
    document.querySelector(".new-invoice").style.display="block"
}

document.getElementById("invoice-cancel").onclick = function(){
    cancel("invoice-popup")
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
	listCustomers();
	listProducts()
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
        invoiceDiv.classList.add("invoices");
        invoiceDiv.setAttribute("data-key", invoice.id)
        invoiceDiv.setAttribute("onclick", "getInvoice(this)")
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


function encodedDetail(invoiceObj, total, today, pay, customerid){
	const detail = JSON.stringify(invoiceObj);
	const sum = total;
	const status = pay;
	const date =today;
	const customer = customerid;

	const encodedDetail = encodeURIComponent(detail);

	const queryParams = `detail=${encodedDetail}&sum=${sum}&status=${status}&date=${date}&customer=${customer}`;
	const finalUrl = queryParams;

	console.log('Final URL: ', finalUrl);
	return finalUrl;
}


function getInvoices(){
	fetch("http://localhost:8080/Invoice/invoices")
	    .then(response => response.json())
	    .then(data => {
	        updateInvoiceList(data.Message);
	});
}



function listCustomers(){
	let option;
	fetch("http://localhost:8080/Invoice/customers")
	    .then(response => response.json())
	    .then(data => {
	        let messages = data.Message;
	       	messages.forEach((message)=>{
				   
				   option += `<option value="${message.id}">${message.name}</option>`;
			})
			document.getElementById("select-customer").innerHTML = option; 
	       	
	});
}


function listProducts(){
	let option;
	fetch("http://localhost:8080/Invoice/products")
	    .then(response => response.json())
	    .then(data => {
	        let messages = data.Message;
	       	messages.forEach((message)=>{
				   
				   option += `<option data-key="${message.name}" data-price="${message.price}"  value="${message.name}">${message.name}</option>`;
			})
			document.getElementById("select-items").innerHTML = option; 
	       	
	});
}
let total=0;
let invoiceObj ={};

function invoiceTemplate(){
	let item = document.getElementById("select-items");
	let quantity = document.getElementById("quantity");
	
	let option= item.options[item.selectedIndex];
	let price = option.getAttribute("data-price");
	
	let obj = {};
	obj.quantity = quantity.value;
	obj.price = price;
	
	let product = item.value;
	
	invoiceObj[product] = obj;
	console.log(invoiceObj)
	updateInvoicetemplate();
}





function updateInvoicetemplate(){
	document.getElementById("table").innerHTML="";
	let len = Object.keys(invoiceObj)
	
	
	for(let i=0;i<len.length;i++){
		let template=`<tr>
						<td class="items-value">${len[i]}</td>
						<td class="quantity-value">${invoiceObj[len[i]].quantity}</td>
						<td class="rate-value">${invoiceObj[len[i]].price}</td>
						<td class="amount-value">${invoiceObj[len[i]].price * invoiceObj[len[i]].quantity}</td>
					</tr>`;
					
		total += invoiceObj[len[i]].price * invoiceObj[len[i]].quantity
					
		document.getElementById("table").innerHTML+=template;
	}
	
	console.log(total)
	document.getElementById("total").innerText=`Total : ${total}`
	
	
	
	
	
}
document.getElementById("add-to-invoice").onclick =()=>{invoiceTemplate()}

let date = new Date();



function createInvoice(){
	let today= `${date.getDate()}-${date.getUTCMonth()+1}-${date.getFullYear()}`
	
	let customer = document.getElementById("select-customer").value
	fetch("http://localhost:8080/Invoice/addinvoice", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: encodedDetail(invoiceObj, total, today, "unpaid", customer)
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
				 fetch("http://localhost:8080/Invoice/invoices")
    			.then(response => response.json())
    			.then(data => {
        		updateInvoiceList(data.Message);
        		});
			}
   
        })
        .catch(error => {
            console.error("Error:", error);
        });
        
        cancel("invoice-popup")
        
    document.getElementById("select-items").value="";
	document.getElementById("quantity").value="1";
	document.getElementById("table").innerHTML="";
	invoiceObj={};
	total=0;
	document.getElementById("total").innerText=`Total : ${total}`
	

}

function deleteInvoice(){
	fetch("http://localhost:8080/Invoice/deleteinvoice", {
        	method: "POST",
        	headers: {
            	"Content-Type": "application/x-www-form-urlencoded",
        	},
        	body: `id=${key}`
    	})
    	.then(response => {
			console.log(response)
			alertBox.style.display="none";
        	if (response.ok) {
            	return fetch("http://localhost:8080/Invoice/invoices");
        	} else {
            	console.error("Failed to delete product.");
        	}
    	})
    	.then(response=>response.json())
		.then(data=>{
			updateInvoiceList(data.Message)
		});

}


function getInvoice(ele){
	let id = ele.getAttribute("data-key")
	console.log(id)
	
	fetch("http://localhost:8080/Invoice/invoice", {
        	method: "POST",
        	headers: {
            	"Content-Type": "application/x-www-form-urlencoded",
        	},
        	body: `invoice_id=${id}`
    	})
    	.then(response => response.json())
    	.then(data => {
        	console.log(JSON.parse(data.Message[0].details));
   		});
	
}






getCustomers();