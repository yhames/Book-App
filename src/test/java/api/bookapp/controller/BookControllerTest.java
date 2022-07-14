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
    }

    // TODO : 책 저장시 title 값 필수
}