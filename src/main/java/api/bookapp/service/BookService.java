package api.bookapp.service;

import api.bookapp.domain.Book;
import api.bookapp.repository.BookRepository;
import api.bookapp.request.BookCreate;
import api.bookapp.response.BookResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void save(BookCreate bookCreate) {
        Book book = Book.builder()
                .title(bookCreate.getTitle())
                .contents(bookCreate.getContents())
                .author(bookCreate.getAuthor())
                .publisher(bookCreate.getPublisher())
                .isbn(bookCreate.getIsbn())
                .build();
        bookRepository.save(book);
    }

    public List<BookResponse> getList() {
        return bookRepository.findAll().stream()
                .map(BookResponse::new)
                .collect(Collectors.toList());
        // TODO: Paging
    }

    public void get(Long bookId) {
        bookRepository.findById(bookId);
    }
}
