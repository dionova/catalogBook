package com.example.catalogBook.converters;

import com.example.catalogBook.database.model.Book;
import com.example.catalogBook.model.BookWithAuthorsDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookWithAuthorsDtoConverter implements Converter<Book, BookWithAuthorsDto> {
    private final AuthorToAuthorsDtoConverter authorToAuthorsDtoConverter;

    public BookToBookWithAuthorsDtoConverter(AuthorToAuthorsDtoConverter authorToAuthorsDtoConverter) {
        this.authorToAuthorsDtoConverter = authorToAuthorsDtoConverter;
    }

    @Override
    public BookWithAuthorsDto convert(Book book){
        BookWithAuthorsDto bookWithAuthorsDto = new BookWithAuthorsDto();

        bookWithAuthorsDto.setId(book.getBookId());
        bookWithAuthorsDto.setTitle(book.getTitle());
        bookWithAuthorsDto.setAuthors(authorToAuthorsDtoConverter.convert(book.getAuthors()));

        return bookWithAuthorsDto;
    }
}
