<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="main-content">
    <div class="container">
        <div class="dashboard-header">
            <h1>製品フォーム (Product Form)</h1>
        </div>

        <div class="card p-4 login-card" style="max-width:800px;margin:auto;">
          <form method="post" action="<%=request.getContextPath()%>/products.do?op=<%= (request.getAttribute("product")!=null) ? "update" : "create" %>">
            <c:if test="${not empty product}">
              <input type="hidden" name="id" value="${product.id}" />
            </c:if>

            <div class="mb-3">
              <label class="form-label">Name</label>
              <input type="text" name="name" class="form-control" value="${product.name}" required />
            </div>

            <div class="mb-3">
              <label class="form-label">Price</label>
              <input type="number" step="0.01" name="price" class="form-control" value="${product.price}" required />
            </div>

            <div class="mb-3">
              <label class="form-label">Stock</label>
              <input type="number" name="stock" class="form-control" value="${product.stock}" required />
            </div>

            <div class="mb-3">
              <label class="form-label">Supplier</label>
              <select name="supplierId" class="form-select">
                <option value="">-- Select Supplier --</option>
                <c:forEach var="s" items="${suppliers}">
                  <option value="${s.id}" <c:if test="${not empty product and product.supplierId == s.id}">selected="selected"</c:if>>${s.name}</option>
                </c:forEach>
              </select>
            </div>

            <div class="d-flex gap-2">
              <button class="btn btn-primary" type="submit">Save</button>
              <a href="<%=request.getContextPath()%>/products.do" class="btn btn-secondary">Cancel</a>
            </div>
          </form>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
