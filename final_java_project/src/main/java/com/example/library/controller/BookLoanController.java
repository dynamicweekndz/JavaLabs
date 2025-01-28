package com.example.library.controller;

import com.example.library.model.BookLoan;
import com.example.library.service.BookLoanService;
import com.example.library.service.BookService;
import com.example.library.service.ReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loans")
public class BookLoanController {

    private final BookLoanService bookLoanService;
    private final BookService bookService;
    private final ReaderService readerService;

    public BookLoanController(
            BookLoanService bookLoanService,
            BookService bookService,
            ReaderService readerService
    ) {
        this.bookLoanService = bookLoanService;
        this.bookService = bookService;
        this.readerService = readerService;
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("loan", new BookLoan());
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("readers", readerService.getAllReaders());
        return "addLoans";
    }

    @PostMapping("/add")
    public String addLoan(@ModelAttribute BookLoan loan) {
        bookLoanService.saveBookLoan(loan);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteLoan(@PathVariable Long id) {
        bookLoanService.deleteBookLoan(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        BookLoan loan = bookLoanService.getBookLoanById(id);
        model.addAttribute("loan", loan);
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("readers", readerService.getAllReaders());
        return "editLoan";
    }

    @PostMapping("/edit")
    public String updateLoan(@ModelAttribute BookLoan loan) {
        bookLoanService.saveBookLoan(loan);
        return "redirect:/";
    }
}