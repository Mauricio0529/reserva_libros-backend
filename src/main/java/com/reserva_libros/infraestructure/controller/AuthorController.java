package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.AuthorDto;
import com.reserva_libros.domain.useCase.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/autor")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<AuthorDto>> getAll() {
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable String name) {
        return ResponseEntity.of(authorService.getAuthorByName(name));
    }

    @PostMapping()
    public ResponseEntity<AuthorDto> save(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.save(authorDto), HttpStatus.CREATED);
    }

    @PatchMapping()
    public ResponseEntity<AuthorDto> update(@RequestBody AuthorDto authorDto) {
        return ResponseEntity.of(authorService.update(authorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAuthorById(@PathVariable Integer id) {
        return new ResponseEntity<>(authorService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Boolean> deleteAuthorById(@PathVariable String name) {
        return new ResponseEntity<>(authorService.deleteByName(name) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}