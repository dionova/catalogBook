package com.example.catalogBook.service;

import com.example.catalogBook.model.Author;
import com.example.catalogBook.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAllAuthorsOrderedByName();
    }

    public List<Author> searchAuthorsByName(String name) {
        return authorRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    public List<Author> findById(List<Long> id) {
        return authorRepository.findByIdIn(id);
    }

    public void valid() {

    }
}
