package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id:\\d+}")
    public Book getBook(@PathVariable("id") Long id) {
        return bookService.getBook(id - 1);
    }


    @PostMapping("")
    public void addBook(@RequestParam("isbn") int isbn,
                        @RequestParam("title") String title,
                        @RequestParam("publisher") String publisher,
                        @RequestParam("type") String type,
                        @RequestParam("author") String author) {
        bookService.addBook(new Book(String.valueOf(isbn), title, publisher, type, author));
    }

    @DeleteMapping("/{id:\\d+}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id - 1);
    }

    @PutMapping("/{id:\\d+}")
    public void updateBook(@PathVariable("id") Long id,
                           @RequestParam("isbn") int isbn,
                           @RequestParam("title") String title,
                           @RequestParam("publisher") String publisher,
                           @RequestParam("type") String type,
                           @RequestParam("author") String author) {
        bookService.updateBook(new Book(id, String.valueOf(isbn), title, publisher, type, author));
    }
}