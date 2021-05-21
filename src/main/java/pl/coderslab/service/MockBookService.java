package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService {

    private List<Book> books;
    private static Long nextId = 4L;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion", "programming"));
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> optionalBook = Optional.ofNullable(books.get(id.intValue()));
        return optionalBook.orElseGet(Book::new);
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public void updateBook(Book book) {
        Optional<Book> optionalBook = Optional.ofNullable(books.get(Math.toIntExact(book.getId())));
        if (optionalBook.isPresent()) {
            Long index = optionalBook.get().getId();
            books.get(index.intValue()).setIsbn(book.getIsbn());
            books.get(index.intValue()).setTitle(book.getTitle());
            books.get(index.intValue()).setAuthor(book.getAuthor());
            books.get(index.intValue()).setPublisher(book.getPublisher());
            books.get(index.intValue()).setType(book.getType());
        }
    }

    @Override
    public void deleteBook(Long id) {
        Optional<Book> book = Optional.ofNullable(books.get(id.intValue()));
        if (book.isPresent()) {
            books.remove(book.get());
        }
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        MockBookService.nextId = nextId;
    }
}


