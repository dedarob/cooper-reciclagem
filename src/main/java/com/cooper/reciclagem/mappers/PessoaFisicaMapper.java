package com.cooper.reciclagem.mappers;

import com.cooper.reciclagem.models.PessoaFisica;
import com.cooper.reciclagem.dto.PessoaFisicaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaFisicaMapper {
    PessoaFisicaDTO toDto(PessoaFisica pessoaFisica);
}
