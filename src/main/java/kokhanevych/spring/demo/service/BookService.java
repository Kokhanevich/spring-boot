package kokhanevych.spring.demo.service;

import java.util.List;
import java.util.Optional;

import kokhanevych.spring.demo.dto.BookDto;
import kokhanevych.spring.demo.entity.Book;

public interface BookService {
    Book save(Book book);

    Optional<Book> findById(Long id);

    List<Book> allBooks();

    Book update(Long id, BookDto book);

    void delete(Long id);
}
