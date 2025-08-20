package org.example.springjpatutorial.model;


import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //make sure that the ISBN is unique
    @Column(unique = true, nullable = false)
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String status;
}
