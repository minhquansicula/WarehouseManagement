<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="container mt-4">
    <h1>Dashboard</h1>
    <div class="row">
        <div class="col-md-4">
            <div class="card p-3">Total Products: ${totalProducts}</div>
        </div>
        <div class="col-md-4">
            <div class="card p-3">Total Suppliers: ${totalSuppliers}</div>
        </div>
        <div class="col-md-4">
            <div class="card p-3">Recent Invoices: ${recentInvoices}</div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
