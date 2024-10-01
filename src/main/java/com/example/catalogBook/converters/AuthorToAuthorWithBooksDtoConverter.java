package com.example.catalogBook.converters;

import com.example.catalogBook.database.model.Author;
import com.example.catalogBook.model.AuthorWithBooksDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToAuthorWithBooksDtoConverter implements Converter<Author, AuthorWithBooksDto> {
    private final BookToBooksDtoConverter bookToBooksDtoConverter;

    public AuthorToAuthorWithBooksDtoConverter(BookToBooksDtoConverter bookToBooksDtoConverter) {
        this.bookToBooksDtoConverter = bookToBooksDtoConverter;
    }

    @Override
    public AuthorWithBooksDto convert(Author author){
        AuthorWithBooksDto authorWithBooksDto = new AuthorWithBooksDto();

        authorWithBooksDto.setId(author.getId());
        authorWithBooksDto.setName(author.getName());
        authorWithBooksDto.setBooks(bookToBooksDtoConverter.convert(author.getBooks()));

        return authorWithBooksDto;
    }
}
