<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <%
            HttpSession session1 = request.getSession(false);
            if (session1 == null || session1.getAttribute("user") == null) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        
        <div class="alert alert-success">
            <h4>Chào mừng, <%= session1.getAttribute("user") %>!</h4>
            <a href="LogoutServlet" class="btn btn-danger">Đăng xuất</a>
        </div>
    </div>

</body>
</html>
