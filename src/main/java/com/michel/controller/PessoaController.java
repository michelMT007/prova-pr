package com.michel.controller;

import com.michel.dto.PessoaDTO;
import com.michel.exception.PessoaException;
import com.michel.service.PessoaService;
import com.sun.xml.internal.ws.wsdl.writer.document.soap12.Body;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class PessoaController {
    private PessoaService service;
    public PessoaController(PessoaService service){
        this.service=service;
    }
    @GetMapping("/")
    public String mensagem() {
        return "Sistema WEB para o SENAI Paraná";
    }
    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<PessoaDTO> ReadById(@PathVariable Long id)  throws PessoaException{
        PessoaDTO dto = service.read(id);
        return ok().body(dto);
    }
    @GetMapping(value = "/pessoa/findall")
    public ResponseEntity<List<PessoaDTO>> findAll() {
        List<PessoaDTO> dto = service.findall();
        return ok().body(dto);
    }

    @PostMapping(value = "/pessoa/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity Create(@RequestBody PessoaDTO dto) {
        service.create(dto);
        return ok().body(dto);
    }
    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity<PessoaDTO> DeleteById(@PathVariable Long id)  throws PessoaException {
        PessoaDTO dto = service.delete(id);
            return ok().body(dto);
    }
}
