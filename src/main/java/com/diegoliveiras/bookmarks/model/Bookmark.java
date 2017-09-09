package com.diegoliveiras.bookmarks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bookmark {
	
	@Id
	@Column(name="id_bookmark")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_bookmark;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_title")	
	private Title title;
	
	private String comment;
	private String marking;
	
	public long getId() {
		return id_bookmark;
	}
	public void setId(long id) {
		this.id_bookmark = id;
	}	
	
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getMarking() {
		return marking;
	}
	public void setMarking(String marking) {
		this.marking = marking;
	}
	
}
