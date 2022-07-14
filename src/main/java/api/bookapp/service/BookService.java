package api.bookapp.service;

import api.bookapp.domain.Book;
import api.bookapp.repository.BookRepository;
import api.bookapp.request.BookCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void save(BookCreate bookCreate) {
        Book book = Book.builder()
                .title(bookCreate.getTitle())
                .contents(bookCreate.getContents())
                .build();
        bookRepository.save(book);
    }
}
