package api.bookapp.controller;

import api.bookapp.request.BookCreate;
import api.bookapp.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
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
    public void save(@RequestBody @Validated BookCreate bookCreate) {
        bookService.save(bookCreate);
    }

    /**
     * 책 간편 조회 - 리스트형
     * response - title
     */
    @GetMapping("/")
    public void home() {

    }

    /**
     * 책 전체 조회 - 갤러리형
     * response: title, author, img
     */
    @GetMapping("/books")
    public void getList() {

    }

    /**
     * 책 상세 조회 - 상세보기
     */
    @GetMapping("/books/{bookId}")
    public void get(@PathVariable Long bookId) {
        bookService.get(bookId);
    }

    /**
     * 책 정보 수정
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
