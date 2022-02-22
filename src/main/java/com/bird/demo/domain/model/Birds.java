package com.bird.demo.domain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Birds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BirdName", nullable = false)
    private String birdName;

    @Column(name = "SeeDate", nullable = false)
    private String seeDate;

    @Column(name = "SeeHour", nullable = false)
    private Integer seeHour;

    @Column(name = "Behavior", nullable = false)
    private String behavior;

    @Column(name = "Comments")
    private String comments;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBirdName() {
        return birdName;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public String getSeeDate() {
        return seeDate;
    }

    public void setSeeDate(String seeDate) {
        this.seeDate = seeDate;
    }

    public Integer getSeeHour() {
        return seeHour;
    }

    public void setSeeHour(Integer seeHour) {
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
}
