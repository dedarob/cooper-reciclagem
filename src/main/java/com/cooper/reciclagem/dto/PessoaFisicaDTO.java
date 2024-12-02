package com.cooper.reciclagem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFisicaDTO {
    private Integer id;
    private Integer cod;
    private String pfNome;
    private String identidade;
    private String email;
    private String telefone;
}
