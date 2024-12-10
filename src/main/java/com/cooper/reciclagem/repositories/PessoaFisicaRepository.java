package com.cooper.reciclagem.repositories;

import com.cooper.reciclagem.models.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Integer> {
    List<PessoaFisica> findByPfNomeContaining(String name);
}
