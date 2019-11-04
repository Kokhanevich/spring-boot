package kokhanevych.spring.demo.controller;

import javax.annotation.PostConstruct;

import kokhanevych.spring.demo.entity.Book;
import kokhanevych.spring.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DataInitializer {
    @Autowired
    private BookService bookService;

    @PostConstruct
    public void initBooks() {
        saveBooks();
    }

    private void saveBooks() {
        Book kobzar = new Book("Kobzar", 520D, 2005);
        bookService.save(kobzar);
        Book english = new Book("English", 600D, 2018);
        bookService.save(english);
        Book montenegro = new Book("Montenegro", 1000D, 2011);
        bookService.save(montenegro);
        Book culture = new Book("Culture", 650D, 2009);
        bookService.save(culture);
    }
}
