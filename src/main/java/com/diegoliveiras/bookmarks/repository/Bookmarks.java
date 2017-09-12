package com.diegoliveiras.bookmarks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diegoliveiras.bookmarks.model.Bookmark;

public interface Bookmarks extends JpaRepository<Bookmark, Long>{	

	@Query(value = "SELECT *"
			+ "FROM bookmark b "
			+ "ORDER BY b.id_title", nativeQuery = true)
	List<Bookmark>  findAllOrderByTitle();
}
