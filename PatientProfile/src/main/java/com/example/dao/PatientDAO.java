package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Patient;
import com.example.util.DatabaseUtil;

public class PatientDAO {
	public boolean createPatient(Patient patient) {
		String sql = "INSERT INTO patients (id, name, email, phone, diagnosis) VALUES (?,?,?,?,?)";
		try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, patient.getId());
			stmt.setString(2, patient.getName());
			stmt.setString(3, patient.getEmail());
			stmt.setString(4, patient.getPhone());
			stmt.setString(5, patient.getDiagnosis());
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<>();
		String sql = "SELECT * FROM patients";
		try (Connection conn = DatabaseUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Patient patient = new Patient(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("phone"), rs.getString("diagnosis"));
				patients.add(patient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patients;
	}
	public boolean updatePatient(Patient patient) {
        String sql = "UPDATE patients SET name = ?, email = ?, phone = ?, diagnosis = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getEmail());
            stmt.setString(3, patient.getPhone());
            stmt.setString(4, patient.getDiagnosis());
            stmt.setInt(5, patient.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	// Delete
	public boolean deletePatient(int id) {
		String sql = "DELETE FROM patients WHERE id = ?";
		try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
