package com.diegoliveiras.bookmarks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diegoliveiras.bookmarks.model.Title;

public interface Titles extends JpaRepository<Title, Long>{

}
