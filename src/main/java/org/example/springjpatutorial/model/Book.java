package org.example.springjpatutorial.model;


import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Data;
import org.example.springjpatutorial.model.authorization.User;

@Entity
@Data
public class Book {
    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String status;
    @ManyToOne
    private User borrowedBy;
}