CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE books_author (
    book_id INT REFERENCES book(id) ON DELETE CASCADE,
    author_id INT REFERENCES author(id) ON DELETE CASCADE,
    PRIMARY KEY (book_id, author_id)

);