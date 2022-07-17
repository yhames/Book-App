package api.bookapp.request;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class BookCreate {

    @NotBlank
    private String title;

    @Length(max = 500)
    private String contents;

    @Length(max = 20)
    private String author;

    @Length(max = 20)
    private String publisher;

    @ISBN
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