package com.diegoliveiras.bookmarks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoliveiras.bookmarks.model.Bookmark;

public interface Bookmarks extends JpaRepository<Bookmark, Long>{

	//@Query(value = "SELECT COUNT(*) "
	//		+ "FROM bookmark b "
	//		+ "RIGHT JOIN title t "
	//		+ "ON t.id_title=b.id_title GROUP BY b.id_title", nativeQuery = true)
	 //List<Count>  countByTitle();

}
