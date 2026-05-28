<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
<div class="container mt-4">
    <h2>Products</h2>
    <a class="btn btn-primary mb-2" href="/products.do?op=form">Add Product</a>
    <table class="table table-striped">
        <thead><tr><th>ID</th><th>Name</th><th>Price</th><th>Stock</th><th>Supplier</th><th>Actions</th></tr></thead>
        <tbody>
        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.stock}</td>
                <td>${p.supplierId}</td>
                <td>
                    <a class="btn btn-sm btn-secondary" href="/products.do?op=form&id=${p.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Simple pagination -->
    <nav>
      <ul class="pagination">
        <c:set var="pages" value="${(total/pageSize) + (total%pageSize != 0 ? 1 : 0)}"/>
        <c:forEach var="i" begin="1" end="${pages}">
          <li class="page-item ${i==page? 'active':''}"><a class="page-link" href="/products.do?page=${i}">${i}</a></li>
        </c:forEach>
      </ul>
    </nav>

</div>
<jsp:include page="footer.jsp"/>
