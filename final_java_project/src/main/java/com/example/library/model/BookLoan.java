package com.example.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @NotNull(message = "Книга должна быть выбрана")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    @NotNull(message = "Читатель должен быть выбран")
    private Reader reader;

    @NotNull(message = "Дата выдачи обязательна")
    @PastOrPresent(message = "Дата выдачи не может быть в будущем")
    private LocalDate loanDate;

    @FutureOrPresent(message = "Дата возврата не может быть в прошлом")
    private LocalDate returnDate;
}
