<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - WMS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/custom.css" rel="stylesheet">
    <style>body{display:flex;align-items:center;justify-content:center;height:100vh}</style>
</head>
<body>
<div class="card p-4" style="width:380px;">
    <h4 class="card-title">Sign in</h4>
    <form method="post"
      action="<%=request.getContextPath()%>/login.do">
        <div class="mb-3">
            <label class="form-label">Username</label>
            <input type="text" name="username" class="form-control"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" name="password" class="form-control"/>
        </div>
        <c:if test="${not empty loginError}">
            <div class="alert alert-danger">${loginError}</div>
        </c:if>
        <button class="btn btn-primary" type="submit">Login</button>
    </form>
</div>
</body>
</html>
