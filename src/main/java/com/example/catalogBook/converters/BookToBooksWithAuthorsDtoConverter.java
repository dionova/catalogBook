package com.example.catalogBook.converters;

import com.example.catalogBook.database.model.Book;
import com.example.catalogBook.model.BookWithAuthorsDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookToBooksWithAuthorsDtoConverter implements Converter<List<Book>, List<BookWithAuthorsDto>> {
    private final BookToBookWithAuthorsDtoConverter bookToBookWithAuthorsDtoConverter;

    public BookToBooksWithAuthorsDtoConverter(BookToBookWithAuthorsDtoConverter bookToBookWithAuthorsDtoConverter) {
        this.bookToBookWithAuthorsDtoConverter = bookToBookWithAuthorsDtoConverter;
    }

    @Override
    public List<BookWithAuthorsDto> convert(List<Book> books){
        List<BookWithAuthorsDto> listBookWithAuthorsDto = new ArrayList<>();

        for(Book book : books)
            listBookWithAuthorsDto.add(bookToBookWithAuthorsDtoConverter.convert(book));

        return listBookWithAuthorsDto;
    }
}
