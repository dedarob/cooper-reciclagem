package com.cooper.reciclagem.controllers;

import com.cooper.reciclagem.mappers.PessoaFisicaMapper;
import com.cooper.reciclagem.models.PessoaFisica;
import com.cooper.reciclagem.repositories.PessoaFisicaRepository;
import com.cooper.reciclagem.services.PessoaFisicaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cooper.reciclagem.dto.PessoaFisicaDTO;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaRepository repo;
    @Autowired
    private PessoaFisicaService pfService;
    @Autowired
    private PessoaFisicaMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<PessoaFisicaDTO> getPessoaFisica(@PathVariable Integer id) throws Exception {
        PessoaFisica pessoaFisica = this.pfService.getUserById(id);
        PessoaFisicaDTO dto = mapper.toDto(pessoaFisica);
        System.out.println(mapper);
        return ResponseEntity.status(200).body(dto);
    }


    @GetMapping
    public ResponseEntity<?> listPessoaFisica(@RequestParam("returnTypes") String returnTypes, @RequestParam(value="name", required = false) String name){
        if("username".equals(returnTypes)) {
            List<String> list = this.pfService.getAllUsernames();
            return ResponseEntity.ok().body(list);
        }
        else if("idAndUsername".equals(returnTypes)) {
            if (name == null || name.isEmpty()) {
                return ResponseEntity.badRequest().body("Name is required for idAndUsername search");
            }
            System.out.println("THIS IS BEING EXECUTED");
            return ResponseEntity.ok().body(this.pfService.getIdAndUsername(name));
        }
        else {
                List<PessoaFisica> list = this.pfService.getAllUsers();
                return ResponseEntity.ok().body(list);
            }
    }

    @PostMapping
    public ResponseEntity<PessoaFisica> createPessoaFisica(@RequestBody PessoaFisica pessoaFisica) {
        PessoaFisica newPessoaFisica = repo.save(pessoaFisica);
        return ResponseEntity.status(201).body(newPessoaFisica);
    }

    @PutMapping
    public ResponseEntity<PessoaFisica> editPessoaFisica(@RequestBody PessoaFisica pessoaFisica) {
        PessoaFisica updatedPessoaFisica = repo.save(pessoaFisica);
        return ResponseEntity.status(200).body(updatedPessoaFisica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePessoaFisica(@PathVariable Integer id) {
        repo.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
