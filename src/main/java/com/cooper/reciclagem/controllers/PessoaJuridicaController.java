package com.cooper.reciclagem.controllers;

import com.cooper.reciclagem.models.PessoaJuridica;
import com.cooper.reciclagem.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pessoajuridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaRepository repo;

    @GetMapping
    public ResponseEntity<List<PessoaJuridica>> getPessoaJuridica() {
        List<PessoaJuridica> list = (List<PessoaJuridica>) repo.findAll();
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping
    public ResponseEntity<PessoaJuridica> createPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica) {
        PessoaJuridica newPessoaJuridica = repo.save(pessoaJuridica);
        return ResponseEntity.status(201).body(newPessoaJuridica);
    }

    @PutMapping
    public ResponseEntity<PessoaJuridica> editPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica) {
        PessoaJuridica updatedPessoaJuridica = repo.save(pessoaJuridica);
        return ResponseEntity.status(200).body(updatedPessoaJuridica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePessoaJuridica(@PathVariable Integer id) {
        repo.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
