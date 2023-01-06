package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();
    static {
        list.add(new Book(101, "Python Programming", "Singh"));
        list.add(new Book(102, "Let Us C", "Yashavant Kanetkar"));
        list.add(new Book(103, " Let Us C++ ", "Yashavant"));
    }

    // get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return book;
    }

    // Adding book
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    // delete book
    public void deleteBook(int bookId) {
        list = list.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
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
    list=list.stream().map(b->{
        if(b.getId()==bookId){
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
        }
        return b;
    }).collect(Collectors.toList());

    }

}
