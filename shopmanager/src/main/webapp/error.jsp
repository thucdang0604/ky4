<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lỗi hệ thống</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">

    <div class="card p-4 shadow-lg rounded" style="max-width: 500px;">
        <h3 class="text-center text-danger">⚠️ Đã xảy ra lỗi</h3>
        
        <%-- Nhận lỗi từ request và hiển thị --%>
        <div class="alert alert-danger text-center">
            <strong>Lỗi:</strong> <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "Lỗi không xác định!" %>
        </div>

        <div class="text-center">
            <a href="login.jsp" class="btn btn-primary">Quay lại Đăng nhập</a>
            <a href="index.jsp" class="btn btn-secondary">Trang chủ</a>
        </div>
    </div>

    <!-- Bootstrap 5 JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
