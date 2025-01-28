package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Получить все книги
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Добавить книгу
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Удалить книгу
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Найти книгу по ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
