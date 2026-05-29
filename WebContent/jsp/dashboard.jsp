<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ダッシュボード - WMS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/custom.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="header.jsp"/>
    
    <div class="main-content">
        <div class="container">
            <!-- Dashboard Header -->
            <div class="dashboard-header">
                <h1>ダッシュボード (Dashboard)</h1>
                <p style="margin-bottom: 0; color: #6B8E7F; font-size: 0.9rem;">
                    ようこそ、${sessionScope.currentUser}様へ
                </p>
            </div>

            <!-- Statistics Grid -->
            <div class="stats-grid">
                <div class="card dashboard-card">
                    <div class="label">📦 総製品数</div>
                    <div class="number">${empty totalProducts ? '0' : totalProducts}</div>
                    <p style="color: #999; font-size: 0.85rem;">Total Products</p>
                </div>

                <div class="card dashboard-card">
                    <div class="label">🏭 仕入先</div>
                    <div class="number">${empty totalSuppliers ? '0' : totalSuppliers}</div>
                    <p style="color: #999; font-size: 0.85rem;">Suppliers</p>
                </div>

                <div class="card dashboard-card">
                    <div class="label">📋 最近の請求書</div>
                    <div class="number">${empty recentInvoices ? '0' : recentInvoices}</div>
                    <p style="color: #999; font-size: 0.85rem;">Recent Invoices</p>
                </div>
            </div>

            <!-- Quick Actions -->
            <div class="row mt-4">
                <div class="col-md-6">
                    <div class="card p-4">
                        <h5 class="card-title" style="border-bottom: 2px solid #6B8E7F; padding-bottom: 0.5rem;">
                            🚀 クイックアクション (Quick Actions)
                        </h5>
                        <div class="mt-3">
                            <a href="<%=request.getContextPath()%>/products.do" class="btn btn-secondary btn-sm me-2 mb-2">
                                製品を表示 (View Products)
                            </a>
                            <a href="#" class="btn btn-secondary btn-sm mb-2">
                                新規製品 (New Product)
                            </a>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card p-4">
                        <h5 class="card-title" style="border-bottom: 2px solid #C41E3A; padding-bottom: 0.5rem;">
                            📊 システム情報 (System Info)
                        </h5>
                        <div class="mt-3">
                            <p style="margin-bottom: 0.5rem;"><strong>ユーザー役割:</strong> ${sessionScope.currentUserRole}</p>
                            <p style="margin-bottom: 0;"><strong>接続ステータス:</strong> 
                                <span style="color: #6B8E7F;">✓ オンライン</span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/main.js"></script>
</body>
</html>
