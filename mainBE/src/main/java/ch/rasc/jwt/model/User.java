package ch.rasc.jwt.model;

public class User {

    private String userid;

    private String deviceid;

    public User() {
    }

    public User(String userid, String deviceid) {
        this.userid = userid;
        this.deviceid = deviceid;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String user_id) {
        this.userid = user_id;
    }

    public String getDeviceid() {
        return this.deviceid;
    }
    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }
}