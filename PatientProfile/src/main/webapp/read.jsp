<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Patients</title>
</head>
<body>
    <h2>All Patients</h2>
    <table border="1" width="100%">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Diagnosis</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="patient" items="${patients}">
            <tr>
                <td>${patient.id}</td>
                <td>${patient.name}</td>
                <td>${patient.email}</td>
                <td>${patient.phone}</td>
                <td>${patient.diagnosis}</td>
                <td>
                    <a href="Patient?action=delete&id=${patient.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="index.jsp">Back to Home</a>
</body>
</html>