package com.example.catalogBook.model;

import java.util.List;

public class AddBookArgs {
    private String title;

    private List<Long> authorIds;

    public String getTitle() {
        return title;
    }

    public AddBookArgs setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Long> getAuthorIds() {
        return authorIds;
    }

    public AddBookArgs setAuthorIds(List<Long> authorIds) {
        this.authorIds = authorIds;
        return this;
    }
}
