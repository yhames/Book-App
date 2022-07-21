package api.bookapp.controller;

import api.bookapp.domain.Book;
import api.bookapp.repository.BookRepository;
import api.bookapp.request.BookCreate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void clean() {
        bookRepository.deleteAll();
    }

    @Test
    @DisplayName("책 저장")
    void bookSave() throws Exception {
        // given
        BookCreate request = BookCreate.builder()
                .title("책제목")
                .contents("책소개")
                .author("책저자")
                .publisher("출판사")
                .isbn("9791161291017")
                .build();
        String json = objectMapper.writeValueAsString(request);

        // when
        mockMvc.perform(post("/books")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print());

        // then
        assertEquals(1L, bookRepository.count());
        Book book = bookRepository.findAll().get(0);
        assertEquals("책제목", book.getTitle());
        assertEquals("책소개", book.getContents());
        assertEquals("책저자", book.getAuthor());
        assertEquals("출판사", book.getPublisher());
        assertEquals("9791161291017", book.getIsbn());
    }

    @Test
    @DisplayName("책 저장 - title 검증")
    void bookSaveValidateTitle() throws Exception {
        // given
        BookCreate request = BookCreate.builder()
                .contents("책소개")
                .build();
        String json = objectMapper.writeValueAsString(request);

        // Expected
        mockMvc.perform(post("/books")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }


    @Test
    @DisplayName("책 저장 - contents 검증")
    void bookSaveValidateContents() throws Exception {
        Random random = new Random();
        int lobLength = 501;
        String lob = random.ints('가', '하')
                .limit(lobLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        // given
        BookCreate request = BookCreate.builder()
                .title("책제목")
                .contents(lob)
                .build();
        String json = objectMapper.writeValueAsString(request);

        // Expected
        mockMvc.perform(post("/books")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("책 저장 - author 검증")
    void bookSaveValidateAuthor() throws Exception {
        Random random = new Random();
        int lobLength = 21;
        String lob = random.ints('가', '하')
                .limit(lobLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        // given
        BookCreate request = BookCreate.builder()
                .title("책제목")
                .author(lob)
                .build();
        String json = objectMapper.writeValueAsString(request);

        // Expected
        mockMvc.perform(post("/books")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("책 저장 - publisher 검증")
    void bookSaveValidatePublisher() throws Exception {
        Random random = new Random();
        int lobLength = 21;
        String lob = random.ints('가', '하')
                .limit(lobLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        // given
        BookCreate request = BookCreate.builder()
                .title("책제목")
                .publisher(lob)
                .build();
        String json = objectMapper.writeValueAsString(request);

        // Expected
        mockMvc.perform(post("/books")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    // TODO: ISBN 검증

    // TODO: getList Test
}