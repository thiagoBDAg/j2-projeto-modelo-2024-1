package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Categoria;
import application.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepo;

    @GetMapping
    public Iterable<Categoria> getAll() {
        return categoriaRepo.findAll();
    }

    @PostMapping
    private Categoria post(@RequestBody Categoria categoria) {
        return categoriaRepo.save(categoria);
    }
}