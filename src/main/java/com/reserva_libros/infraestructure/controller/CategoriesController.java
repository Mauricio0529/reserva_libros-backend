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

    @GetMapping("/{name}")
    public ResponseEntity<CategoriesDto> getCategoryByName(@PathVariable String name){
        return ResponseEntity.of(categoriesService.getCategory(name));
    }

    @PostMapping()
    public ResponseEntity<CategoriesDto> save(@RequestBody CategoriesDto categoriesDto) {
        return new ResponseEntity<>(categoriesService.save(categoriesDto), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<CategoriesDto> update(@RequestBody CategoriesDto categoriesDto) {
        /** se usa of ya que retorna un Optional */
        return ResponseEntity.of(categoriesService.update(categoriesDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        /** SI SE ENCUENTRA LA CATEGORIA A ELIMINAR LANZA UN OK
         * Y
         * SI NO ENCUENTRA CATEGORA LANZA NO_FOUND (NO CONTENIDO)*/
        return new ResponseEntity<>(categoriesService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}