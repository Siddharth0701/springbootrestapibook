package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<>();
    // static {
    //     list.add(new Book(101, "Python Programming", "Singh"));
    //     list.add(new Book(102, "Let Us C", "Yashavant Kanetkar"));
    //     list.add(new Book(103, " Let Us C++ ", "Yashavant"));
    // }

    // get all books
    public List<Book> getAllBooks() {
     List<Book> list=(List<Book>)   this.bookRepository.findAll();
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
           // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
          book= this.bookRepository.findById(id);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return book;
    }

    // Adding book
    public Book addBook(Book b) {
       // list.add(b);
      Book result= bookRepository.save(b);
        return result;
    }

    // delete book
    public void deleteBook(int bookId) {
        this.bookRepository.deleteById(bookId);
     //   list = list.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
        // list= list.stream().filter(book->{
        // if(book.getId()!=bookId){
        // return true;
        // }
        // else{
        // return false;
        // }
        // }).collect(Collectors.toList());

    }

    // update book
    public void updateBook(Book book, int bookId) {
        book.setId(bookId);
        bookRepository.save(book);
    // list=list.stream().map(b->{
    //     if(b.getId()==bookId){
    //         b.setTitle(book.getTitle());
    //         b.setAuthor(book.getAuthor());
    //     }
    //     return b;
    // }).collect(Collectors.toList());

    }

}
