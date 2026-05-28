<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Warehouse Management System</title>
    <!-- Bootstrap 5 via CDN -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link href="../css/custom.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body>
    <jsp:include page="header.jsp" />
    <div class="container mt-4">
      <jsp:include page="${contentPage}" />
    </div>
    <jsp:include page="footer.jsp" />
  </body>
</html>
