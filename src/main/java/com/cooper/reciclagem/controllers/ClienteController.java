package com.cooper.reciclagem.controllers;

import com.cooper.reciclagem.models.Cliente;
import com.cooper.reciclagem.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repo;

    @GetMapping
    public ResponseEntity<List<Cliente>> getCliente(){
        List<Cliente> list = (List<Cliente>) repo.findAll();
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        Cliente newCliente =repo.save(cliente);
        return ResponseEntity.status(201).body(newCliente);
    }

    @PutMapping
    public ResponseEntity<Cliente> editCliente(@RequestBody Cliente cliente){
        Cliente newCliente = repo.save(cliente);
        return ResponseEntity.status(200).body(newCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Integer id){
        repo.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}

