package com.example.recetas.controller;

import com.example.recetas.model.Ingrediente;
import com.example.recetas.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteRepository repository;

    @GetMapping
    public List<Ingrediente> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Ingrediente create(@RequestBody Ingrediente ingrediente) {
        return repository.save(ingrediente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}