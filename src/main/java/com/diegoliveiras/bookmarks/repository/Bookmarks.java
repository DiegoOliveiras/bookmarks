package com.diegoliveiras.bookmarks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoliveiras.bookmarks.model.Bookmark;

public interface Bookmarks extends JpaRepository<Bookmark, Long>{

}
