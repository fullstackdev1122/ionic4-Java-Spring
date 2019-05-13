package ch.rasc.jwt.model;

public class Message {

    private long id;
    private String userid;
    private String visitorid;
    private String content;

    public Message() {
    }

    public Message(String userid, String visitorid, String content) {
        this.userid = userid;
        this.visitorid = visitorid;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return this.userid;
    }

    public String getVisitorid() {
        return this.visitorid;
    }

    public void setVisitorid(String visitorid) {
        this.visitorid = visitorid;
    }

    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
