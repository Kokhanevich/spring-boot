package kokhanevych.spring.demo.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import kokhanevych.spring.demo.dto.BookDto;
import kokhanevych.spring.demo.dto.BookDtoUtil;
import kokhanevych.spring.demo.entity.Book;
import kokhanevych.spring.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Book book = BookDtoUtil.convertToBook(bookDto);
        bookService.save(book);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable("bookId") Long id,
                           @Valid @RequestBody BookDto bookDto){
        Book book = BookDtoUtil.convertToBook(bookDto);
        return bookService.update(id, book);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Long id) {
        bookService.delete(id);
    }
}
