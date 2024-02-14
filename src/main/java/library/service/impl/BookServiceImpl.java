package library.service.impl;

import library.model.Book;
import library.repository.BookRepo;
import library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookRepo.findAll());
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    public Book findById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public Book update(Book book) {
        if (bookRepo.findById(book.getId()).isPresent()) {
            return bookRepo.save(book);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
}
