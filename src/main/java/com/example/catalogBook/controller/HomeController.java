package com.example.catalogBook.controller;

import com.example.catalogBook.model.BookWithAuthorsDto;
import com.example.catalogBook.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/home")
public class HomeController {

    private final BookService bookService;

    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/last-add-books/{countBooks}")
    @ResponseBody
    public List<BookWithAuthorsDto> getLastAddBooks(@PathVariable int countBooks) {
        List<BookWithAuthorsDto> result = bookService.getLastAddBooks(countBooks);

        return result;
    }
}
