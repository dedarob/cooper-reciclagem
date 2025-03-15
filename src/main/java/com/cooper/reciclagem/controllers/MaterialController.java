package com.cooper.reciclagem.controllers;

import com.cooper.reciclagem.models.Material;
import com.cooper.reciclagem.repositories.MaterialRepository;
import com.cooper.reciclagem.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialRepository repo;

    @Autowired
    private MaterialService materialService;
        @GetMapping
        public ResponseEntity<?> listMaterial(@RequestParam("returnTypes") String returnTypes, @RequestParam(value="name", required = false) String name){
            if("nomematerial".equals(returnTypes)){
                List<Map<String, Object>> list = this.materialService.getAllNamesWithIds();

                return ResponseEntity.ok().body(list);
            } else {
            List<Material> list = (List<Material>) repo.findAll();
            return ResponseEntity.status(200).body(list);


        }}


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
