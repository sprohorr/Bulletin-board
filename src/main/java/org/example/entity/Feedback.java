package org.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

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
    private LocalDateTime date;
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

    public LocalDateTime getDate(LocalDateTime date) {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Advertisement getAd() {
        return ad;
    }

    public void setAd(Advertisement ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", grade=" + grade +
                ", date=" + date +
                ", ad=" + ad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return id == feedback.id && Double.compare(feedback.grade, grade) == 0 && Objects.equals(userName, feedback.userName) && Objects.equals(description, feedback.description) && Objects.equals(date, feedback.date) && Objects.equals(ad, feedback.ad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, description, grade, date, ad);
    }
}
