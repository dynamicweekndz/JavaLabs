package com.example.library.repository;

import com.example.library.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {
}
