package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public Categoria getOne(@PathVariable long id) {
        Optional<Categoria> result = categoriaRepo.findById(id);
        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria Não Encontrada"
            );
        }
        return result.get();
    }

    @PostMapping
    private Categoria post(@RequestBody Categoria categoria) {
        return categoriaRepo.save(categoria);
    }
}