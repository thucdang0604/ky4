package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.example.dao.PatientDAO;
import com.example.model.Patient;

/**
 * Servlet implementation class patientServlet
 */
@WebServlet("/Patient")
public class patientServlet extends HttpServlet {
	private PatientDAO patientDAO;
	@Override
	public void init() throws ServletException {
		patientDAO = new PatientDAO();
	}
       

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            // Hiển thị danh sách bệnh nhân
            List<Patient> patients = patientDAO.getAllPatients();
            request.setAttribute("patients", patients);
            request.getRequestDispatcher("/read.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            // Xóa bệnh nhân
            int id = Integer.parseInt(request.getParameter("id"));
            patientDAO.deletePatient(id);
            response.sendRedirect("Patient?action=list");
        } else if (action.equals("showUpdate")) {
            // Hiển thị form cập nhật
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } else if (action.equals("showCreate")) {
            // Hiển thị form tạo mới
            request.getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("create")) {
            // Tạo bệnh nhân mới
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String diagnosis = request.getParameter("diagnosis");

            Patient patient = new Patient(id, name, email, phone, diagnosis);
            if (patientDAO.createPatient(patient)) {
                request.setAttribute("message", "Patient created successfully!");
            } else {
                request.setAttribute("message", "Failed to create patient.");
            }
            response.sendRedirect("Patient?action=list");
        } else if (action.equals("update")) {
            // Cập nhật bệnh nhân
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String diagnosis = request.getParameter("diagnosis");

            Patient patient = new Patient(id, name, email, phone, diagnosis);
            if (patientDAO.updatePatient(patient)) {
                request.setAttribute("message", "Patient updated successfully!");
            } else {
                request.setAttribute("message", "Failed to update patient.");
            }
            response.sendRedirect("Patient?action=list");
        }
    }

}
