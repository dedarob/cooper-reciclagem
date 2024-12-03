package com.cooper.reciclagem.controllers;

import com.cooper.reciclagem.models.Funcionario;
import com.cooper.reciclagem.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repo;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getFuncionario() {
        List<Funcionario> list = (List<Funcionario>) repo.findAll();
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario newFuncionario = repo.save(funcionario);
        return ResponseEntity.status(201).body(newFuncionario);
    }

    @PutMapping
    public ResponseEntity<Funcionario> editFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario updatedFuncionario = repo.save(funcionario);
        return ResponseEntity.status(200).body(updatedFuncionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFuncionario(@PathVariable Integer id) {
        repo.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
