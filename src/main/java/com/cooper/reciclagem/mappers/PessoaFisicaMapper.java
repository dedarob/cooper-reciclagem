package com.cooper.reciclagem.mappers;

import com.cooper.reciclagem.dto.PessoaFisicaSomenteIdNomeAndCodigoDTO;
import com.cooper.reciclagem.models.PessoaFisica;
import com.cooper.reciclagem.dto.PessoaFisicaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaFisicaMapper {
    PessoaFisicaDTO toDto(PessoaFisica pessoaFisica);
    List<PessoaFisicaSomenteIdNomeAndCodigoDTO> toDtoList(List<PessoaFisica> pessoaFisica);
}
