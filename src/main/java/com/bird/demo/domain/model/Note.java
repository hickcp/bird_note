package com.bird.demo.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	@JoinColumn(name = "idBird")
	private Bird bird;

	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
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
