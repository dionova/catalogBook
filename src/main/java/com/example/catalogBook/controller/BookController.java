package com.example.catalogBook.controller;

import com.example.catalogBook.error.UniqueConstraintViolationException;
import com.example.catalogBook.model.Book;
import com.example.catalogBook.service.AuthorService;
import com.example.catalogBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String title, Model model) {
        List<Book> books = bookService.searchBooksByTitle(title);
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{id}")
    public String viewBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("authors", book.getAuthors());
        }
        return "book";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "add_book";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String title, @RequestParam List<Long> authorIds, Model model) {
        Book book = new Book();
        try {
            book.setTitle(title);
            book.setAuthors(authorService.findById(authorIds));
            bookService.add(book, title, authorIds);
            model.addAttribute("message", "Книга успешно добавлена!");
        }
        catch (UniqueConstraintViolationException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("authors", authorService.getAllAuthors());
        return "add_book";
    }
}
