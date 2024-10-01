package com.example.catalogBook.service.interfaces;

import com.example.catalogBook.model.AddBookArgs;
import com.example.catalogBook.model.BookDto;
import com.example.catalogBook.model.BookWithAuthorsDto;

import java.util.List;

public interface BookService {
    List<BookWithAuthorsDto> getLastAddBooks(int countBooks);
    List<BookDto> getAllBooks();
    List<BookDto> searchBooksByTitle(String title);
    BookWithAuthorsDto getBookById(Long id);
    BookWithAuthorsDto addBook(AddBookArgs addBookArgs);
}
