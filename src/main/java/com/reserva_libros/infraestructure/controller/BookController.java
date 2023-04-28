package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.BookDto;
import com.reserva_libros.domain.useCase.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/libro")
public class BookController {

    private final BookService bookService;

    @GetMapping()
    public ResponseEntity<List<BookDto>> getAll() {
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getById(@PathVariable Integer bookId) {
        return ResponseEntity.of(bookService.getById(bookId));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<BookDto> getByTitle(@PathVariable String title) {
        return ResponseEntity.of(bookService.getByTitle(title));
    }

    @GetMapping("/category-book/{categoryId}")
    public ResponseEntity<List<BookDto>> getByCategoryId(@PathVariable Integer categoryId) {
        return new ResponseEntity<>(bookService.getByCategoryId(categoryId), HttpStatus.OK);
    }

    @GetMapping("/author-book/{authorId}")
    public ResponseEntity<List<BookDto>> getByAuthorId(@PathVariable Integer authorId) {
        return new ResponseEntity<>(bookService.getByAuthorId(authorId), HttpStatus.OK);
    }

    @GetMapping("/year-book/{year}")
    public ResponseEntity<List<BookDto>> getByYear(@PathVariable Integer year) {
        return new ResponseEntity<>(bookService.getBookByYearLessThan(year), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.save(bookDto), HttpStatus.CREATED);
    }

    @PatchMapping()
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto) {
        return ResponseEntity.of(bookService.update(bookDto));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer bookId) {
        return new ResponseEntity<>(bookService.delete(bookId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/title/{title}")
    public ResponseEntity<Boolean> deleteByTitle(@PathVariable String title) {
        return new ResponseEntity<>(bookService.deleteByTitle(title) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}