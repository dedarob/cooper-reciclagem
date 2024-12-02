package com.cooper.reciclagem.controllers;

import com.cooper.reciclagem.models.Enderecos;
import com.cooper.reciclagem.repositories.EnderecosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/enderecos")
public class EnderecosController {

    @Autowired
    private EnderecosRepository repo;

    @GetMapping
    public ResponseEntity<List<Enderecos>> getEnderecos() {
        List<Enderecos> list = (List<Enderecos>) repo.findAll();
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping
    public ResponseEntity<Enderecos> createEnderecos(@RequestBody Enderecos enderecos) {
        Enderecos newEnderecos = repo.save(enderecos);
        return ResponseEntity.status(201).body(newEnderecos);
    }

    @PutMapping
    public ResponseEntity<Enderecos> editEnderecos(@RequestBody Enderecos enderecos) {
        Enderecos updatedEnderecos = repo.save(enderecos);
        return ResponseEntity.status(200).body(updatedEnderecos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnderecos(@PathVariable Integer id) {
        repo.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
