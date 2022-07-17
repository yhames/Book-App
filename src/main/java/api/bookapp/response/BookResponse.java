package api.bookapp.response;

import api.bookapp.domain.Book;
import lombok.Builder;

public class BookResponse {

    private Long id;
    private String title;
    private String contents;    //TODO: 글자 수 제한
    private String author;
    private String publisher;
    private String isbn;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.contents = book.getContents();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.isbn = book.getIsbn();
    }

    @Builder
    public BookResponse(Long id, String title, String contents, String author, String publisher, String isbn) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }
}
