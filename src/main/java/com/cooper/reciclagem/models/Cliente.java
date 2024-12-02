package com.cooper.reciclagem.models;

import com.cooper.reciclagem.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cod;
    private Integer pfId;
    private Integer pjId;
    private TipoPessoa tipoPessoa;
}
