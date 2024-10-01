package com.example.catalogBook.converters;

import com.example.catalogBook.database.model.Book;
import com.example.catalogBook.model.BookDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookToBooksDtoConverter implements Converter<List<Book>, List<BookDto>> {
    @Override
    public List<BookDto> convert(List<Book> listBooks) {
        List<BookDto> listDto = new ArrayList<>();

        for(Book book : listBooks)
            listDto.add(convertBookToBookDto(book));

        return listDto;
    }

    private BookDto convertBookToBookDto(Book book) {
        BookDto dto = new BookDto();

        dto.setTitle(book.getTitle());
        dto.setId(book.getBookId());

        return dto;
    }
}
