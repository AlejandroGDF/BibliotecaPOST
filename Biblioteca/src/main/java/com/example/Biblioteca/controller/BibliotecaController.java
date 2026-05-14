package com.example.Biblioteca.controller;

import com.example.Biblioteca.model.Autor;
import com.example.Biblioteca.model.Libro;
import com.example.Biblioteca.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService service;

    // Endpoints Autor
    @GetMapping("/autores")
    public List<Autor> getAutores() {
        return service.listarAutores();
    }

    @PostMapping("/autores")
    public Autor createAutor(@RequestBody Autor autor) {
        return service.guardarAutor(autor);
    }

    @DeleteMapping("/autores/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        service.eliminarAutor(id);
        return ResponseEntity.ok().build();
    }

    // Endpoints Libro
    @GetMapping("/libros")
    public List<Libro> getLibros() {
        return service.listarLibros();
    }

    @PostMapping("/autores/{autorId}/libros")
    public Libro createLibro(@PathVariable Long autorId, @RequestBody Libro libro) {
        return service.guardarLibro(autorId, libro);
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        service.eliminarLibro(id);
        return ResponseEntity.ok().build();
    }
}
