package kokhanevych.spring.demo.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import kokhanevych.spring.demo.dto.BookDto;
import kokhanevych.spring.demo.entity.Book;
import kokhanevych.spring.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> allBooks() {
        return bookService.allBooks();
    }

    @GetMapping("/{bookId}")
    public Book findById(@PathVariable("bookId") Long id) {
        return bookService.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Entity with id " + id + " not found"));
    }

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setPrice(bookDto.getPrice());
        bookService.save(book);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable("bookId") Long id, @Valid @RequestBody BookDto bookDto){
        return bookService.update(id, bookDto);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Long id) {
        bookService.delete(id);
    }
}
