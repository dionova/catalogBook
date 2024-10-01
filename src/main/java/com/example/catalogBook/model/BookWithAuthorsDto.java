package com.example.catalogBook.model;

import java.util.List;

public class BookWithAuthorsDto {
    private long id;

    private String title;

    private List<AuthorDto> authors;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
