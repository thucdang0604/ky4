<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Patient</title>
</head>
<body>
    <h2>Update Patient</h2>
    <form method="post" action="Patient">
        <input type="hidden" name="action" value="update">
        ID: <input type="number" name="id" required><br><br>
        Name: <input type="text" name="name"><br><br>
        Email: <input type="email" name="email"><br><br>
        Phone: <input type="text" name="phone"><br><br>
        Diagnosis: <input type="text" name="diagnosis"><br><br>
        <input type="submit" value="Update">
    </form>
    <a href="index.jsp">Back to Home</a>
</body>
</html>