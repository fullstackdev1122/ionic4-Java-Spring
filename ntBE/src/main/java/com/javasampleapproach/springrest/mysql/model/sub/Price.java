package com.javasampleapproach.springrest.mysql.model.sub;

public class Price {
    private String name;
    private String email;
    private String message;
    private Visitors visitors;

    public Price(String name, String email, String message, Visitors visitors) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.visitors = visitors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Visitors getVisitors() {
        return visitors;
    }

    public void setVisitors(Visitors visitors) {
        this.visitors = visitors;
    }
}