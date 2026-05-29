<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="main-content">
    <div class="container">
        <div class="dashboard-header">
            <h1>仕入先一覧 (Suppliers)</h1>
        </div>

        <div class="card p-3 mb-3">
            <a href="<%=request.getContextPath()%>/suppliers.do?op=form" class="btn btn-primary">＋ 新規作成 (Add Supplier)</a>
        </div>

        <div class="card p-3">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Contact</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="s" items="${suppliers}">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <td>${s.contact}</td>
                        <td>
                            <a class="btn btn-sm btn-secondary" href="<%=request.getContextPath()%>/suppliers.do?op=edit&id=${s.id}">Edit</a>
                            <a class="btn btn-sm btn-logout" href="<%=request.getContextPath()%>/suppliers.do?op=delete&id=${s.id}" onclick="return confirm('Delete supplier?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
