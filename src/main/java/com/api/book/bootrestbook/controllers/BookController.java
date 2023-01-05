package com.api.book.bootrestbook.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    //get all book
    @GetMapping("/books")
    public List<Book> getBooks() {
       // Book book = new Book(1,"Java Programming","Siddharth Singh");
      // Book book = new Book();
        //  book.setId(11110);
        //  book.setTitle("Java Complete Reference");
        //  book.setAuthor("Siddharth Singh");

        return this.bookService.getAllBooks();
    }
    //get book by id
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id){
        return this.bookService.getBookById(id);
    }
    //add book by post method
@PostMapping("/books")
    public Book addBook( @RequestBody Book book){
        Book b= this.bookService.addBook(book);
        System.out.println(book);
         return b;

    }
    // delete book handeler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
        
    }
}
