package com.javasampleapproach.springrest.mysql.model;

import com.javasampleapproach.springrest.mysql.audit.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "message")
@EntityListeners(AuditingEntityListener.class)
public class Message extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "userid")
    private String userid;

    @Column(name = "visitorid")
    private String visitorid;

    @Column(name = "content", nullable = false)
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
    @Override
    public String toString() {
        return "Message [id=" + id + ", userid=" + userid + ", visitorid=" + visitorid +", content=" + content + "]";
    }
}
