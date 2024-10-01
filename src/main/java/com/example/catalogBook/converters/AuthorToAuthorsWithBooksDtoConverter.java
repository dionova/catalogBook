package com.example.catalogBook.converters;

import com.example.catalogBook.database.model.Author;
import com.example.catalogBook.model.AuthorWithBooksDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorToAuthorsWithBooksDtoConverter implements Converter<List<Author>, List<AuthorWithBooksDto>>{
    private final AuthorToAuthorWithBooksDtoConverter authorToAuthorWithBooks;

    public AuthorToAuthorsWithBooksDtoConverter(AuthorToAuthorWithBooksDtoConverter authorToAuthorWithBooks) {
        this.authorToAuthorWithBooks = authorToAuthorWithBooks;
    }

    @Override
    public List<AuthorWithBooksDto> convert(List<Author> authors){
        List<AuthorWithBooksDto> listAuthorWithBooksDto = new ArrayList<>();

        for(Author author : authors)
            listAuthorWithBooksDto.add(authorToAuthorWithBooks.convert(author));

        return listAuthorWithBooksDto;
    }
}
