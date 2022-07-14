package api.bookapp.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class BookCreate {

    private String title;

    private String contents;

    private String author;

    private String publisher;

    private String isbn;

    @Builder
    public BookCreate(String title, String contents, String author, String publisher, String isbn) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }
}