<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WMS - ログイン (Warehouse Management System)</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/custom.css" rel="stylesheet">
</head>
<body class="login-container">
    <div class="login-card">
        <div style="text-align: center; margin-bottom: 2rem;">
            <h3 style="color: #1B3E5F; margin-bottom: 0.5rem;">WMS</h3>
            <p style="color: #6B8E7F; font-size: 0.9rem; letter-spacing: 2px;">WAREHOUSE MANAGEMENT SYSTEM</p>
        </div>

        <form method="post" action="<%=request.getContextPath()%>/login.do">
            <div class="mb-3">
                <label class="form-label" for="username">ユーザー名 (Username)</label>
                <input 
                    type="text" 
                    id="username"
                    name="username" 
                    class="form-control" 
                    placeholder="admin"
                    required/>
            </div>

            <div class="mb-4">
                <label class="form-label" for="password">パスワード (Password)</label>
                <input 
                    type="password" 
                    id="password"
                    name="password" 
                    class="form-control" 
                    placeholder="••••••••"
                    required/>
            </div>

            <c:if test="${not empty loginError}">
                <div class="alert alert-danger" role="alert">
                    <strong>ログイン失敗 (Login Failed)</strong><br/>
                    ${loginError}
                </div>
            </c:if>

            <button class="btn btn-primary w-100" type="submit" style="font-weight: 600; padding: 0.7rem;">
                ログイン (Login)
            </button>
        </form>

        <div style="text-align: center; margin-top: 2rem; padding-top: 1.5rem; border-top: 1px solid #E8E8E8;">
            <p style="font-size: 0.85rem; color: #6B8E7F;">
                デモ用: admin / admin<br/>
                <span style="font-size: 0.8rem; color: #999;">Demo: admin / admin</span>
            </p>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
