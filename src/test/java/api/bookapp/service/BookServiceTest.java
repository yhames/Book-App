package api.bookapp.service;

import api.bookapp.domain.Book;
import api.bookapp.repository.BookRepository;
import api.bookapp.request.BookCreate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("책 저장")
    void save() throws Exception {
        // given
        BookCreate request = BookCreate.builder()
                .title("책제목")
                .contents("책소개")
                .build();

        // when
        bookService.save(request);

        // then
        assertEquals(1L, bookRepository.count());
        Book book = bookRepository.findAll().get(0);
        assertEquals("책제목", book.getTitle());
        assertEquals("책소개", book.getContents());
    }

}