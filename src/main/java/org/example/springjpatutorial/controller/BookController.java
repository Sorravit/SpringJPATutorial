package org.example.springjpatutorial.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.springjpatutorial.model.Book;
import org.example.springjpatutorial.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Book Management")
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Create a new book")
    @PostMapping
    public ResponseEntity<Book> createBook(@Parameter(description = "Book object to be added to the library") @RequestBody Book book) {
        Book createdBook = bookService.saveBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a book by its ISBN")
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@Parameter(description = "ISBN of the book to be retrieved") @PathVariable String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @Operation(summary = "Get all books in the library")
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @Operation(summary = "Update a book by its ISBN")
    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateBook(@Parameter(description = "ISBN of the book to be updated") @PathVariable String isbn,
                                           @Parameter(description = "Updated book object") @RequestBody Book book) {
        Book existingBook = bookService.getBookByIsbn(isbn);
        if (existingBook != null) {
            book.setId(existingBook.getId());
            Book updatedBook = bookService.updateBook(book);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete a book by its ISBN")
    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteBook(@Parameter(description = "ISBN of the book to be deleted") @PathVariable String isbn) {
        Book existingBook = bookService.getBookByIsbn(isbn);
        if (existingBook != null) {
            bookService.deleteBook(existingBook.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}