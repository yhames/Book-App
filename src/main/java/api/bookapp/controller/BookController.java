package api.bookapp.controller;

import api.bookapp.request.BookCreate;
import api.bookapp.response.BookResponse;
import api.bookapp.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    /**
     * 책 저장
     */
    @PostMapping("/books")
    public void save(@RequestBody @Validated BookCreate bookCreate) {
        bookService.save(bookCreate);
    }

    /**
     * 책 조회 - 전체
     */
    @GetMapping("/books")
    public List<BookResponse> getList() {
        return bookService.getList();
    }

    /**
     * 책 조회 - 상세
     */
    @GetMapping("/books/{bookId}")
    public void get(@PathVariable Long bookId) {
        bookService.get(bookId);
    }

    /**
     * 책 수정
     */
    @PatchMapping("/books/{bookId}")
    public void update(@PathVariable Long bookId) {

    }

    /**
     * 책 삭제
     */
    @DeleteMapping("/books/{bookId}")
    public void delete(@PathVariable Long bookId) {

    }
}
