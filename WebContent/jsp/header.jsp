<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/jsp/dashboard.jsp">WMS</a>
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarNav"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/products.do">Products</a>
        </li>
        <li class="nav-item"><a class="nav-link" href="#">Suppliers</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Inventory</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Invoices</a></li>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item">
          <span class="navbar-text me-3">Welcome, ${sessionScope.currentUser}!</span>
        </li>
        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/logout.do">Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
