package org.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private java.util.Date date;
    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Advertisement adId;

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

    public Date getDate(java.util.Date date) {
        return this.date;
    }

    public void setDate(LocalDateTime now) {
        this.date = date;
    }

    public Advertisement getAdId() {
        return adId;
    }

    public void setAdId(Advertisement adId) {
        this.adId = adId;
    }
}
