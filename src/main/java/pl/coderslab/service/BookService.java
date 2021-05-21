package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookService {
    Book getBook(Long id);
    List<Book> getBooks();
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);
}
