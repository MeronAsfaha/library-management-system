package library.service;

import library.model.Book;

import java.util.List;

public interface BookService{
    List<Book> findAll();
    Book findById(Long id);
    Book saveBook(Book book);
    Book update(Book book);
    void delete(Long id);
}
