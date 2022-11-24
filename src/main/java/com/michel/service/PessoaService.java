package com.michel.service;

import com.michel.dto.PessoaDTO;
import com.michel.entities.Pessoa;
import com.michel.repositories.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PessoaService  {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PessoaRepository repository;
    @Transactional
    public PessoaDTO read(Long id) {
        Pessoa pessoa = repository.findById(id).get();
        if (pessoa != null) {
            return mapper.map(pessoa, PessoaDTO.class);
        }else {

            return null;
        }
    }
    @Transactional
    public List<PessoaDTO> findall()  {
        List<Pessoa> list = repository.findAll();
        List<PessoaDTO> dtos=new ArrayList<PessoaDTO>();
        for (Pessoa elemento :list) {

            dtos.add(mapper.map(elemento , PessoaDTO.class));
        }
        return dtos;
    }
    @Transactional
    public void create(PessoaDTO dto)  {
        repository.save(mapper.map(dto, Pessoa.class));
    }
    @Transactional
    public PessoaDTO delete(Long id)  {
        PessoaDTO dto = read(id);
        if( dto!= null) {
            repository.deleteById(id);
            return dto;
        }else{
            return null;
        }
    }
}
