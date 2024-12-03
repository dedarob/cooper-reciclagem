package com.cooper.reciclagem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="coleta")
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer materialId;
    private Integer clienteId;
    private LocalDate coletaData;
    private BigDecimal quantidadeKg;
    private Integer funcionarioId;
}
