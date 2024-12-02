package com.cooper.reciclagem.controllers;

import com.cooper.reciclagem.models.Coleta;
import com.cooper.reciclagem.repositories.ColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/coleta")
public class ColetaController {

    @Autowired
    private ColetaRepository repo;

    @GetMapping
    public ResponseEntity<List<Coleta>> getColeta() {
        List<Coleta> list = (List<Coleta>) repo.findAll();
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping
    public ResponseEntity<Coleta> createColeta(@RequestBody Coleta coleta) {
        Coleta newColeta = repo.save(coleta);
        return ResponseEntity.status(201).body(newColeta);
    }

    @PutMapping
    public ResponseEntity<Coleta> editColeta(@RequestBody Coleta coleta) {
        Coleta updatedColeta = repo.save(coleta);
        return ResponseEntity.status(200).body(updatedColeta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteColeta(@PathVariable Integer id) {
        repo.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
