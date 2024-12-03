package com.cooper.reciclagem.repositories;


import com.cooper.reciclagem.models.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
    UserDetails findByUsername(String username);
}


