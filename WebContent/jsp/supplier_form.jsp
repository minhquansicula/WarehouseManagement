<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="main-content">
    <div class="container">
        <div class="dashboard-header">
            <h1>仕入先フォーム (Supplier Form)</h1>
        </div>

        <div class="card p-4 login-card" style="max-width:700px;margin:auto;">
            <form method="post" action="<%=request.getContextPath()%>/suppliers.do?op=<%= (request.getAttribute("supplier")!=null) ? \"update\" : \"create\" %>">
                <c:if test="${not empty supplier}">
                    <input type="hidden" name="id" value="${supplier.id}" />
                </c:if>

                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" value="${supplier.name}" required />
                </div>

                <div class="mb-3">
                    <label class="form-label">Contact</label>
                    <input type="text" name="contact" class="form-control" value="${supplier.contact}" />
                </div>

                <div class="d-flex gap-2">
                    <button class="btn btn-primary" type="submit">Save</button>
                    <a href="<%=request.getContextPath()%>/suppliers.do" class="btn btn-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
