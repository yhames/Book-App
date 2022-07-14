package api.bookapp.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String contents;

    private String author;

    private String publisher;

    private String isbn;


    @Builder
    public Book(String title, String contents, String author, String publisher, String isbn) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }
}
