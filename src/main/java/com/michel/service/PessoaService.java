package com.michel.service;

import java.util.List;
import java.util.stream.Collectors;

import com.michel.dto.PessoaDTO;
import com.michel.entities.Pessoa;
import com.michel.mapper.PessoaMapper;
import com.michel.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    private PessoaMapper mapper = PessoaMapper.INSTANCE;

    @Transactional(readOnly=true)
    public List<PessoaDTO> findAll() {
        List<Pessoa> list = repository.findAll();
        return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
    }
    @Transactional
    public PessoaDTO readPessoa(Long id)  {
        repository.findById(id);
        return mapper.toDTO(repository.findById(id));
    }
}
