package com.javasampleapproach.springrest.mysql.model.sub;

public class Visitors {
    private String id;
    private String name;
    private String email;
    private String company;
    private String arrivalDate;
    private String leaveDate;
    private String cardnumber;
    private boolean cardHandedDown;

    public Visitors() { }

    public Visitors(String id, String name, String email, String company, String arrivalDate, String leaveDate, String cardnumber, boolean cardHandedDown) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.company = company;
        this.arrivalDate = arrivalDate;
        this.leaveDate = leaveDate;
        this.cardnumber = cardnumber;
        this.cardHandedDown = cardHandedDown;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public boolean getCardHandedDown() {
        return cardHandedDown;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public void setCardHandedDown(boolean cardHandedDown) {
        this.cardHandedDown = cardHandedDown;
    }
}
