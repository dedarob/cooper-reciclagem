package com.cooper.reciclagem.services;

import com.cooper.reciclagem.dto.PessoaFisicaDTO;
import com.cooper.reciclagem.dto.PessoaFisicaSomenteIdNomeAndCodigoDTO;
import com.cooper.reciclagem.mappers.PessoaFisicaMapper;
import com.cooper.reciclagem.models.PessoaFisica;
import com.cooper.reciclagem.repositories.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository repo;

    @Autowired
    private PessoaFisicaMapper mapper;

    public PessoaFisica getUserById(Integer id) throws Exception {
        // Lógica de negócio para buscar usuário pelo ID
        return repo.findById(id)
                .orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public List<String>  getAllUsernames() {
       List<PessoaFisica> list = (List<PessoaFisica>) repo.findAll();
        ArrayList<String> arrayList = new ArrayList<String>();
        list.forEach( (n) -> { arrayList.add(n.getPfNome()); } );
        return arrayList;
    }
    //o argumento desse parametro vem do controller, não do model
    public List<PessoaFisicaSomenteIdNomeAndCodigoDTO> getIdAndUsername(String name){
        List<PessoaFisica> pessoaFisicas = this.repo.findByPfNomeContaining(name);
        List<PessoaFisicaSomenteIdNomeAndCodigoDTO> dtoList = mapper.toDtoList(pessoaFisicas);
        return dtoList;
    }

    public List<PessoaFisica>  getAllUsers() {
        List<PessoaFisica> list = (List<PessoaFisica>) repo.findAll();
        return list;
    }
}
