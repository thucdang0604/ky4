<%@page import="jdk.jfr.Percentage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Navigation Bar (nếu cần) -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">My Shop</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="dashboard.jsp">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="products.jsp">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Container -->
    <div class="container mt-4">
        <h2>Product List</h2>
        <hr/>

        <!-- Danh sách sản phẩm -->
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Image</th>
                        <th>Cart</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${productList}">
                        <tr>
                            <!-- Giả sử thuộc tính "code" dùng làm id của sản phẩm -->
                            <td>${product.code}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>
                                <img src="${product.image}" alt="${product.name}" width="50">
                            </td>
                            <td>
                                <!-- Giả sử addToCart là servlet xử lý chức năng thêm vào giỏ hàng -->
                                <a href="addToCart?id=${product.code}" class="btn btn-sm btn-info">Add to Cart</a>
                            </td>
                            <td>
                                <!-- Chuyển đến trang hoặc servlet chỉnh sửa sản phẩm -->
                                <a href="editProduct?id=${product.code}" class="btn btn-sm btn-primary">Edit</a>
                            </td>
                            <td>
                                <!-- Chuyển đến servlet xóa sản phẩm -->
                                <a href="deleteProduct?id=${product.code}" class="btn btn-sm btn-danger"
                                   onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này không?');">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty productList}">
                        <tr>
                            <td colspan="7" class="text-center">No products found.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
