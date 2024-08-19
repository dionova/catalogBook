package com.example.catalogBook.repository;

import com.example.catalogBook.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a ORDER BY a.name ASC")
    List<Author> findAllAuthorsOrderedByName();

    List<Author> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    List<Author> findByIdIn(List<Long> id);
}
