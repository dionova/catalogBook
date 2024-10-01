package com.example.catalogBook.database.repository;

import com.example.catalogBook.database.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByOrderByNameAsc();

    List<Author> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    List<Author> findByIdIn(List<Long> ids);
}
