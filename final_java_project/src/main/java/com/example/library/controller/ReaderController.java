package com.example.library.controller;

import com.example.library.model.Reader;
import com.example.library.service.ReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/readers")
public class ReaderController {

    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("reader", new Reader());
        return "addReader";
    }

    @PostMapping("/add")
    public String addReader(@ModelAttribute Reader reader) {
        readerService.saveReader(reader);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Reader reader = readerService.getReaderById(id);
        model.addAttribute("reader", reader);
        return "editReader";
    }

    @PostMapping("/edit")
    public String updateReader(@ModelAttribute Reader reader) {
        readerService.saveReader(reader);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
        return "redirect:/";
    }
}