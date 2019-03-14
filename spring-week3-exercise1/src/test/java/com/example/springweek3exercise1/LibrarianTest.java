package com.example.springweek3exercise1;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LibrarianTest {
    @Autowired
    Librarian librarian;

    @ParameterizedTest
    @CsvSource({"harrypotter,3",
            "thefoundation,2",
            "thelordoftherings,4"})
    void getBooks(String bookName, Integer copies) {
        Map<String, Integer> books = librarian.getBooks();
        assertTrue(books.containsKey(bookName) && books.containsValue(copies));

        assertThat(books, IsMapContaining.hasEntry(bookName, copies));

    }
}