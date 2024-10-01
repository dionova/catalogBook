package com.example.catalogBook.converters;

import com.example.catalogBook.database.model.Author;
import com.example.catalogBook.model.AuthorDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorToAuthorsDtoConverter implements Converter<List<Author>, List<AuthorDto>> {
    @Override
    public List<AuthorDto> convert(List<Author> listAuthor) {
        List<AuthorDto> listDto = new ArrayList<>();

        for(Author author : listAuthor)
            listDto.add(convertAuthorToAuthorDto(author));

        return listDto;
    }

    private AuthorDto convertAuthorToAuthorDto(Author author){
        AuthorDto dto = new AuthorDto();

        dto.setName(author.getName());
        dto.setId(author.getId());

        return dto;
    }
}
