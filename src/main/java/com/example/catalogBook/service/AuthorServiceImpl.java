package com.example.catalogBook.service;

import com.example.catalogBook.converters.AuthorToAuthorWithBooksDtoConverter;
import com.example.catalogBook.converters.AuthorToAuthorsDtoConverter;
import com.example.catalogBook.database.model.Author;
import com.example.catalogBook.database.repository.AuthorRepository;
import com.example.catalogBook.exception.MessageException;
import com.example.catalogBook.exception.NotFoundAuthorException;
import com.example.catalogBook.model.AuthorDto;
import com.example.catalogBook.model.AuthorWithBooksDto;
import com.example.catalogBook.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorToAuthorsDtoConverter authorToAuthorsDtoConverter;
    private final AuthorToAuthorWithBooksDtoConverter authorToAuthorWithBooksDtoConverter;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorToAuthorsDtoConverter authorToAuthorsDtoConverter, AuthorToAuthorWithBooksDtoConverter authorToAuthorWithBooksDtoConverter) {
        this.authorRepository = authorRepository;
        this.authorToAuthorsDtoConverter = authorToAuthorsDtoConverter;
        this.authorToAuthorWithBooksDtoConverter = authorToAuthorWithBooksDtoConverter;
    }

    public List<AuthorDto> getAllAuthors() {
        List<Author> allAuthors = authorRepository.findAllByOrderByNameAsc();

        return authorToAuthorsDtoConverter.convert(allAuthors);
    }

    public List<AuthorDto> searchAuthorsByName(String name) {
        List<Author> searchAuthors = authorRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);

        if(searchAuthors.isEmpty())
            throw new NotFoundAuthorException(MessageException.NOT_FOUND_AUTHOR_BY_NAME);

        return authorToAuthorsDtoConverter.convert(searchAuthors);
    }

    public AuthorWithBooksDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).get();

        return authorToAuthorWithBooksDtoConverter.convert(author);
    }
}
