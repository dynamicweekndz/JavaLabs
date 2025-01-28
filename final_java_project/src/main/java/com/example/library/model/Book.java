package com.example.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название книги не может быть пустым")
    @Size(min = 2, max = 200, message = "Название должно быть от 2 до 200 символов")
    private String title;

    @NotBlank(message = "Автор не может быть пустым")
    @Size(min = 3, max = 100, message = "Имя автора должно быть от 3 до 100 символов")
    private String author;

    @Min(value = 1800, message = "Год издания не может быть меньше 1800")
    @Max(value = 2100, message = "Год издания не может быть больше 2100")
    private int publishedYear;
}
