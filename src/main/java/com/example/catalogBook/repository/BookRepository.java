package com.example.catalogBook.repository;

import com.example.catalogBook.model.Book;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b ORDER BY id DESC limit 10")
    List<Book> findLatestBooks();

    List<Book> findByTitleContainingIgnoreCaseOrderByTitleAsc(String title);

    @Query("SELECT b FROM Book b ORDER BY b.title ASC")
    List<Book> findAllBooksOrderedByTitle();

    boolean existsByTitleAndAuthorsId(String title, Long authorId);

}
