package com.diegoliveiras.bookmarks.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Title {
	
	@Id
	@Column(name="id_title")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id_title;
	
	@NotBlank(message = "Name can'''t be empty.")
	@Size(min=3, max=60, message = "Name  must have more than 3 and less than 60 characters.")
	private String name;
	
	@Size(max=400, message = "Description can'''t have more than 400 characters.")
	private String description;
	
	@Size(max=60, message = "Creator can'''t have more than 60 characters.")
	private String creator;
	
	@OneToMany(mappedBy = "title", targetEntity = Bookmark.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Bookmark> bookmarks;
	
	private byte[] picture;
	
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public long getId_title() {
		return id_title;
	}
	public void setId_title(long id_title) {
		this.id_title = id_title;
	}
	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}
	public void setBookmarks(Set<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public long getId() {
		return id_title;
	}
	public void setId(long id) {
		this.id_title = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public int getBookmarksCouting() {
		return bookmarks.size();
	}
}
