package com.javasampleapproach.springrest.mysql.model.sub;

public class Notification {
    private String title;
    private String body;
    private String sound;
    private String click_action;
    private String icon;

    public Notification(String title, String body, String sound, String click_action, String icon) {
        this.title = title;
        this.body = body;
        this.sound = sound;
        this.click_action = click_action;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getClick_action() {
        return click_action;
    }

    public void setClick_action(String click_action) {
        this.click_action = click_action;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
