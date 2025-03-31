package com.mytech.shopmgmt;

import com.mytech.shopmgmt.DAO.ProductDAO;
import com.mytech.shopmgmt.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ProductDAO productDAO = new ProductDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.getAllProducts();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}
