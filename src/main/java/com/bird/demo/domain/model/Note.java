package com.bird.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SeeDate", nullable = false)
    private String seeDate;

    @Column(name = "SeeHour", nullable = false)
    private String seeHour;

    @Column(name = "Behavior", nullable = false)
    private String behavior;

    @Column(name = "Comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "idBirds")
    private Birds birds;

    public Birds getBirds() {
        return birds;
    }

    public void setBirds(Birds birds) {
        this.birds = birds;
    }

    public String getSeeDate() {
        return seeDate;
    }

    public void setSeeDate(String seeDate) {
        this.seeDate = seeDate;
    }

    public String getSeeHour() {
        return seeHour;
    }

    public void setSeeHour(String seeHour) {
        this.seeHour = seeHour;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
