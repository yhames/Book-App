package api.bookapp.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 도서 제목
     */
    private String title;


    /**
     * 도서 소개
     */
    private String contents;

    @Builder
    public Book(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
