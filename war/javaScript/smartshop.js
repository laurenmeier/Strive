function loadProducts(containerId) {
	$.ajax({
		async : true,
		url : "/jello/data/app/Product",
		success : function(response) {
			var products = response.d.results;
			var productsContainer = $("#" + containerId);
			for ( var i in products) {
				var p = products[i];
				productsContainer.append(getProductHtml(p));
			}
		}
	});
}

function refreshProduct(productId) {
	$.ajax({
		async : true,
		url : "/jello/data/app/Product(" + productId + ")",
		success : function(response) {
			$("#product_" + productId).replaceWith(getProductHtml(response.d));
		}
	});
}

function getProductHtml(p) {
	var html = '<div class="column" id="product">\n';/*
														 * html += ' <img
														 * class="thumbnail"
														 * src="/jello/data/app/Product('')/photo/$value">\n';
														 */
	html += '   <div id="rating"></div>\n';
	html += '	<h5>' + p.name + '</h5>\n';/*
											 * html += ' <p id="inventory">$'+p.price+'</p>\n';
											 */
	if (userInfo.isAdmin) {
		html += '	<a "class="button tiny alert">Edit</a>\n';
	}
	html += '	<a href= "/jello/view/app/Product"class="button expanded ' + '">Book</a>\n';
	html += '</div>';

	return html;
}

function book(productId) {
	$.ajax({
		async : false,
		url : "/jello/data/app/Product(" + productId + ")/buy()",
		success : function(response) {
			refreshProduct(productId);
			alert(response);
		}
	});

}

var userInfo = {
	isAdmin : false
};
function initUserInfo(containerId) {
	$
			.ajax({
				url : "/jello/data/jello.services/UserProfile/whoAmI()",
			})
			.done(
					function(response) {
						userInfo = response.d.result;
						if (userInfo.user) {
							$("#" + containerId)
									.html(
											'Welcome <i>'
													+ userInfo.user
													+ '</i> | <a href="'
													+ userInfo.logoutLink
													+ '"><span style="color: #1485c3;">Logout</span></a>');
						} else {
							$("#" + containerId)
									.html(
											'Welcome  <i>Guest</i> | <a href="'
													+ userInfo.loginLink
													+ '"><span style="color: #1485c3;">Login</span></a>');
						}
					});
}
