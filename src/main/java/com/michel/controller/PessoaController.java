package com.michel.controller;

import com.michel.dto.PessoaDTO;
import com.michel.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> ReadPessoa(@PathVariable Long id) {
        PessoaDTO dto = service.readPessoa(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/buscatodos")
    public ResponseEntity<List<PessoaDTO>> ReadAlppPessoas() {
        List<PessoaDTO> dto = service.findAll();
        return ResponseEntity.ok().body(dto);
    }
}
