package com.example.catalogBook.controller;

import com.example.catalogBook.model.Author;
import com.example.catalogBook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String name, Model model) {
        List<Author> authors = authorService.searchAuthorsByName(name);
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping("/{id}")
    public String viewAuthor(@PathVariable Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        if (author != null) {
            model.addAttribute("author", author);
            model.addAttribute("books", author.getBooks());
        }
        return "author";
    }
}
