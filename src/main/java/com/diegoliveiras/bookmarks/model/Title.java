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

@Entity
public class Title {
	
	@Id
	@Column(name="id_title")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id_title;
	
	@Size(min=3, max=60)
	private String name;
	
	@Size(max=400)
	private String description;
	
	@Size(max=60)
	private String creator;
	
	@OneToMany(mappedBy = "title", targetEntity = Bookmark.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Bookmark> bookmarks;
	
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
