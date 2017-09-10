package com.diegoliveiras.bookmarks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diegoliveiras.bookmarks.model.Bookmark;
import com.diegoliveiras.bookmarks.model.Count;

public interface Bookmarks extends JpaRepository<Bookmark, Long>{

	@Query(value = "SELECT COUNT(*) "
			+ "FROM bookmark b "
			+ "RIGHT JOIN title t "
			+ "ON t.id_title=b.id_title GROUP BY b.id_title", nativeQuery = true)
	List<String> countByTitle();

}
