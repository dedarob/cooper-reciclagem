package com.cooper.reciclagem.controllers;

import com.cooper.reciclagem.models.Material;
import com.cooper.reciclagem.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialRepository repo;

        @GetMapping
        public ResponseEntity<List<Material>> getMaterial() {
            List<Material> list = (List<Material>) repo.findAll();
            return ResponseEntity.status(200).body(list);
        }

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        Material newMaterial = repo.save(material);
        return ResponseEntity.status(201).body(newMaterial);
    }

    @PutMapping
    public ResponseEntity<Material> editMaterial(@RequestBody Material material) {
        Material updatedMaterial = repo.save(material);
        return ResponseEntity.status(200).body(updatedMaterial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMaterial(@PathVariable Integer id) {
        repo.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
