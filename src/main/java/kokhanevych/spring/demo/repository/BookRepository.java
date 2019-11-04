package kokhanevych.spring.demo.repository;

import kokhanevych.spring.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
