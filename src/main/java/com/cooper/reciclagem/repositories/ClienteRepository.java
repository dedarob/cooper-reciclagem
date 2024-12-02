package com.cooper.reciclagem.repositories;

import com.cooper.reciclagem.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
