package com.example.catalogBook.service.interfaces;

import com.example.catalogBook.model.AuthorDto;
import com.example.catalogBook.model.AuthorWithBooksDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAllAuthors();
    List<AuthorDto> searchAuthorsByName(String name);
    AuthorWithBooksDto getAuthorById(Long id);
}
