package com.cooper.reciclagem.services;

import com.cooper.reciclagem.models.Material;
import com.cooper.reciclagem.models.PessoaFisica;
import com.cooper.reciclagem.repositories.MaterialRepository;
import com.cooper.reciclagem.repositories.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository repo;

    //Nao abstrai a entidade para o um DTO porque nao tem dados sensiveis na tabela material
    public List<Map<String, Object>> getAllNamesWithIds() {
        List<Material> list = (List<Material>) repo.findAll();
        List<Map<String, Object>> resultList = new ArrayList<>();

        list.forEach((material) -> {
            Map<String, Object> map = new LinkedHashMap<>();  // Usando LinkedHashMap para garantir a ordem
            map.put("id", material.getId());  // Adiciona o ID
            map.put("nomeMaterial", material.getNomeMaterial());  // Adiciona o nome do material
            resultList.add(map);
        });

        System.out.println("THIS IS BEING EXECUTED");
        return resultList;
    }
    }

