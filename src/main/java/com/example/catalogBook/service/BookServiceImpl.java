package com.example.catalogBook.service;

import com.example.catalogBook.converters.BookToBookWithAuthorsDtoConverter;
import com.example.catalogBook.converters.BookToBooksDtoConverter;
import com.example.catalogBook.converters.BookToBooksWithAuthorsDtoConverter;
import com.example.catalogBook.model.AddBookArgs;
import com.example.catalogBook.database.repository.AuthorRepository;
import com.example.catalogBook.exception.MessageException;
import com.example.catalogBook.exception.NotFoundBookException;
import com.example.catalogBook.exception.UniqueConstraintViolationException;
import com.example.catalogBook.database.model.Author;
import com.example.catalogBook.database.model.Book;
import com.example.catalogBook.database.repository.BookRepository;
import com.example.catalogBook.model.BookDto;
import com.example.catalogBook.model.BookWithAuthorsDto;
import com.example.catalogBook.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookToBooksWithAuthorsDtoConverter bookToBooksWithAuthorsDtoConverter;
    private final BookToBooksDtoConverter bookToBooksDtoConverter;
    private final BookToBookWithAuthorsDtoConverter bookToBookWithAuthorsDtoConverter;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BookToBooksWithAuthorsDtoConverter bookToBooksWithAuthorsDtoConverter, BookToBooksDtoConverter bookToBooksDtoConverter, BookToBookWithAuthorsDtoConverter bookToBookWithAuthorsDtoConverter) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookToBooksWithAuthorsDtoConverter = bookToBooksWithAuthorsDtoConverter;
        this.bookToBooksDtoConverter = bookToBooksDtoConverter;
        this.bookToBookWithAuthorsDtoConverter = bookToBookWithAuthorsDtoConverter;
    }

    public List<BookWithAuthorsDto> getLastAddBooks(int countBooks) {
        List<Book> lastBooks = bookRepository.findLastAddBooks(countBooks);

        return bookToBooksWithAuthorsDtoConverter.convert(lastBooks);
    }

    public List<BookDto> getAllBooks() {
        List<Book> allBooks = bookRepository.findAllByOrderByTitleAsc();

        return bookToBooksDtoConverter.convert(allBooks);
    }

    public List<BookDto> searchBooksByTitle(String title) {
        List<Book> searchBooks = bookRepository.findByTitleContainingIgnoreCaseOrderByTitleAsc(title);

        if(searchBooks.isEmpty())
            throw new NotFoundBookException(MessageException.NOT_FOUND_BOOK_BY_TITLE);

        return bookToBooksDtoConverter.convert(searchBooks);
    }

    public BookWithAuthorsDto getBookById(Long id) {
        Book book = bookRepository.findById(id).get();

        return bookToBookWithAuthorsDtoConverter.convert(book);
    }

    public BookWithAuthorsDto addBook(AddBookArgs addBookArgs) throws UniqueConstraintViolationException {
        List<Author> authors = authorRepository.findByIdIn(addBookArgs.getAuthorIds());

        validation(addBookArgs.getTitle(), authors);

        Book bookNew = new Book();
        bookNew.setTitle(addBookArgs.getTitle());
        bookNew.setAuthors(authors);
        bookRepository.save(bookNew);

        return bookToBookWithAuthorsDtoConverter.convert(bookNew);
    }

    private void validation(String titleNew, List<Author> authors) throws UniqueConstraintViolationException {

        for(Author author : authors) {
            if(author.getBooks().stream().anyMatch(x -> x.getTitle().equals(titleNew))) {
                throw new UniqueConstraintViolationException(MessageException.BOOK_EXIST);
            }
        }
    }
}
