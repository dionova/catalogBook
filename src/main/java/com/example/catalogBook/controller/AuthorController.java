package com.example.catalogBook.controller;

import com.example.catalogBook.model.AuthorDto;
import com.example.catalogBook.model.AuthorWithBooksDto;
import com.example.catalogBook.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/getAllAuthors")
    @ResponseBody
    public List<AuthorDto> getAllAuthors() {
        List<AuthorDto> result = authorService.getAllAuthors();

        return result;
    }

    @GetMapping("/search")
    @ResponseBody
    public List<AuthorDto> searchAuthorsByName(@RequestParam String name) {
        List<AuthorDto> result = authorService.searchAuthorsByName(name);

        return result;
    }

    @GetMapping("/viewAuthorWithBooks/{id}")
    @ResponseBody
    public AuthorWithBooksDto viewAuthorAndBook(@PathVariable Long id) {
        AuthorWithBooksDto result = authorService.getAuthorById(id);

        return result;
    }
}
