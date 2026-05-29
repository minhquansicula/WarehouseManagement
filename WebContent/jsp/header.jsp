<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark">
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
          <a class="nav-link" href="<%=request.getContextPath()%>/products.do">
            📦 製品 (Products)
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/suppliers.do">🏭 仕入先 (Suppliers)</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">📊 在庫 (Inventory)</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">📋 請求書 (Invoices)</a>
        </li>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item">
          <span class="navbar-text me-3">
            👤 ${sessionScope.currentUser}
          </span>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#" onclick="showLogoutModal(event)">
            🚪 ログアウト (Logout)
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Logout Confirmation Modal -->
<div class="logout-modal" id="logoutModal">
  <div class="logout-modal-content">
    <h4>ログアウトの確認 (Confirm Logout)</h4>
    <p>ログアウトしてもよろしいですか？<br/><span style="font-size: 0.9rem; color: #999;">Are you sure you want to logout?</span></p>
    <div class="logout-modal-actions">
      <button class="btn btn-secondary" onclick="closeLogoutModal()">
        キャンセル (Cancel)
      </button>
      <button class="btn btn-primary" onclick="confirmLogout()">
        ログアウト (Logout)
      </button>
    </div>
  </div>
</div>

<script>
function showLogoutModal(event) {
  event.preventDefault();
  document.getElementById('logoutModal').classList.add('show');
}

function closeLogoutModal() {
  document.getElementById('logoutModal').classList.remove('show');
}

function confirmLogout() {
  window.location.href = '<%=request.getContextPath()%>/logout.do';
}

// Close modal when clicking outside of it
window.onclick = function(event) {
  const modal = document.getElementById('logoutModal');
  if (event.target == modal) {
    modal.classList.remove('show');
  }
}
</script>
