package com.example.catalogBook.controller;

import com.example.catalogBook.model.AddBookArgs;
import com.example.catalogBook.exception.UniqueConstraintViolationException;
import com.example.catalogBook.model.BookDto;
import com.example.catalogBook.model.BookWithAuthorsDto;
import com.example.catalogBook.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAllBooks")
    @ResponseBody
    public List<BookDto> getAllBooks() {
        List<BookDto> result = bookService.getAllBooks();

        return result;
    }

    @GetMapping("/search")
    @ResponseBody
    public List<BookDto> searchBooksByTitle(@RequestParam String title) {
        List<BookDto> result = bookService.searchBooksByTitle(title);

        return result;
    }

    @GetMapping("/viewBookWithAuthors/{id}")
    @ResponseBody
    public BookWithAuthorsDto getBookWithAuthors(@PathVariable Long id, Model model) {
        BookWithAuthorsDto result = bookService.getBookById(id);

        return result;
    }

    @PostMapping("/addBook")
    @ResponseBody
    public BookWithAuthorsDto addBook(@RequestBody AddBookArgs addBookArgs) throws UniqueConstraintViolationException {
        BookWithAuthorsDto result = bookService.addBook(addBookArgs);

        return result;
    }
}
