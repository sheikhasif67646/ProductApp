<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Read Products</h1>
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Version</th>
            <th>Price</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.version}</td>
                <td>${product.productId}</td>
                 <td>${product.name}</td>
                 <td>${product.price}</td>
                <td>${contact.country}</td>
                <td><a href="/update-contact/${product.id}">Update</a></td>
                <td><a href="/delete-contact/${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
<br/>
<a href="/create-product">Create Product</a>