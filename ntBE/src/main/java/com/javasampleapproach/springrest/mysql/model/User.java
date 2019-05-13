package com.javasampleapproach.springrest.mysql.model;

import com.javasampleapproach.springrest.mysql.audit.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "userid")
    private String userid;

    @Column(name = "deviceid")
    private String deviceid;

    public User() {
    }

    public User(String userid, String deviceid) {
        this.userid = userid;
        this.deviceid = deviceid;
    }

    public long getId() {
        return id;
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
    @Override
    public String toString() {
        return "User [id=" + id + ", userid=" + userid + ", deviceid=" + deviceid +"]";
    }
}