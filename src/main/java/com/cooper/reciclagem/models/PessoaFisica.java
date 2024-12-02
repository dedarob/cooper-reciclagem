package com.cooper.reciclagem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cod;
    private String pfNome;
    private String cpf;
    private String identidade;
    private String email;
    private String telefone;
}
