package com.example.library.service;

import com.example.library.model.BookLoan;
import com.example.library.repository.BookLoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLoanService {
    private final BookLoanRepository bookLoanRepository;

    public BookLoanService(BookLoanRepository bookLoanRepository) {
        this.bookLoanRepository = bookLoanRepository;
    }

    // Получить все записи о выдаче книг
    public List<BookLoan> getAllBookLoans() {
        return bookLoanRepository.findAll();
    }

    // Сохранить новую запись о выдаче книги
    public BookLoan saveBookLoan(BookLoan bookLoan) {
        return bookLoanRepository.save(bookLoan);
    }

    // Удалить запись о выдаче книги по ID
    public void deleteBookLoan(Long id) {
        bookLoanRepository.deleteById(id);
    }

    // Найти запись о выдаче книги по ID
    public BookLoan getBookLoanById(Long id) {
        return bookLoanRepository.findById(id).orElse(null);
    }
}

