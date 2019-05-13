package com.javasampleapproach.springrest.mysql.model;

public class Result {

    public String user;
    public String visitor;
    public String message;

    public Result(String user, String visitor, String message) {
        setUser(user);
        setVisitor(visitor);
        setMessage(message);
    }

    public Result(){}

    public String getUser(){
        return user;
    }
    public void setUser(String user){
        this.user = user;
    }

    public String getVisitor(){
        return visitor;
    }
    public void setVisitor(String visitor){
        this.visitor = visitor;
    }

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
