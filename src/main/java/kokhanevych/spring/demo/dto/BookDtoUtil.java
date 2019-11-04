package kokhanevych.spring.demo.dto;

import kokhanevych.spring.demo.entity.Book;

public class BookDtoUtil {

    public static Book convertToBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setPrice(bookDto.getPrice());
        return book;
    }
}
