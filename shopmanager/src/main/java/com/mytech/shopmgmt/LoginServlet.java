package com.mytech.shopmgmt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        super.init();
    }

    public void destroy() {
        System.out.println("LoginServlet is being destroyed...");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("error", "Vui lòng nhập tên đăng nhập và mật khẩu!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if ("admin".equals(username) && "123".equals(password)) {
            // Lưu thông tin vào session
            HttpSession session = request.getSession();
            session.setAttribute("username", username); // Đặt lại đúng tên session
            session.setAttribute("loginDate", System.currentTimeMillis());

            // Tạo cookie
            Cookie ckUsername = new Cookie("username", username);
            Cookie ckLoginDate = new Cookie("loginDate", String.valueOf(System.currentTimeMillis()));

            ckUsername.setMaxAge(86400);
            ckLoginDate.setMaxAge(86400);

            response.addCookie(ckUsername);
            response.addCookie(ckLoginDate);

            // Chuyển hướng đến DashBoardServlet để lấy dữ liệu từ session & cookie
            response.sendRedirect("DashBoard");

        } else {
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
