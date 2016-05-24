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

function getProductHtml(p) {
	var html = '<div class="column" id="product">\n';
	html += '   <div id="rating"></div>\n';
	html += '	<h5>' + p.name + '</h5>\n';
	if (userInfo.isAdmin) {
		html += '	<a "class="button tiny alert">Edit</a>\n';
	}
	html += '	<a href= "/jello/view/app/Product"class="button expanded ' + '">Book</a>\n';
	html += '</div>';
	return html;
}

var userInfo = {
	isAdmin : false
};