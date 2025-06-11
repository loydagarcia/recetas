package com.example.recetas.controller;

import com.example.recetas.model.Ingrediente;
import com.example.recetas.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IngredienteUIController {

    @Autowired
    private IngredienteRepository repository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/ingredientes")
    public String listar(Model model) {
        model.addAttribute("ingredientes", repository.findAll());
        return "ingredientes";
    }

    @PostMapping("/ingredientes")
    public String guardar(@RequestParam String nombre, @RequestParam String tipo) {
        Ingrediente i = new Ingrediente();
        i.setNombre(nombre);
        i.setTipo(tipo);
        repository.save(i);
        return "redirect:/ingredientes";
    }

    @GetMapping("/ingredientes/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/ingredientes";
    }
}