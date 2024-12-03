$(document).ready(function() {
	$("a").on("click", function(event) {
		if (this.hash !== "") {
			event.preventDefault();

			var hash = this.hash;
			$("html, body").animate(
				{
					scrollTop: $(hash).offset().top,
				},
				800,
				function() {
					window.location.hash = hash;
				}
			);
		}
	});
});

$(".menu-items a").click(function() {
	$("#checkbox").prop("checked", false);
});

// Additional form validation for new pages

// Payment form validation
$("form[action='#']").on("submit", function(event) {
	const card = $("#card").val()?.trim();
	const expiry = $("#expiry").val()?.trim();
	const cvv = $("#cvv").val()?.trim();

	if (!card || !expiry || !cvv) {
		alert("Please fill in all payment details.");
		event.preventDefault();
	}
});

// Delivery tracking form validation
$("#order-id").on("submit", function(event) {
	const orderId = $(this).val()?.trim();
	if (!orderId) {
		alert("Please enter a valid Order ID.");
		event.preventDefault();
	}
});

// Return and exchange form validation
$("#reason").on("submit", function(event) {
	const reason = $(this).val()?.trim();
	if (!reason) {
		alert("Please provide a reason for the return/exchange.");
		event.preventDefault();
	}
});
// Login Page Logic
if (document.getElementById('login-form')) {
	document.getElementById('login-form').addEventListener('submit', function(event) {
		const email = document.getElementById('email').value.trim();
		const password = document.getElementById('password').value.trim();
		if (!email || !password) {
			alert('Please fill in all fields.');
			event.preventDefault();
		}
	});
}

// Signup Page Logic
if (document.getElementById('signup-form')) {
	document.getElementById('signup-form').addEventListener('submit', function(event) {
		const password = document.getElementById('password').value.trim();
		const confirmPassword = document.getElementById('confirm-password').value.trim();
		if (password !== confirmPassword) {
			alert('Passwords do not match!');
			event.preventDefault();
		}
	});
}

// Payment Page Logic
if (document.getElementById('payment-form')) {
	document.getElementById('payment-form').addEventListener('submit', function(event) {
		const card = document.getElementById('card').value.trim();
		const expiry = document.getElementById('expiry').value.trim();
		const cvv = document.getElementById('cvv').value.trim();
		if (!card || !expiry || !cvv) {
			alert('Please fill in all payment details.');
			event.preventDefault();
		}
	});
}

// Delivery Page Logic
if (document.getElementById('order-id')) {
	document.getElementById('order-id').addEventListener('submit', function(event) {
		const orderId = document.getElementById('order-id').value.trim();
		if (!orderId) {
			alert('Please enter a valid Order ID.');
			event.preventDefault();
		}
	});
}

// Return Page Logic
if (document.getElementById('reason')) {
	document.getElementById('reason').addEventListener('submit', function(event) {
		const reason = document.getElementById('reason').value.trim();
		if (!reason) {
			alert('Please provide a reason for the return/exchange.');
			event.preventDefault();
		}
	});
}

// Cart Page Logic
if (document.querySelector('.cart-container')) {
	let cartItems = [
		{ id: 1, name: "PS England Shoes", price: 3150, quantity: 1 },
		{ id: 2, name: "PS England Jacket", price: 1450, quantity: 2 },
	];

	function renderCart() {
		const cartContainer = document.querySelector('.cart-items');
		const totalElement = document.getElementById('cart-total');

		cartContainer.innerHTML = '';
		let total = 0;

		cartItems.forEach(item => {
			const itemElement = document.createElement('div');
			itemElement.classList.add('cart-item');

			itemElement.innerHTML = `
              <img src="https://via.placeholder.com/100" alt="${item.name}">
              <div class="cart-item-details">
                  <p>${item.name}</p>
                  <p>Price: ₹${item.price}</p>
                  <p>Quantity: <input type="number" value="${item.quantity}" min="1" data-id="${item.id}" class="quantity-input"></p>
                  <button class="remove-item" data-id="${item.id}">Remove</button>
              </div>
          `;

			cartContainer.appendChild(itemElement);
			total += item.price * item.quantity;
		});

		totalElement.textContent = `₹${total}`;
	}

	function updateQuantity(id, quantity) {
		const item = cartItems.find(item => item.id === id);
		if (item) {
			item.quantity = quantity;
		}
		renderCart();
	}

	function removeItem(id) {
		cartItems = cartItems.filter(item => item.id !== id);
		renderCart();
	}

	document.addEventListener('input', function(event) {
		if (event.target.classList.contains('quantity-input')) {
			const id = parseInt(event.target.getAttribute('data-id'));
			const quantity = parseInt(event.target.value);
			updateQuantity(id, quantity);
		}
	});

	document.addEventListener('click', function(event) {
		if (event.target.classList.contains('remove-item')) {
			const id = parseInt(event.target.getAttribute('data-id'));
			removeItem(id);
		}
	});

	renderCart();
}
