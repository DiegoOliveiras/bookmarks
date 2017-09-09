package com.diegoliveiras.bookmarks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoliveiras.bookmarks.model.Bookmark;
import com.diegoliveiras.bookmarks.model.User;

public interface Users extends JpaRepository<User, Long>{

}
