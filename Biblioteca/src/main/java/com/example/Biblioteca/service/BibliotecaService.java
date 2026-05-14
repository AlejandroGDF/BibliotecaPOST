package com.example.Biblioteca.service;

import com.example.Biblioteca.model.Autor;
import com.example.Biblioteca.model.Libro;
import com.example.Biblioteca.repository.AutorRepository;
import com.example.Biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    // CRUD Autor
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public Optional<Autor> obtenerAutorPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor guardarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public void eliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }

    // CRUD Libro
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Libro guardarLibro(Long autorId, Libro libro) {
        return autorRepository.findById(autorId).map(autor -> {
            libro.setAutor(autor);
            return libroRepository.save(libro);
        }).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
