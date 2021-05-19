package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private MockBookService mockBookService = new MockBookService();

    @GetMapping("")
    public List<Book> getBooks() {
        return mockBookService.getAllBook();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return mockBookService.getBook(id - 1);
    }

//    @PostMapping("")
//    public void addBook(@RequestParam("isbn") int isbn,
//                        @RequestParam("title") String title,
//                        @RequestParam("publisher") String publisher,
//                        @RequestParam("type") String type,
//                        @RequestParam("author") String author) {
//        mockBookService.addBook(new Book(mockBookService.getNextId(), String.valueOf(isbn), title, publisher, type, author));
//    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        mockBookService.addBook(new Book(mockBookService.getNextId(), book.getIsbn(), book.getTitle(), book.getTitle(), book.getPublisher(), book.getAuthor()));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        mockBookService.deleteBook(id - 1);
    }

    @PutMapping("")
    public void editBook(@RequestParam("isbn") int isbn,
                         @RequestParam("title") String title,
                         @RequestParam("publisher") String publisher,
                         @RequestParam("type") String type,
                         @RequestParam("author") String author){
        mockBookService.updateBook(new Book(mockBookService.getNextId(), String.valueOf(isbn), title, publisher, type, author),1);
    }
}