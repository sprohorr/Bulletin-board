package org.example.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "description")
    private String description;
    @Column(name = "grade")
    private double grade;
    @Column(name = "date")
    private java.sql.Date date;
    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Advertisement ad;

    public Feedback() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Date getDate(java.sql.Date date) {
        return this.date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public Advertisement getAd() {
        return ad;
    }

    public void setAdId(int adId) {
        this.ad = ad;
    }
}
