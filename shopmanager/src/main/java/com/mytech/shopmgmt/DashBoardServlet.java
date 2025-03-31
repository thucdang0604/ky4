package com.mytech.shopmgmt;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DashBoardServlet
 */
@WebServlet("/DashBoard")
public class DashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String usernameSession = (String) session.getAttribute("username");

        if (usernameSession == null) {
            usernameSession = "Guest"; // Đặt giá trị mặc định nếu session chưa có username
        }

        String username = "Guest";  
        String loginDate = "Không xác định";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) { // Kiểm tra null trước khi duyệt
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                } else if ("loginDate".equals(cookie.getName())) {
                    try {
                        long timestamp = Long.parseLong(cookie.getValue());
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        loginDate = sdf.format(new Date(timestamp));
                    } catch (NumberFormatException e) {
                        loginDate = "Không hợp lệ";
                    }
                }
            }
        }

        request.setAttribute("username", username);
        request.setAttribute("usernameSession", usernameSession); // Đặt usernameSession vào request
        request.setAttribute("loginDate", loginDate);

        System.out.println("Debug: usernameSession = " + usernameSession); // Kiểm tra debug

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
        requestDispatcher.forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
