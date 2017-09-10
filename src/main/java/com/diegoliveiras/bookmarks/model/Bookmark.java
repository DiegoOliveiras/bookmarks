package com.diegoliveiras.bookmarks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Bookmark {
	
	@Id
	@Column(name="id_bookmark")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_bookmark;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_title")	
	@NotNull(message = "Please, select a title.")
	private Title title;
	
	@Size(max=400, message = "Comment can'''t have more than 400 characters.")
	private String comment;
	
	@NotBlank(message = "Marking can'''t be empty.")
	@Size(min=3, max=60, message = "Marking must have more than 3 and less than 60 characters.")
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
