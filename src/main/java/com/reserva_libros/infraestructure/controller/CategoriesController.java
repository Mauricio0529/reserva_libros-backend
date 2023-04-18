package com.reserva_libros.infraestructure.controller;

import com.reserva_libros.domain.dto.CategoriesDto;
import com.reserva_libros.domain.useCase.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/categoria")
public class CategoriesController {

    private final CategoriesService categoriesService;

    @GetMapping()
    public ResponseEntity<List<CategoriesDto>> getAll() {
        return new ResponseEntity<>(categoriesService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CategoriesDto> save(@RequestBody CategoriesDto categoriesDto) {
        return new ResponseEntity<>(categoriesService.save(categoriesDto), HttpStatus.CREATED);
    }
}