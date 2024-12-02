package com.cooper.reciclagem.services;

import com.cooper.reciclagem.models.PessoaFisica;
import com.cooper.reciclagem.repositories.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository repo;

    public PessoaFisica getUserById(Integer id) throws Exception {
        // Lógica de negócio para buscar usuário pelo ID
        return repo.findById(id)
                .orElseThrow(() -> new Exception("Usuário não encontrado"));
    }
}
