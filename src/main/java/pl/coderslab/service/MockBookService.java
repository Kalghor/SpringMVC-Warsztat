package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService {
    private List<Book> list;
    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public Long getNextId() {
        return nextId;
    }

    public void setNextId(Long nextId) {
        MockBookService.nextId = nextId;
    }

    public boolean addBook(Book book){
        boolean result = false;
        if(list.add(book)){
            result = true;
            nextId++;
        }
        return result;
    }


    public Book getBook(int id){
        return list.get(id);
    }

    public boolean deleteBook(int id){
        boolean result = false;
        if(list.remove(list.get(id))){
           result = true;
        }
        return result;
    }

    public void updateBook(Book book, int bookId){
        list.get(bookId).setIsbn(book.getIsbn());
        list.get(bookId).setAuthor(book.getAuthor());
        list.get(bookId).setPublisher(book.getPublisher());
        list.get(bookId).setTitle(book.getTitle());
        list.get(bookId).setType(book.getType());
    }

    public List<Book> getAllBook(){
        return list;
    }
}
