<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
<div class="main-content">
    <div class="container">
        <div class="dashboard-header">
            <h1>製品一覧 (Products)</h1>
        </div>

        <div class="card p-3 mb-3">
            <a href="<%=request.getContextPath()%>/products.do?op=form" class="btn btn-primary">＋ 新規作成 (Add Product)</a>
        </div>

        <div class="card p-3">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Stock</th>
                        <th>Supplier</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="p" items="${products}">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.price}</td>
                        <td>${p.stock}</td>
                        <td>
                            <c:choose>
                                <c:when test="${not empty suppliers}">
                                    <c:forEach var="s" items="${suppliers}">
                                        <c:if test="${s.id == p.supplierId}">
                                            ${s.name}
                                        </c:if>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    ${p.supplierId}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a class="btn btn-sm btn-secondary" href="<%=request.getContextPath()%>/products.do?op=edit&id=${p.id}">Edit</a>
                            <a class="btn btn-sm btn-logout" href="<%=request.getContextPath()%>/products.do?op=delete&id=${p.id}" onclick="return confirm('Delete product?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
            </table>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
