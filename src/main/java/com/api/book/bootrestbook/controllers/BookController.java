package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    // get all book
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        // return this.bookService.getAllBooks();
        List<Book> list = this.bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(list));

    }

    // get book by id
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return this.bookService.getBookById(id);
    }

    // add book by post method
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        System.out.println(book);
        return b;

    }

    // delete book handeler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        this.bookService.deleteBook(bookId);

    }

    // update book handler
    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        this.bookService.updateBook(book, bookId);
        return book;

    }
}
