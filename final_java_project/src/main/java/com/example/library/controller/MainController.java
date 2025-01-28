package com.example.library.controller;

import com.example.library.service.BookService;
import com.example.library.service.ReaderService;
import com.example.library.service.BookLoanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final BookService bookService;
    private final ReaderService readerService;
    private final BookLoanService bookLoanService;

    public MainController(
            BookService bookService,
            ReaderService readerService,
            BookLoanService bookLoanService
    ) {
        this.bookService = bookService;
        this.readerService = readerService;
        this.bookLoanService = bookLoanService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("readers", readerService.getAllReaders());
        model.addAttribute("loans", bookLoanService.getAllBookLoans());
        return "index";
    }
}