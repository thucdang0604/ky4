package com.example.model;

public class Patient {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String diagnosis;

    // Constructor
    public Patient(int id, String name, String email, String phone, String diagnosis) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.diagnosis = diagnosis;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
}