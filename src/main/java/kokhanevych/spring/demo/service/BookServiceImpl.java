package kokhanevych.spring.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import kokhanevych.spring.demo.dto.BookDto;
import kokhanevych.spring.demo.entity.Book;
import kokhanevych.spring.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book update(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Book with id " + id + " not found"));
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setPrice(bookDto.getPrice());
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
