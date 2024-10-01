package com.example.catalogBook.database.repository;

import com.example.catalogBook.database.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b ORDER BY id DESC limit :countBooks")
    List<Book> findLastAddBooks(@Param("countBooks") int countBooks);

    List<Book> findByTitleContainingIgnoreCaseOrderByTitleAsc(String title);

    List<Book> findAllByOrderByTitleAsc();
}
