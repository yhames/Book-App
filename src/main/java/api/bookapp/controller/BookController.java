package api.bookapp.controller;

import api.bookapp.request.BookCreate;
import api.bookapp.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    /**
     * 책 저장
     */
    @PostMapping("/books")
    public void save(@RequestBody BookCreate bookCreate) {
        bookService.save(bookCreate);
    }

    /**
     * 책 조회 - 전체
     */
    @GetMapping("/books")
    public void getList() {

    }

    /**
     * 책 조회 - 단건
     */
    @GetMapping("/books/{bookId}")
    public void get(@PathVariable Long bookId) {

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
