<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<div class="container mt-4">
  <h2>Add / Edit Product</h2>
  <form method="post" action="/products.do">
    <input type="hidden" name="op" value="save" />
    <div class="mb-3">
      <label class="form-label">Name</label>
      <input
        type="text"
        name="name"
        class="form-control"
        value="${param.name}"
      />
    </div>
    <div class="mb-3">
      <label class="form-label">Price</label>
      <input
        type="number"
        step="0.01"
        name="price"
        class="form-control"
        value="${param.price}"
      />
    </div>
    <div class="mb-3">
      <label class="form-label">Stock</label>
      <input
        type="number"
        name="stock"
        class="form-control"
        value="${param.stock}"
      />
    </div>
    <div class="mb-3">
      <label class="form-label">Supplier ID</label>
      <input
        type="number"
        name="supplierId"
        class="form-control"
        value="${param.supplierId}"
      />
    </div>
    <button class="btn btn-primary" type="submit">Save</button>
    <a class="btn btn-secondary" href="/products.do">Cancel</a>
  </form>
</div>
<jsp:include page="footer.jsp" />
