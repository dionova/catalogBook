package com.example.catalogBook.service;

import com.example.catalogBook.error.UniqueConstraintViolationException;
import com.example.catalogBook.model.Author;
import com.example.catalogBook.model.Book;
import com.example.catalogBook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public List<Book> getLatestBooks() {
        return bookRepository.findLatestBooks();
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCaseOrderByTitleAsc(title);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAllBooksOrderedByTitle();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    public void add(Book book, String title, List<Long> authorIds) {
        validation(title, authorIds.get(0));
        bookRepository.save(book);
    }

    private void validation(String titleNew, Long authorId) {
        Author author = authorService.getAuthorById(authorId);
        List<Book> books = author.getBooks();
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(titleNew)){
                throw new UniqueConstraintViolationException("Такая книга уже добавлена");
            }
        }
    }
}
