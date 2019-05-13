package com.javasampleapproach.springrest.mysql.model;

import com.javasampleapproach.springrest.mysql.model.sub.Data;
import com.javasampleapproach.springrest.mysql.model.sub.Notification;

public class FirebaseBody {

    private Notification notification;
    private Data data;
    private String to;
    private String priority;
    private String restricted_package_name;

    public FirebaseBody(Notification notification, Data data, String to, String priority, String restricted_package_name) {
        this.notification = notification;
        this.data = data;
        this.to = to;
        this.priority = priority;
        this.restricted_package_name = restricted_package_name;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRestricted_package_name() {
        return restricted_package_name;
    }

    public void setRestricted_package_name(String restricted_package_name) {
        this.restricted_package_name = restricted_package_name;
    }
}

