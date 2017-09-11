package com.diegoliveiras.bookmarks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diegoliveiras.bookmarks.model.Title;

public interface Titles extends JpaRepository<Title, Long>{

	@Query(value = "SELECT *"
			+ "FROM title t "
			+ "ORDER BY t.name", nativeQuery = true)
	List<Title>  findAllOrderByName();

}
